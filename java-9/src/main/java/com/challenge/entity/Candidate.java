package com.challenge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Candidate {
	
	@EmbeddedId
	private CandidateIdentity candidateIdentity;
	
	@NotNull
	private Integer status;
	
	@Column(name = "created_at")
	@CreatedDate
	private LocalDateTime createdAt;
	
	// checkPrimaryKeysWithManyToOne -> Not embeddedId
	// hasEmbeddedId
	// checkEmbeddedIdIsEmbeddable
	// checkPrimaryKeys -> Not embeddedId
	// isEntityListener
	// checkManyToOneFieldsQuantity
	// TableWithEmbeddedIdTest -> ?? 
}
