<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta name="description" content="">
<meta name="author" content="">
<title>Maven Shop Admin - Start Spring here</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/files/admin/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link
	href="${pageContext.request.contextPath}/files/admin/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Plugin CSS -->
<link
	href="${pageContext.request.contextPath}/files/admin/vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath}/files/admin/css/sb-admin.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/files/admin/css/style.css"
	rel="stylesheet">
	<script
	src="${pageContext.request.contextPath}/files/admin/vendor/jquery/jquery.min.js"></script>
</head>


<body class="fixed-nav" id="page-top">

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/admin/">Maven Shop</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav">
				<li class="nav-item" data-toggle="tooltip"
					data-placement="right" title="Dashboard"><a class="nav-link"
					href="${pageContext.request.contextPath}/admin/"> <i class="fa fa-fw fa-dashboard"></i> <span
						class="nav-link-text"> Dashboard</span>
				</a></li>

								
					<li class="nav-item " data-toggle="tooltip" data-placement="right"
					title="Categories"><a class="nav-link" href="${pageContext.request.contextPath}/admin/categories"> <i
						class="fa fa-fw fa-folder-open"></i> <span class="nav-link-text">
							Categories</span>
					</a></li>
					
			
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Posts"><a
					class="nav-link nav-link-collapse collapsed" data-toggle="collapse"
					href="#postCollapseComponents"> <i class="fa fa-fw 	fa-thumb-tack"></i>
						<span class="nav-link-text"> Posts</span>
				</a>
					<ul class="sidenav-second-level collapse" id="postCollapseComponents">
						<li><a href="${pageContext.request.contextPath}/admin/posts"><i class="fa fa-fw fa-list"></i> All Posts</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/addpost"><i class="fa fa-fw fa-plus"></i> Add New Post</a></li>
					</ul></li>		
					
		<li class="nav-item " data-toggle="tooltip" data-placement="right"
					title="Assignment #1"><a class="nav-link" href="${pageContext.request.contextPath}/admin/world"> <i
						class="fa fa-fw fa-link"></i> <span class="nav-link-text">
							Assignment #1</span>
					</a></li>

			
			</ul>
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">


				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>
						Logout
				</a></li>
			</ul>
		</div>
	</nav>