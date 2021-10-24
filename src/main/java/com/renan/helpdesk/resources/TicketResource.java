package com.renan.helpdesk.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<TicketDTO>> findAll(){
		List<Ticket> list = service.findAll();
		List<TicketDTO> listDTO = list.stream().map(obj -> new TicketDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<TicketDTO> create(@Valid @RequestBody TicketDTO obj){
		Ticket newObj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().
				path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TicketDTO> update(@PathVariable Integer id, @Valid @RequestBody TicketDTO objDTO){
		Ticket newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TicketDTO(newObj));
	}
}
