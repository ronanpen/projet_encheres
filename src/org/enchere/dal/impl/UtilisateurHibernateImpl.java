package org.enchere.dal.impl;

import java.util.List;

import javax.persistence.Query;

import org.enchere.bo.Utilisateur;
import org.enchere.dal.DALException;
import org.enchere.dal.UtilisateurDAO;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

public class UtilisateurHibernateImpl implements UtilisateurDAO {
	private static final int NB_ROUNDS = 13;

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
	public Utilisateur verificationConnexion(Utilisateur utilisateur) throws DALException {
		Session session = SessionProvider.getSession();
		
		Query q = session.createQuery("FROM Utilisateur WHERE pseudo = " + utilisateur.getPseudo());
		
		Utilisateur utilisateur_bdd = (Utilisateur) q.getSingleResult();
		
		if(BCrypt.checkpw(utilisateur.getMotDePasse(), utilisateur_bdd.getMotDePasse())) return utilisateur_bdd;
		return null;
	}

	@Override
	public Utilisateur selectById(int id) throws DALException {
		// TODO Faire la selection par id d'utilisateur
		return null;
	}
	
	

}
