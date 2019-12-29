package de.tekup.GLSIB.MatiereProjet.entite;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value="admin" )
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends Utilisateur {
     private Date dateAdmin;
     
}
