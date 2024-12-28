package com.todolist.todolists.restapi.Exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class CustomizeresponsibilityExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,WebRequest request){
	  Errorclass errordetails=new Errorclass(LocalDate.now(), ex.getMessage(), request.getDescription(false));
	return new ResponseEntity(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
	  
  }
@ExceptionHandler(UsernameNottFoundException.class)
public final ResponseEntity<Errorclass> handleUserNottFoundException(Exception ex,WebRequest request){
  Errorclass errordetails=new Errorclass(LocalDate.now(), ex.getMessage(), request.getDescription(false));
return new ResponseEntity<Errorclass>(errordetails, HttpStatus.NOT_FOUND);
}


}
