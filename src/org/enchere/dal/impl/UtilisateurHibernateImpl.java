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
	// TODO changer le retour en Integer
	public void insert(Utilisateur utilisateur) throws DALException{
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		Query q = session.createQuery("FROM Utilisateurs");
		session.getTransaction().commit();
		
		return q.getResultList();
	}

	@Override
	public Integer verificationConnexion(Utilisateur utilisateur) throws DALException {
		Utilisateur utilisateur_bdd = this.selectByPseudo(utilisateur.getPseudo());
		
		// Vérification du hash mot de passe
		if(BCrypt.checkpw(utilisateur.getMotDePasse(), utilisateur_bdd.getMotDePasse())) return utilisateur_bdd.getIdUtilisateur();
		return null;
	}

	@Override
	public Utilisateur selectById(int id) throws DALException {
		Session session = SessionProvider.getSession();
		session.beginTransaction();
		Utilisateur utilisateur = session.get(Utilisateur.class, id);
		session.getTransaction().commit();
		
		return utilisateur;
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		Query q = session.createQuery("FROM Utilisateurs WHERE pseudo = ?1", Utilisateur.class);
		q.setParameter(1, pseudo);
		session.getTransaction().commit();
		
		return (Utilisateur) q.getSingleResult();
	}
	
	

}
