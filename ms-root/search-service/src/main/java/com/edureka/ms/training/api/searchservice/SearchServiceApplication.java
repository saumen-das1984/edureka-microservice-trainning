package com.edureka.ms.training.api.searchservice;

import java.math.BigInteger;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edureka.ms.training.api.searchservice.model.Players;
import com.edureka.ms.training.api.searchservice.repository.SearchRepository;

@SpringBootApplication
public class SearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SearchServiceApplication.class, args);
	}
	
	@Bean
	public InitializingBean seeDatabase(SearchRepository repository)
	{
		return () ->
		{
			repository.deleteAll();
			repository.save(Players.builder().id(Long.valueOf(1)).name("Sachin Tendulkar").place("Mumbai")
					.aka("God of Cricket").build());

			repository.save(Players.builder().id(Long.valueOf(2)).name("Sourov Ganguly").place("Kolkata")
					.aka("Prince of Calcutta").build());

			repository.save(Players.builder().id(Long.valueOf(3)).name("Virendra Shewbagh").place("Delhi")
					.aka("Multan ka Sultan").build());
			
			repository.save(Players.builder().id(Long.valueOf(4)).name("MS Dhoni").place("Ranchi")
					.aka("Captain Cool").build());
		};
	}

}
