package de.tekup.GLSIB.MatiereProjet.service;

import java.util.List;
import java.util.Optional;

import de.tekup.GLSIB.MatiereProjet.entite.Categorie;

public interface CategorieService {
	void addCat(Categorie categorie);
	List<Categorie> getAll();
    void deleteCategorie(String id);
 	Optional<Categorie> getByNom(String id);
	Optional<Categorie> getById(Long id);
}
