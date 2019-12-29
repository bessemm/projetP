package de.tekup.GLSIB.MatiereProjet.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import de.tekup.GLSIB.MatiereProjet.entite.Abonne;
import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;


@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{
    public Utilisateur findUtilisateurByUsername(String username);
    public List<Utilisateur> findByRole(String role);
	public Optional<Utilisateur> findByUsername(String username);
	public Optional<Abonne> findOneByUsername(String username);

}
