Select JOB_EXECUTION_ID, VERSION, JOB_INSTANCE_ID, CREATE_TIME, START_TIME, END_TIME, STATUS, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED, JOB_CONFIGURATION_LOCATION from fcb_q2_batch.batch_job_execution
USE fcb_q2_batch;

CREATE TABLE `batch_job_execution` (
  `JOB_EXECUTION_ID` bigint NOT NULL,
  `VERSION` bigint DEFAULT NULL,
  `JOB_INSTANCE_ID` bigint NOT NULL,
  `CREATE_TIME` datetime(6) NOT NULL,
  `START_TIME` datetime(6) DEFAULT NULL,
  `END_TIME` datetime(6) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `EXIT_CODE` varchar(2500) DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) DEFAULT NULL,
  `LAST_UPDATED` datetime(6) DEFAULT NULL,
  `JOB_CONFIGURATION_LOCATION` varchar(2500) DEFAULT NULL,
  PRIMARY KEY (`JOB_EXECUTION_ID`),
  KEY `JOB_INST_EXEC_FK` (`JOB_INSTANCE_ID`),
  CONSTRAINT `JOB_INST_EXEC_FK` FOREIGN KEY (`JOB_INSTANCE_ID`) REFERENCES `batch_job_instance` (`JOB_INSTANCE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_job_execution`(`JOB_EXECUTION_ID`,`VERSION`,`JOB_INSTANCE_ID`,`CREATE_TIME`,`START_TIME`,`END_TIME`,`STATUS`,`EXIT_CODE`,`EXIT_MESSAGE`,`LAST_UPDATED`,`JOB_CONFIGURATION_LOCATION`) values (1,2,1,'2024-01-14 23:50:36','2024-01-14 23:50:36','2024-01-14 23:50:37','COMPLETED','COMPLETED','','2024-01-14 23:50:37',null);
Select JOB_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT from fcb_q2_batch.batch_job_execution_context
USE fcb_q2_batch;

CREATE TABLE `batch_job_execution_context` (
  `JOB_EXECUTION_ID` bigint NOT NULL,
  `SHORT_CONTEXT` varchar(2500) NOT NULL,
  `SERIALIZED_CONTEXT` text,
  PRIMARY KEY (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_CTX_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_job_execution_context`(`JOB_EXECUTION_ID`,`SHORT_CONTEXT`,`SERIALIZED_CONTEXT`) values (1,'{"@class":"java.util.HashMap"}',null);
Select JOB_EXECUTION_ID, TYPE_CD, KEY_NAME, STRING_VAL, DATE_VAL, LONG_VAL, DOUBLE_VAL, IDENTIFYING from fcb_q2_batch.batch_job_execution_params
USE fcb_q2_batch;

CREATE TABLE `batch_job_execution_params` (
  `JOB_EXECUTION_ID` bigint NOT NULL,
  `TYPE_CD` varchar(6) NOT NULL,
  `KEY_NAME` varchar(100) NOT NULL,
  `STRING_VAL` varchar(250) DEFAULT NULL,
  `DATE_VAL` datetime(6) DEFAULT NULL,
  `LONG_VAL` bigint DEFAULT NULL,
  `DOUBLE_VAL` double DEFAULT NULL,
  `IDENTIFYING` char(1) NOT NULL,
  KEY `JOB_EXEC_PARAMS_FK` (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_PARAMS_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


Select ID, UNIQUE_KEY from fcb_q2_batch.batch_job_execution_seq
USE fcb_q2_batch;

CREATE TABLE `batch_job_execution_seq` (
  `ID` bigint NOT NULL,
  `UNIQUE_KEY` char(1) NOT NULL,
  UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_job_execution_seq`(`ID`,`UNIQUE_KEY`) values (1,'0');
Select JOB_INSTANCE_ID, VERSION, JOB_NAME, JOB_KEY from fcb_q2_batch.batch_job_instance
USE fcb_q2_batch;

CREATE TABLE `batch_job_instance` (
  `JOB_INSTANCE_ID` bigint NOT NULL,
  `VERSION` bigint DEFAULT NULL,
  `JOB_NAME` varchar(100) NOT NULL,
  `JOB_KEY` varchar(32) NOT NULL,
  PRIMARY KEY (`JOB_INSTANCE_ID`),
  UNIQUE KEY `JOB_INST_UN` (`JOB_NAME`,`JOB_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_job_instance`(`JOB_INSTANCE_ID`,`VERSION`,`JOB_NAME`,`JOB_KEY`) values (1,0,'First Job','d41d8cd98f00b204e9800998ecf8427e');
Select ID, UNIQUE_KEY from fcb_q2_batch.batch_job_seq
USE fcb_q2_batch;

CREATE TABLE `batch_job_seq` (
  `ID` bigint NOT NULL,
  `UNIQUE_KEY` char(1) NOT NULL,
  UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_job_seq`(`ID`,`UNIQUE_KEY`) values (1,'0');
Select STEP_EXECUTION_ID, VERSION, STEP_NAME, JOB_EXECUTION_ID, START_TIME, END_TIME, STATUS, COMMIT_COUNT, READ_COUNT, FILTER_COUNT, WRITE_COUNT, READ_SKIP_COUNT, WRITE_SKIP_COUNT, PROCESS_SKIP_COUNT, ROLLBACK_COUNT, EXIT_CODE, EXIT_MESSAGE, LAST_UPDATED from fcb_q2_batch.batch_step_execution
USE fcb_q2_batch;

CREATE TABLE `batch_step_execution` (
  `STEP_EXECUTION_ID` bigint NOT NULL,
  `VERSION` bigint NOT NULL,
  `STEP_NAME` varchar(100) NOT NULL,
  `JOB_EXECUTION_ID` bigint NOT NULL,
  `START_TIME` datetime(6) NOT NULL,
  `END_TIME` datetime(6) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `COMMIT_COUNT` bigint DEFAULT NULL,
  `READ_COUNT` bigint DEFAULT NULL,
  `FILTER_COUNT` bigint DEFAULT NULL,
  `WRITE_COUNT` bigint DEFAULT NULL,
  `READ_SKIP_COUNT` bigint DEFAULT NULL,
  `WRITE_SKIP_COUNT` bigint DEFAULT NULL,
  `PROCESS_SKIP_COUNT` bigint DEFAULT NULL,
  `ROLLBACK_COUNT` bigint DEFAULT NULL,
  `EXIT_CODE` varchar(2500) DEFAULT NULL,
  `EXIT_MESSAGE` varchar(2500) DEFAULT NULL,
  `LAST_UPDATED` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`STEP_EXECUTION_ID`),
  KEY `JOB_EXEC_STEP_FK` (`JOB_EXECUTION_ID`),
  CONSTRAINT `JOB_EXEC_STEP_FK` FOREIGN KEY (`JOB_EXECUTION_ID`) REFERENCES `batch_job_execution` (`JOB_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_step_execution`(`STEP_EXECUTION_ID`,`VERSION`,`STEP_NAME`,`JOB_EXECUTION_ID`,`START_TIME`,`END_TIME`,`STATUS`,`COMMIT_COUNT`,`READ_COUNT`,`FILTER_COUNT`,`WRITE_COUNT`,`READ_SKIP_COUNT`,`WRITE_SKIP_COUNT`,`PROCESS_SKIP_COUNT`,`ROLLBACK_COUNT`,`EXIT_CODE`,`EXIT_MESSAGE`,`LAST_UPDATED`) values (1,3,'First Step',1,'2024-01-14 23:50:36','2024-01-14 23:50:36','COMPLETED',1,0,0,0,0,0,0,0,'COMPLETED','','2024-01-14 23:50:36');
insert into `batch_step_execution`(`STEP_EXECUTION_ID`,`VERSION`,`STEP_NAME`,`JOB_EXECUTION_ID`,`START_TIME`,`END_TIME`,`STATUS`,`COMMIT_COUNT`,`READ_COUNT`,`FILTER_COUNT`,`WRITE_COUNT`,`READ_SKIP_COUNT`,`WRITE_SKIP_COUNT`,`PROCESS_SKIP_COUNT`,`ROLLBACK_COUNT`,`EXIT_CODE`,`EXIT_MESSAGE`,`LAST_UPDATED`) values (2,3,'Second Step',1,'2024-01-14 23:50:36','2024-01-14 23:50:37','COMPLETED',1,0,0,0,0,0,0,0,'COMPLETED','','2024-01-14 23:50:37');
Select STEP_EXECUTION_ID, SHORT_CONTEXT, SERIALIZED_CONTEXT from fcb_q2_batch.batch_step_execution_context
USE fcb_q2_batch;

CREATE TABLE `batch_step_execution_context` (
  `STEP_EXECUTION_ID` bigint NOT NULL,
  `SHORT_CONTEXT` varchar(2500) NOT NULL,
  `SERIALIZED_CONTEXT` text,
  PRIMARY KEY (`STEP_EXECUTION_ID`),
  CONSTRAINT `STEP_EXEC_CTX_FK` FOREIGN KEY (`STEP_EXECUTION_ID`) REFERENCES `batch_step_execution` (`STEP_EXECUTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_step_execution_context`(`STEP_EXECUTION_ID`,`SHORT_CONTEXT`,`SERIALIZED_CONTEXT`) values (1,'{"@class":"java.util.HashMap","batch.taskletType":"com.fcb.q2.batch.config.SampleJob$1","batch.stepType":"org.springframework.batch.core.step.tasklet.TaskletStep"}',null);
insert into `batch_step_execution_context`(`STEP_EXECUTION_ID`,`SHORT_CONTEXT`,`SERIALIZED_CONTEXT`) values (2,'{"@class":"java.util.HashMap","batch.taskletType":"com.fcb.q2.batch.service.SecondTasklet","batch.stepType":"org.springframework.batch.core.step.tasklet.TaskletStep"}',null);
Select ID, UNIQUE_KEY from fcb_q2_batch.batch_step_execution_seq
USE fcb_q2_batch;

CREATE TABLE `batch_step_execution_seq` (
  `ID` bigint NOT NULL,
  `UNIQUE_KEY` char(1) NOT NULL,
  UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_step_execution_seq`(`ID`,`UNIQUE_KEY`) values (2,'0');

-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

