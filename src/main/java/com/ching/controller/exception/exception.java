package com.ching.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class exception {
	
	@ExceptionHandler(Exception.class)
	public String yichang(Exception e){
		System.out.println("chucuo");
		e.printStackTrace();
		return "error"; 
	}
}
