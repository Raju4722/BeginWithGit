package com.todolist.todolists.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Todo {
	
  
  @Id
  private String name;
  private int count;
  private String description;
  private int experience;
  private LocalDate localDate;
  public Todo() 
  {}
  
public Todo(int count, String name, String description, int experience,LocalDate localDate) {
	super();
	this.count = count;
	this.name = name;
	this.description = description;
	this.experience = experience;
	this.localDate=localDate;
	
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getExperience() {
	return experience;
}
public void setExperience(int experience) {
	this.experience = experience;
}



public LocalDate getLocalDate() {
	return localDate;
}
public void setLocalDate(LocalDate localDate) {
	this.localDate = localDate;
}
@Override
public String toString() {
	return "Todo [count=" + count + ", name=" + name + ", description=" + description + ", experience=" + experience
			+ ", localDate=" + localDate + "]";
}


}
