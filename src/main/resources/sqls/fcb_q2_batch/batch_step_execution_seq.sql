Select ID, UNIQUE_KEY from fcb_q2_batch.batch_step_execution_seq
USE fcb_q2_batch;

CREATE TABLE `batch_step_execution_seq` (
  `ID` bigint NOT NULL,
  `UNIQUE_KEY` char(1) NOT NULL,
  UNIQUE KEY `UNIQUE_KEY_UN` (`UNIQUE_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into `batch_step_execution_seq`(`ID`,`UNIQUE_KEY`) values (2,'0');
