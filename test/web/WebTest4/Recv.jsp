<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接收信息页面</title>
</head>
<body style="text-align: center"><%request.setCharacterEncoding("utf-8"); %>
    <h3>学生信息录入</h3>
    学号:<%=request.getParameter("id")%><br>
    姓名:<%=request.getParameter("name")%><br>
    生日:<%=request.getParameter("date")%><br>
    性别:<%=request.getParameter("sex")%><br>
        <%String[] hobby = request.getParameterValues("hobby");
            String s = "";
            for(int i = 0 ; i < hobby.length ; i++){
            s = s + hobby[i] + " ";
        }%>
    体育爱好:<%=s%>
</body>
</html>
