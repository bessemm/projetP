package de.tekup.GLSIB.MatiereProjet.entite;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abonne extends Utilisateur {

	private boolean etatAbonne;
	private LocalDate dateInscription;
	private LocalDate derDateConn ;
	@OneToMany
	private List<Abonne> abonnes=new ArrayList<Abonne>() ;
	@ManyToMany
	private List<Annonce> favoris=new ArrayList<Annonce>() ;

}
