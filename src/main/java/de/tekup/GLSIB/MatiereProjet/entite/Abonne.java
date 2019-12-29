package de.tekup.GLSIB.MatiereProjet.entite;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "abonne")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abonne extends Utilisateur {

	private boolean etatAbonne;
	private LocalDate dateInscription;
	private LocalDate derDateConn ;
	@OneToMany
	private List<Abonne> abonnes ;

}
