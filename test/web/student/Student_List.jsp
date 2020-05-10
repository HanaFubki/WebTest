<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
    <script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
    <script>
        $(function () {
            $.get("../findAllStudentServlet" , {startCount : 0} , function (backData) {
                $("#stu_list").html(backData.msg);
            });
            $("#search_stu").click(function () {
                $.post("../findStudentServlet?startCount=0" , $("#submitForm").serialize() , function (backData) {
                    $("#stu_list").html(backData.msg);
                });
            });
            $("#search_all_stu").click(function () {
                $.post("../findAllStudentServlet" , {startCount : 0} , function (backData) {
                    $("#stu_list").html(backData.msg);
                });
            });
            $("#insert_stu").click(function () {
                $.post("../insertStudentServlet" , $("#submitForm").serialize() , function (backData) {
                    if(backData.flag){
                        alert("添加成功");
                    }else{
                        alert("添加失败，已有相同的学号存在");
                    }
                    FindAllFunc(0);
                });
            });
            deleteFunc = function (id) {
                if(!confirm("您确定要删除uid为" + id + "的用户吗？")){
                    window.event.returnValue = false;
                }else{
                    $.post("../deleteStudentServlet" , {sid : id} , function (backData) {
                        if(backData.flag){
                            alert("删除成功");
                        }else{
                            alert("删除失败，并不存在这个学号的学生");
                        }
                    });
                    FindAllFunc(0);
                }
            }
            updateFunc = function(sid){
                location.href = "./Update_Student.jsp?sid=" + sid;
            }
            FindFunc = function (sid , sname , sbirthday , ssex , startCount) {
                $.post("../findStudentServlet" , {sid : sid , sname : sname , sbirthday : sbirthday , ssex : ssex , startCount : startCount} , function (backData) {
                    $("#stu_list").html(backData.msg);
                });
            }
            FindAllFunc = function (startCount) {
                $.get("../findAllStudentServlet" , {startCount : startCount} , function (backData) {
                    $("#stu_list").html(backData.msg);
                });
            }
        });
    </script>
</head>
<body>
    <h1>学生列表</h1>
    <h4>操作区 :</h4>
    <form method="post" id="submitForm">
        学号:<input type="text" name="sid"><br>
        姓名:<input type="text" name="sname"><br>
        生日:<input id="date" type="date" name="sbirthday"><br>
        性别:<input name="ssex" checked="checked" type="radio" value="1">男
        <input name="ssex" type="radio" value="0">女<br>
        <input id="search_stu" type="button" value="查找学生">
        <input id="insert_stu" type="button" value="添加学生">
        <input id="search_all_stu" type="button" value="查找全部学生">
    </form>
    <div id="stu_list">
        <table>
            <thead>
                <th>学号</th>
                <th>姓名</th>
                <th>生日</th>
                <th>操作</th>
            </thead>
            <tr>
                <td>s00000001</td>
                <td>赵雷</td>
                <td>1999-01-01</td>
                <td><a href="#">修改</a><a href="#">删除</a></td>
            </tr>
        </table>
        <div class="page">
            <a href="javascript:void(0);" onclick="">1</a>
        </div>
    </div>
</body>
</html>
