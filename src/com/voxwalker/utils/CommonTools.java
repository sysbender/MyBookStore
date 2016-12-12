package com.voxwalker.utils;

import java.util.Map;
import java.util.UUID;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

public class CommonTools {
	
	/**
	 * return random UUID - length = 32 
	 * @return
	 */
	public static String uuid(){
		return  UUID.randomUUID().toString().replace("-", "");
	}
	
	public static<T> T toBean(Map<?, ?> map, Class<T> clazz){
		
		T bean = null;
		try{
			bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(),  java.util.Date.class);
			BeanUtils.populate(bean, map);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return bean;
		
	}
	


}
