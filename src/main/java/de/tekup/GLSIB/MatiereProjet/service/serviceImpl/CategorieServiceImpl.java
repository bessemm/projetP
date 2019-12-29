package de.tekup.GLSIB.MatiereProjet.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.GLSIB.MatiereProjet.dao.CategorieRepository;
import de.tekup.GLSIB.MatiereProjet.entite.Categorie;
import de.tekup.GLSIB.MatiereProjet.service.CategorieService;

@Service

public class CategorieServiceImpl implements CategorieService{

	@Autowired
	CategorieRepository categorieRepository ;
	@Override
	public void addCat(Categorie categorie) {
		
		categorieRepository.save(categorie);
		
	}

	@Override
	public List<Categorie> getAll() {
		return categorieRepository.findAll() ;
	}

	@Override
	public void deleteCategorie(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Categorie> getById(Long id) {
		return categorieRepository.findById(id);
	}

	@Override
	public Optional<Categorie> getByNom(String nom) {
		return categorieRepository.findByNom(nom);
	}

	 

}
