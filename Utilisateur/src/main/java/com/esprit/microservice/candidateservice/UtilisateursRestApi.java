package com.esprit.microservice.candidateservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/api/utilisateurs")
public class UtilisateursRestApi {
	private String title = "Hello, I'm the Utilisateurs Microservice";
	@Autowired
	private UtilisateursService utilisateursService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Utilisateurs> createCandidat(@RequestBody Utilisateurs utilisateurs) {
		return new ResponseEntity<>(utilisateursService.addCandidat(utilisateurs), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Utilisateurs> updateCandidat(@PathVariable(value = "id") int id,
    										@RequestBody Utilisateurs utilisateurs){
		return new ResponseEntity<>(utilisateursService.updateCandidat(id, utilisateurs), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(utilisateursService.deleteCandidat(id), HttpStatus.OK);
	}
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Utilisateurs> getAllCandidats(){
		return utilisateursService.GetCandidats();
	}
}
