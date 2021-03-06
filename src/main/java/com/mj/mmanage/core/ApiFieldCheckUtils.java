package com.mj.mmanage.core;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.mj.mmanage.core.ApiFieldsCheck.BooleanEnum;
import com.mj.mmanage.core.ApiFieldsCheck.FieldTypeEnum;
import com.mj.mmanage.model.UserInfo;
import com.mj.mmanage.util.StringUtil;

public class ApiFieldCheckUtils {

	public static boolean fieldCheckUtil(Object obj) throws AppException {
		
		Class<? extends Object> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		
		for(Field field : fields){
			if(field.isAnnotationPresent(ApiFieldsCheck.class)){
				Object value = null ;
				try {
					//用反射获取值
					PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
					//执行get方法获取值
					value = pd.getReadMethod().invoke(obj);
				} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
					throw new AppException("-901", "系统异常，请联系管理员！");
				}
				
				//获取字段的校验规则
				ApiFieldsCheck api = field.getAnnotation(ApiFieldsCheck.class);
				
				String desc = api.desc();
				
				//是否必输
				BooleanEnum isNull = api.isNull();
				if(BooleanEnum.Yes.equals(isNull) && StringUtil.isEmpty(value)){
					throw new AppException("101", desc + "字段为必输项");
				}
				//字段长度
				int length = api.length();
				if(length!=-1 && !StringUtil.isEmpty(value) && value.toString().length() > length){
					throw new AppException("102", desc + "字段长度最大为"+length);
				}
				
				//正则表达式
				String matches = api.matches();
				if(!StringUtil.isEmpty(matches) && !StringUtil.isEmpty(value) &&
						!value.toString().matches(matches)){
					throw new AppException("103", desc + "字段格式不符合");
				}
				
				//字段类型
				FieldTypeEnum type = api.type();
				
			}
		}
		
		return true;
	}
	
}
