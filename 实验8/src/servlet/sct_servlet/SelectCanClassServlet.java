package servlet.sct_servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.SCT_Course;
import domain.SCT_Student;
import service.SCT_Service;
import service.SCT_Service_Impl.SCT_Service_Impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/WebTest8/selectCanClassServlet")
public class SelectCanClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int startCount = Integer.parseInt((String)request.getParameter("startCount"));
        int sid = (int)request.getSession().getAttribute("sid");
        SCT_Service service = new SCT_Service_Impl();
        StringBuffer sb = new StringBuffer();
        SCT_Student sct_student = service.getStudentBySid((int)request.getSession().getAttribute("sid"));
        int maxCount = 0;
        BackMsg msg = new BackMsg();
        maxCount = service.getCourseCountByLimit(sct_student.getSgrade());
        if(maxCount > 0){
            List<SCT_Course> list = service.getCourseByLimit(sct_student.getSgrade() , startCount * 5);
            int nowCount = 0;
            int cid = 0;
            sb.append("\n" +
                    "                <table>\n" +
                    "                    <thead>\n" +
                    "                    <th>课程id</th>\n" +
                    "                    <th>课程名</th>\n" +
                    "                    <th>教师id</th>\n" +
                    "                    <th>最大人数</th>\n" +
                    "                    <th>当前人数</th>\n" +
                    "                    <th>年级限制</th>\n" +
                    "                    <th>操作</th>\n" +
                    "                    </thead>\n");
            if(maxCount - startCount * 5 >= 5){
                nowCount = 5;
            }else{
                nowCount = maxCount - startCount * 5;
            }
            for(int i = 0 ; i < list.size() ; i++){
                SCT_Course course = list.get(i);
                sb.append(
                        "                    <tr>\n" +
                                "                        <td>" + course.getCid() + "</td>\n" +
                                "                        <td>" + course.getCname() + "</td>\n" +
                                "                        <td>" + service.getTeacherByTid(course.getTid()).getTname() + "</td>\n" +
                                "                        <td>" + course.getCountLimit() + "</td>\n" +
                                "                        <td>" + course.getNowCount() + "</td>\n" +
                                "                        <td>大" + course.getGradeLimit() + "</td>");
                if(service.stuInClass(sid , course.getCid())){
                    sb.append("<td><a href=\"javascript:void(0);\" onclick=\"exitClass(" + course.getCid() + ")\">退选</a></td>");
                }else{
                    sb.append("<td><a href=\"javascript:void(0);\" onclick=\"joinClass(" + course.getCid() + ")\">选课</a></td>");
                }
                sb.append("</tr>");
            }
            int totalCount = startCount;
            if(maxCount % 5 == 0){
                totalCount = maxCount / 5;
            }else{
                totalCount = (maxCount / 5) + 1;
            }
            sb.append("</table>        <div class=\"page\"> 共" + maxCount + "条数据" + " , 共" + totalCount + "页 , 当前为第" + (startCount + 1) + "页<br>" + "\n");
            for(int i = 0 ; i < totalCount ; i++){
                sb.append("            <a href=\"javascript:void(0);\" onclick=\"selectCanClass(" + i + ")\">" + (i + 1) + "</a>\n");
            }
            sb.append("        </div>");
        }else{
            sb.append("没有选修任何课程开放哦...");
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
