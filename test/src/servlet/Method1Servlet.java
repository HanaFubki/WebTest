package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/method1Servlet")
public class Method1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String sex = request.getParameter("sex");
        String[] hobby = request.getParameterValues("hobby");
        String s = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>表单提交信息</title>\n" +
                "</head>\n" +
                "<body style=\"text-align: center\">\n" +
                "    <div id=\"InfoPart\">\n" +"    <h3>学生信息录入</h3>" +
                "    学号:" + id + "<br>" +
                "    姓名:" + name + "<br>" +
                "    生日:" + date + "<br>" +
                "    性别:" + sex + "<br>" +
                "    体育爱好:";
        for(int i = 0 ; i < hobby.length ; i++){
            s = s + hobby[i] + " ";
        }
        s = s + "<br>"+
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.write(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
