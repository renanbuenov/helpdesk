package com.renan.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Ticket;
import com.renan.helpdesk.repositories.TicketRepository;
import com.renan.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;
	
	public Ticket findById(Integer id) {
		Optional<Ticket> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found" + id));
	}
}
