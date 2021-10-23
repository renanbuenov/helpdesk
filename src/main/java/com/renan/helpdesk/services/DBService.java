package com.renan.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renan.helpdesk.domain.Ticket;
import com.renan.helpdesk.domain.Client;
import com.renan.helpdesk.domain.Technician;
import com.renan.helpdesk.domain.enums.Profile;
import com.renan.helpdesk.domain.enums.Priority;
import com.renan.helpdesk.domain.enums.Status;
import com.renan.helpdesk.repositories.TicketRepository;
import com.renan.helpdesk.repositories.PersonRepository;

@Service
public class DBService {

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private PersonRepository personRepository;

	public void instanceDB() {

		Technician tec1 = new Technician(null, "Renan Bueno", "550.482.150-95", "renan@mail.com", "123");
		tec1.addProfile(Profile.ADMIN);
		Technician tec2 = new Technician(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", "123");
		Technician tec3 = new Technician(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", "123");
		Technician tec4 = new Technician(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", "123");
		Technician tec5 = new Technician(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", "123");

		Client cli1 = new Client(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", "123");
		Client cli2 = new Client(null, "Marie Curie", "322.429.140-06", "curie@mail.com", "123");
		Client cli3 = new Client(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", "123");
		Client cli4 = new Client(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", "123");
		Client cli5 = new Client(null, "Max Planck", "081.399.300-83", "planck@mail.com", "123");

		Ticket c1 = new Ticket(null, Priority.AVERAGE, Status.INPROGRESS, "Ticket 1", "Teste Ticket 1", tec1, cli1);
		Ticket c2 = new Ticket(null, Priority.HIGH, Status.OPENED, "Ticket 2", "Teste Ticket 2", tec1, cli2);
		Ticket c3 = new Ticket(null, Priority.LOW, Status.FINISHED, "Ticket 3", "Teste Ticket 3", tec2, cli3);
		Ticket c4 = new Ticket(null, Priority.HIGH, Status.OPENED, "Ticket 4", "Teste Ticket 4", tec3, cli3);
		Ticket c5 = new Ticket(null, Priority.AVERAGE, Status.INPROGRESS, "Ticket 5", "Teste Ticket 5", tec2, cli1);
		Ticket c6 = new Ticket(null, Priority.LOW, Status.FINISHED, "Ticket 7", "Teste Ticket 6", tec1, cli5);

		personRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		ticketRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}