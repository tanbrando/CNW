package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.Account;
import model.BO.AccountBO;

/**
 * Servlet implementation class AuthController
 */
@WebServlet("/Auth/*")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String destination;
		String pathInfo = req.getPathInfo(); 
		PrintWriter out = resp.getWriter();
		if (pathInfo == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid endpoint\"}");
            return;
        }
		
		switch (pathInfo) {
        case "/login":
        	destination="/login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
            break;
        case "/logout":
            handleLogout(req, resp);
            break;
        default:
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.print("{\"error\": \"Endpoint not found\"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pathInfo = req.getPathInfo(); 
		PrintWriter out = resp.getWriter();
		if (pathInfo == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid endpoint\"}");
            return;
        }
		
		switch (pathInfo) {
        case "/login":
            handleLogin(req, resp);
            break;
        
        default:
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            out.print("{\"error\": \"Endpoint not found\"}");
		}
	}
	
	private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String destination;
      
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Account currentAccount = AccountBO.checkLogin(username, password); 

        if (currentAccount != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", currentAccount);

            resp.setStatus(HttpServletResponse.SC_OK);
            destination="/index.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            destination="/login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(req, resp);
        }
    }
	
	private void handleLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String destination;

        HttpSession session = req.getSession();
        session.setAttribute("account", null);

        destination="/index.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(req, resp);
    }

}
