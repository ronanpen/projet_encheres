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
 * Servlet implementation class ServletMonProfile
 */
@WebServlet("/monProfil")
public class ServletMonProfil extends HttpServlet {
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
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/monProfil.jsp");
		rd.forward(request, response);
	}

}
