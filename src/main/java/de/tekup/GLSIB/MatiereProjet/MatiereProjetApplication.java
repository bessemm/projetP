package de.tekup.GLSIB.MatiereProjet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MatiereProjetApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(MatiereProjetApplication.class, args);
	}

	/**
	 * @param abonneService
	 * @param userRepo
	 * @return
	 */
	@Bean
    CommandLineRunner star(de.tekup.GLSIB.MatiereProjet.service.AbonneService abonneService, de.tekup.GLSIB.MatiereProjet.dao.UtilisateurRepository userRepo){
        return args -> {
             

           
			
			/*
			 * abonneService.inscription("admin","1234","1234","bessem","manita",
			 * "bessem.manita@gmail.com");
			 */userRepo.findAll().forEach(System.out::println);
			  
			 
			 
        };
    }

    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
 	  
}
