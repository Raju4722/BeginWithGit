package com.todolist.todolists.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class service {
	
		  private static List<Todo1> arrays=new ArrayList<>();
		  static {
			  arrays.add(new Todo1(1,"raju","enginner"));
			  arrays.add(new Todo1(2,"om","enginner"));

		  }
		  public List<Todo1> getAll(){
			  return arrays;
		  
}}
