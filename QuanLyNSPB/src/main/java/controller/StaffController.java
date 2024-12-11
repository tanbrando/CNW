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

import model.BEAN.Staff;
import model.BO.DepartmentBO;
import model.BO.StaffBO;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/Staff/*")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String destination;
		ArrayList<Staff> staffList = new ArrayList<Staff>();
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
	        	destination="/staffList.jsp";
	        	String searchObject = req.getParameter("searchObject");
	        	String searchData = req.getParameter("searchData");
	        	if ((searchObject != null) && (searchData != null)) {
	        		staffList = StaffBO.getSearchedStaffList(searchObject,searchData);
	        	} else
	        		staffList = StaffBO.getStaffList();
	        	req.setAttribute("staffList", staffList);
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
	            break;
	        case "/search":
	        	destination="/searchStaff.jsp";
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
	            break;
	        case "/insert":
	        	destination="/insertStaff.jsp";
	        	ArrayList<String> idList = StaffBO.getStaffIDList();
	        	ArrayList<String> departmentIDList = DepartmentBO.getDepartmentIDList();
	        	req.setAttribute("idList", idList);
	        	req.setAttribute("departmentIDList", departmentIDList);
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
	        	break;
	        case "/delete":
	        	destination="/deleteStaff.jsp";
	        	String id = req.getParameter("id");
	        	if (id!=null) {
	        		StaffBO.deleteStaff(id);
	        	}
	        	staffList = StaffBO.getStaffList();
	        	req.setAttribute("staffList", staffList);
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
	        	break;
	        case "/deleteAll":
	        	destination="/deleteAllStaff.jsp";
	        	String[] ids =  req.getParameterValues("idList");
	        	if (ids!=null) {
	        		for (int i = 0; i<ids.length; i++) {
	        			StaffBO.deleteStaff(ids[i]);
	        		}
	        	}
	        	staffList = StaffBO.getStaffList();
	        	req.setAttribute("staffList", staffList);
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
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		RequestDispatcher rd;
		String pathInfo = req.getPathInfo(); 
		PrintWriter out = resp.getWriter();
		if (pathInfo == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid endpoint\"}");
            return;
        }
		switch (pathInfo) {
	        case "/insert":
	        	destination="/staffList.jsp";
	        	String id = req.getParameter("IDNV");
	        	String name = req.getParameter("Hoten");
	        	String adddress = req.getParameter("Diachi");
	        	String department_id = req.getParameter("IDPB");
	        	StaffBO.addStaff(id, department_id, name, adddress);
	        	staffList = StaffBO.getStaffList();
	        	req.setAttribute("staffList", staffList);
				rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(req, resp);
	        	break;
	        default:
	            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            out.print("{\"error\": \"Endpoint not found\"}");
		}
	}

}
