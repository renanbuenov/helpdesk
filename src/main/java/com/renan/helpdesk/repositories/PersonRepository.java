package com.renan.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
