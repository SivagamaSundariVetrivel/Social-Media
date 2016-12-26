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
	 <!-- <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script> 
  <scrip src="/resources/bootstrap-3.3.6-dist/js/angular.min.js"></scrip>
<script>
/* var v=${blogdata}; */
var c=${cmts}
angular.module('myApp',[]).controller('BlogController',function($scope)
		{       
			//console.log(v);
			/* $scope.blog=v; */
			$scope.cList=c;
		});
</script> -->
	<style>
	body
	{
	margin-top:50px;
	margin-left:100px;
	margin-right:100px;
	}
	</style>
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
<!-- <div class="container" ng-app="myApp" ng-controller="BlogController">
 -->
 <a><h6>Preview</h6></a>
<h1 class="page-header">${blog.title}</h1>
<p><small>-written by</small> <i>${blog.author}</i> on ${blog.blogcreationDate}</p><br><br>
<p>${blog.content}</p>
<br>
<hr>
<center>
<a class="btn btn-xl" href="blogIt?id=${blog.blogId}" method="post">Conform blog</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a class="btn btn-xl" href="editBlog?id=${blog.blogId}" method="post">edit blog</a> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<a class="btn btn-xl" href="deleteBlog?id=${blog.blogId}">delete blog</a>
</center>
<%-- <a href="addLike?id=${blog.blogId}">Like</a>|<a href="addDislike?id=${blog.blogId}">DisLike</a>
<p>${blog.likeCount}Likes|${blog.dislikeCount}DisLikes</p> 
 --%><hr>
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
