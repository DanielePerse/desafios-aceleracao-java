package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.entity.Challenge;

public interface ChallengeRepository extends CrudRepository<Challenge, Long>{
	
	@Query("select c from Challenge c where " +
			"c.id = (select a.challenge.id from Acceleration a where a.id = :accelerationId) and " +
			"c.id = (select s.id.challenge.id from Submission s where s.id.user.id = :userId)")
	List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId, @Param("userId") Long userId);
}
