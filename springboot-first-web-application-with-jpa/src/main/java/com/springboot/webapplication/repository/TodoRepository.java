package com.springboot.webapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.webapplication.model.Todo;

public interface TodoRepository extends JpaRepository<Todo,Integer>{
	//define the methods for the implementation for the custom use
	public List<Todo> findByUser(String user); //find by the userName Column 
}
