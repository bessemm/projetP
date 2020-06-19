package de.tekup.GLSIB.MatiereProjet.entite;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Suggestion {

	@Id
	@GeneratedValue
	private Long id ;
	@OneToMany(mappedBy = "suggestion")
	private List<Annonce> annoncesugg ;
	@OneToOne
	Annonce annonce ;
	private LocalDateTime date ;
	private String comment ;
	
} 
