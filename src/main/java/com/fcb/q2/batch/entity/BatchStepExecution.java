package com.fcb.q2.batch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the batch_step_execution database table.
 * 
 */
/*@Entity
@Table(name="batch_step_execution")
@NamedQuery(name="BatchStepExecution.findAll", query="SELECT b FROM BatchStepExecution b")*/
public class BatchStepExecution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STEP_EXECUTION_ID")
	private String stepExecutionId;

	@Column(name="COMMIT_COUNT")
	private BigInteger commitCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;

	@Column(name="EXIT_CODE")
	private String exitCode;

	@Column(name="EXIT_MESSAGE")
	private String exitMessage;

	@Column(name="FILTER_COUNT")
	private BigInteger filterCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATED")
	private Date lastUpdated;

	@Column(name="PROCESS_SKIP_COUNT")
	private BigInteger processSkipCount;

	@Column(name="READ_COUNT")
	private BigInteger readCount;

	@Column(name="READ_SKIP_COUNT")
	private BigInteger readSkipCount;

	@Column(name="ROLLBACK_COUNT")
	private BigInteger rollbackCount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date startTime;

	private String status;

	@Column(name="STEP_NAME")
	private String stepName;

	private BigInteger version;

	@Column(name="WRITE_COUNT")
	private BigInteger writeCount;

	@Column(name="WRITE_SKIP_COUNT")
	private BigInteger writeSkipCount;

	//bi-directional many-to-one association to BatchJobExecution
	@ManyToOne
	@JoinColumn(name="JOB_EXECUTION_ID")
	private BatchJobExecution batchJobExecution;

	//bi-directional one-to-one association to BatchStepExecutionContext
	@OneToOne(mappedBy="batchStepExecution")
	private BatchStepExecutionContext batchStepExecutionContext;

	public BatchStepExecution() {
	}

	public String getStepExecutionId() {
		return this.stepExecutionId;
	}

	public void setStepExecutionId(String stepExecutionId) {
		this.stepExecutionId = stepExecutionId;
	}

	public BigInteger getCommitCount() {
		return this.commitCount;
	}

	public void setCommitCount(BigInteger commitCount) {
		this.commitCount = commitCount;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getExitCode() {
		return this.exitCode;
	}

	public void setExitCode(String exitCode) {
		this.exitCode = exitCode;
	}

	public String getExitMessage() {
		return this.exitMessage;
	}

	public void setExitMessage(String exitMessage) {
		this.exitMessage = exitMessage;
	}

	public BigInteger getFilterCount() {
		return this.filterCount;
	}

	public void setFilterCount(BigInteger filterCount) {
		this.filterCount = filterCount;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public BigInteger getProcessSkipCount() {
		return this.processSkipCount;
	}

	public void setProcessSkipCount(BigInteger processSkipCount) {
		this.processSkipCount = processSkipCount;
	}

	public BigInteger getReadCount() {
		return this.readCount;
	}

	public void setReadCount(BigInteger readCount) {
		this.readCount = readCount;
	}

	public BigInteger getReadSkipCount() {
		return this.readSkipCount;
	}

	public void setReadSkipCount(BigInteger readSkipCount) {
		this.readSkipCount = readSkipCount;
	}

	public BigInteger getRollbackCount() {
		return this.rollbackCount;
	}

	public void setRollbackCount(BigInteger rollbackCount) {
		this.rollbackCount = rollbackCount;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStepName() {
		return this.stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public BigInteger getVersion() {
		return this.version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

	public BigInteger getWriteCount() {
		return this.writeCount;
	}

	public void setWriteCount(BigInteger writeCount) {
		this.writeCount = writeCount;
	}

	public BigInteger getWriteSkipCount() {
		return this.writeSkipCount;
	}

	public void setWriteSkipCount(BigInteger writeSkipCount) {
		this.writeSkipCount = writeSkipCount;
	}

	public BatchJobExecution getBatchJobExecution() {
		return this.batchJobExecution;
	}

	public void setBatchJobExecution(BatchJobExecution batchJobExecution) {
		this.batchJobExecution = batchJobExecution;
	}

	public BatchStepExecutionContext getBatchStepExecutionContext() {
		return this.batchStepExecutionContext;
	}

	public void setBatchStepExecutionContext(BatchStepExecutionContext batchStepExecutionContext) {
		this.batchStepExecutionContext = batchStepExecutionContext;
	}

}
