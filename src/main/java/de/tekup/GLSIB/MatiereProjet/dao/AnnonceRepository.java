package de.tekup.GLSIB.MatiereProjet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import de.tekup.GLSIB.MatiereProjet.entite.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

	List<Annonce> findByCategorieId(Long idCat);

	List<Annonce> findBySousCategorieId(Long idSCat);

	@Query("select a from Annonce a ,Utilisateur u where a.utilsateur=u.id and u.username=?1")
	List<Annonce> findByUtilisateurId(String id);
 
	  
}
