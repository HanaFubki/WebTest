<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter过滤后的登录保护页</title>
</head>
<body>
    <h2>登录保护页面</h2>
    <h4>欢迎${ sessionScope.user_name}访问本系统，点击【<a href="./newLogoutServlet">注销</a>】</h4>
    <br>本页是受信息保护的页面，仅在您输入了正确的用户名和密码后才可以访问到本页信息。
    <br>如果你在没有登录或者注销后看到了本页信息，说明在下的程序出现了错误漏洞。
</body>
</html>
