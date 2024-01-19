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
