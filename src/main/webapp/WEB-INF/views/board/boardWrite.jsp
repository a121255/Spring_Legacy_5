<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<style type="text/css">
	.a {
		width:500px;
		margin:0 auto;
	}
</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="a">
		<form action="./${board}Write" method="POST" >
			<p>title : <input type="text" name="title" value=""></p>
			<p>title : <input type="text" name="writer" value=""></p>
			<textarea rows="10" cols="70" name="contents" value=""></textarea>
			<input type="submit" value="WRITE" class="btn btn-danger">
		</form>
	
	
	
	</div>
</body>
</html>