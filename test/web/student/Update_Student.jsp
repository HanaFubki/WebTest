<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新学生信息</title>
    <script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
    <script>
        $(function () {
            function GetQueryString(aid)
            {
                var reg = new RegExp("(^|&)"+ aid +"=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if(r!=null)return unescape(r[2]); return null;
            }
            $.get("../getUpdateStudentInfoServlet" , {sid : GetQueryString("sid")} , function (backData) {
                document.title = backData.data.sname + "的个人信息修改页";
                $("#update_sid").val(backData.data.sid);
                $("#update_sname").val(backData.data.sname);
                var date = backData.data.sbirthday;
                $("#update_sbirthday").val(date);
                if(backData.data.ssex == 1){
                    $("#male").attr("selected" , "selected");
                }else{
                    $("#female").attr("selected" , "selected");
                }
            });
            $("#update_stu").click(function () {
                $.post("../updateStudentServlet" , $("#update_form").serialize() , function (backData) {
                    alert("修改成功");
                    location.href = "./Student_List.jsp";
                });
            });
        });
    </script>
</head>
<body>
    <h1>学生信息修改</h1>
    <form method="post" id="update_form">
        学号:<input id="update_sid" style="cursor: not-allowed;
               color: #a29e9e!important;
               background: none!important;
            " type="text" name="sid"><br>
        姓名:<input id="update_sname" type="text" name="sname"><br>
        生日:<input id="update_sbirthday" id="date" type="date" name="sbirthday"><br>
        性别:<select id="update_ssex" name="ssex">
            <option id="male" selected="selected" value="1">男</option>
            <option id="female" value="0">女</option>
        </select><br>
        <input id="update_stu" type="button" value="更新学生信息">
    </form>
</body>
</html>
