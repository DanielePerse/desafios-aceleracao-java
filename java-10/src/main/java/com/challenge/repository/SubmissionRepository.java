package com.challenge.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId>{
	
	@Query("select max(s.score) from Submission s where s.id.challenge.id = :challengeId")
	BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);
	
	// List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}

// https://www.guj.com.br/t/resolvido-select-de-dados-com-o-maior-valor/396882/2


//findByChallegeIdAndAccelerationId: buscar submissões de um determinado desafio de uma determinada aceleração

//[ERROR]   SubmissionServiceTest.whenFindByChallengeIdAndAccelerationId » UnsatisfiedDependency
