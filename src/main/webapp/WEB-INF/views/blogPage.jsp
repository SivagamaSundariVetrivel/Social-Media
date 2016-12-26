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
	 <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script> 
  <!-- <scrip src="/resources/bootstrap-3.3.6-dist/js/angular.min.js"></scrip> -->
<script>
/* var v=${blogdata}; */
var c=${cmts}
angular.module('myApp',[]).controller('BlogController',function($scope)
		{       
			//console.log(v);
			/* $scope.blog=v; */
			$scope.cList=c;
		});
</script>
	<style>
    .error
    {
    font-size:9px;
    color:red;
    }
	
	body
	{
	margin-top:50px;
	margin-left:100px;
	margin-right:100px;
	}
	.comment{
    background:#eee;
}

hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #FFFFFF;
}
a {
    color: #82b440;
    text-decoration: none;
}
.blog-comment::before,
.blog-comment::after,
.blog-comment-form::before,
.blog-comment-form::after{
    content: "";
	display: table;
	clear: both;
}

.blog-comment{
    padding-left: 15%;
	padding-right: 15%;
}

.blog-comment ul{
	list-style-type: none;
	padding: 0;
}

.blog-comment img{
	opacity: 1;
	filter: Alpha(opacity=100);
	-webkit-border-radius: 4px;
	   -moz-border-radius: 4px;
	  	 -o-border-radius: 4px;
			border-radius: 4px;
}

.blog-comment img.avatar {
	position: relative;
	float: left;
	margin-left: 0;
	margin-top: 0;
	width: 65px;
	height: 65px;
}

.blog-comment .post-comments{
	border: 1px solid #eee;
    margin-bottom: 20px;
    margin-left: 85px;
	margin-right: 0px;
    padding: 10px 20px;
    position: relative;
    -webkit-border-radius: 4px;
       -moz-border-radius: 4px;
       	 -o-border-radius: 4px;
    		border-radius: 4px;
	background: #fff;
	color: #6b6e80;
	position: relative;
}

.blog-comment .meta {
	font-size: 13px;
	color: #aaaaaa;
	padding-bottom: 8px;
	margin-bottom: 10px !important;
	border-bottom: 1px solid #eee;
}

.blog-comment ul.comments ul{
	list-style-type: none;
	padding: 0;
	margin-left: 85px;
}

.blog-comment-form{
	padding-left: 15%;
	padding-right: 15%;
	padding-top: 40px;
}

.blog-comment h3,
.blog-comment-form h3{
	margin-bottom: 40px;
	font-size: 26px;
	line-height: 30px;
	font-weight: 800;
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
<!-- <div class="container" ng-app="myApp" ng-controller="BlogController">
 -->
<h1 class="page-header">${blog.title}</h1>
<p><small>-written by</small> <i>${blog.author}</i> on ${blog.blogcreationDate}</p><br><br>
<p>${blog.content}</p>
<br>
<%-- To add <a href="addBlogComment?id=${blog.blogId}">Comment</a>, Click on comment...<br>
To <a href="editBlog?id=${blog.blogId}">edit</a> the blog, Click on edit...<br> 
To <a href="deleteBlog?id=${blog.blogId}">delete</a> the blog, Click on delete...--%>
<a href="addBlogLike?id=${blog.blogId}">Like</a>
<p>${likeItCount}Likes</p>
<hr>
<br>
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10">
<form:form action="./addComment?id=${blog.blogId}" method="post" commandName="cmt">
<form:hidden path="blogId" value="${blog.blogId}"/>
<form:input path="userName" class="form-control" palcehoder="Your username.."/>
<form:errors path="userName" class="error" /><br>
<form:textarea path="cmtContent" class="form-control" palcehoder="Please leave your comment here.."></form:textarea>
<form:errors path="cmtContent" class="error" /><br>
<div class="col-sm-9">
<button type="submit" value="Comment">Comment</button>
</div>

</form:form><br><br> 
<!-- <div ng-repeat="blogcmt in cList"> -->
<!-- <h1>Comments</h1>
 -->
<div class="container bootstrap snippet">
    <div class="row">
		<div class="col-md-12">
		    <div class="blog-comment">
				<h1 class="text-success">${count} Comments</h1>
                <hr/>
				<ul class="comments">
				<c:forEach var="blogcmt" items="${cmts}">
				<li class="clearfix">
				  <!-- <img src="" class="avatar" alt=""> -->
				  <div class="post-comments">
				     <p class="meta">${blogcmt.cmtDate} <a href="#">${blogcmt.userName}</a> says : <!-- <i class="pull-right"><a href="#"><small>Reply</small></a> --></i></p>
				      <p>
				           ${blogcmt.cmtContent}
				      </p>
				  </div>
				</li>
</c:forEach> 
				</ul>
			</div>
		</div>
	</div>
</div>

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
