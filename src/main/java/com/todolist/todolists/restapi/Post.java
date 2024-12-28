package com.todolist.todolists.restapi;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	private int id;
	private String desc;
	@ManyToOne(fetch=FetchType.LAZY)
    private UserDeta user;
	public Post() {
	}

	public Post(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", desc=" + desc + "]";
	}

	public UserDeta getUser() {
		return user;
	}

	public void setUser(UserDeta user) {
		this.user = user;
	}

}
