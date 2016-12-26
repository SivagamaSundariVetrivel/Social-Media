<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
  <head>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
    <link href="<c:url value='resources/assets/style.css'/>" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="<c:url value='resources/css/bootstrap.min.css'/>"/>
  
  <link href="<c:url value='resources/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
    
    <!-- Custom Fonts -->
    <link href="<c:url value='resources/vendor/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="<c:url value='resources/css/agency.min.css'/>" rel="stylesheet">
  
  
  <title> Chat </title>
  <style>
body {
    background:black;/* -image: url("<c:url value='resources/image/1.jpg'/>"); */
} 



</style>
  
  
  </head>
  
  
  
  
  <body ng-app="chatApp">
  <%@include file="logo.jsp" %>
  <center> 
  <h1>Group chat</h1>
  <p>People can chat here...</p></center>
    <div ng-controller="ChatCtrl" class="container">
      <form ng-submit="addMessage()" name="messageForm">
      
      <div class="heaa1">
        <input type="text" placeholder="Type your message here..." ng-model="message" />
        </div>
        
        <div class="info">
          <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
          <button class="btn btn-xl" ng-disabled="message.length > max || message.length === 0">Send</button>
        </div>
      </form>
      <hr />
      <p ng-repeat="message in messages | orderBy:'time':true" class="message">
       
       
        <time>{{message.time | date:'HH:mm'}}</time>
       
        <span ng-class="{self: message.self}">{{message.message}}</span>
      </p>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.1/sockjs.min.js"></script>  
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.17.2/lodash.min.js"></script>
    <script src="resources/app/app.js" type="text/javascript"></script>
    <script src="resources/app/controllers.js" type="text/javascript"></script>
    <script src="resources/app/services.js" type="text/javascript"></script>
  </body>
</html>
