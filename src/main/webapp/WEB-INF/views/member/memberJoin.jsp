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
		
		<div class="container">
			<h1>Member Join Form</h1>
		  <form class="form-horizontal" action="./memberJoin" method="post" enctype="multipart/form-data">
		 	 <div class="form-group">
		     	<label class="control-label col-sm-2" for="email">ID:</label>
		     	<div class="col-sm-10">
		     	  <input type="text" class="form-control" placeholder="ID" name="id" id="id">
		     	  <button id="cbtn">Check</button>
		     	  <input type="button" id="jb" value="bb">
		      </div>
		    </div>
		    
		    
		    
			<div class="form-group">
		      <label class="control-label col-sm-2" for="email">Name:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="Name" name="name">
		      </div>
		    </div>
		    
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Email:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="Email" name="email">
		      </div>
		    </div>
		    
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Phone:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="Phone" name="phone">
		      </div>
		    </div>
		    
		    
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="email">Age:</label>
		      <div class="col-sm-10">
		        <input type="text" class="form-control" id="email" placeholder="Age" name="age">
		      </div>
		    </div>
		    
		    
		    
		    
		    <div class="form-group">
		      <label class="control-label col-sm-2" for="pic">Avata:</label>
		      <div class="col-sm-10">
		        <input type="file" class="form-control" id="avata" placeholder="file" name="avata">
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
		        <button type="submit" class="btn btn-danger">Join</button>
		      </div>
		    </div>
		  </form>
		</div>
		
		
		
		<script type="text/javascript">
 		$("#id").blur(function(){
			
			alert("dd");
			
		 	var id = $("#id").val();
			
			 $.post("./memberIdCheck",{id:id},function(data){//data값은 html
				 
				 alert(data);
			
				if(data>0){
					alert("사용 가능한 아이디입니다.")
				}else{
					alert("중복되는 아이디입니다.")
					$("#id").remove();
				}
				
				
			});  
		});
 
 
 	
 
		</script>
		
		
		
	</body>
</html>