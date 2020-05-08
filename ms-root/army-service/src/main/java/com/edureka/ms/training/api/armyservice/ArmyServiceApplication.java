package com.edureka.ms.training.api.armyservice;

import java.math.BigInteger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edureka.ms.training.api.armyservice.model.Army;
import com.edureka.ms.training.api.armyservice.repository.ArmyRepository;



@SpringBootApplication
public class ArmyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArmyServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner seedDatabase(ArmyRepository armyRepository) {
		return args -> {
			armyRepository.save(Army.builder().id(Long.valueOf(1))
					.personId(Long.valueOf(1))
					.run(50000)
					.wickets(500)
					.catches(500)
					.stumps(0).build());

			armyRepository.save(Army.builder().id(Long.valueOf(2))
					.personId(Long.valueOf(2))
					.run(20000)
					.wickets(600)
					.catches(300)
					.stumps(0).build());

			armyRepository.save(Army.builder().id(Long.valueOf(2))
					.personId(Long.valueOf(2))
					.run(30000)
					.wickets(400)
					.catches(400)
					.stumps(0).build());
			
			armyRepository.save(Army.builder().id(Long.valueOf(2))
					.personId(Long.valueOf(2))
					.run(30000)
					.wickets(20)
					.catches(500)
					.stumps(100).build());
		};
	}

}
