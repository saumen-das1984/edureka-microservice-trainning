package com.edureka.ms.training.api.personservice.repository;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.edureka.ms.training.api.personservice.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, BigInteger>{
	@Query("{ 'name' : { $regex: '?0' } }")
	Stream<Person> findbyNameContainning(String name);
	
	@Query("{ 'place' : { '$regex' : ?0 , $options: 'i' } }")
	Stream<Person> findbyPlaceIgnoringCase(String place);
}
