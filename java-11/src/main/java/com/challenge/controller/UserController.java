package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired // faz injeção de dependências do userService (não precisa instanciar - new)
	private UserService userService;
	
	
	@GetMapping
	public ResponseEntity<List<User>> findByAccelerationNameOrCompanyId(@RequestParam(required = false) String accelerationName, @RequestParam(required = false) Long companyId) {
		
		if (accelerationName != null) return ResponseEntity.ok(userService.findByAccelerationName(accelerationName));
		
		if (companyId != null) return ResponseEntity.ok(userService.findByCompanyId(companyId));

		return ResponseEntity.notFound().build();	
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok(userService.findById(id).orElseThrow(() -> new RuntimeException()));
	}
}
