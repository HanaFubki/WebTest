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

@WebServlet("/insertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        student searchInfo = new student();
        String sid , sname , sbirthday = "";
        int ssex = 0;
        if(request.getParameter("sid") != null)
            sid = request.getParameter("sid");
        else{sid = "";}
        if(request.getParameter("sname") != null)
            sname = request.getParameter("sname");
        else{sname = "";}
        if(request.getParameter("sbirthday") != null)
            sbirthday = request.getParameter("sbirthday");
        else{sbirthday = "";}
        if(request.getParameter("ssex") != null)
            ssex = Integer.parseInt((String)request.getParameter("ssex"));
        else{ssex = 0;}
        searchInfo.setSid(sid);
        searchInfo.setSname(sname);
        searchInfo.setSbirthday(sbirthday);
        searchInfo.setSsex(ssex);
        BackMsg msg = new BackMsg();
        ObjectMapper mapper = new ObjectMapper();
        service service = new serviceImpl();
        if(service.hasStudent(sid)){
            msg.setFlag(false);
        }else{
            msg.setFlag(true);
            service.insertStudent(searchInfo);
        }
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
