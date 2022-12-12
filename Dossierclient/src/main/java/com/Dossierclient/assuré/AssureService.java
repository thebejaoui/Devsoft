package com.Dossierclient.assuré;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;









@Service
public class AssureService {
	@Autowired
	private AssureRepository assureRepository;
	
	
	
	//ajouter un assurée
	
	public Assure addAssuré(Assure assure) {
		return assureRepository.save(assure);
	}
	
	//mise a jour un assureé
	
	public Assure updateAssuré(int id, Assure newAssuré) {
		if (assureRepository.findById(id).isPresent()) {
			Assure existingCandidat = assureRepository.findById(id).get();
			existingCandidat.setNom(newAssuré.getNom());
			existingCandidat.setPrenom(newAssuré.getPrenom());
			existingCandidat.setadresse(newAssuré.getadresse());

			return assureRepository.save(existingCandidat);
		} else
			return null;
	}
	
	
	//supprimer un assuré
	public String deleteAssuré(int id) {
		if (assureRepository.findById(id).isPresent()) {
			assureRepository.deleteById(id);
			return "Assure supprimé";
		} else
			return "Assure non supprimé";
	}
	
	//Obtenir tous les candidats
		public  List<Assure> GetCandidats() {
			return assureRepository.findAll();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
