<%--
  Created by IntelliJ IDEA.
  User: ravikiran_gorthi
  Date: 5/4/17
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SpringJdbcGradleDemo</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/js/jquery-3.2.1.min.js" />"></script>
    <link href="<c:url value="/css/jquery-ui.1.12.1.css" />" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/js/jquery-ui.1.12.1.js" />"></script>
    <script>
        $(document).ready(function (){
            $('a').click(function(){
                var id = this.id;
                $.ajax({
                    type: "GET",
                    url: id,
                    success: function(response) {
                        $('#main').html(response);
                    }
                });
            });
        });
    </script>
</head>
<body>
    <div id="header" align="center">
        <a href="./index"><img src="<c:url value="/images/home.png" />" width="35px" ></a>
        <h1>Spring, Jdbc, Gradle - Practice</h1>
    </div>
    <div id="menu" align="center">
        <h2>Modules</h2>
        <a class="button shadow animate blue" id="springCheck">Spring Setup Test</a>
        <a class="button shadow animate blue" id="loginPage">Login Test</a>
        <a class="button shadow animate blue" id="jdbcTest">JDBC Test</a>
        <a class="button shadow animate blue" id="jdbcLoginPage">JDBC Login Test</a>
        <a class="button shadow animate blue" id="jdbcCrudPage">JDBC Crud Test</a>
    </div>
    <div id="main" align="center">
        <c:choose>
            <c:when test="${message != null}">
                <%@include file="login.jsp" %>
            </c:when>
            <c:when test="${jdbcMessage != null}">
                <%@include file="jdbcLogin.jsp" %>
            </c:when>
            <c:when test="${jdbcCustomer != null}">
                <c:import url="jdbcCrud.jsp" />
            </c:when>
            <c:when test="${loginBean != null}">
                <%@include file="welcome.jsp" %>
            </c:when>
            <c:otherwise>
                <br><br>

                <h2>Welcome to Ravi's Practice Place</h2>
            </c:otherwise>
        </c:choose>
    </div>

</body>
</html>
