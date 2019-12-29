package de.tekup.GLSIB.MatiereProjet.service;

import java.util.List;

import de.tekup.GLSIB.MatiereProjet.entite.SousCategorie;


public interface SousCategorieService {
    public SousCategorie saveSousCategorie(String idCat,String name);
    public List<SousCategorie> getByCatNom(String id);
    

}
