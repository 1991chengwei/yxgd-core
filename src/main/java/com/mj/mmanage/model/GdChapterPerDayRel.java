package com.mj.mmanage.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tGdChapterPerDayRel")
public class GdChapterPerDayRel<date> extends BaseEntity {
	
	@Id
	@Column(name = "gdDate")
	private String gdDate;
	
	@Column(name = "gdPeriod")
	private String gdPeriod;
	
	@Column(name = "bookId")
	private int bookId;
	
	@Column(name = "bookChapter")
	private int bookChapter;
	
	@Column(name = "gdId")
	private int gdId;
	
	@Column(name = "recordTime")
	private date recordTime;

	public String getGdDate() {
		return gdDate;
	}

	public void setGdDate(String gdDate) {
		this.gdDate = gdDate;
	}

	public String getGdPeriod() {
		return gdPeriod;
	}

	public void setGdPeriod(String gdPeriod) {
		this.gdPeriod = gdPeriod;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookChapter() {
		return bookChapter;
	}

	public void setBookChapter(int bookChapter) {
		this.bookChapter = bookChapter;
	}

	public int getGdId() {
		return gdId;
	}

	public void setGdId(int gdId) {
		this.gdId = gdId;
	}

	public date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(date recordTime) {
		this.recordTime = recordTime;
	}

	
	
	
}
