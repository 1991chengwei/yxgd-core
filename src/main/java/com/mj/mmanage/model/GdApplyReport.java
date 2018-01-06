package com.mj.mmanage.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tGdApplyReport")
public class GdApplyReport extends BaseEntity {
	@Id
	@Column(name = "dataDate")
	private String dataDate;
	
	@Column(name = "gdId")
	private int gdId;
	
	@Column(name = "signRate")
	private double signRate;

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	public int getGdId() {
		return gdId;
	}

	public void setGdId(int gdId) {
		this.gdId = gdId;
	}

	public double getSignRate() {
		return signRate;
	}

	public void setSignRate(double signRate) {
		this.signRate = signRate;
	}

	
	
	

}
