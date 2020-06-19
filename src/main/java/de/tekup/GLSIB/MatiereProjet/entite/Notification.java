package de.tekup.GLSIB.MatiereProjet.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

	@Id
	@GeneratedValue
	private Long id ;
	private String url ;
	private String contenu ;
	@ManyToOne
	Utilisateur utilisateur ;
}
