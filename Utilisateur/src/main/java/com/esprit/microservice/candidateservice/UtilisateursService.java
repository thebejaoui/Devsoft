package com.esprit.microservice.candidateservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

;

@Service
public class UtilisateursService {

	@Autowired
	private UtilisateursRepository utilisateursRepository;

	public Utilisateurs addCandidat(Utilisateurs utilisateurs) {
		return utilisateursRepository.save(utilisateurs);
	}
	public Utilisateurs updateCandidat(int id, Utilisateurs newCandidat) {
		if (utilisateursRepository.findById(id).isPresent()) {
			Utilisateurs existingCandidat = utilisateursRepository.findById(id).get();
			existingCandidat.setNom(newCandidat.getNom());
			existingCandidat.setPrenom(newCandidat.getPrenom());
			existingCandidat.setEmail(newCandidat.getEmail());

			return utilisateursRepository.save(existingCandidat);
		} else
			return null;
	}
	public String deleteCandidat(int id) {
		if (utilisateursRepository.findById(id).isPresent()) {
			utilisateursRepository.deleteById(id);
			return "candidat supprimé";
		} else
			return "candidat non supprimé";
	}
	
	//Obtenir tous les candidats
			public  List<Utilisateurs> GetCandidats() {
				return utilisateursRepository.findAll();
			}
}
