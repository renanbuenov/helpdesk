package com.renan.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Technician;
import com.renan.helpdesk.repositories.TechnicianRepository;

@Service
public class TechService {
	
	@Autowired
	private TechnicianRepository repository;
	
	public Technician findById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElse(null);
	}
}