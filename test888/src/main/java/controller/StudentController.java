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

import model.BEAN.Student;
import model.BO.StudentBO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/Student/*")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String destination,id;
		ArrayList<Student> studentList;
		Student student = null;
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
				if (req.getParameter("department") != null) {
					String department = req.getParameter("department");
                    studentList = StudentBO.getDepartmentStudentList(department);
				} else {
					studentList = StudentBO.getStudentList();
					System.out.println(studentList);
				}
				ArrayList<String> departmentList = StudentBO.getStudentDepartmentList();
				req.setAttribute("studentList", studentList);
				req.setAttribute("departmentList",departmentList);
                destination = "/list.jsp";
                rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(req, resp);
                break;
            case "/insert":
				ArrayList<String> idList = StudentBO.getStudentIdList();
			    destination = "/insert.jsp";
				rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(req, resp);
				break;
			case "/edit":
				id = req.getParameter("id");
                student = StudentBO.getStudentById(id);
                if (student == null) {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.print("{\"error\": \"Student not found\"}");
                    return;
                }
                destination = "/edit.jsp";
                req.setAttribute("student", student);
                rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(req, resp);
                break;
            case "/delete":
				id = req.getParameter("id");
				student = StudentBO.getStudentById(id);
				if (student == null) {
					resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
					out.print("{\"error\": \"Student not found\"}");
					return;
				}
				destination = "/delete.jsp";
				req.setAttribute("student", student);
				rd = getServletContext().getRequestDispatcher(destination);
                rd.forward(req, resp);
				break;
			default:
			    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				out.print("{\"error\": \"Invalid endpoint\"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id,name,gender,department;
		String pathInfo = req.getPathInfo(); 
		PrintWriter out = resp.getWriter();
		if (pathInfo == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid endpoint\"}");
            return;
        }

		switch (pathInfo) {
			case "/insert":
			    id = req.getParameter("id");
				name = req.getParameter("name");
				gender = req.getParameter("gender");
				department = req.getParameter("department");
				StudentBO.addStudent(id, name, gender, department);
				resp.sendRedirect("list");
                break;
            case "/update":
            	id = req.getParameter("id");
				name = req.getParameter("name");
				gender = req.getParameter("gender");
				department = req.getParameter("department");
                StudentBO.updateStudent(id, name, gender, department);
                resp.sendRedirect("list");
                break;
            case "/delete":
                id = req.getParameter("id");
                StudentBO.deleteStudent(id);
                resp.sendRedirect("list");
                break;
            default:
			    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				out.print("{\"error\": \"Invalid endpoint\"}");
		}
	}

}
