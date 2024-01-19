package com.fcb.q2.batch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the batch_job_execution_seq database table.
 * 
 */
/*@Entity
@Table(name="batch_job_execution_seq")
@NamedQuery(name="BatchJobExecutionSeq.findAll", query="SELECT b FROM BatchJobExecutionSeq b")*/
public class BatchJobExecutionSeq implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger id;

	@Column(name="UNIQUE_KEY")
	private String uniqueKey;

	public BatchJobExecutionSeq() {
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getUniqueKey() {
		return this.uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

}
