package de.tekup.GLSIB.MatiereProjet.entite;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data // getters and setters
@AllArgsConstructor
@NoArgsConstructor
public class SousCategorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
 	private Long id;
	private String nom;

	@OneToMany
	private Collection<Annonce> annonces = new ArrayList<>();
	@ManyToOne
	private Categorie categorie;

	@Override
	public String toString() {
		return "SubCategory{" + "id='" + id + '\'' + ", name='" + nom + '\'' + '}';
	}
}
