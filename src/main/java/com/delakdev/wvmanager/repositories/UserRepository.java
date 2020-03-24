package com.delakdev.wvmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.delakdev.wvmanager.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
