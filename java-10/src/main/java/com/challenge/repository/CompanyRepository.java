package com.challenge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.entity.Company;

public interface CompanyRepository extends CrudRepository<Company, Long>{
	
	@Query("select distinct c.id.company from Candidate c where c.id.acceleration.id = :accelerationId")
	List<Company> findByAccelerationId(@Param("accelerationId") Long accelerationId);
	
	@Query("select c.id.company from Candidate c where c.id.user.id = :userId")
	List<Company> findByUserId(@Param("userId") Long userId);
}
// https://www.w3schools.com/sql/sql_distinct.asp
