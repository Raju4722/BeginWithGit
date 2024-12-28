package com.todolist.todolists.restapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UsernameNottFoundException extends RuntimeException {

	

	public UsernameNottFoundException(String string) {
		super(string);
	}

}
