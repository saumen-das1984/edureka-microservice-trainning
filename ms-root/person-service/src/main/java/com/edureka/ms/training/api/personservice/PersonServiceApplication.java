package com.edureka.ms.training.api.personservice;

import java.math.BigInteger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edureka.ms.training.api.personservice.model.Person;
import com.edureka.ms.training.api.personservice.repository.PersonRepository;

@SpringBootApplication
public class PersonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedDatabase(PersonRepository personRepository) {
		return args -> {
			personRepository.save(Person.builder().id(BigInteger.valueOf(1)).name("Sachin Tendulkar").place("Mumbai")
					.aka("God of Cricket").build());

			personRepository.save(Person.builder().id(BigInteger.valueOf(2)).name("Sourov Ganguly").place("Kolkata")
					.aka("Prince of Calcutta").build());

			personRepository.save(Person.builder().id(BigInteger.valueOf(3)).name("Virendra Shewbagh").place("Delhi")
					.aka("Multan ka Sultan").build());
			
			personRepository.save(Person.builder().id(BigInteger.valueOf(4)).name("MS Dhoni").place("Ranchi")
					.aka("Captain Cool").build());
		};

	}

}
