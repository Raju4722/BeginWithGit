package com.todolist.todolists.restapi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class Rservice {
  private static List<UserDeta> arrays=new ArrayList<>();
  static {
	   arrays.add(new UserDeta(512,"Raju"));
	   arrays.add(new UserDeta(531,"Raju"));
  }
  public List<UserDeta> getall() {
	  return arrays;
  }
  public UserDeta gettingone(int id) {
	  Predicate<? super UserDeta> predicate=ab->ab.getId()==id;
	  UserDeta abc = arrays.stream().filter(predicate).findFirst().orElse(null);
	return abc;
  }
  public UserDeta add(UserDeta user) {
	  arrays.add(user);
	  return user;
  }
  public void deleting(int id) {
	  Predicate<? super UserDeta> predicate=a->a.getId()==id;
	arrays.removeIf(predicate);
  }
}
