package org.enchere.bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import lombok.Generated;

@Entity(name = "Encheres")
public class Enchere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no_enchere")
	private Integer idEnchere;
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

	public Enchere(Utilisateur utilisateur, ArticleVendu article, float montantEnchere) {
		this.utilisateur = utilisateur;
		this.article = article;
		this.dateEnchere = LocalDateTime.now();
		this.montantEnchere = montantEnchere;
	}
	
	
}
