package org.enchere.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated constructor stub
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

		try {
			if (this.utilisateurManager.connexion(pseudo, motDePasse, seSouvenirDeMoi)) {

				// si vrai => vers liste des encheres
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/connexion.jsp");
				rd.forward(request, response);
			}
		} catch (BLLException e) {
			e.printStackTrace();
		}

	}

}
