package com.renan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.helpdesk.domain.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

}
