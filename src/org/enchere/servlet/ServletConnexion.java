package org.enchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.enchere.bll.BLLException;
import org.enchere.bll.UtilisateurManager;

/**
 * Servlet implementation class SerletConnexion
 */
@WebServlet("/connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurManager utilisateurManager;

	@Override
	public void init() throws ServletException {
		super.init();

		this.utilisateurManager = UtilisateurManager.getInstance();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletConnexion() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("identifiant");
		String motDePasse = request.getParameter("MotDePasse");
		boolean seSouvenirDeMoi = true;

		// verifier que l'utilisateur existe
		try {
			Integer idUtilisateur = this.utilisateurManager.connexion(pseudo, motDePasse, seSouvenirDeMoi);
			if (idUtilisateur != null) {
				// si vrai => sendRedirect vers la servlet Accueil + créer la session
				// TODO: si faux => message d'erreur;
				// TODO: pointer vers la servlet d'accueil

				HttpSession session = request.getSession();
				session.setAttribute("idUtilisateur", idUtilisateur);

				response.sendRedirect("accueil");

				System.out.println("connecté");

			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

}
