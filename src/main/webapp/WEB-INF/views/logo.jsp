<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav id="mainNav" class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="page1">Blabby</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                     <form action="logout" id="logout" method="post">
				    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
				    </form>
				    <c:choose>
				   <%--  <c:when test="${pageContext.request.userPrincipal.name!=null}">
				    <li><a href="#">${pageContext.request.userPrincipal.name}</a></li>
				    <li><a href="javascript:document.getElementById('logout').submit()"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
				    </c:when> --%>
				    <c:when test="${pageContext.request.userPrincipal.name==null}">
				     <li><a class="page-scroll" href="signUp"><span class="glyphicon glyphicon-user"></span> SignUp</a></li>
		   		 	<li><a class="page-scroll" href="logIn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				    </c:when>
				    </c:choose>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</body>
</html>