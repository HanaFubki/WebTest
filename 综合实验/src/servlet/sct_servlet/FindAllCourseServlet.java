package servlet.sct_servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.SCT_Course;
import service.SCT_Service;
import service.SCT_Service_Impl.SCT_Service_Impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/WebTest8/findAllCourseServlet")
public class FindAllCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int startCount = Integer.parseInt((String)request.getParameter("startCount"));
        SCT_Service service = new SCT_Service_Impl();
        List<SCT_Course> list = service.getAllCourse(startCount * 5);
        int count = service.getAllCount();
        StringBuffer sb = new StringBuffer();
        BackMsg msg = new BackMsg();
        if(count > 0){
            sb.append("\n" +
                    "                <table>\n" +
                    "                    <thead>\n" +
                    "                    <th>课程id</th>\n" +
                    "                    <th>课程名</th>\n" +
                    "                    <th>教师id</th>\n" +
                    "                    <th>最大人数</th>\n" +
                    "                    <th>当前人数</th>\n" +
                    "                    <th>年级限制</th>\n" +
                    "                    </thead>\n");
            for(int i = 0 ; i < list.size() ; i++){
                SCT_Course course = list.get(i);
                sb.append(
                        "                    <tr>\n" +
                                "                        <td>" + course.getCid() + "</td>\n" +
                                "                        <td>" + course.getCname() + "</td>\n" +
                                "                        <td>" + service.getTeacherByTid(course.getTid()).getTname() + "</td>\n" +
                                "                        <td>" + course.getCountLimit() + "</td>\n" +
                                "                        <td>" + course.getNowCount() + "</td>\n" +
                                "                        <td>大" + course.getGradeLimit() + "</td><td></tr>");
            }
            int totalCount = startCount;
            if(count % 5 == 0){
                totalCount = count / 5;
            }else{
                totalCount = (count / 5) + 1;
            }
            sb.append("</table>        <div class=\"page\"> 共" + count + "条数据" + " , 共" + totalCount + "页 , 当前为第" + (startCount + 1) + "页<br>" + "\n");
            for(int i = 0 ; i < totalCount ; i++){
                sb.append("            <a href=\"javascript:void(0);\" onclick=\"find_all_course(" + i + ")\">" + (i + 1) + "</a>\n");
            }
            sb.append("        </div>");
        }else{
            sb.append("目前没有在选课程哦...");
        }
        msg.setMsg(sb.toString());
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
