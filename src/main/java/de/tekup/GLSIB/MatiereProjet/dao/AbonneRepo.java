package de.tekup.GLSIB.MatiereProjet.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import de.tekup.GLSIB.MatiereProjet.entite.Abonne;
import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;

@RepositoryRestResource
public interface AbonneRepo extends JpaRepository<Abonne, Long> {

	public Abonne findAbonneByUsername(String username);
    public List<Abonne> findByRole(String role);
	public Optional<Abonne> findByUsername(String username);
	public Optional<Abonne> findOneByUsername(String username);
	//@Query("SELECT u FROM Utilisateur u WHERE u.username = ?1")
	 public Abonne findUtilisateurByUsername(String username);
}
