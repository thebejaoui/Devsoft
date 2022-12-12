package com.Dossierclient.assuré;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class DossierclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DossierclientApplication.class, args);
	}
	
	@Bean
    ApplicationRunner init(AssureRepository repository) {
        return args -> {
            Stream.of("arwa", "amine", "yosr").forEach(nom -> {
                repository.save(new Assure(nom)
                		);
            });
            repository.findAll().forEach(System.out::println);
            
        };
    }
	
	@RestController
	class ServiceInstanceRestController{
		@Autowired
		private DiscoveryClient discoveryClient;
		
		@RequestMapping("/service-instances/{applicationName}")
		public List<ServiceInstance> ServiceInstancesByApplicationName(
				@PathVariable String applicationName){
			return this.discoveryClient.getInstances(applicationName);
		}
	}

}
