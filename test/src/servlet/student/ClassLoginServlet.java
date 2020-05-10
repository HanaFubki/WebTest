package servlet.student;

import service.service;
import service.serviceImpl.serviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/classLoginServlet")
public class ClassLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String sname = request.getParameter("sname");
        String sid = request.getParameter("sid");
        boolean isStu = false;
        service service = new serviceImpl();
        isStu = service.isStudent(sname , sid);
        if(isStu){
            System.out.println("LoginSuccess");
            session.setAttribute("sname" , sname);
            response.sendRedirect("./student/Student_List.jsp");
        }else{
            System.out.println("LoginFailed");
            response.sendRedirect("./index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
