package com.delakdev.wvmanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ethnicity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Faction factionId;
	private Image crest;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Faction getFactionId() {
		return factionId;
	}
	public void setFactionId(Faction factionId) {
		this.factionId = factionId;
	}
	public Image getCrest() {
		return crest;
	}
	public void setCrest(Image crest) {
		this.crest = crest;
	}
	
	

}
