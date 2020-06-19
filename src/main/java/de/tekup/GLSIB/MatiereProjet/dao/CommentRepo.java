package de.tekup.GLSIB.MatiereProjet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.GLSIB.MatiereProjet.entite.Commentaire;

public interface CommentRepo extends JpaRepository<Commentaire,Long>{

}
