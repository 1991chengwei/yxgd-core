package com.mj.mmanage.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tGdBook")
public class GdBook extends BaseOperateEntity {

	@Id
	@Column(name = "bookId")
	private Integer bookId;
	
	@Column(name = "bookName")
	private String bookName;
	
	@Column(name = "bookAuthor")
	private String bookAuthor;
	
	@Column(name = "bookTag")
	private String bookTag;
	
	@Column(name = "bookSltPath")
	private String bookSltPath;
	
	@Column(name = "bookSummary")
	private String bookSummary;
	
	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookTag() {
		return bookTag;
	}

	public void setBookTag(String bookTag) {
		this.bookTag = bookTag;
	}

	public String getBookSltPath() {
		return bookSltPath;
	}

	public void setBookSltPath(String bookSltPath) {
		this.bookSltPath = bookSltPath;
	}

	public String getBookSummary() {
		return bookSummary;
	}

	public void setBookSummary(String bookSummary) {
		this.bookSummary = bookSummary;
	}
	
	
}
