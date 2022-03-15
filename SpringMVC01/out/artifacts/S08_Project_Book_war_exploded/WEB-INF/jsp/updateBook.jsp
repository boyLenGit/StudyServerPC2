<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/17 0017
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateBook</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%-- 这里非常重要，隐藏bookID变量，但是也必须给Controller传递bookID参数，否则数据库修改失败！ --%>
        <input type="hidden" name="bookID" value="${book.bookID}">
        <div class="form-group">
            <label for="bookName">书籍名称：</label>
            <input id="bookName" type="text"  class="form-control" value="${book.bookName}" name="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookCounts">书籍数量：</label>
            <input id="bookCounts" type="text" class="form-control" value="${book.bookCounts}" name="bookCounts" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍详情：</label>
            <input id="detail" type="text" class="form-control" value="${book.detail}" name="detail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control"  value="修改">
        </div>

    </form>
</div>
</body>
</html>
=======
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/7/17 0017
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateBook</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%-- 这里非常重要，隐藏bookID变量，但是也必须给Controller传递bookID参数，否则数据库修改失败！ --%>
        <input type="hidden" name="bookID" value="${book.bookID}">
        <div class="form-group">
            <label for="bookName">书籍名称：</label>
            <input id="bookName" type="text"  class="form-control" value="${book.bookName}" name="bookName" required>
        </div>
        <div class="form-group">
            <label for="bookCounts">书籍数量：</label>
            <input id="bookCounts" type="text" class="form-control" value="${book.bookCounts}" name="bookCounts" required>
        </div>
        <div class="form-group">
            <label for="detail">书籍详情：</label>
            <input id="detail" type="text" class="form-control" value="${book.detail}" name="detail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control"  value="修改">
        </div>

    </form>
</div>
</body>
</html>
>>>>>>> 1da3f48 (first commit)
