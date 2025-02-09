package com.infy.utility;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.error.ErrorInfo;
import com.infy.exception.InfyMeMobileGlobalExceptionHandler;

@RestControllerAdvice
public class Exception {

	@Autowired
	Environment environment;
	
	//private static final Log LOGGER = LogFactory.getLog(Exception.class);
	
//	@ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
//	public ResponseEntity<ErrorInfo> ExceptionHandler(Exception exception){
//		LOGGER.error(exception.getMessage(), exception);
//		String errorMsg;
//		if (exception instanceof MethodArgumentNotValidException) {
//			MethodArgumentNotValidException manvException = (MethodArgumentNotValidException) exception;
//			errorMsg = manvException.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
//					.collect(Collectors.joining(", "));
//		} else {
//			ConstraintViolationException cvException = (ConstraintViolationException) exception;
//			errorMsg = cvException.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
//					.collect(Collectors.joining(", "));
//		}
//		ErrorInfo errorInfo = new ErrorInfo();
//		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
//		errorInfo.setErrorMessage(errorMsg);
//		errorInfo.setErrorTimeStamp(LocalDateTime.now());
//		return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
//		
//	}
//	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<ErrorInfo> exceptionHandler(MethodArgumentNotValidException exception){
		
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(exception.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(",")));
		errorInfo.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(ConstraintViolationException exception){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMessage(exception.getConstraintViolations().stream().map(x -> x.getMessage())
				.collect(Collectors.joining(",")));
		errorInfo.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InfyMeMobileGlobalExceptionHandler.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(InfyMeMobileGlobalExceptionHandler ex){
		
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
		errorInfo.setErrorMessage(environment.getProperty(ex.getMessage()));
		errorInfo.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.NOT_FOUND);
	}
}
