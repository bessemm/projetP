package de.tekup.GLSIB.MatiereProjet.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.tekup.GLSIB.MatiereProjet.entite.SousCategorie;

@Repository
public interface SousCategorieRepository extends JpaRepository<SousCategorie,Long> {

	List<SousCategorie> findByCategorieNom(String nom);

	SousCategorie findOneByNom(String nom);

    
}
