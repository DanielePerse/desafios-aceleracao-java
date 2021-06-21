package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class CandidateIdentity implements Serializable{

    @ManyToOne
    @NotNull
    private User user;
    
    @ManyToOne
    @NotNull
    private Acceleration accelaration;
    
    @ManyToOne
    @NotNull
    private Company company;
}
