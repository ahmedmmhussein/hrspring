package hr.web;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {
/*@ExceptionHandler(EmptyResultDataAccessException.class)
public String outofRangeHandler(){
	return "errorpage";
	
}*/
}
