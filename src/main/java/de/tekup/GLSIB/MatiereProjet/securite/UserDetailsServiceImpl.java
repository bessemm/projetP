package de.tekup.GLSIB.MatiereProjet.securite;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.tekup.GLSIB.MatiereProjet.dao.UtilisateurRepository;
import de.tekup.GLSIB.MatiereProjet.entite.Utilisateur;

import java.util.ArrayList;
import java.util.Collection;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepo;

    @Override
    public UserDetails loadUserByUsername(String username)  {
        Utilisateur appUser=utilisateurRepo.findUtilisateurByUsername(username);
       if (appUser== null)throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities=new ArrayList<>();
       authorities.add( new SimpleGrantedAuthority(appUser.getRole()));
       
        return new User(appUser.getUsername(),appUser.getPassword(),authorities);
    }
}
