package com.bairisolutions.votingapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bairisolutions.votingapp.entity.Candidate;
import com.bairisolutions.votingapp.entity.Citizen;
import com.bairisolutions.votingapp.repositories.CandidateRepo;
import com.bairisolutions.votingapp.repositories.CitizenRepo;

@Controller
public class VotingController {
	public final Logger logger = Logger.getLogger(VotingController.class);

	@Autowired
	CitizenRepo citizenRepo;
	
	@Autowired
	CandidateRepo candidateRepo;
	
	@RequestMapping("/")
	public String goToVote() {
		logger.info("returning vote.html");
		return "vote.html";
	}
	
	@RequestMapping("/doLogin")
	public String doLogin(@RequestParam String name, Model model, HttpSession session) {
		logger.info("getting citizen from database");
		Citizen citizen = citizenRepo.findByName(name);
		if(!citizen.getHasVoted().booleanValue()) {
			session.setAttribute("citizen", citizen);
			List<Candidate> candidates = candidateRepo.findAll();
			logger.info("putting candidates to model");
			model.addAttribute("candidates",candidates);
			return "/performVote.html";
		} else {
			return "/alreadyVoted.html";
		}
	}
	
	@RequestMapping("/voteFor")
	public String  voteFor(@RequestParam Long id, HttpSession session) {
		Citizen citizen = (Citizen) session.getAttribute("citizen");
		if(!citizen.getHasVoted()) {
			
		citizen.setHasVoted(true);
		
		citizenRepo.save(citizen);
		
		Candidate candidate = candidateRepo.findByid(id);
		logger.info("voting for candidate "+ candidate.getName());
		candidate.setNoOfVotes(candidate.getNoOfVotes()+1);
		candidateRepo.save(candidate);
		
		return "voted.html";
		} 
		
		return "alreadyVoted.html";
		
	}
	
}
