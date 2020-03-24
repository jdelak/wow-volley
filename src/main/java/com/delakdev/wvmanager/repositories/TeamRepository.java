package com.delakdev.wvmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delakdev.wvmanager.entities.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
	
}
