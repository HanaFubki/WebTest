package servlet.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.BackMsg;
import domain.student;
import org.apache.commons.beanutils.BeanUtils;
import service.service;
import service.serviceImpl.serviceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findStudentServlet")
public class FindStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int startCount = Integer.parseInt((String)request.getParameter("startCount"));
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
        int totalCount = startCount;
        int allCount = startCount;
        BackMsg msg = new BackMsg();
        StringBuffer sb = new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        service service = new serviceImpl();
        allCount = service.FindStudentCount(searchInfo);
        if(allCount % 5 == 0){
            totalCount = allCount / 5;
        }else{
            totalCount = (allCount / 5) + 1;
        }
        List<student> students = null;
        sb.append("<table>\n" +
                "            <thead>\n" +
                "                <th>学号</th>\n" +
                "                <th>姓名</th>\n" +
                "                <th>生日</th>\n" +
                "                <th>操作</th>\n" +
                "            </thead>\n");
        students = service.FindStudent(startCount * 5 , searchInfo);
        for(student student : students){
            sb.append("            <tr>\n" +
                    "                <td>" + student.getSid() + "</td>\n" +
                    "                <td>" + student.getSname() + "</td>\n" +
                    "                <td>" + student.getSbirthday() + "</td>\n"+
                    "                <td><a href=\"javascript:void(0);\" onclick=\"updateFunc('" + student.getSid() + "')\">修改</a> &nbsp; " +
                    "                    <a href=\"javascript:void(0);\" onclick=\"deleteFunc('" + student.getSid() + "')\">删除</a></td>\n" +
                    "            </tr>\n");
        }
        sb.append("</table>        <div class=\"page\"> 共" + allCount + "条数据" + " , 共" + totalCount + "页 , 当前为第" + (startCount + 1) + "页<br>" + "\n");
        for(int i = 0 ; i < totalCount ; i++){
            sb.append("            <a href=\"javascript:void(0);\" onclick=\"FindFunc('" + sid + "','" + sname + "','" + sbirthday + "'," + ssex + "," + i + ")\">" + (i + 1) + "</a>\n");
        }
        sb.append("        </div>");
        msg.setMsg(sb.toString());
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream() , msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
