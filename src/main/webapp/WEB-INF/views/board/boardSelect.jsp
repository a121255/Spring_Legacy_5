<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="row">
		
		<h1>Title : ${vo.title}</h1>
		<h1>Writer : ${vo.writer}</h1>
		<h1>Contents : ${vo.contents}</h1>
		<h1>Date : ${vo.regdate}</h1>
		<h1>hit : ${vo.hit}</h1>
	</div>
	
	
	<div>
		<a href="./${board}Update?num=${vo.num}" class="btn btn-danger">Update</a>
		<a href="./${board}Delete?num=${vo.num}" class="btn btn-danger">Delete</a>
	</div>
</body>
</html>