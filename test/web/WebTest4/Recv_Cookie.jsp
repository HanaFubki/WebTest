<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用Cookie方式接收</title>
</head>
<body>
    <%
        String name = "";
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("name")){
                name = cookie.getValue();
            }
        }if(name.equals("")){
            if(request.getParameter("name") != null)
                name = request.getParameter("name");
            String password = "";
            if(request.getParameter("password") != null)
                password = request.getParameter("password");
            if(name.equals("default") && password.equals("123456")){
                Cookie cookie = new Cookie("name" , name);
                response.addCookie(cookie);
            }else{
                request.setAttribute("errMsg" , "用户名或密码错误，请重新登录");
                request.getRequestDispatcher("./Send_Cookie.jsp").forward(request , response);
            }
        }
    %>
    <h2>登录保护页面</h2>
    <h4>欢迎<%=name%>访问本系统，点击【<a href="./LogOut_Cookie.jsp">注销</a>】</h4>
    <br>本页是受信息保护的页面，仅在您输入了正确的用户名和密码后才可以访问到本页信息。
    <br>如果你在没有登录或者注销后看到了本页信息，说明在下的程序出现了错误漏洞。
</body>
</html>
