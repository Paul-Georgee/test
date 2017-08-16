package com.project.util;

import java.sql.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * Ê±¼ä×ª»»Æ÷
 * @author SherLock
 *
 */
public class DateChange implements Converter<String, Date>{

	@Override
	public Date convert(String arg0) {
		if(arg0!=null&&arg0.matches("\\d{4}-\\d{2}-\\d{2}")){
			return Date.valueOf(arg0);
		}
		return null;
	}

}
