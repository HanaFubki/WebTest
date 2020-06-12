package servlet.sct_servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import service.SCT_Service;
import service.SCT_Service_Impl.SCT_Service_Impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/WebTest8/stuLoginServlet")
public class StuLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String stel = request.getParameter("stel");
        String spassword = request.getParameter("spassword");
        SCT_Service service = new SCT_Service_Impl();
        BackMsg msg = new BackMsg();
        if(service.stu_login(stel , spassword)){
            msg.setFlag(true);
            int sid = service.getStudentByTel(stel).getSid();
            HttpSession session = request.getSession();
            session.setAttribute("sid" , sid);
        }else{
            msg.setFlag(false);
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
