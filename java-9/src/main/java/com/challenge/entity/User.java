package com.challenge.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

// https://www.baeldung.com/jpa-size-length-column-differences
// https://thorben-janssen.com/key-jpa-hibernate-annotations/
// https://dzone.com/articles/all-jpa-annotations-mapping-annotations
// https://www.baeldung.com/javax-validation
// https://www.devmedia.com.br/hibernate-mapping-mapeando-relacionamentos-entre-entidades/29445
// https://www.devmedia.com.br/manytomany-hibernate-variacoes-unidirecional-e-bidirecional/29535
// https://www.youtube.com/watch?v=GRyNWIEZ6MQ

// Objetivo do desafio -> fazer estrutura básica -> criei apenas os atributos, pois só preciso mostrar as tabelas e seus relacionamentos
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "full_name")
	@Size(max = 100)
	@NotNull
	private String fullName;
	
	@Column(name = "email")
	@Size(max = 100)
	@NotNull
	@Email
	private String email;
	
	@Column(name = "nickname")
	@Size(max = 50)
	@NotNull
	private String nickname;
	
	@Column(name = "password")
	@Size(max = 255)
	@NotNull
	private String password;
	
	@Column(name = "created_at")
	@CreatedDate
	private LocalDateTime createdAt;
	
	@OneToMany
	private List<Candidate> candidates;
	
	@OneToMany
	private List<Submission> submissions;
	
	// OK - hasOneToManySubmissions
	// OK - hasOneToManyCandidates
	// hasIdWithAnnotationGeneratedValueWithStrategyIdentity
	// checkOneToManyFieldsQuantity
	// isEntityListener
}
