package de.tekup.GLSIB.MatiereProjet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.GLSIB.MatiereProjet.entite.Suggestion;

public interface SuggestionRepo extends JpaRepository<Suggestion	, Long>{

}
