<%--
  Created by IntelliJ IDEA.
  User: boyLenPC
  Date: 2021/5/10
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>首页</title>
  <style type="text/css">
    a {
      text-decoration: none;
      color: black;
      font-size: 18px;
    }
    h3 {
      width: 180px;
      height: 38px;
      margin: 10px auto;
      text-align: center;
      line-height: 38px;
      background: deepskyblue;
      border-radius: 4px;
    }
  </style>
</head>
<body>
<h3><a href="${pageContext.request.contextPath}/book/queryAllBooks">全部书籍</a></h3>
<h3><a href="${pageContext.request.contextPath}/queryBooksById_form.jsp">查询书籍</a></h3>
<h3><a href="${pageContext.request.contextPath}/book/addBook_form">增加书籍</a></h3>
</body>
</html>
