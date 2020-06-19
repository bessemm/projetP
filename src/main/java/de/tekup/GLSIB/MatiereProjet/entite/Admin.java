package de.tekup.GLSIB.MatiereProjet.entite;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Data
@AllArgsConstructor
 
public class Admin extends Utilisateur {
      
	 }
