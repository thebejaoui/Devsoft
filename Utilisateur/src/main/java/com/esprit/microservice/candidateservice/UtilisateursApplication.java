package com.esprit.microservice.candidateservice;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
public class UtilisateursApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilisateursApplication.class, args);
	}
	
	 @Bean
	    ApplicationRunner init(UtilisateursRepository repository) {
	        return args -> {
	            Stream.of("Mariem", "Sarra", "Mohamed").forEach(nom -> {
	                repository.save(new Utilisateurs(nom));
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	    }

}
