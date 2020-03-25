package com.delakdev.wvmanager.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="divisions")
public class Division {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_division")
	private long id;
	@Column(name="level_division")
	private int level;
	@Column(name="pts_to_up_division", nullable=true)
	private int ptsToUp;
	@Column(name="pts_to_down_division", nullable=true)
	private int ptsToDown;
	@Column(name="parent_division", nullable=true)
	private Division parentId;
	@OneToMany(mappedBy="divisionId")
	private List <Team> teams;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPtsToUp() {
		return ptsToUp;
	}
	public void setPtsToUp(int ptsToUp) {
		this.ptsToUp = ptsToUp;
	}
	public int getPtsToDown() {
		return ptsToDown;
	}
	public void setPtsToDown(int ptsToDown) {
		this.ptsToDown = ptsToDown;
	}
	public Division getParentId() {
		return parentId;
	}
	public void setParentId(Division parentId) {
		this.parentId = parentId;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
	
	
	

}
