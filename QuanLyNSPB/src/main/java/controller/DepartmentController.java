package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BEAN.Department;
import model.BO.DepartmentBO;

/**
 * Servlet implementation class DepartmentController
 */
@WebServlet("/Department/*")
public class DepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String destination;
		ArrayList<Department> departmentList;
		RequestDispatcher rd;
		String pathInfo = req.getPathInfo(); 
		PrintWriter out = resp.getWriter();
		if (pathInfo == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid endpoint\"}");
            return;
        }
		
		switch (pathInfo) {
	        case "/list":
	        	destination="/departmentList.jsp";
	        	departmentList = DepartmentBO.getDepartmentList();
	        	req.setAttribute("departmentList", departmentList);
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
	            break;
	        case "/editList":
	        	destination="/departmentUpdateList.jsp";
	        	departmentList = DepartmentBO.getDepartmentList();
	        	req.setAttribute("departmentList", departmentList);
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
	            break;
	        case "/edit":
	        	destination="/departmentUpdateList.jsp";
	        	String department_id = req.getParameter("id");
	        	Department department = DepartmentBO.getDepartment(department_id);
	    		req.setAttribute("department", department);
	    		destination="/editDepartment.jsp";
	    		rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
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
	        case "/edit":
	        	String department_id = req.getParameter("IDPB");
	        	String name = req.getParameter("Tenphongban");
	        	String detail = req.getParameter("Mota");
	        	DepartmentBO.editDepartment(department_id, name, detail);
	        	resp.sendRedirect("editList");
	        	break;
	        default:
	            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            out.print("{\"error\": \"Endpoint not found\"}");
		}
	}
}
