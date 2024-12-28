package com.todolist.todolists.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

	import com.todolist.todolists.todo.Todo;

@Service
public class serviceclass {
  private static List<Todo> arrays=new ArrayList<>();
  static {
	  arrays.add(new Todo(1,"raju","enginner",0,LocalDate.now().plusYears(66)));
	  arrays.add(new Todo(2,"om","enginner",2,LocalDate.now().plusYears(25)));

  }
  public List<Todo> getAll(){
	  return arrays;
  }
  public void adding(Todo todo) {
	  arrays.add(todo);
  }
  public void deletings(String name) {
	  Predicate<? super Todo> predicate=ac -> ac.getName().equals(name);
	arrays.removeIf(predicate);
  }
public Todo findbyname(String name) {
      Predicate<? super Todo> predicate=ab -> ab.getName().equals(name);
	return arrays.stream().filter(predicate).findFirst().get();
}
//public void update(Todo todoes) {
//deletings(todoes.getName());
//adding(todoes);
//}

}
