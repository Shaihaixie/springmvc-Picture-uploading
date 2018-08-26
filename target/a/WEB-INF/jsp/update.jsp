<%--
  Created by IntelliJ IDEA.
  User: xiexie
  Date: 2018/8/13
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>班级</th>
        <th>操作</th>
    </tr>
    <form action="" method="post">

        <table align="center" >
            <tr>
                <td>学号</td><td><input type="text" name="stunum" value="${stu.stunum}"></td>
            </tr>
            <tr>
                <td>姓名</td><td><input type="text" name="stuname" value="${stu.stuname}"></td>
            </tr>
            <tr>
                <td>班级</td><td>
                <select name="banji">
             <c:forEach items="${smp}" var="ss">
                 <c:choose>
                     <c:when test="${ss.banji.equals(stus.banji)}">
                         <option value="${ss.banji}" selected="selected">${ss.banji}</option>
                     </c:when>
                  <c:otherwise>
                      <option value="${ss.banji}" >${ss.banji}</option>
                  </c:otherwise>
                 </c:choose>
             </c:forEach>

                </select>



            </td>
            </tr>

            <tr>
                <td><input  class="btn btn-default"type="submit" value="修改"></td>
            </tr>
        </table>
    </form>
</table>
</body>
</html>
