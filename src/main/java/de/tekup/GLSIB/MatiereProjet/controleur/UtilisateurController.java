package de.tekup.GLSIB.MatiereProjet.controleur;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.GLSIB.MatiereProjet.entite.Abonne;
import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;
import de.tekup.GLSIB.MatiereProjet.service.AbonneService;
import de.tekup.GLSIB.MatiereProjet.service.AnnonceService;
import lombok.Data;

@RestController
@CrossOrigin("**")
public class UtilisateurController {

    
    
    @Autowired
    private AbonneService abonneService;
    @Autowired
   private AnnonceService annonceService ;

    @PostMapping("/inscription")
    public Utilisateur inscription(@RequestBody UserForm userForm){
        return abonneService.inscription(
                userForm.getUsername(),
                userForm.getPassword(),
                userForm.getPassword(),
                userForm.getNom(),
                userForm.getPrenom(),
                userForm.getEmail()

        );

    }
    @RolesAllowed("ADMIN")
    @PutMapping("/desactiver")
boolean desactiverCompte(@RequestBody String username) {
    	return	abonneService.desactiver(username);
    	
}
    
    @GetMapping("/utilisateurs/nbreAbonne/{username}")
 public Integer getNbreAbbone(@PathVariable("username")String username) {
    	System.out.println(username);
	 return ((Abonne) abonneService.findAbonneByUsername(username)).getAbonnes().size() ;
 }

    @GetMapping("/utilisateurs/nbreAnnonce/{username}")
    public Integer getNbreAnnonce(@PathVariable("username")String username) {
       	System.out.println(username);
   	 return   annonceService.getByUserId(username).size() ;
    }



}


@Data
class UserForm{
    private Long id;

    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String email;
}
