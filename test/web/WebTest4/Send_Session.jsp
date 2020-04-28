<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>利用Session发送</title>
</head>
<body>
    <h2>用户登录</h2>
    <%=request.getAttribute("errMsg")%>
    <form action="./Recv_Session.jsp" method="post">
        用户名：<input type="text" name="name"><br>
        密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"><br><br>
        <button id="reset">重填</button>
        <input type="submit" value="登录">
    </form>
</body>
</html>
