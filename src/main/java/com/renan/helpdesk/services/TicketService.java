package com.renan.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Client;
import com.renan.helpdesk.domain.Technician;
import com.renan.helpdesk.domain.Ticket;
import com.renan.helpdesk.domain.dtos.TicketDTO;
import com.renan.helpdesk.domain.enums.Priority;
import com.renan.helpdesk.domain.enums.Status;
import com.renan.helpdesk.repositories.TicketRepository;
import com.renan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;
	@Autowired
	private TechService techService;
	@Autowired
	private ClientService clientService;
	
	
	public Ticket findById(Integer id) {
		Optional<Ticket> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found" + id));
	}

	public List<Ticket> findAll() {
		return repository.findAll();
	}

	public Ticket create(@Valid TicketDTO objDTO) {
		return repository.save(newTicket(objDTO));
	}
	
	private Ticket newTicket(TicketDTO obj) {
		Technician technician = techService.findById(obj.getTechnician());
		Client client = clientService.findById(obj.getClient());
		
		Ticket ticket = new Ticket();
		if(obj.getId() != null) {
			ticket.setId(obj.getId());
		}
		
		ticket.setTechnician(technician);
		ticket.setClient(client);
		ticket.setPriority(Priority.toEnum(obj.getPriority()));
		ticket.setStatus(Status.toEnum(obj.getStatus()));
		ticket.setTitle(obj.getTitle());
		ticket.setObservation(obj.getObservation());
		return ticket;
	}
}
