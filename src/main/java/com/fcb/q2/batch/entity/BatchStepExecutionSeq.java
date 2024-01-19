package com.fcb.q2.batch.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the batch_step_execution_seq database table.
 * 
 */
/*@Entity
@Table(name="batch_step_execution_seq")
@NamedQuery(name="BatchStepExecutionSeq.findAll", query="SELECT b FROM BatchStepExecutionSeq b")*/
public class BatchStepExecutionSeq implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigInteger id;

	@Column(name="UNIQUE_KEY")
	private String uniqueKey;

	public BatchStepExecutionSeq() {
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
