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
           <th>班图</th>
           <th>操作</th>
       </tr>
     <c:forEach items="${stus}" var="stu">
         <tr>
             <td>${stu.stunum}</td>
             <td>${stu.stuname}</td>
             <td>${stu.banji}</td>
             <td><img  style="height: 50px;width: 80px" src="${stu.touxiang}"></td>
             <td>
                 <a href="update/${stu.stunum}">修改</a>
                 <a href="delete/${stu.stunum}">删除</a>
             </td>

         </tr>


     </c:forEach>
 </table>
</body>
</html>
