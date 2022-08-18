package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException{

	String value;
	
	public ResourceNotFoundException(String value){
		super(String.format("%s mobile number is not present..", value));
		this.value=value;
	}
	
}
