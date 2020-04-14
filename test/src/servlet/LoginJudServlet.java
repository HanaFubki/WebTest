package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginJudServlet")
public class LoginJudServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        BackMsg msg = new BackMsg();
        String name = "";
//        Cookie[] cookies = request.getCookies();
//        for(Cookie cookie : cookies){
//            if(cookie.getName().equals("name")){
//                name = cookie.getValue();
//            }
//        }
        HttpSession session = request.getSession();
        name = (String)session.getAttribute("name");
        if(name.equals("")){
            msg.setFlag(false);
        }else{
            msg.setFlag(true);
            msg.setMsg(name);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
