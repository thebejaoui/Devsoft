package com.esprit.microservice.candidateservice;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Integer> {
	@Query("select c from Utilisateurs c where c.nom like :nom")
	public Page<Utilisateurs> candidatByNom(@Param("nom") String n, Pageable pageable);
	   
}
