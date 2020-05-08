package com.edureka.ms.training.api.personservice.service;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.ms.training.api.personservice.model.Person;
import com.edureka.ms.training.api.personservice.repository.PersonRepository;


import lombok.AllArgsConstructor;
@Service
//@AllArgsConstructor
public class PersonService{
	
	@Autowired
	PersonRepository personRepository;


	public Stream<Person> getByName(String name) {
		return personRepository.findbyNameContainning(name);
	}


	public Stream<Person> getByPlace(String place) {
		return personRepository.findbyPlaceIgnoringCase(place);
	}


	public Stream<Person> getAll() {
		return personRepository.findAll().stream();
	}


	public Optional<Person> getById(BigInteger id) {
		return personRepository.findById(id);
	}


	public Person save(Person person) {
		return personRepository.save(person);
	}

}
