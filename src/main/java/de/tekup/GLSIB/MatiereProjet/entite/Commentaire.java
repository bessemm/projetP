package de.tekup.GLSIB.MatiereProjet.entite;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Commentaire {
	@Id
	private String id;
    String contenu;
    Date date;
@ManyToOne
@JoinColumn(name = "user_id")
Utilisateur  username;
}
