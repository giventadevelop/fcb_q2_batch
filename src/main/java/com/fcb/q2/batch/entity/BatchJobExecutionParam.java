package com.fcb.q2.batch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the batch_job_execution_params database table.
 * 
 */
/*@Entity
@Table(name="batch_job_execution_params")
@NamedQuery(name="BatchJobExecutionParam.findAll", query="SELECT b FROM BatchJobExecutionParam b")*/
public class BatchJobExecutionParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATE_VAL")
	private Date dateVal;

	@Column(name="DOUBLE_VAL")
	private double doubleVal;

	private String identifying;

	@Column(name="KEY_NAME")
	private String keyName;

	@Column(name="LONG_VAL")
	private BigInteger longVal;

	@Column(name="STRING_VAL")
	private String stringVal;

	@Column(name="TYPE_CD")
	private String typeCd;

	//bi-directional many-to-one association to BatchJobExecution
	/*@ManyToOne
	@JoinColumn(name="JOB_EXECUTION_ID")*/
	private BatchJobExecution batchJobExecution;

	public BatchJobExecutionParam() {
	}

	public Date getDateVal() {
		return this.dateVal;
	}

	public void setDateVal(Date dateVal) {
		this.dateVal = dateVal;
	}

	public double getDoubleVal() {
		return this.doubleVal;
	}

	public void setDoubleVal(double doubleVal) {
		this.doubleVal = doubleVal;
	}

	public String getIdentifying() {
		return this.identifying;
	}

	public void setIdentifying(String identifying) {
		this.identifying = identifying;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public BigInteger getLongVal() {
		return this.longVal;
	}

	public void setLongVal(BigInteger longVal) {
		this.longVal = longVal;
	}

	public String getStringVal() {
		return this.stringVal;
	}

	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}

	public String getTypeCd() {
		return this.typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}

	public BatchJobExecution getBatchJobExecution() {
		return this.batchJobExecution;
	}

	public void setBatchJobExecution(BatchJobExecution batchJobExecution) {
		this.batchJobExecution = batchJobExecution;
	}

}
