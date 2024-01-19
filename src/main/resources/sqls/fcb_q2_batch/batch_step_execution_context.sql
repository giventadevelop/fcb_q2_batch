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
