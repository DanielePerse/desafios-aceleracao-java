package com.challenge.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Acceleration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;	
	
	@Size(max = 100)
	@NotNull
	private String name;
	
	@Size(max = 50)
	@NotNull
	private String slug;
	
	@Column(name = "created_at")
	@CreatedDate
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(name = "challenge_id")
	private Challenge challenge;
	
	@OneToMany
	private List<Candidate> candidates;
	
	// OK - hasOneToManyCandidates
	// OK - checkOneToManyFieldsQuantity
	// isEntityListener
	// OK - checkOneToManyFieldsQuantity
}
