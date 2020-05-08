package com.edureka.ms.training.api.personservice.controller;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.ms.training.api.personservice.service.PersonService;
import com.edureka.ms.training.api.personservice.model.Person;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PersonController {
	
//	@Autowired
	PersonService personService;

	@GetMapping("/get")
	public Stream<Person> getByName(@RequestParam(required=false) String name, @RequestParam(required=false) String place)
	{
		if (!StringUtils.isEmpty(name))
		{
			return personService.getByName(name);
		}
		else if (!StringUtils.isEmpty(place))
		{
			return personService.getByPlace(place);
		}
		return personService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Person> getById(@PathVariable BigInteger id)
	{
		return personService.getById(id);
	}
	
	@PostMapping("/save")
	public Person save(@RequestBody Person person)
	{
		return personService.save(person);
	}
	
}
