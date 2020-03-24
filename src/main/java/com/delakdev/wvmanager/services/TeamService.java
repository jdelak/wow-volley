package com.delakdev.wvmanager.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.delakdev.wvmanager.entities.Faction;
import com.delakdev.wvmanager.entities.Player;
import com.delakdev.wvmanager.entities.Team;
import com.delakdev.wvmanager.repositories.TeamRepository;

@Service
public class TeamService {
	
	EntityManager em;
	@Autowired
	TeamRepository teamRepo;
	
	public List<Team> findAll(){
		return teamRepo.findAll();
	}
	
	public List<Player> findPlayerSquadByTeam(Team team){
		final Query query = em.createQuery("SELECT * from players WHERE team_id ="+team.getId()+" AND in_team = 1");
		@SuppressWarnings("unchecked")
		List<Player> players = query.getResultList();
		return players;
	}
	
	public List<Team> findByFaction(Faction faction){
		final Query query = em.createQuery("SELECT * from teams WHERE faction_id ="+faction.getId()+"");
		@SuppressWarnings("unchecked")
		List<Team> teams = query.getResultList();
		return teams;
	}

}
