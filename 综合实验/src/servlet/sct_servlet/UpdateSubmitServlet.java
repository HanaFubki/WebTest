package servlet.sct_servlet;

import domain.SCT_Course;
import org.apache.commons.beanutils.BeanUtils;
import service.SCT_Service;
import service.SCT_Service_Impl.SCT_Service_Impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/WebTest8/updateSubmitServlet")
public class UpdateSubmitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int cid = Integer.parseInt((String)request.getParameter("cid"));
        Map<String , String[]> map = request.getParameterMap();
        SCT_Course course = new SCT_Course();
        try {
            BeanUtils.populate(course , map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        SCT_Service service = new SCT_Service_Impl();
        service.updateCourseInfo(course , cid);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
