package com.todolist.todolists.controller;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todolist.todolists.service.jparepository;
import com.todolist.todolists.todo.Todo;


//@Controller

public class controlcalassjpa {

//private serviceclass service;
private jparepository repository;
public controlcalassjpa(jparepository repository) {
	super();
	this.repository = repository;
}
@GetMapping("listtodos")
public String gotolists(ModelMap model) {
	List<Todo> getall = repository.findAll();
	model.put("todos", getall);
	return "listall";
}
@GetMapping("addtodo")
public String adding(ModelMap model) {
	Todo todo = new Todo(1,getloginusername(model),"rew",6,LocalDate.now().plusYears(2));
	model.put("todos", todo);
	return "adding";
}
@PostMapping("addtodo")
public String addingpost(ModelMap model,Todo todos) {
	
	repository.save(todos);
	return "redirect:listtodos";
}
@GetMapping("delete")
public String deleting(@RequestParam int count) {
	repository.deleteById(count);
	repository.deleteById(count);
	
	return "redirect:listtodos";
}
@GetMapping("update")
public String updating(@RequestParam int count,ModelMap model) {
	
	Optional<Todo> byId = repository.findById(count);
	
	
	model.put("todos",byId);
	
	return "adding";
}
@PostMapping("update")
public String updating(ModelMap model,Todo todo) {

//	service.update(todoes);

repository.deleteById(todo.getCount());

	repository.save(todo);
	
	return "redirect:listtodos";
}
private String getloginusername(ModelMap model) {
	return SecurityContextHolder.getContext().getAuthentication().getName();
}
}
///META-INF/resources/webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css
///META-INF/resources/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js
///META-INF/resources/webjars/jquery/3.6.0/jquery.min.js
///META-INF/resources/webjars/bootstrap/5.1.3/css/bootstrap.min.css
///META-INF/resources/webjars/bootstrap/5.1.3/js/bootstrap.min.js