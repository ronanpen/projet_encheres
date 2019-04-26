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
 * Servlet implementation class ServletInscription
 */
@WebServlet("/inscription")
public class ServletInscription extends HttpServlet {
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
	public ServletInscription() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation = request.getParameter("confirmation");

		try {
			Integer idUtilisateur = this.utilisateurManager.inscription(pseudo, nom, prenom, email, telephone, rue,
					codePostal, ville, motDePasse, confirmation);
			if (idUtilisateur != null) {
				HttpSession session = request.getSession();
				session.setAttribute("idUtilisateur", idUtilisateur);
				response.sendRedirect("accueil");
			}

			HttpSession session = request.getSession();

			session.setAttribute("idUtilisateur", idUtilisateur);

			response.sendRedirect("accueil");

		} catch (BLLException e) {
			e.printStackTrace();

		}
	}
}
