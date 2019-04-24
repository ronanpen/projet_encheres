package org.enchere.dal.impl;

import java.util.List;

import javax.persistence.Query;

import org.enchere.bo.Utilisateurs;
import org.enchere.dal.DALException;
import org.enchere.dal.UtilisateurDAO;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

public class UtilisateurHibernateImpl implements UtilisateurDAO {
	private static final int NB_ROUNDS = 13;

	@Override
	public void insert(Utilisateurs utilisateur) throws DALException{
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();
	}

	@Override
	public List<Utilisateurs> selectAll() throws DALException {
		Session session = SessionProvider.getSession();
		
		Query q = session.createQuery("FROM Utilisateurs");
		
		return q.getResultList();
	}

	@Override
	public Integer verificationConnexion(Utilisateurs utilisateur) throws DALException {
		Session session = SessionProvider.getSession();
		
		Query q = session.createQuery("FROM Utilisateurs WHERE pseudo = ?");
		q.setParameter(0, utilisateur.getPseudo());
		
		Utilisateurs utilisateur_bdd = (Utilisateurs) q.getSingleResult();
		
		// Vérification du hash mot de passe
		if(BCrypt.checkpw(utilisateur.getMotDePasse(), utilisateur_bdd.getMotDePasse())) return utilisateur_bdd.getIdUtilisateur();
		return null;
	}

	@Override
	public Utilisateurs selectById(int id) throws DALException {
		// TODO Faire la selection par id d'utilisateur
		return null;
	}
	
	

}
