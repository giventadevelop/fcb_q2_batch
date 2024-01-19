package com.fcb.q2.batch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the batch_job_execution database table.
 * 
 */
/*@Entity
@Table(name="batch_job_execution")
@NamedQuery(name="BatchJobExecution.findAll", query="SELECT b FROM BatchJobExecution b")*/
public class BatchJobExecution implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JOB_EXECUTION_ID")
	private String jobExecutionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME")
	private Date createTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="END_TIME")
	private Date endTime;

	@Column(name="EXIT_CODE")
	private String exitCode;

	@Column(name="EXIT_MESSAGE")
	private String exitMessage;

	@Column(name="JOB_CONFIGURATION_LOCATION")
	private String jobConfigurationLocation;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDATED")
	private Date lastUpdated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="START_TIME")
	private Date startTime;

	private String status;

	private BigInteger version;

	//bi-directional many-to-one association to BatchJobInstance
	@ManyToOne
	@JoinColumn(name="JOB_INSTANCE_ID")
	private BatchJobInstance batchJobInstance;

	//bi-directional one-to-one association to BatchJobExecutionContext
	@OneToOne(mappedBy="batchJobExecution")
	private BatchJobExecutionContext batchJobExecutionContext;

	//bi-directional many-to-one association to BatchJobExecutionParam
	/*@OneToMany(mappedBy="batchJobExecution")*/
	private List<BatchJobExecutionParam> batchJobExecutionParams;

	//bi-directional many-to-one association to BatchStepExecution
	@OneToMany(mappedBy="batchJobExecution")
	private List<BatchStepExecution> batchStepExecutions;

	public BatchJobExecution() {
	}

	public String getJobExecutionId() {
		return this.jobExecutionId;
	}

	public void setJobExecutionId(String jobExecutionId) {
		this.jobExecutionId = jobExecutionId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getJobConfigurationLocation() {
		return this.jobConfigurationLocation;
	}

	public void setJobConfigurationLocation(String jobConfigurationLocation) {
		this.jobConfigurationLocation = jobConfigurationLocation;
	}

	public Date getLastUpdated() {
		return this.lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
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

	public BigInteger getVersion() {
		return this.version;
	}

	public void setVersion(BigInteger version) {
		this.version = version;
	}

	public BatchJobInstance getBatchJobInstance() {
		return this.batchJobInstance;
	}

	public void setBatchJobInstance(BatchJobInstance batchJobInstance) {
		this.batchJobInstance = batchJobInstance;
	}

	public BatchJobExecutionContext getBatchJobExecutionContext() {
		return this.batchJobExecutionContext;
	}

	public void setBatchJobExecutionContext(BatchJobExecutionContext batchJobExecutionContext) {
		this.batchJobExecutionContext = batchJobExecutionContext;
	}

	public List<BatchJobExecutionParam> getBatchJobExecutionParams() {
		return this.batchJobExecutionParams;
	}

	public void setBatchJobExecutionParams(List<BatchJobExecutionParam> batchJobExecutionParams) {
		this.batchJobExecutionParams = batchJobExecutionParams;
	}

	public BatchJobExecutionParam addBatchJobExecutionParam(BatchJobExecutionParam batchJobExecutionParam) {
		getBatchJobExecutionParams().add(batchJobExecutionParam);
		batchJobExecutionParam.setBatchJobExecution(this);

		return batchJobExecutionParam;
	}

	public BatchJobExecutionParam removeBatchJobExecutionParam(BatchJobExecutionParam batchJobExecutionParam) {
		getBatchJobExecutionParams().remove(batchJobExecutionParam);
		batchJobExecutionParam.setBatchJobExecution(null);

		return batchJobExecutionParam;
	}

	public List<BatchStepExecution> getBatchStepExecutions() {
		return this.batchStepExecutions;
	}

	public void setBatchStepExecutions(List<BatchStepExecution> batchStepExecutions) {
		this.batchStepExecutions = batchStepExecutions;
	}

	public BatchStepExecution addBatchStepExecution(BatchStepExecution batchStepExecution) {
		getBatchStepExecutions().add(batchStepExecution);
		batchStepExecution.setBatchJobExecution(this);

		return batchStepExecution;
	}

	public BatchStepExecution removeBatchStepExecution(BatchStepExecution batchStepExecution) {
		getBatchStepExecutions().remove(batchStepExecution);
		batchStepExecution.setBatchJobExecution(null);

		return batchStepExecution;
	}

}
