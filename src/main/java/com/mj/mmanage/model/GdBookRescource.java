package com.mj.mmanage.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tGdBookResource")
public class GdBookRescource extends BaseOperateEntity {
	@Id
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "bookChapter")
	private String bookChapter;
	
	@Column(name = "txtPath")
	private String txtPath;
	
	@Column(name = "txtName")
	private String txtName;
	
	@Column(name = "txtSize")
	private double txtSize;
	
	@Column(name = "fileType")
	private String fileType;
	
	@Column(name = "wxUserId")
	private String wxUserId;
	
	@Column(name = "fileState")
	private String fileState;

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookChapter() {
		return bookChapter;
	}

	public void setBookChapter(String bookChapter) {
		this.bookChapter = bookChapter;
	}

	public String getTxtPath() {
		return txtPath;
	}

	public void setTxtPath(String txtPath) {
		this.txtPath = txtPath;
	}

	public String getTxtName() {
		return txtName;
	}

	public void setTxtName(String txtName) {
		this.txtName = txtName;
	}

	public double getTxtSize() {
		return txtSize;
	}

	public void setTxtSize(double txtSize) {
		this.txtSize = txtSize;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getWxUserId() {
		return wxUserId;
	}

	public void setWxUserId(String wxUserId) {
		this.wxUserId = wxUserId;
	}

	public String getFileState() {
		return fileState;
	}

	public void setFileState(String fileState) {
		this.fileState = fileState;
	}

	

}
