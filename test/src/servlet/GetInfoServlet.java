package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/getInfoServlet")
public class GetInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        BackMsg msg = new BackMsg();
        msg.setMsg(
                "    <h3>学生信息录入</h3>" +
                "    学号:" + session.getAttribute("id") + "<br>" +
                "    姓名:" + session.getAttribute("name") + "<br>" +
                "    生日:" + session.getAttribute("date") + "<br>" +
                "    性别:" + session.getAttribute("sex") + "<br>" +
                "    体育爱好:" + session.getAttribute("hobby") + "<br>");
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
