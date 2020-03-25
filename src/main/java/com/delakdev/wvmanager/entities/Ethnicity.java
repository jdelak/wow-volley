package com.delakdev.wvmanager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ethnicities")
public class Ethnicity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_ethnicity")
	private long id;
	@Column(name="name_ethnicity")
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_faction_ethnicity", referencedColumnName = "id_faction")
	private Faction factionId;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_image_ethnicity", referencedColumnName = "id_image")
	private Image crest;
	@OneToMany(mappedBy="ethnicityId")
	private List <Player> players;
	
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
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
	
	
	

}
