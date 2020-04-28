<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登出</title>
</head>
<body>
    <%
        HttpSession req_session = request.getSession();
        req_session.setAttribute("name" , "");
        response.sendRedirect("./Send_Session.jsp");
    %>
</body>
</html>
