package com.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface {
	
	@Autowired
	private ChallengeRepository challengeRepository;

	@Override
	public Challenge save(Challenge challenge) {
		return challengeRepository.save(challenge);
	}

	@Override
	public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
		List<Challenge> challenge = challengeRepository.findByAccelerationIdAndUserId(accelerationId, userId);
		return challenge;
	}

}
// https://imasters.com.br/desenvolvimento/spring-boot-um-exemplo-completo
// https://www.tutorialspoint.com/spring_boot/spring_boot_service_components.htm
// exemplo biblioteca último video módulo 5