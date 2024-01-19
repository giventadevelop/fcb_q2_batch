package com.fcb.q2.batch.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the batch_step_execution_context database table.
 * 
 */
/*@Entity
@Table(name="batch_step_execution_context")
@NamedQuery(name="BatchStepExecutionContext.findAll", query="SELECT b FROM BatchStepExecutionContext b")*/
public class BatchStepExecutionContext implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STEP_EXECUTION_ID")
	private String stepExecutionId;

	@Lob
	@Column(name="SERIALIZED_CONTEXT")
	private String serializedContext;

	@Column(name="SHORT_CONTEXT")
	private String shortContext;

	//bi-directional one-to-one association to BatchStepExecution
	@OneToOne
	@JoinColumn(name="STEP_EXECUTION_ID")
	private BatchStepExecution batchStepExecution;

	public BatchStepExecutionContext() {
	}

	public String getStepExecutionId() {
		return this.stepExecutionId;
	}

	public void setStepExecutionId(String stepExecutionId) {
		this.stepExecutionId = stepExecutionId;
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

	public BatchStepExecution getBatchStepExecution() {
		return this.batchStepExecution;
	}

	public void setBatchStepExecution(BatchStepExecution batchStepExecution) {
		this.batchStepExecution = batchStepExecution;
	}

}
