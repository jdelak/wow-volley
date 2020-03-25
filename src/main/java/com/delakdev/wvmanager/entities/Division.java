package com.delakdev.wvmanager.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	@Transient
	private Long parent_division;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=true)
	@JoinColumn(name="parent_division")
	private Division parent;
	
	@OneToMany(mappedBy="parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Division> children = new HashSet<Division>();

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

	public Long getParent_division() {
		return parent_division;
	}

	public void setParent_division(Long parent_division) {
		this.parent_division = parent_division;
	}

	public Division getParent() {
		return parent;
	}

	public void setParent(Division parent) {
		this.parent = parent;
	}

	public Set<Division> getChildren() {
		return children;
	}

	public void setChildren(Set<Division> children) {
		this.children = children;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
	
	
	
	
	

}
