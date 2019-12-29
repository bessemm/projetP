package de.tekup.GLSIB.MatiereProjet.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.GLSIB.MatiereProjet.entite.Categorie;
import de.tekup.GLSIB.MatiereProjet.entite.SousCategorie;
import de.tekup.GLSIB.MatiereProjet.service.CategorieService;
import de.tekup.GLSIB.MatiereProjet.service.SousCategorieService;

@RestController
@RequestMapping("/categories")
public class CategorieController {

	@Autowired
	SousCategorieService subCategoryService;
	@Autowired
	CategorieService categorieService;

	@PostMapping
	public void addCat(@RequestBody Categorie categorie) {
		categorieService.addCat(categorie);

	}

	@GetMapping
	public List<Categorie> getAll() {
		List<Categorie> list = categorieService.getAll();
		if (list != null)
			return list;
		return null;
	}

	@GetMapping("/souscat/{nom}")
	List<SousCategorie> getsouCat(@PathVariable String nom) {
		return categorieService.getByNom(nom).get().getSousCategories();
	}

	@PostMapping("/addsubcat/{idCat}")
	public SousCategorie ajouterSousCategorie(@PathVariable("idCat") String idCat, @RequestBody String name) {
		System.out.println(name + idCat);
		return subCategoryService.saveSousCategorie(idCat, name);
 	}
 
}
