<%--
  Created by IntelliJ IDEA.
  User: xiexie
  Date: 2018/8/13
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8" />
</head>
<body>
<sf:form  method="post" action="" enctype="multipart/form-data" modelAttribute="student">
<%--<input type="hidden"  navalue="add"/>--%>
    <table style="font-size: 20px"   align="center"  border="1" cellpadding="0" cellspacing="0">
        <tr>
            <td>学号</td><td><sf:input  class="form-control" type="text" path="stunum"/></td>
        </tr>
        <tr>
            <td>姓名</td><td><sf:input class="form-control" type="text" path="stuname"/></td><sf:errors path="stuname" ></sf:errors>
        </tr>
        <tr>
            <td>班级</td><td>
             <sf:select path="banji"  class="form-control">
                 <c:forEach items="${stus}" var="stu">
                     <option value="${stu.banji}">${stu.banji}</option>
                 </c:forEach>
             </sf:select>
            </td>
        </tr>
        <tr>
            <td>上传头像</td><td>
             <input type="file" name="upload">
        </td>
        </tr>
        <%--<tr>--%>
            <%--<td colspan="2"><input class="btn btn-default"type="submit" value="添加学生" style="width: 290px;"></td>--%>
        <%--</tr>--%>
        <tr>
           <td> <sf:button  class="btn btn-default">提交</sf:button></td>
        </tr>
    </table>
</sf:form>
</body>
</html>
