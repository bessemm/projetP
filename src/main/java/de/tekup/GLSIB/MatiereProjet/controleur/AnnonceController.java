package de.tekup.GLSIB.MatiereProjet.controleur;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.GLSIB.MatiereProjet.entite.Abonne;
import de.tekup.GLSIB.MatiereProjet.entite.Annonce;
import de.tekup.GLSIB.MatiereProjet.service.AbonneService;
import de.tekup.GLSIB.MatiereProjet.service.AnnonceService;

@RestController
@RequestMapping("/annonces")
public class AnnonceController {

	@Autowired
	AnnonceService annonceService;
	 
	 
@Autowired
AbonneService abonneService ;
	@PostMapping(value = "/{cat}/{scat}")
	public Annonce ajouterAnnonce(@RequestBody Annonce annonce, @PathVariable("cat") String categorie,
			@PathVariable("scat") String sousCategorie, Principal username) {

		System.out.println("ajout annonce ... " + annonce);
		System.out.println(username.getName());
		return annonceService.ajouterAnnonce(annonce, username.getName(),categorie,sousCategorie);
	}

	@GetMapping("/byCat")
	public List<Annonce> getByCat(Long idCat) {
		return annonceService.getByCat(idCat);
	}

	@GetMapping("/bySousCat/{idSCat}")

	public List<Annonce> getBySouCat(Long idSCat) {
		return annonceService.getBySouCat(idSCat);
	}

	@GetMapping("/{id}")
	public Optional<Annonce> getById(@PathVariable Long id) {
		return annonceService.getById(id);
	}

	@GetMapping()
	public List<Annonce> getAll() {
		return annonceService.getAll();
	}
	@GetMapping("/myannonces")
	public List<Annonce> getMyAnnonces(Authentication authentication) {
 		System.out.println("annonce controlle "+ authentication.getName());
		Abonne abonne=abonneService.loadAbonneByUsername( authentication.getName());
		
		return abonne.getAnnonces();
	}

}
