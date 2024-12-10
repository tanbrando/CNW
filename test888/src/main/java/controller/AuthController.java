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
		RequestDispatcher rd;
		String pathInfo = req.getPathInfo(); 
		PrintWriter out = resp.getWriter();
		if (pathInfo == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid endpoint\"}");
            return;
        }
		
        switch (pathInfo) {
			case "/login":
			    destination = "/login.jsp";
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
				break;
			case "/logout":
				HttpSession session = req.getSession(false);
				if (session!= null) {
                    session.invalidate();
                }
				resp.sendRedirect(req.getContextPath() + "/Auth/login");
                break;
            default: 
			    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				out.print("{\"error\": \"Invalid endpoint\"}");
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
			    String username = req.getParameter("username");
				String password = req.getParameter("password");
				if (AccountBO.checkLogin(username, password)) {
					HttpSession session = req.getSession();
                    session.setAttribute("username", username);
                    resp.sendRedirect(req.getContextPath() + "/Student/list");
				} else {
					resp.sendRedirect(req.getContextPath() + "/Auth/login");
				}
                break;
            default:
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.print("{\"error\": \"Invalid endpoint\"}");
        }
	}

}
