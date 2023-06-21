package web;

import java.io.IOException;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.CreditMetierImpl;
import metier.ICreditMetier;
@WebServlet(name="cs",urlPatterns = {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet{

	private ICreditMetier metier;
	@Override
	public void init() throws ServletException {
		metier = new CreditMetierImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.doGet(req, resp);
		request.setAttribute("creditModel", new CreditModel());
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Lire les données de la requête
		 */
		double montant = Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		/*
		 * valider les données
		 */
		/*
		 * Stocker les données saisies dans le modèle
		 */
		CreditModel model =new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		/*
		 * Faire appel à la couche métier pour effectuer le traitement
		 */
		double res=metier.calculerMensualiteCredit(montant,taux,duree);
		/*
		 * Stocker le resultat dans le model
		 */
		model.setMensualite(res);
		/*
		 * stocker le modèle dans l'objet request
		 */
		request.setAttribute("creditModel", model);
		/*
		 * Fraire un forward vers la vue JSP
		 */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
		
	}
}
