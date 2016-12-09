package fr.tbr.iam.web.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.tbr.iam.log.IAMLogger;
import fr.tbr.iam.log.impl.IAMLogManager;
import fr.tbr.iamcore.datamodel.User;
import fr.tbr.iamcore.exception.DAOSaveException;
import fr.tbr.iamcore.exception.DAOSearchException;
import fr.tbr.iamcore.service.dao.UserDAOInterface;

/**
 * Servlet implementation class Login
 */

@WebServlet(name="Login", urlPatterns="/Login")
public class Login extends GenericSpringServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	UserDAOInterface dao;
	
	IAMLogger logger = IAMLogManager.getIAMLogger(Login.class);

    /**
     * Default constructor. 
     */
    public Login() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		try {
			dao.save(new User("test", "test"));
		} catch (DAOSaveException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		logger.debug(login);
		logger.debug(password);
		
		try {
			if (dao.authenticate(login, password)){
				response.sendRedirect("welcome.jsp");
			}else{
				response.sendRedirect("reconnect.jsp");
			}
		} catch (DAOSearchException | DAOSaveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
