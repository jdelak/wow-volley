package com.delakdev.wvmanager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="factions")
public class Faction {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_faction")
	private long id;
	@Column(name="name_faction")
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image_faction", referencedColumnName = "id_image")
	private Image crest;
	@OneToMany(mappedBy="factionId")
	private List <Ethnicity> ethnicities;
	
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
	public Image getCrest() {
		return crest;
	}
	public void setCrest(Image crest) {
		this.crest = crest;
	}
	public List<Ethnicity> getEthnicities() {
		return ethnicities;
	}
	public void setEthnicities(List<Ethnicity> ethnicities) {
		this.ethnicities = ethnicities;
	}
	
	
	
	

}
