package com.mj.mmanage.util;
/**
 * 公共返回对象
 * @author 郭保利
 *
 */
public class RetMessageVo {
	private String retCode = "AAAAAAA";
	private String retMsg = "操作成功!";
	private Object content;
	
	public String getRetCode() {
		return retCode;
	}
	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}
	public String getRetMsg() {
		return retMsg;
	}
	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	
}
