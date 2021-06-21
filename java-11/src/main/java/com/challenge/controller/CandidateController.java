package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private CandidateMapper candidateMapper;
	
	
	@GetMapping
	public ResponseEntity<List<CandidateDTO>> findByCompanyIdOrByAccelerationId(@RequestParam(required = false) Long companyId, @RequestParam(required = false) Long accelerationId) {
		
		if (accelerationId != null) return ResponseEntity.ok(candidateMapper.map(candidateService.findByAccelerationId(accelerationId)));
		
		if (companyId != null) return ResponseEntity.ok(candidateMapper.map(candidateService.findByCompanyId(companyId)));
		
		return ResponseEntity.notFound().build();	
		
	}

	@GetMapping("/{userId}/{companyId}/{accelerationId}")
	public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId, @PathVariable Long companyId, @PathVariable Long accelerationId) {
		
		Candidate candidate = candidateService.findById(userId, companyId, accelerationId).orElseThrow(() -> new RuntimeException());
		
		return ResponseEntity.ok(candidateMapper.map(candidate));
	}
}
