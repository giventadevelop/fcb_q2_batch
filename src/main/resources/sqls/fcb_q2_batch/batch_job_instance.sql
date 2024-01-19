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
