package org.enchere.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.enchere.bll.ArticleManager;
import org.enchere.bll.BLLException;
import org.enchere.bll.UtilisateurManager;
import org.enchere.bo.ArticleVendu;
import org.enchere.bo.Utilisateur;

/**
 * Servlet implementation class ServletVenteArticle
 */
@WebServlet("/vente")
public class ServletVenteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurManager utilisateurManager;
	private static ArticleManager articleManager = ArticleManager.getInstance();
	
	@Override
	public void init() throws ServletException {
		super.init();
		utilisateurManager = UtilisateurManager.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer idUtilisateur = (Integer)session.getAttribute("idUtilisateur");
		Utilisateur utilisateur = null;
		
		try {
			utilisateur = utilisateurManager.recupererProfilParId(idUtilisateur);
		}catch(BLLException blle) {
			blle.printStackTrace();
		}
		
		request.setAttribute("utilisateur", utilisateur);
		
		String idArticle = request.getParameter("id");
		if(idArticle != null) {
			int id = Integer.parseInt(idArticle);
			ArticleVendu article = null;
			try {
				article = this.articleManager.recupererArticleParId(id);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			request.setAttribute("article", article);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/afficherArticle.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/venteArticle.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomArticle = request.getParameter("nomArticle");
		String description = request.getParameter("descriptionArticle");
		int idCategorie = Integer.parseInt(request.getParameter("categorieArticle"));
		int prixDepart = Integer.parseInt(request.getParameter("prixDepart"));
		LocalDate dateDebutEnchere = LocalDate.parse(request.getParameter("debutEnchere"));
		LocalDate dateFinEnchere = LocalDate.parse(request.getParameter("finEnchere"));
		String nomRue = request.getParameter("nomRue");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");

		Integer idArticle = 1;
		/*try {
			idArticle = articleManager.ajouterArticle(nomArticle, description, 
					idCategorie, prixDepart, dateDebutEnchere, 
					dateFinEnchere, nomRue, codePostal, ville);
			idArticle = 1;
		} catch(BLLException blle) {
			blle.printStackTrace();
		}*/
		
		response.sendRedirect("vente?id=" + idArticle);
	}

}
