package com.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;

@Service
public class UserServiceImpl implements UserServiceInterface{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public List<User> findByAccelerationName(String name) {
		return userRepository.findByAccelerationName(name);
	}

	@Override
	public List<User> findByCompanyId(Long companyId) {
		return userRepository.findByCompanyId(companyId);
	}

}
