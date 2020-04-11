package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/method2_2Servlet")
public class Method2_2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String s = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>表单提交信息</title>\n" +
                "</head>\n" +
                "<body style=\"text-align: center\">\n" +
                "    <div id=\"InfoPart\">\n" +"    <h3>学生信息录入</h3>" +
                "    学号:" + request.getAttribute("id") + "<br>" +
                "    姓名:" + request.getAttribute("name") + "<br>" +
                "    生日:" + request.getAttribute("date") + "<br>" +
                "    性别:" + request.getAttribute("sex") + "<br>" +
                "    体育爱好:" + request.getAttribute("hobby") + "<br>"+
                "    </div>\n" +
                "</body>\n" +
                "</html>";
        PrintWriter pw = response.getWriter();
        pw.write(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
