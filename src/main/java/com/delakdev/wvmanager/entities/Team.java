package com.delakdev.wvmanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Image logo;
	private Faction factionId;
	private User userId;
	private Division divisionId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Image getLogo() {
		return logo;
	}
	public void setLogo(Image logo) {
		this.logo = logo;
	}
	public Faction getFactionId() {
		return factionId;
	}
	public void setFactionId(Faction factionId) {
		this.factionId = factionId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Division getDivisionId() {
		return divisionId;
	}
	public void setDivisionId(Division divisionId) {
		this.divisionId = divisionId;
	}
	
	

}
