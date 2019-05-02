package org.enchere.bo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity(name="Article_vendus")
public class ArticleVendu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="no_article")
	private Integer idArticle;
	@Column(name="nom_article")
	private String nomArticle;
	private String description;
	@Column(name="date_debut_encheres")
	private LocalDate dateDebutEncheres;
	@Column(name="date_fin_encheres")
	private LocalDate dateFinEncheres;
	@Column(name="prix_initial")
	private int miseAPrix;
	@Column(name="prix_vente")
	private Integer prixVente;
	@ManyToOne
	@JoinColumn(name="no_utilisateur")
	@Column(name="no_utilisateur")
	private Utilisateur utilisateur;
	@OneToOne
	@JoinColumn(name="no_retrait")
	@Column(name="no_retrait")
	private Retrait retrait;
	@ManyToOne
	@JoinColumn(name="no_categorie")
	@Column(name="no_categorie")
	private Categorie categorie;
	
	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, Integer prixVente, Utilisateur utilisateur, Retrait retrait, Categorie categorie) {
		this(null, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, utilisateur, retrait, categorie);
	}
	
	public ArticleVendu(Integer idArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, Integer prixVente, Utilisateur utilisateur, Retrait retrait, Categorie categorie) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.retrait = retrait;
		this.prixVente = prixVente;
		this.utilisateur = utilisateur;
		this.categorie = categorie;
	}

	public Integer getIdArticle() {
		return idArticle;
	}
	
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	
	public String getNomArticle() {
		return nomArticle;
	}
	
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	
	public int getMiseAPrix() {
		return miseAPrix;
	}
	
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	
	public Integer getPrixVente() {
		if(prixVente == null) return miseAPrix;
		return prixVente;
	}
	
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	@Override
	public String toString() {
		return "ArticleVendu [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", utilisateur=" + utilisateur + ", categorie=" + categorie
				+ "]";
	}
}
