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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.renan.helpdesk.domain.Technician;
import com.renan.helpdesk.domain.dtos.TechnicianDTO;
import com.renan.helpdesk.services.TechService;

@RestController
@RequestMapping(value = "/technicians")
public class TechResource {
	
	@Autowired
	private TechService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id){
		Technician obj = service.findById(id);
		return ResponseEntity.ok().body(new TechnicianDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TechnicianDTO>> findAll(){
		List<Technician> list = service.findAll();
		List<TechnicianDTO> listDTO = list.stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<TechnicianDTO> create(@Valid @RequestBody TechnicianDTO objDTO){
		Technician newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
