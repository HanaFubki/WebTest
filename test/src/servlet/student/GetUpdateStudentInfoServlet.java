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

@WebServlet("/getUpdateStudentInfoServlet")
public class GetUpdateStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String sid = request.getParameter("sid");
        service service = new serviceImpl();
        BackMsg msg = new BackMsg();
        ObjectMapper mapper = new ObjectMapper();
        student student = service.getstudent(sid);
        msg.setData(student);
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
