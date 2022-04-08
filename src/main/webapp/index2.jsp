<%--
  Created by IntelliJ IDEA.
  User: steven
  Date: 2021/6/4
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <h2>Hello World!</h2>
    <form action="/user/save" method="post" enctype="multipart/form-data">
        姓名:<input type="text" name="username"><br>
        头像:<input type="file" name="headImg"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
