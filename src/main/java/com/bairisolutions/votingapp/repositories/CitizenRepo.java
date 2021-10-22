package com.bairisolutions.votingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bairisolutions.votingapp.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen,Integer> {

	Citizen findByName(String name);
}
