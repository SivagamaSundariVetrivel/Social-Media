<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
    <meta charset="UTF-8">
    <title>Blog Form</title>
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
  <%@include  file="logo.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Create a blog..</h2>
                    <h3 class="section-subheading text-muted">You can create your own blog over here..</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form:form action="./conformBlog" commandName="blo" method="post">
                        <div class="row">
                        	<div class="col-md-2">
                            </div>
                            
               	<%-- <div class="col-md-8">
                                <div class="form-group">
                                	<form:input path="blogId" class="form-control" placeholder="Blog ID"/>
                                </div> <br>
                 --%>            <div class="col-md-8">
                                <div class="form-group">
                                	<form:input path="title" class="form-control" placeholder="Blog title"/>
                                <form:errors path="title" class="error" />
                                </div> <br>
                                <div class="form-group">
                                    <form:input path="author" class="form-control" placeholder="Blog author"/>
                                <form:errors path="author" class="error" />
                                </div><br>
                                <div class="form-group">
                                    <form:textarea path="content" class="form-control" placeholder="Blog content"/>
                                <form:errors path="content" class="error" />
                                </div><br>
                                <div class="form-group">
                                    <form:input path="tags" class="form-control" placeholder="tags"/>
                                </div>
                                <div class="form-group">
                                    <form:input path="blogcreationDate" value="${dt}" readonly="true"   class="form-control" placeholder="date of creation"/>
                                </div>
                            </div>
                            <div class="col-md-2">
                            </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                <button type="submit" class="btn btn-xl">Confirm Page</button>
							</div>
          				                            
                    </form:form>
                </div>
            </div>
 		</div>
      <%@include file="footer.jsp" %>
      
    <!-- jQuery -->
    <script src="<c:url value='resources/vendor/jquery/jquery.min.js'/>"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value='resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="<c:url value='resources/js/jqBootstrapValidation.js'/>"></script>
    <script src="<c:url value='resources/js/contact_me.js'/>"></script>

    <!-- Theme JavaScript -->
    <script src="<c:url value='resources/js/agency.min.js'/>"></script>
  </body>
</html>
