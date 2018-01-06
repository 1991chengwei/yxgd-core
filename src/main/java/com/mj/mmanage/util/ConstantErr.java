package com.mj.mmanage.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 错误码常量
 * @author 郭保利
 *
 */
public class ConstantErr {
	public static Map<String,String> errorMap = new HashMap<String,String>();
	static{
		errorMap.put("-999", "数据库操作异常");
		errorMap.put("000", "测试异常");
		errorMap.put("IMBK001", "图书文本或音频上传失败");
		errorMap.put("IMBK002", "图书图书编号不能为空");
	}
	
	public static final String E0001 = "E0001"; // 
	
}
