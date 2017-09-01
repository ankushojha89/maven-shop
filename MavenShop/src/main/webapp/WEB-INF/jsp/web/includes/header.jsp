<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

  
    
    
    <c:choose>
         
         
         <c:when test = "${!empty sKey }">
      
          
              <title>Search results for : <c:out value="${sKey }" /></title>
       
         </c:when>
         
         <c:when test = "${!empty catDetails }">                
          
           <title>Category : <c:out value="${catDetails.cat_name }" /> | <c:out value="${catDetails.cat_desc }" /></title>
         </c:when>
         <c:when test = "${!empty post }">                
          
           <title>Post : <c:out value="${post.post_title }" /> | <c:out value="${post.post_desc }" /></title>
         </c:when>
         
         <c:otherwise>
              <title>Welcome to Maven Shop | Spring... Practical Interesting</title>
         
         </c:otherwise>
      </c:choose>
    
    
    
    
    
    
    
    

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/files/web/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/files/web/css/shop-homepage.css" rel="stylesheet">

  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}"> Maven Shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="${pageContext.request.contextPath}">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>