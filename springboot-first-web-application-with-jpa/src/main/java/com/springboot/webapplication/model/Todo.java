package com.springboot.webapplication.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="todo")
public class Todo {
	@Id
	@GeneratedValue
	private int id;
	
	private String user;
	@Size(min=10,message="Enter atleast 10 characters..")
	private String descr;
	private Date targDate;
	private boolean isDone;
	
	public Todo() {
		super();
	}
	public Todo(int id, String user, String desc, Date targDate, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.descr = desc;
		this.targDate = targDate;
		this.isDone = isDone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return descr;
	}
	public void setDesc(String desc) {
		this.descr = desc;
	}
	public Date getTargDate() {
		return targDate;
	}
	public void setTargDate(Date targDate) {
		this.targDate = targDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
		
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		 if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        Todo other = (Todo) obj;
	        if (id != other.id) {
	            return false;
	        }
	        return true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
                "Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id,
                user, descr, targDate, isDone);
	}
	
	
}
