package org.enchere.dal;

import org.enchere.dal.impl.UtilisateurHibernateImpl;

public abstract class DAOFactory {
	public static UtilisateurDAO getUtilisateurImpl() {
		return new UtilisateurHibernateImpl();
	}
}
