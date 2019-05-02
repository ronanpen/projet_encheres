package org.enchere.dal.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.enchere.bo.Utilisateur;
import org.enchere.dal.DALException;
import org.enchere.dal.UtilisateurDAO;
import org.enchere.dal.connection.SessionProvider;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

public class UtilisateurHibernateImpl implements UtilisateurDAO {

	@Override
	public Integer insert(Utilisateur utilisateur) throws DALException{
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		session.save(utilisateur);
		session.getTransaction().commit();
		session.close();
		
		return utilisateur.getIdUtilisateur();
	}

	@Override
	public List<Utilisateur> selectAll() throws DALException {
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		Query<Utilisateur> q = session.createQuery("FROM Utilisateurs", Utilisateur.class);
		List<Utilisateur> utilisateurs = q.getResultList();
		session.getTransaction().commit();
		session.close();
		
		return utilisateurs;
	}

	@Override
	public Integer verificationConnexion(Utilisateur utilisateur, boolean isMail) throws DALException {
		Utilisateur utilisateur_bdd = null;
		if(isMail) {
			utilisateur_bdd = this.selectByMail(utilisateur.getEmail());
		}else {
			utilisateur_bdd = this.selectByPseudo(utilisateur.getPseudo());
		}
		
		if(utilisateur_bdd == null) throw new DALException("L'utilisateur n'existe pas dans la base de donnée");
		
		// Vérification du hash mot de passe
		if(!BCrypt.checkpw(utilisateur.getMotDePasse(), utilisateur_bdd.getMotDePasse())) throw new DALException("Le mot de passe est incorrect");
 
		return utilisateur_bdd.getIdUtilisateur();
	}

	@Override
	public Utilisateur selectById(int id) throws DALException {
		Session session = SessionProvider.getSession();
		session.beginTransaction();
		Utilisateur utilisateur = session.get(Utilisateur.class, id);
		if(utilisateur == null) session.getTransaction().rollback();
		else session.getTransaction().commit();
		session.close();
		
		return utilisateur;
	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		Session session = SessionProvider.getSession();
		Utilisateur utilisateur = null;
		
		session.beginTransaction();
		Query<Utilisateur> q = session.createQuery("FROM Utilisateurs WHERE pseudo = ?1", Utilisateur.class);
		q.setParameter(1, pseudo);
		try {
			utilisateur = q.getSingleResult();
		} catch(NoResultException nore) {}
		session.getTransaction().commit();
		session.close();
		
		return utilisateur;
	}
	
	@Override
	public Utilisateur selectByMail(String mail) throws DALException {
		Session session = SessionProvider.getSession();
		Utilisateur utilisateur = null;
		
		session.beginTransaction();
		Query<Utilisateur> q = session.createQuery("FROM Utilisateurs WHERE email = ?1", Utilisateur.class);
		q.setParameter(1, mail);
		try {
			utilisateur = (Utilisateur) q.getSingleResult();
		} catch(NoResultException nore) {}
		session.getTransaction().commit();
		session.close();
		
		return utilisateur;
	}

	@Override
	public void update(Utilisateur utilisateur) throws DALException {
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		session.update(utilisateur);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void delete(Integer idUtilisateur) {
		Session session = SessionProvider.getSession();
		
		session.beginTransaction();
		Query<?> q = session.createQuery("DELETE FROM Utilisateurs WHERE no_utilisateur = ?1");
		q.setParameter(1, idUtilisateur);
		q.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

}
