package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.student;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/submitServlet")
public class SubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String , String[]> map = request.getParameterMap();
        String hobby = request.getParameter("hobbys");
        System.out.println("hobby : " + hobby);
        student stu = new student();
        try {
            BeanUtils.populate(stu , map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession();
        session.setAttribute("id" , stu.id);
        session.setAttribute("name" , stu.name);
        session.setAttribute("date" , stu.date);
        session.setAttribute("sex" , stu.sex);
        session.setAttribute("hobby" , hobby);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
