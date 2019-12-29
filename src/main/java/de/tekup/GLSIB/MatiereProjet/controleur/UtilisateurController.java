package de.tekup.GLSIB.MatiereProjet.controleur;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;
import de.tekup.GLSIB.MatiereProjet.service.AbonneService;
import lombok.Data;

@RestController
@CrossOrigin("**")
public class UtilisateurController {

    
    
    @Autowired
    private AbonneService abonneService;


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
    
    @GetMapping("/utilisateurs/nbreAbonne")
 public Integer getNbreAbbone(@AuthenticationPrincipal Principal principal) {
    	System.out.println(principal.getName());
	 return abonneService.loadAbonneByUsername(principal.getName()).getAbonnes().size() ;
 }

     



}


@Data
class UserForm{
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String email;
}
