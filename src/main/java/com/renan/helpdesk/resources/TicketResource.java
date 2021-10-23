package com.renan.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renan.helpdesk.domain.Ticket;
import com.renan.helpdesk.domain.dtos.TicketDTO;
import com.renan.helpdesk.services.TicketService;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {
	
	@Autowired
	private TicketService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TicketDTO> findById(@PathVariable Integer id){
		Ticket obj = service.findById(id);
		return ResponseEntity.ok().body(new TicketDTO(obj));
	}
}
