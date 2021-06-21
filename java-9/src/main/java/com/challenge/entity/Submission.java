package com.challenge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Submission {
	
	@EmbeddedId
	// cgave composta por outros ids
	private SubmissionIdentity submissionIdentity;
	
	@NotNull
	private Float score;
	
	@Column(name = "created_at")
	@CreatedDate
	private LocalDateTime createdAt;
	
	// TableWithEmbeddedIdTest
}
