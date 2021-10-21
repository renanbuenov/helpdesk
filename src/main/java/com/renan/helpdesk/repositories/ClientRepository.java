package com.renan.helpdesk.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.helpdesk.domain.Client;
import com.renan.helpdesk.domain.Technician;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
