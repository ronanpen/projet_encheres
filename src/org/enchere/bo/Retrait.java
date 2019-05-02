package org.enchere.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Retraits")
public class Retrait {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no_retrait")
	private Integer idRetrait;
	private String rue;
	@Column(name = "code_postal")
	private String codePostal;
	private String ville;

	/**
	 * @return the idRetrait
	 */
	public Integer getIdRetrait() {
		return idRetrait;
	}

	/**
	 * @param idRetrait
	 *            the idRetrait to set
	 */
	public void setIdRetrait(Integer idRetrait) {
		this.idRetrait = idRetrait;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue
	 *            the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @param idRetrait
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Retrait(Integer idRetrait, String rue, String codePostal, String ville) {
		super();
		this.idRetrait = idRetrait;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [idRetrait=" + idRetrait + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ "]";
	}

}
