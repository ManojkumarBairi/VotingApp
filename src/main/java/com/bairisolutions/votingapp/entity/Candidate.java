package com.bairisolutions.votingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="candidate")
@Entity
public class Candidate {
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="candidate_name")
	private String name;
	
	@Column(name ="numberOfVotes")
	private Integer noOfVotes;
	
    
	public Candidate() {
		super();
	}

	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNoOfVotes() {
		return noOfVotes;
	}

	public void setNoOfVotes(Integer noOfVotes) {
		this.noOfVotes = noOfVotes;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", noOfVotes=" + noOfVotes + "]";
	}
	
	
	
}
