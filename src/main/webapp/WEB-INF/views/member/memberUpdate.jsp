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
		<c:import url="../template/header.jsp"></c:import>  <!-- header.jsp -->
		
			<div class="container">
		  <h1>Member Update Form</h1>
		  <form class="form-horizontal" action="./memberUpdate" method="post">
		 	 <div class="form-group">
		     	<label class="control-label col-sm-2" for="email">ID:</label>
		     	<div class="col-sm-10">
		     	  <input type="text" class="form-control" id="email" placeholder="name" name="id" value="${member.id}" readonly="readonly">
		    	 </div>
		    </div>
		    
		     <div class="form-group">
		     	<label class="control-label col-sm-2" for="email">PW:</label>
		     	<div class="col-sm-10">
		     	  <input type="password" class="form-control" id="email" placeholder="name" name="pw" value="${member.pw}" readonly="readonly">
		    	 </div>
		    </div>
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Name:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="num" name="name" value="${member.name}">
		      </div>																			
		    </div>
		    
		    
		    
			<div class="form-group">
		      <label class="control-label col-sm-2" for="email">Email:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="kor" name="email" value="${member.email}" >
		      </div>
		    </div>
		    
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Phone:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="engl" name="phone" value="${member.phone}">
		      </div>
		    </div>
		    
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Age:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="math" name="age" value="${member.age}">
		      </div>
		    </div>
		    
		    
		    
		    
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <div class="checkbox">
		          <label><input type="checkbox" name="remember"> Remember me</label>
		        </div>
		      </div>
		    </div>
		    
		    
		    
		    <div class="form-group">        
		      <div class="col-sm-offset-2 col-sm-10">
		        <button type="submit" class="btn btn-danger" id="update">Update</button>
		      </div>
		    </div>
		  </form>
		</div>

	</body>
</html>