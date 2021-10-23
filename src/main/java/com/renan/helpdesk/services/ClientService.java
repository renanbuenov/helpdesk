package com.renan.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Client;
import com.renan.helpdesk.domain.Person;
import com.renan.helpdesk.domain.dtos.ClientDTO;
import com.renan.helpdesk.repositories.ClientRepository;
import com.renan.helpdesk.repositories.PersonRepository;
import com.renan.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.renan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private PersonRepository personRepository;
	
	public Client findById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client create(ClientDTO objDTO) {
		objDTO.setId(null);
		validateByCpfandEmail(objDTO);
		Client newObj = new Client(objDTO);
		return repository.save(newObj);	
	}
	
	public Client update(Integer id, @Valid ClientDTO objDTO) {
		objDTO.setId(id);
		Client oldObj = findById(id);
		validateByCpfandEmail(objDTO);
		oldObj = new Client(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Client obj = findById(id);
		if (obj.getTickets().size() > 0) {
			throw new DataIntegrityViolationException("Client has service orders assigned and can not be deleted!");
		}
		
		repository.deleteById(id);
	}
	
	private void validateByCpfandEmail(ClientDTO objDTO) {
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
