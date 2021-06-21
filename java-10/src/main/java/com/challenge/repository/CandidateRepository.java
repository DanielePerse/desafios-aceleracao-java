package com.challenge.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId>{
	
	@Query("select c from Candidate c where c.id.company.id = :companyId")
	List<Candidate> findByCompanyId(@Param("companyId") Long companyId);
	
	@Query("select c from Candidate c where c.id.acceleration.id = :accelerationId")
	List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
	
	@Query("select c from Candidate c where " +
			"c.id.user.id = :userId and " +
			"c.id.company.id = :companyId and " +
			"c.id.acceleration.id = :accelerationId")
	Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);
}
