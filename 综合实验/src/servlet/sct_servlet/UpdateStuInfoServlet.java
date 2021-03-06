package servlet.sct_servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.SCT_Student;
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

@WebServlet("/WebTest8/updateStuInfoServlet")
public class UpdateStuInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String , String[]> map = request.getParameterMap();
        HttpSession session = request.getSession();
        int sid = (int) session.getAttribute("sid");
        SCT_Student sct_student = new SCT_Student();
        try {
            BeanUtils.populate(sct_student , map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        SCT_Service service = new SCT_Service_Impl();
        BackMsg msg = new BackMsg();
        if(!service.stu_check(sct_student.getStel())){
            service.updateStuInfo(sct_student , sid);
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
