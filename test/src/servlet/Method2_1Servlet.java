package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/method2_1Servlet")
public class Method2_1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        request.setAttribute("id" , id);
        String name = request.getParameter("name");
        request.setAttribute("name" , name);
        String date = request.getParameter("date");
        request.setAttribute("date" , date);
        String sex = request.getParameter("sex");
        request.setAttribute("sex" , sex);
        String[] hobby = request.getParameterValues("hobby");
        String s = "";
        for(int i = 0 ; i < hobby.length ; i++){
            s = s + hobby[i] + " ";
        }
        request.setAttribute("hobby" , s);
        request.getRequestDispatcher("./method2_2Servlet").forward(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
