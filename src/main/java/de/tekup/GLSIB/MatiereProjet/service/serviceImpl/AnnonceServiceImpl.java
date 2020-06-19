package de.tekup.GLSIB.MatiereProjet.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.GLSIB.MatiereProjet.dao.AnnonceRepository;
import de.tekup.GLSIB.MatiereProjet.dao.CategorieRepository;
import de.tekup.GLSIB.MatiereProjet.dao.SousCategorieRepository;
import de.tekup.GLSIB.MatiereProjet.dao.UtilisateurRepository;
import de.tekup.GLSIB.MatiereProjet.entite.Annonce;
import de.tekup.GLSIB.MatiereProjet.entite.Commentaire;
import de.tekup.GLSIB.MatiereProjet.entite.SousCategorie;
import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;
import de.tekup.GLSIB.MatiereProjet.service.AnnonceService;
@Service

public class AnnonceServiceImpl implements AnnonceService {
	@Autowired
	AnnonceRepository annonceRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	CategorieRepository categorieRepo ;
	@Autowired
	SousCategorieRepository sousCatRepo ;

	@Override
	public Annonce ajouterAnnonce(Annonce annonce, String username,String cat,String scat) {

		annonce.setSousCategorie(sousCatRepo.findOneByNom(scat));
		annonce.setCategorie(categorieRepo.findByNom(cat).get());
		
		Optional<Utilisateur> abonne = utilisateurRepository.findByUsername(username);
		annonce.setUtilsateur(abonne.get());
		return annonceRepository.save(annonce);
	}

	@Override
	public List<Annonce> getByCat(Long idCat) {
		return annonceRepository.findByCategorieId(idCat);
	}

	@Override
	public List<Annonce> getBySouCat(Long idSCat) {
		return annonceRepository.findBySousCategorieId(idSCat);

	}

	@Override
	public Optional<Annonce> getById(Long id) {
		return annonceRepository.findById(id);

	}

	@Override
	public List<Annonce> getAll() {
		return annonceRepository.findAll() ;
	}
	@Override
	public List<Annonce> getByUserId(String id) {
		// TODO Auto-generated method stub
		return annonceRepository.findByUtilisateurId(id);
	}
@Override
public Annonce addComment(Commentaire c, Long idAn) {
	Annonce annonce=annonceRepository.findById(idAn).get();
   annonce.getCommentaires().add(c) ;
   return annonceRepository.save(annonce);
}
}
