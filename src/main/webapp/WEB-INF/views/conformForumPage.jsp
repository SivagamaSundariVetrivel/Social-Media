<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
    <meta charset="UTF-8">
    <title>Blog Page</title>
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
    </head>
  <body style="margin-top:40px">
  <%@include  file="logo.jsp" %>
  <br>
  <br>
  <br>
  <br>
  <a><h6>Preview</h6></a>
<h1 class="page-header">${forum.question}?</h1>

<p><small>-enquired by</small> <i>${forum.askedby}</i> on ${forum.creationDate}</p><br><br>
<p>This question is based on ${forum.basedOn}</p>

<hr>
<br>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10">
<form action="#">
<%-- <hidden path="forumId" value="${forum.forumId}"/> --%>
<input path="username" class="form-control" palcehoder="Your username.."/>
<textarea path="replyContent" class="form-control" palcehoder="Please leave your answer here.."></textarea><br>
<div class="col-sm-9">
<button type="submit" value="Answer">Answer</button>
</div>
</form><br><br> 

</div>
<hr>
<center>
<a class="btn btn-xl" href="postIt?id=${forum.forumId}" method="post">Conform forum</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a class="btn btn-xl" href="editForum?id=${forum.forumId}" method="post">edit forum</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a class="btn btn-xl" href="deleteForum?id=${forum.forumId}">delete forum</a>
</center>
</div>
</div> 
<br>

      <%@include file="footer.jsp" %>
      
    <!-- jQuery -->
    <script src="<c:url value='resources/vendor/jquery/jquery.min.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

<%--     <!-- Contact Form JavaScript -->
    <script src="<c:url value='resources/js/jqBootstrapValidation.js'/>"></script>
    <script src="<c:url value='resources/js/contact_me.js'/>"></script>
 --%>
    <!-- Theme JavaScript -->
    <script src="<c:url value='resources/js/agency.min.js'/>"></script>
  </body>
</html>
