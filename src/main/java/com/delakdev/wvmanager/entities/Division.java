package com.delakdev.wvmanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Division {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String level;
	private Division parentId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Division getParentId() {
		return parentId;
	}
	public void setParentId(Division parentId) {
		this.parentId = parentId;
	}
	
	
	

}
