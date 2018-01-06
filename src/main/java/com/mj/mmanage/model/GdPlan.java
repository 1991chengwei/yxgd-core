package com.mj.mmanage.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "tGdPlan")
public class GdPlan extends BaseOperateEntity {

	@Id
    @Column(name = "gdId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gdId;
	
	@Column(name = "gdTitle")
    private String gdTitle;
	
	@Column(name = "signupBeginDate")
    private String signupBeginDate;
	
	@Column(name = "signupEndDate")
    private String signupEndDate;
	
	@Column(name = "gdBeginDate")
    private String gdBeginDate;
	
	@Column(name = "gdEndDate")
    private String gdEndDate;
	
	@Column(name = "gdState")
    private String gdState;
	
	@Column(name = "sponsorUser")
    private String sponsorUser;
	
	@Column(name = "gdSlogan")
    private String gdSlogan;
	
	@Column(name = "wxUserId")
	private String wxUserId;
	
	@Column(name = "applyNum")
	private int applyNum;
	
	private String signFlag;

	@Transient
	private List<GdBook> gdBook;

	public List<GdBook> getGdBook() {
		return gdBook;
	}

	public void setGdBook(List<GdBook> gdBook) {
		this.gdBook = gdBook;
	}


	public int getGdId() {
		return gdId;
	}

	public void setGdId(int gdId) {
		this.gdId = gdId;
	}

	public String getGdTitle() {
		return gdTitle;
	}

	public void setGdTitle(String gdTitle) {
		this.gdTitle = gdTitle;
	}

	public String getSignupBeginDate() {
		return signupBeginDate;
	}

	public void setSignupBeginDate(String signupBeginDate) {
		this.signupBeginDate = signupBeginDate;
	}

	public String getSignupEndDate() {
		return signupEndDate;
	}

	public void setSignupEndDate(String signupEndDate) {
		this.signupEndDate = signupEndDate;
	}

	public String getGdBeginDate() {
		return gdBeginDate;
	}

	public void setGdBeginDate(String gdBeginDate) {
		this.gdBeginDate = gdBeginDate;
	}

	public String getGdEndDate() {
		return gdEndDate;
	}

	public void setGdEndDate(String gdEndDate) {
		this.gdEndDate = gdEndDate;
	}

	public String getGdState() {
		return gdState;
	}

	public void setGdState(String gdState) {
		this.gdState = gdState;
	}

	public String getSponsorUser() {
		return sponsorUser;
	}

	public void setSponsorUser(String sponsorUser) {
		this.sponsorUser = sponsorUser;
	}

	public String getGdSlogan() {
		return gdSlogan;
	}

	public void setGdSlogan(String gdSlogan) {
		this.gdSlogan = gdSlogan;
	}

	public int getApplyNum() {
		return applyNum;
	}

	public void setApplyNum(int applyNum) {
		this.applyNum = applyNum;
	}

	public String getSignFlag() {
		return signFlag;
	}

	public void setSignFlag(String signFlag) {
		this.signFlag = signFlag;
	}

	public String getWxUserId() {
		return wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}
}
