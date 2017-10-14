package com.trexza.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trexza.springboot.rest.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}