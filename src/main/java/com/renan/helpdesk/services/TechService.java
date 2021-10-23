package com.renan.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Person;
import com.renan.helpdesk.domain.Technician;
import com.renan.helpdesk.domain.dtos.TechnicianDTO;
import com.renan.helpdesk.repositories.PersonRepository;
import com.renan.helpdesk.repositories.TechnicianRepository;
import com.renan.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.renan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TechService {
	
	@Autowired
	private TechnicianRepository repository;
	
	@Autowired
	private PersonRepository personRepository;
	
	public Technician findById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null);
		validateByCpfandEmail(objDTO);
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);	
	}
	
	public Technician update(Integer id, @Valid TechnicianDTO objDTO) {
		objDTO.setId(id);
		Technician oldObj = findById(id);
		validateByCpfandEmail(objDTO);
		oldObj = new Technician(objDTO);
		return repository.save(oldObj);
	}
	
	private void validateByCpfandEmail(TechnicianDTO objDTO) {
		Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF is already added on the system!");
		}
		obj = personRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email is already added on the system!");
		}
	}


}
