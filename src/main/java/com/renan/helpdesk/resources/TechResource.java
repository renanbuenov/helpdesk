package com.renan.helpdesk.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
