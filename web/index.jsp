<%@ page import="java.util.List" %>
<%@ page import="data.Model" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
  <%List listName = model.getColumnName();%>
  index.jsp
  <table border="1">
    <tr><td>
      <%int i = 0;%>
      <%for (Object o:listName) {%>
      <%=i++%>
    </td><td>
      <%=o.toString()%>
      <%}%>
    </td></tr>
    <%for (List list:listAll) {%>
    <tr><td>
      <%for (Object o:list) {%>
    </td><td>
      <%=o.toString()%>
      <%}%>
    </td></tr>
    <%}%>
  </table>
</body>
</html>
