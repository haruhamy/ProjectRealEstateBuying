package com.javaweb.customexception;

public class ValidateDataBuildingException extends RuntimeException{
	public ValidateDataBuildingException(String messages){
		super(messages);
	}
}
