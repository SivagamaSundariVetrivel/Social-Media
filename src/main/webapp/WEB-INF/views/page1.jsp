<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>Chat</title>

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

<body id="page-top" class="index">

 <!-- Navigation bar -->
   <%@include  file="header.jsp" %>
    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">Welcome To Blabby.com!</div>
                <div class="intro-heading">It's Nice To Meet You</div>
                <!-- <a href="#services" class="page-scroll btn btn-xl">Tell Me More</a> -->
            </div>
        </div>
    </header>

    <!-- Services Section -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">In STACK</h2>
                    <h3 class="section-subheading text-muted">You can chat all you want. Be a blabber at our website</h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa  fa-comment fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">BLOG</h4>
                    <p class="text-muted"><a href="addBlog">Create your own Blogs..</a><br>
                    <a href="listBlog">See all the blogs..</a><br> Comment in there whatsoever in your mind..</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-users fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">FORUM</h4>
                    <p class="text-muted"><a href="addForum">Ask your query..</a><br>
                    <a href="listForum">See if your doubts are cleared..</a><br>Let join and discuss with each other.. </p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-comments-o fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">CHAT</h4>
                    
                    <p class="text-muted"><a href="index">Let's all chat here...</a><br>Let's be in touch with each other.. </p>
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
    <%-- <script src="<c:url value='resources/js/jqBootstrapValidation.js'/>"></script>
    <script src="<c:url value='resources/js/contact_me.js'/>"></script> --%>

    <!-- Theme JavaScript -->
    <script src="<c:url value='resources/js/agency.min.js'/>"></script>

</body>

</html>
