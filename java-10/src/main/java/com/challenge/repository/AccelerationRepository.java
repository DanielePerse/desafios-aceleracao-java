package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.entity.Acceleration;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long>{
	
	@Query("select c.id.acceleration from Candidate c where c.id.company.id =:companyId")
	List<Acceleration> findByCompanyId(@Param("companyId") Long companyId);
}
