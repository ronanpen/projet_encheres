package org.enchere.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity(name="Retraits")
public class Retrait {
	@OneToOne
	@JoinColumn(name="no_article")
	@Column(name="no_article")
	private ArticleVendu article;
	private String rue;
	@Column(name="code_postal")
	private String codePostal;
	private String ville;
}
