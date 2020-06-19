package de.tekup.GLSIB.MatiereProjet.entite;

 import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
 public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	@Column(unique = true)
    private String username;
     private String password;
    private String nom;
    private String prenom;
    private String image;
    private String tel;
	@Column(unique = true)
    private String email;
    private String adresse;
    @Column(nullable=false)
    private  String role;
     @OneToMany()
    private List<Annonce> annonces=new ArrayList<>();
    @Override
    public String toString() {
        return "Utilisateur{" +
                "id='" + id + 
                ", username= " + username + 
                ", etat=" + etat +
                 ", roles=" + role +
                ", annonces=" + annonces +
                '}';
    }


    private boolean etat;
    @OneToMany(mappedBy = "utilisateur")
    List<Notification> notifications=new ArrayList<Notification>() ;
    
}