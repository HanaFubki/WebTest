<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发送信息页面</title>
</head>
<body style="text-align: center">
    <form method="post" action="./Recv.jsp" id="submitForm">
        学号:<input type="text" name="id"><br>
        姓名:<input type="text" name="name"><br>
        生日:<input id="date" type="date" name="date"><br>
        性别:<input name="sex" checked="checked" type="radio" value="男">男
        <input name="sex" type="radio" value="女">女<br>
        体育爱好:
        <input name="hobby" type="checkbox" value="篮球">篮球
        <input name="hobby" type="checkbox" value="散步">散步
        <input name="hobby" type="checkbox" value="游泳">游泳<br>
        <input type="submit" id="submit">
        <button id="reset">重置</button>
    </form>
</body>
</html>
