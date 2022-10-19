<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  String userLogin = (String)request.getAttribute("userLogin");
    String userName = (String)request.getAttribute("userName");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Reg</title>

</head>
<body>
<form method="post" action="">
<label>Login: </label>
<input type="text" name="userLogin"/>
<br/>
<br/>
<label>Password: </label>
<input type="password" name="userPassword"/>
<br/>
<br/>
<label>Compare passwords: </label>
<input type="password" name="userComparePassword"/>
<br/>
<br/>
<label>Email: </label>
<input type="email" name="email"/>
<br/>
<br/>
<label>Name: </label>
<input type="text" name="userName"/>
<br/>
<br/>
<label>Surname: </label>
<input type="text" name="userSurname"/>
<br/>
<br/>
<label>Age: </label>
<input type="number" name="userAge"/>
<br/>
<br/>
<input type="submit" value="Go on"/>
</form>
<p>
    <% if( userLogin != null && userName != null) { %>
    Привет, <%=userName%> ! Вы зарегистрированы под логином <%=userLogin%>.
    <button><a href=http://localhost:8080/WebBasics_war_exploded/">Home</a></button>
    <% }
    else { %>
    Поле Login или поле Name осталось пустым при регистрации!!
    <button><a href=http://localhost:8080/WebBasics_war_exploded/">Home</a></button>
    <% } %>
</p>
</body>

<jsp:include page="footer.jsp"></jsp:include>
</html>
