package model.BO;

import java.util.ArrayList;

import model.BEAN.Student;
import model.DAO.StudentDAO;

public class StudentBO {
    public static ArrayList<Student> getStudentList() {
        return StudentDAO.Instance().getStudentList();
    }

    public static ArrayList<String> getStudentIdList() {
        return StudentDAO.Instance().getStudentIdList();
    }

    public static Student getStudentById(String id) {
        return StudentDAO.Instance().getStudentById(id);
    }

    public static ArrayList<Student> getDepartmentStudentList(String department) {
        return StudentDAO.Instance().getDepartmentStudentList(department);
    }

    public static ArrayList<String> getStudentDepartmentList() {
        return StudentDAO.Instance().getStudentDepartmentList();
    }

    public static void addStudent(String id, String name, String gender, String department) {
        StudentDAO.Instance().addStudent(id, name, gender, department);
    }

    public static void updateStudent(String id, String name, String gender, String department) {
        StudentDAO.Instance().updateStudent(id, name, gender, department);
    }

    public static void deleteStudent(String id) {
        StudentDAO.Instance().deleteStudent(id);
    }

    
}
