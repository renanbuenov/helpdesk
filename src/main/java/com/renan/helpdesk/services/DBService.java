package com.renan.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Client;
import com.renan.helpdesk.domain.Technician;
import com.renan.helpdesk.domain.Ticket;
import com.renan.helpdesk.domain.enums.Priority;
import com.renan.helpdesk.domain.enums.Profile;
import com.renan.helpdesk.domain.enums.Status;
import com.renan.helpdesk.repositories.ClientRepository;
import com.renan.helpdesk.repositories.TechnicianRepository;
import com.renan.helpdesk.repositories.TicketRepository;

@Service
public class DBService {
	
	@Autowired
	private TechnicianRepository technicianRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	public void instanceDB() {
		
		Technician t1 = new Technician(null, "Renan Bueno", "08687996969", "renanbueno@hotmail.com", "123");
		t1.addProfile(Profile.ADMIN);
		
		Client c1 = new Client(null, "Fernanda Marie", "43242432", "fernanda@hotmail", "234");
		
		Ticket ticket = new Ticket(null, Priority.AVERAGE, Status.INPROGRESS, "Ticket 01", "First ticket", t1, c1);
		
		technicianRepository.saveAll(Arrays.asList(t1));
		clientRepository.saveAll(Arrays.asList(c1));
		ticketRepository.saveAll(Arrays.asList(ticket));
		
	}
}
