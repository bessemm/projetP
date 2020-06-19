package de.tekup.GLSIB.MatiereProjet.service.serviceImpl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import de.tekup.GLSIB.MatiereProjet.dao.AbonneRepo;
import de.tekup.GLSIB.MatiereProjet.dao.UtilisateurRepository;
import de.tekup.GLSIB.MatiereProjet.entite.Abonne;
import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;
import de.tekup.GLSIB.MatiereProjet.service.AbonneService;


@Service
public class AbonneServiceImpl implements AbonneService {
    @Autowired
    private UtilisateurRepository userRepository;
    @Autowired
    private AbonneRepo abonneRepo ;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public Utilisateur inscription(String username, String password, String confirmedPassword,String firstName, String lastName,String email) {
        Utilisateur user = userRepository.findUtilisateurByUsername(username);
        if (user != null) throw new RuntimeException("L utilisateur existe déjà");
        if (!password.equals(confirmedPassword)) throw new RuntimeException(" confirmer votre mot de passe");
        Abonne appUser = new Abonne();
        appUser.setUsername(username);
        appUser.setEmail(email);
        appUser.setNom(firstName);
        appUser.setPrenom(lastName);
        appUser.setEtat(true);
         appUser.setImage("./assets/image/profile/default.png");
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setRole("ABONNE");
        abonneRepo.save(appUser);
        return appUser;
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return userRepository.findUtilisateurByUsername(username);
    }
    
    
    public Utilisateur loadAbonneByUsername(String username) {
    	System.out.println(username);
        Utilisateur a=  userRepository.findOneByUsername(username).get();
        
        System.out.println(a.getNom());
        return a;
    }
	@Override
	public boolean desactiver(String username) {
		Optional<Utilisateur> utilisateur=userRepository.findByUsername(username);
		utilisateur.get().setEtat(false);
		userRepository.saveAndFlush(utilisateur.get());
		return true ;
	}

	@Override
	public Abonne findByid(Long id) {
		// TODO Auto-generated method stub
		return abonneRepo.findById(id).get();
	}
@Override
public Abonne findByUsername(String id) {
	// TODO Auto-generated method stub
	  return abonneRepo.findAbonneByUsername(id);
}

@Override
public Utilisateur findAbonneByUsername(String s) {
 	return userRepository.findUtilisateurByUsername(s);
}


@Override
public Integer findNbAbonnee(String username) {
	// TODO Auto-generated method stub
	return abonneRepo.findAbonneByUsername(username).getAnnonces().size();
}
}



