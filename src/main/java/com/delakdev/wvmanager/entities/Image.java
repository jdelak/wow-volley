package com.delakdev.wvmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_image")
	private long id;
	@Column(name="url_image")
	private String url;
	@Column(name="name_type_image")
	@Enumerated(EnumType.STRING)
	private Type imageType;

	@OneToOne(mappedBy = "crest")
	private Faction faction;
	
	@OneToOne(mappedBy = "logo")
	private Team team;
	
	@OneToOne(mappedBy = "crest")
	private Ethnicity ethnicity;

	public enum Type {
		ETHNICITY,
		FACTION,
		TEAM
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Type getImageType() {
		return imageType;
	}

	public void setImageType(Type imageType) {
		this.imageType = imageType;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Ethnicity getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(Ethnicity ethnicity) {
		this.ethnicity = ethnicity;
	}



}
