<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<c:import url="../template/summer.jsp"></c:import>
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
		<h1>${board} Write</h1>
		<form action="./${board}Write" id="frm" method="post" enctype="multipart/form-data">
		  <div class="form-group">
		    <label for="title">Title:</label>
		    <input type="text" class="form-control" id="title" name="title">
		  </div>
		  <div class="form-group">
		    <label for="writer">Writer:</label>
		    <input type="text" class="form-control" id="writer" value="${member.id}" readonly="readonly" name="writer">
		  </div>
		 <div class="form-group" >
		    <label for="contents">Contents:</label>
		    <textarea rows="20" cols="" class="form-control" id="contents" name="contents"></textarea>
		  </div> 
		  
		  <input type="button" id="add" class="btn btn-info" value="AddFile">
		  
		  
		  
		  <div id="file">
			  <div class="form-group fileg" >
			  	<label for="file">File:</label>
			    <input type="file" class="form-control files" name="files">
			    
			  </div> 
		  </div>
		  
		  
		  <input type="button" id="btn" class="btn btn-default" value="Write">
		</form>
	
	
	
	</div>
 	<script type="text/javascript" src="../resources/js/boardForm.js">
 

	
	</script> 
	

	
</body>
</html>