package com.todolist.todolists.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todolists.todo.Todo;

public interface jparepository extends JpaRepository<Todo, Integer> {
	}
