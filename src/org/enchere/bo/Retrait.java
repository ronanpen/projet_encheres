package org.enchere.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name="Retraits")
public class Retrait {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no_retrait")
	private Integer idRetrait;
	@OneToOne
	@JoinColumn(name="no_article")
	@Column(name="no_article")
	private ArticleVendu article;
	private String rue;
	@Column(name="code_postal")
	private String codePostal;
	private String ville;
}
