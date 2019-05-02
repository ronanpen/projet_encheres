package org.enchere.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.enchere.bll.BLLException;
import org.enchere.bll.CategorieManager;
import org.enchere.bo.Categorie;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategorieManager categorieManager;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.categorieManager = CategorieManager.getInstance();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categorie> categories = null;
		try {
			categories = this.categorieManager.recupererCategories();
		} catch(BLLException blle) {
			blle.printStackTrace();
		}
		
		request.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);

	}

}
