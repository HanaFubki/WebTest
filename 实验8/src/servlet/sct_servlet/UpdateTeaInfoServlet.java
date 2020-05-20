package servlet.sct_servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.SCT_Student;
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

@WebServlet("/WebTest8/updateTeaInfoServlet")
public class UpdateTeaInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String , String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        int tid = (int) session.getAttribute("tid");
        SCT_Teacher sct_teacher = new SCT_Teacher();
        try {
            BeanUtils.populate(sct_teacher , map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        SCT_Service service = new SCT_Service_Impl();
        BackMsg msg = new BackMsg();
        if(!service.tea_check(sct_teacher.getTtel())){
            service.updateTeaInfo(sct_teacher , tid);
            msg.setFlag(true);
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
