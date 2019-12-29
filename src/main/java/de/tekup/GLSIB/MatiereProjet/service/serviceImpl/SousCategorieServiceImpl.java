package de.tekup.GLSIB.MatiereProjet.service.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.GLSIB.MatiereProjet.dao.CategorieRepository;
import de.tekup.GLSIB.MatiereProjet.dao.SousCategorieRepository;
import de.tekup.GLSIB.MatiereProjet.entite.Categorie;
import de.tekup.GLSIB.MatiereProjet.entite.SousCategorie;
import de.tekup.GLSIB.MatiereProjet.service.SousCategorieService;

@Service
public class SousCategorieServiceImpl implements SousCategorieService {
    @Autowired
    SousCategorieRepository subCategoryRepo ;
    @Autowired
    CategorieRepository categoryRepo;


    @Override
    public SousCategorie saveSousCategorie(String idCat,String name) {

        Categorie c= categoryRepo.findByNom(idCat).get();
        SousCategorie sc=new SousCategorie();
        sc.setNom(name);
        sc.setCategorie(c);
        sc=subCategoryRepo.save(sc);
        c.getSousCategories().add(sc);
        categoryRepo.save(c);
         return sc;
    }


	@Override
	public List<SousCategorie> getByCatNom(String id) {
 		return subCategoryRepo.findByCategorieNom(id);
	}

}
