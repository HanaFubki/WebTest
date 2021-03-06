package servlet.sct_servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.SCT_Teacher;
import org.apache.commons.beanutils.BeanUtils;
import service.SCT_Service;
import service.SCT_Service_Impl.SCT_Service_Impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/WebTest8/teaLoginServlet")
public class TeaLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ttel = request.getParameter("ttel");
        String spassword = request.getParameter("tpassword");
        SCT_Service service = new SCT_Service_Impl();
        BackMsg msg = new BackMsg();
        if(service.tea_login(ttel , spassword)){
            msg.setFlag(true);
            int tid = service.getTaecherByTel(ttel).getTid();
            HttpSession session = request.getSession();
            session.setAttribute("tid" , tid);
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
