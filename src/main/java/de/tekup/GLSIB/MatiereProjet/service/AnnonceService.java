package de.tekup.GLSIB.MatiereProjet.service;

import java.util.List;
import java.util.Optional;

import de.tekup.GLSIB.MatiereProjet.entite.Annonce;

public interface AnnonceService {

	public Annonce ajouterAnnonce(Annonce annonce, String username,String cat,String scat);
	public List<Annonce> getByCat(Long idCat);
	public List<Annonce> getBySouCat(Long idSCat);
	public Optional<Annonce> getById(Long id);
	public List<Annonce> getAll();

}
