package com.javaweb.util;

public class StringUtils {
	
	public static boolean isNotBlank(String value) {
		if(value != null && !value.isEmpty()) return true;
		else return false;
	}
	
	public static boolean isNumber(Object value) {
		try {
			Long number = Long.parseLong(value.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
		
	}
}
