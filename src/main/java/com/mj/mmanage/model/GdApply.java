package com.mj.mmanage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tGdApply")
public class GdApply extends BaseEntity {

	@Id
    @Column(name = "gdId")
    private int gdId;
	
	@Column(name = "wxUserId")
    private String wxUserId;
	
	@Column(name = "applyTime")
    private Date applyTime;
	
	@Column(name = "signNum")
    private int signNum;
	
	@Column(name = "signContinuousDays")
    private int signContinuousDays;

	public int getGdId() {
		return gdId;
	}

	public void setGdId(int gdId) {
		this.gdId = gdId;
	}

	public String getWxUserId() {
		return wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public int getSignNum() {
		return signNum;
	}

	public void setSignNum(int signNum) {
		this.signNum = signNum;
	}

	public int getSignContinuousDays() {
		return signContinuousDays;
	}

	public void setSignContinuousDays(int signContinuousDays) {
		this.signContinuousDays = signContinuousDays;
	}

	
	
}
