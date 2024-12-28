package com.todolist.todolists.restapi.Exception;

import java.time.LocalDate;

public class Errorclass {
private LocalDate localdate;
private String message;
private String details;
public LocalDate getLocaldate() {
	return localdate;
}
public String getMessage() {
	return message;
}
public String getDetails() {
	return details;
}
public Errorclass(LocalDate localdate, String message, String details) {
	super();
	this.localdate = localdate;
	this.message = message;
	this.details = details;
}
@Override
public String toString() {
	return "Errorclass [localdate=" + localdate + ", message=" + message + ", details=" + details + "]";
}


}
