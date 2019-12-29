package de.tekup.GLSIB.MatiereProjet.service;

import de.tekup.GLSIB.MatiereProjet.entite.Abonne;
import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;


public interface AbonneService {
    public Utilisateur inscription(String username,String password,String confirmedPassword,String firstName, String lastName,String email);
    public Utilisateur loadUserByUsername(String username);
	public boolean desactiver(String username);
	public Abonne loadAbonneByUsername(String name);
}
