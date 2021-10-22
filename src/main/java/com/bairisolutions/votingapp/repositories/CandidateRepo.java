package com.bairisolutions.votingapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bairisolutions.votingapp.entity.Candidate;
import com.bairisolutions.votingapp.entity.Citizen;

public interface CandidateRepo extends JpaRepository<Candidate, Integer>{

  Candidate findByid(Long id);
}
