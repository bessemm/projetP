package de.tekup.GLSIB.MatiereProjet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.GLSIB.MatiereProjet.entite.Categorie;



public interface CategorieRepository extends JpaRepository<Categorie,Long> {

	Optional<Categorie> findByNom(String nom);

    
}
