package com.Dossierclient.assuré;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;





public interface AssureRepository extends JpaRepository<Assure, Integer>{
	
	@Query("select c from Assure c where c.nom like :nom")
	public Page<Assure> candidatByNom(@Param("nom") String n, Pageable pageable);

}
