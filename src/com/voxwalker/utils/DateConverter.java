package com.voxwalker.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

/**
 * convert String to java.util.Date
 * @author jason
 *
 */
public class DateConverter implements Converter{

	@Override
	public Object convert(Class type, Object value) {
		// value is null
		if(value == null) return null;
		// value is not string
		if(!(value instanceof String)) {return value; }
		// value is String
		String val = (String) value;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			return sdf.parse(val);
		}catch(ParseException e){
			throw new RuntimeException(e);
		}
		 
	}

}
