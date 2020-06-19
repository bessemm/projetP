package de.tekup.GLSIB.MatiereProjet.entite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Annonce {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 10000)
	private String image1;
	private String image2;
	private String image3;
	private String titre;
	private String description;
	private String type;
	private String tel;
	private Date datePublication;
	private Boolean disponible;
	private String prixLocation; 
	private String gouvernorat;
	private String ville ;
 	@ManyToOne
    private Utilisateur utilsateur ;
	@ManyToOne(fetch = FetchType.EAGER)	
	private Suggestion suggestion=new Suggestion();
	@OneToOne
 	Suggestion suggAnnonce=new Suggestion() ;
	@OneToMany
	private List<Commentaire> commentaires = new ArrayList<>();
	@ManyToOne
	private Categorie categorie;
	@ManyToOne
	private SousCategorie sousCategorie;
	
	
	
	

}
