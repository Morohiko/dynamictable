<%@ page import="data.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="data.Controller" %>
<%@ page import="data.Model" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 16.11.2017
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<jsp:useBean id="service" class="data.Service" scope="session"/>--%>
<jsp:useBean id="controller" class="data.Controller" scope="session"/>
<html>
  <head>
    <title>Title</title>
</head>
<body>
<form action="index.jsp" name="get">
  <input name="reloadList" type="submit" value="reloadList">
</form>
  <form action="index.jsp" name="add">
    <input name="name" type="text">
    <input name="age" type="text">
    <input name="btn" type="submit" value="add">
  </form>
  <form action="index.jsp" name="remove">
    <input name="name" type="text">
    <input name="btn" type="submit" value="remove">
  </form>
  <%controller.checkController(request, response);%>
  <%Model model = controller.getModel();%>
  <%List <List<String>>listAll = model.getAllTableValue();%>
<%List listName = Model.columnName;%>
  index.jsp
  <table border="1">
    <tr><td>
    <%for (Object o:listName) {%>
    </td><td>
        <%=o.toString()%>
     <%}%>
    </tr></td>
    <%for (List list:listAll) {%>
        <tr><td>
    <%for (Object o:list) {%>
    </td><td>
    <%=o.toString()%>
    <%}%>
    </tr></td>
      <%}%>
  </table>
</body>
</html>
