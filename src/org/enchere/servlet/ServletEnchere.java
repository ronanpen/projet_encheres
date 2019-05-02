package org.enchere.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.enchere.bll.ArticleManager;
import org.enchere.bll.BLLException;
import org.enchere.bll.EnchereManager;
import org.enchere.bo.ArticleVendu;
import org.enchere.bo.Enchere;

/**
 * Servlet implementation class ServletEnchere
 */
@WebServlet("/enchere")
public class ServletEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArticleManager articleManager;
	private EnchereManager enchereManager;
	private Integer idArticle;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.articleManager = ArticleManager.getInstance();
		this.enchereManager = EnchereManager.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.idArticle = Integer.parseInt(request.getParameter("id"));
		ArticleVendu article = null;
		Enchere enchere = null;
		
		try {
			article = this.articleManager.recupererArticleParId(this.idArticle);
			List<Enchere> encheres = this.enchereManager.recupererEncheresParIdArticle(this.idArticle);
			enchere = encheres.get(0);
		} catch(BLLException blle) {
			blle.printStackTrace();
		}
		
		if(article == null) {
			response.sendRedirect("accueil");
		}
		
		request.setAttribute("article", article);
		request.setAttribute("enchere", enchere);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/enchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer idUtilisateur = (Integer)session.getAttribute("idUtilisateur");
		Integer prixPropose = Integer.parseInt(request.getParameter("prixPropose"));
		
		try {
			this.enchereManager.ajouterEnchere(this.idArticle, prixPropose, idUtilisateur);
		} catch (BLLException blle) {
			request.setAttribute("message", blle.getErrorCodes());
			doGet(request, response);
		}
	}

}
