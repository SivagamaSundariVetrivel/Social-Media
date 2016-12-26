<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
    <meta charset="UTF-8">
    <title>Forum List</title>
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
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script> 
  <!-- <scrip src="/resources/bootstrap-3.3.6-dist/js/angular.min.js"></scrip> -->
<script>
var v=${forumdata};
angular.module('myApp',[]).controller('ForumController',function($scope)
		{       
			//console.log(v);
			$scope.fList=v;
			
		});
</script>
    
    </head>
  <body>
  <%@include  file="logo.jsp" %>
  <br>
  <br>
    <center>
<h1>Forums</h1>
</center>
<div class="container" ng-app="myApp" ng-controller="ForumController">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-4">
<input type="text" class="form-control" placeholder="Search by query...." ng-model="sr.question"/>
</div>
<div class="col-sm-2"></div>
<div class="col-sm-4">
<input type="text" class="form-control" placeholder="Search by basis...." ng-model="sr.basedOn"/>
</div>
</div><br>

<table class="table">
<thead>
<tr>
<td>Forum Title</td>
<td>Asked by</td>
<td>Creation Date</td>
<!-- <td>Replies</td> -->
<td>View</td>
</tr>
</thead>
<tbody>
<tr ng-repeat="x in fList|filter:sr"> 
<td>{{x.question}}</td>
<td>{{x.askedby}}</td>
<td>{{x.creationDate}}</td>
<!-- <td>{{x.replyCount}}</td> -->
<td><a href="forumPage?id={{x.forumId}}">View</a></td>
</tr>
</tbody>
</table>
  
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
