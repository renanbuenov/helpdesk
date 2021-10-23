package com.renan.helpdesk.services;

import java.util.List;
import java.util.Optional;

import com.renan.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Technician;
import com.renan.helpdesk.domain.dtos.TechnicianDTO;
import com.renan.helpdesk.repositories.TechnicianRepository;

@Service
public class TechService {
	
	@Autowired
	private TechnicianRepository repository;
	
	public Technician findById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null);
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);
	}
}
