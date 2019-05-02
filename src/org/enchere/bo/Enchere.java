package org.enchere.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Encheres")
public class Enchere implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no_enchere")
	private Integer idEnchere;

	@ManyToOne
	@JoinColumn(name = "no_utilisateur")
	@Column(name = "no_utilisateur")
	private Utilisateur utilisateur;

	@ManyToOne
	@JoinColumn(name = "no_article")
	@Column(name = "no_article")
	private ArticleVendu article;

	@Column(name = "date_enchere")
	private Date dateEnchere;
	@Column(name = "montant_enchere")
	private Integer montantEnchere;

	/**
	 * @return the idEnchere
	 */
	public Integer getIdEnchere() {
		return idEnchere;
	}

	/**
	 * @param idEnchere
	 *            the idEnchere to set
	 */
	public void setIdEnchere(Integer idEnchere) {
		this.idEnchere = idEnchere;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur
	 *            the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the article
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * @param article
	 *            the article to set
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	/**
	 * @return the dateEnchere
	 */
	public Date getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * @param dateEnchere
	 *            the dateEnchere to set
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * @return the montantEnchere
	 */
	public Integer getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * @param montantEnchere
	 *            the montantEnchere to set
	 */
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	/**
	 * @param idEnchere
	 * @param utilisateur
	 * @param article
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Enchere(Integer idEnchere, Utilisateur utilisateur, ArticleVendu article, Date dateEnchere,
			Integer montantEnchere) {
		super();
		this.idEnchere = idEnchere;
		this.utilisateur = utilisateur;
		this.article = article;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [idEnchere=" + idEnchere + ", utilisateur=" + utilisateur + ", article=" + article
				+ ", dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}

}
