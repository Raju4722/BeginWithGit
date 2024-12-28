package com.todolist.todolists.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo1 {
	@Id
	private int id1;
	private String name1;
	private String branch1;
	public Todo1(){}
	
	public Todo1(int id1, String name1, String branch1) {
		super();
		this.id1 = id1;
		this.name1 = name1;
		this.branch1 = branch1;
	}

	public int getId1() {
		return id1;
	}
	public void setId1(int id1) {
		this.id1 = id1;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getBranch1() {
		return branch1;
	}
	public void setBranch1(String branch1) {
		this.branch1 = branch1;
	}

	@Override
	public String toString() {
		return "Todo1 [id1=" + id1 + ", name1=" + name1 + ", branch1=" + branch1 + "]";
	}
	

}
