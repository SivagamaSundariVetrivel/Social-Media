<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
    <meta charset="UTF-8">
    <title>SignUp Form</title>
            <!-- Bootstrap Core CSS -->
    <link href="<c:url value='resources/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="<c:url value='resources/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="<c:url value='resources/css/agency.min.css'/>" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
    .error
    {
    font-size:9px;
    color:red;
    }
    </style>
    </head>
  <body>
  <%@include  file="header.jsp" %>
    <section id="contact"> 
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">signup here..</h2>
                    <h3 class="section-subheading text-muted">If you already have an account, <a href="login">click here</a> to LogIn..</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form:form name="signUp" action="./joinUs" method="post" commandName="usr">
                        <div class="row">
                        	<div class="col-md-3">
                                </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <form:input path="email" type="email" name="email" class="form-control" placeholder="Your Email *" id="email" />
                                    <form:errors path="email" class="error" />
                                     <div id="success" class="error">${errmail}</div>  
                                </div>
                                <div class="form-group">
                                    <form:input path="password" type="password" name="password" class="form-control" placeholder="Your Password *" id="password" />
                                    <form:errors path="password" class="error" />
                                    <!-- <p class="help-block text-danger"></p> -->
                                </div>
                                <div class="form-group">
                                    <form:input path="reTypePass" type="password" name="reTypePass" class="form-control" placeholder="Conform Your Password *" id="conformPassword" />
                                    <%-- <form:errors path="reTypePass" class="error"/> --%>
                                    <!-- <p class="help-block text-danger"></p> -->
                                    <div id="success" class="error">${reTypePassError}</div> 
                                </div>
                                <hr>
                                <div class="form-group">
                               <!--  User Name: -->
                                    <form:input path="userName" type="text" name="userName" class="form-control" placeholder="Your User Name *" id="name"/>
                                    <form:errors path="userName" class="error"/>
                                      <div id="success" class="error">${erruser}</div> 
                                </div>
                                <div class="form-group">
                                <form:select path="gender" class="form-control">
                                <option value="">Gender</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                                </form:select>
                                <form:errors path="gender" class="error"/>
                                   <%--  <form:input path="gender" type="radio" class="form-control" value="M"/>Male
                                    <form:input path="gender" type="radio" class="form-control" value="F"/>Female --%>
                                </div>
                                <div class="form-group">                                
                                    <form:input path="dob" class="form-control" placeholder="Your Date of Birth(mm/dd/yyyy)"/>
                                    <form:errors path="dob" class="error"/>
                                     <%-- <div id="success" style="color:red;">${erruser}</div> --%>
                                </div>
                                <div class="form-group">                               
                                    <form:input path="phone" type="text" class="form-control" placeholder="Your Phone Number *"/>
                                    <form:errors path="phone" class="error"/>
                                   <%--  <div id="success" style="color:red;">${erruser}</div>  --%>
                                </div>
                            </div>
                            <div class="col-md-3">
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success" style="color:red;">${err}</div>
                                <button type="submit" class="btn btn-xl">Join Us..</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </section> 
 <%@include file="footer.jsp" %>
    <!-- jQuery -->
    <script src="<c:url value='resources/vendor/jquery/jquery.min.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
   <%--  <script src="<c:url value='resources/js/jqBootstrapValidation.js'/>"></script> --%>
   <%--  <script src="<c:url value='resources/js/contact_me.js'/>"></script> --%>

    <!-- Theme JavaScript -->
    <script src="<c:url value='resources/js/agency.min.js'/>"></script>
  </body>
</html>
