package de.tekup.GLSIB.MatiereProjet.controleur;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.GLSIB.MatiereProjet.dao.CommentRepo;
import de.tekup.GLSIB.MatiereProjet.dao.NotificationRepo;
import de.tekup.GLSIB.MatiereProjet.dao.SuggestionRepo;
import de.tekup.GLSIB.MatiereProjet.entite.Annonce;
import de.tekup.GLSIB.MatiereProjet.entite.Commentaire;
import de.tekup.GLSIB.MatiereProjet.entite.Notification;
import de.tekup.GLSIB.MatiereProjet.entite.Suggestion;
import de.tekup.GLSIB.MatiereProjet.service.AbonneService;
import de.tekup.GLSIB.MatiereProjet.service.AnnonceService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/annonces")
@AllArgsConstructor
public class AnnonceController {

 	AnnonceService annonceService;
	  
	 CommentRepo commentRepo ;
	
	 AbonneService abonneServ ;
	 NotificationRepo notifRepo ;
	 SuggestionRepo suggestionRepo ;
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
	@PostMapping("/commenter")
	public Annonce commenter(@RequestParam("contenu") String contenu,@RequestParam("idAnnonce")Long idAn,@RequestParam("username")String username) {
		System.out.println("coment 4444444444444444444444");
		Commentaire c=new Commentaire() ;
		c.setContenu(contenu);
		c.setUsername(abonneServ.findAbonneByUsername(username));
		commentRepo.save(c);
		return annonceService.addComment(c,idAn) ;
	}
	
	@GetMapping("/myannonces/{id}")
	@ResponseBody
	public List<Annonce> getMyAnnonces(@PathVariable("id") String id) {
		//Principal principal = request.getUserPrincipal();
		//System.out.println("username mmmm" +principal.getName());
 		System.out.println("annonce controlle ");
		return annonceService.getByUserId(id);
	}
@GetMapping("/sugg/{ids}/{ida}")
public boolean ajouterSugg(@PathVariable("ids") Long idsugg,@PathVariable("ida") Long idAnn) {
	Optional<Annonce> annonce=annonceService.getById(idAnn);
	Optional<Annonce> sugg=annonceService.getById(idsugg);
	Suggestion suggestion=annonce.get().getSuggAnnonce() ;
	if(suggestion!=null )

		if(annonce.isPresent()) {
			suggestion.getAnnoncesugg().add(sugg.get());
			Notification notification=new Notification();
		notification.setContenu("vous aves une dmande de echaneg");
		notification.setUtilisateur(annonce.get().getUtilsateur());
		notification.setUrl(sugg.get().getId()+"");
		notifRepo.save(notification);
		return true ;
		
	}
		return false ;
}
@GetMapping("/sugg/{id}")
List<Annonce> getSugg(@PathVariable Long id){
	return annonceService.getById(id).get().getSuggAnnonce().getAnnoncesugg();
}
}
