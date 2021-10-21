package com.renan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.helpdesk.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
