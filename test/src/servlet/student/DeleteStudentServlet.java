package servlet.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.student;
import service.service;
import service.serviceImpl.serviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = "";
        if(request.getParameter("sid") != null)
            sid = request.getParameter("sid");
        else{sid = "";}
        BackMsg msg = new BackMsg();
        System.out.println("sid" + sid);
        ObjectMapper mapper = new ObjectMapper();
        service service = new serviceImpl();
        if(service.hasStudent(sid)){
            msg.setFlag(true);
            service.deleteStudent(sid);
        }else{
            msg.setFlag(false);
        }
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
