package com.javaweb.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.customexception.ValidateDataBuildingException;
import com.javaweb.dto.ErrorDetailReponse;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ValidateDataBuildingException.class)
	public ResponseEntity<Object> handleValidateDataBuildingExxception(ValidateDataBuildingException ex){
		ErrorDetailReponse errorDetailReponse = new ErrorDetailReponse();
		errorDetailReponse.setError(ex.getMessage());
		return new ResponseEntity<Object>(errorDetailReponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex){
		ErrorDetailReponse errorDetailReponse = new ErrorDetailReponse();
		errorDetailReponse.setError(ex.getMessage());
		return new ResponseEntity<Object>(errorDetailReponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> handleNumberFormatException(Exception ex){
		ErrorDetailReponse errorDetailReponse = new ErrorDetailReponse();
		errorDetailReponse.setError(ex.getMessage());
		return new ResponseEntity<Object>(errorDetailReponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
