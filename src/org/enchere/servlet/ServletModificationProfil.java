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
import org.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletModification
 */
@WebServlet("/modification")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager;

	@Override
	public void init() throws ServletException {
		super.init();
		utilisateurManager = UtilisateurManager.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer idUtilisateur = (Integer) session.getAttribute("idUtilisateur");
		Utilisateur utilisateur = null;

		try {
			utilisateur = utilisateurManager.recupererProfilParId(idUtilisateur);

		} catch (BLLException e) {

			e.printStackTrace();
		}

		request.setAttribute("utilisateur", utilisateur);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/modificationProfil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Integer idUtilisateur = (Integer) session.getAttribute("idUtilisateur");
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
			this.utilisateurManager.modificationProfil(idUtilisateur, pseudo, nom, prenom, email, telephone, rue,
					codePostal, ville, motDePasse, confirmation);

			response.sendRedirect("monProfil");

		} catch (BLLException e) {
			request.setAttribute("message", e.getErrorCodes());
			doGet(request, response);

		}
	}

}
