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
@Table(name="teams")
public class Team {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_team")
	private long id;
	@Column(name="name_team")
	private String name;
	@OneToOne()
    @JoinColumn(name = "id_image_team", referencedColumnName = "id_image")
	private Image logo;
	@ManyToOne()
    @JoinColumn(name = "id_faction_team", referencedColumnName = "id_faction")
	private Faction factionId;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_team", referencedColumnName = "id_user")
	private User userId;
	@ManyToOne()
    @JoinColumn(name = "id_division_team", referencedColumnName = "id_division", nullable=true)
	private Division divisionId;
	@OneToMany(mappedBy="teamId")
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
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	

}
