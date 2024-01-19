package com.fcb.q2.batch.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the batch_job_execution_context database table.
 * 
 */
/*@Entity
@Table(name="batch_job_execution_context")
@NamedQuery(name="BatchJobExecutionContext.findAll", query="SELECT b FROM BatchJobExecutionContext b")*/
public class BatchJobExecutionContext implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JOB_EXECUTION_ID")
	private String jobExecutionId;

	@Lob
	@Column(name="SERIALIZED_CONTEXT")
	private String serializedContext;

	@Column(name="SHORT_CONTEXT")
	private String shortContext;

	//bi-directional one-to-one association to BatchJobExecution
	/*@OneToOne
	@JoinColumn(name="JOB_EXECUTION_ID")*/
	private BatchJobExecution batchJobExecution;

	public BatchJobExecutionContext() {
	}

	public String getJobExecutionId() {
		return this.jobExecutionId;
	}

	public void setJobExecutionId(String jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}

	public String getSerializedContext() {
		return this.serializedContext;
	}

	public void setSerializedContext(String serializedContext) {
		this.serializedContext = serializedContext;
	}

	public String getShortContext() {
		return this.shortContext;
	}

	public void setShortContext(String shortContext) {
		this.shortContext = shortContext;
	}

	public BatchJobExecution getBatchJobExecution() {
		return this.batchJobExecution;
	}

	public void setBatchJobExecution(BatchJobExecution batchJobExecution) {
		this.batchJobExecution = batchJobExecution;
	}

}
