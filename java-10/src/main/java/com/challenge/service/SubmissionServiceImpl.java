package com.challenge.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.Submission;
import com.challenge.repository.SubmissionRepository;
import com.challenge.service.interfaces.SubmissionServiceInterface;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface {
	
	@Autowired
	private SubmissionRepository submissionRepository;

	@Override
	public Submission save(Submission submission) {
		return submissionRepository.save(submission);
	}

	@Override
	public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
		BigDecimal score = submissionRepository.findHigherScoreByChallengeId(challengeId);
		
		if (score == null) {
			return BigDecimal.ZERO;
		}
		
		return score;
	}

	@Override
	public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
		return null;
	}

}
