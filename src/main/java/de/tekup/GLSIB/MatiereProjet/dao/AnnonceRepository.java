package de.tekup.GLSIB.MatiereProjet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.GLSIB.MatiereProjet.entite.Annonce;


public interface AnnonceRepository extends JpaRepository<Annonce,Long> {

	List<Annonce> findByCategorieId(Long idCat);

	List<Annonce> findBySousCategorieId(Long idSCat);

    



}
