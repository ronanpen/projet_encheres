package org.enchere.dal.impl;

import java.util.List;

import javax.persistence.Query;

import org.enchere.bo.Utilisateur;
import org.enchere.dal.DALException;
import org.enchere.dal.UtilisateurDAO;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;

public class UtilisateurHibernateImpl implements UtilisateurDAO {

	@Override
	public void insert(Utilisateur utilisateur) throws DALException{
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		Session session = SessionProvider.getSession();
		
		Query q = session.createQuery("FROM Utilisateur");
		
		return q.getResultList();
	}

	@Override
	public boolean verificationConnexion(Utilisateur utilisateur) throws DALException {
		Session session = SessionProvider.getSession();
		
		Query q = session.createQuery("FROM Utilisateur WHERE pseudo = " + utilisateur.getPseudo());
		
		Utilisateur utilisateur_bdd = (Utilisateur) q.getSingleResult();
		
		if(utilisateur_bdd.getMotDePasse().equals(utilisateur.getMotDePasse())) return true;
		return false;
	}

	@Override
	public Utilisateur selectById(int id) throws DALException {
		// TODO Faire la selection par id d'utilisateur
		return null;
	}
	
	

}
