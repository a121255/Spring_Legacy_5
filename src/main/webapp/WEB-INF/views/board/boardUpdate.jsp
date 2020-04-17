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
		<form action="./${board}Update" method="POST" >
			<input type="hidden" name="num" value="${vo.num}">
			<p>Title : <input type="text" name="title" value="${vo.title}"></p>
			<p>Writer : <input type="text" name="writer" value="${vo.writer}" disabled="disabled"></p> <!-- read only와 구분해서 사용 -->
			<p>Num : ${vo.num}</p>
			<textarea rows="10" cols="70" name="contents">${vo.contents}</textarea>
			<input type="submit" value="WRITE" class="btn btn-danger">
		</form>
	<!-- 왜 업데이트 햇는데 인서트가 될까?? -->
	
	
	</div>
</body>
</html>