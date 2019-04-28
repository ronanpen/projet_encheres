package org.enchere.bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "Encheres")
public class Enchere {
	@ManyToOne
	@JoinColumn(name="no_utilisateur")
	@Column(name="no_utilisateur")
	private Utilisateur utilisateur;
	
	@ManyToOne
	@JoinColumn(name="no_article")
	@Column(name="no_article")
	private ArticleVendu article;
	
	@Column(name="date_enchere")
	private LocalDateTime dateEnchere;
	
	@Column(name="montant_enchere")
	private float montantEnchere;
}
