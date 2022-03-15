<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/18 0018
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

    <script>
        function a1() {
            console.log("data:" + $("#name").val())
            console.log('${pageContext.request.contextPath}/a3')

            $.post("${pageContext.request.contextPath}/a3", {"name": $("#name").val()}, function (data) {
                console.log(data)
                if (data === "ok") {
                    $("#userInfo").css("color", "green");
                } else {
                    $("#userInfo").css("color", "red");
                }
                $("#userInfo").html(data);

            })
        }

        function a2() {
            $.post("${pageContext.request.contextPath}/a3", {"pwd": $("#pwd").val()}, function (data) {
                console.log(data)
                if (data.toString() === "123456") {
                    $("#pwdInfo").css("color", "green");
                } else {
                    $("#pwdInfo").css("color", "red");
                }
                $("#pwdInfo").html(data);
            })
        }
    </script>
</head>
<body>

<p>
    用户名：<input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密码：<input type="text" id="pwd" onblur="a2()">
    <span id="pwdInfo"></span>
</p>
</body>
</html>
=======
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/18 0018
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>

    <script>
        function a1() {
            console.log("data:" + $("#name").val())
            console.log('${pageContext.request.contextPath}/a3')

            $.post("${pageContext.request.contextPath}/a3", {"name": $("#name").val()}, function (data) {
                console.log(data)
                if (data === "ok") {
                    $("#userInfo").css("color", "green");
                } else {
                    $("#userInfo").css("color", "red");
                }
                $("#userInfo").html(data);

            })
        }

        function a2() {
            $.post("${pageContext.request.contextPath}/a3", {"pwd": $("#pwd").val()}, function (data) {
                console.log(data)
                if (data.toString() === "123456") {
                    $("#pwdInfo").css("color", "green");
                } else {
                    $("#pwdInfo").css("color", "red");
                }
                $("#pwdInfo").html(data);
            })
        }
    </script>
</head>
<body>

<p>
    用户名：<input type="text" id="name" onblur="a1()">
    <span id="userInfo"></span>
</p>
<p>
    密码：<input type="text" id="pwd" onblur="a2()">
    <span id="pwdInfo"></span>
</p>
</body>
</html>
>>>>>>> 1da3f48 (first commit)
