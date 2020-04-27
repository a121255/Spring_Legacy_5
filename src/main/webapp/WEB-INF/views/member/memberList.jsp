<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
<script type="text/javascript">
	$(function(){
		
	});
</script>

</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		<div class="row">
			<h1>Member List</h1>
			<form class="col-xs-6" action="./memberList">
			    <div class="input-group">
			      <select value="key" class="form-control col-xs-2" id="sel1" name="kind">
			        <option>Notice</option>
				    <option value="mi">ID</option>
				    <option value="mn">NAME</option>
				    <option value="mp">PHONE</option>
				    <option value="me">EMAIL</option>
				  </select>
			      <input type="text" class="form-control" placeholder="Search" name="search">
			      <div class="input-group-btn">
			        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
			      </div>
			    </div>
			  </form>
		</div>
			
			
			<div id = "result">
			<table class="table table-hover" id="tb1">
				<tr>
					<td>ID</td>
					<td>NAME</td>
					<td>PHONE</td>
					<td>EMAIL</td>
					<td><input type="checkbox" id="checkAll"><button id="del" class="btn btn-danger">Delete</button></td>
				</tr>
				<c:forEach items="${list}" var="mo" varStatus="i">
				<tr>
					<td id="id${i.index}">${mo.id}</td>
					<td><a href="">${mo.name}</a></td>
					<td>${mo.phone}</td>
					<td>${mo.email}</td>
					<td class="chk"><input type="checkbox" name="del" title="id${i.index}" id="${mo.id}" class="check"></td>
				</tr>
				</c:forEach>
				
			
			</table>
			
 			<div>
				<ul class="pagination">
					<c:if test="${pager.curBlock gt 1}">
					<li><a href="./memberList?curPage=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">이전</a></li>
					</c:if>
					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						
						<li><a href="./memberList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
					</c:forEach>
					<c:if test="${pager.curBlock lt pager.totalBlock}">
					<li><a href="./memberList?curPage=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">다음</a></li>
					</c:if>
				</ul>
				
			</div> 
			</div>
			
			<div>
				<a href="./memberList" class="btn btn-danger">WRITE</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function() {
		
		 
		 $("#result").on("click","#checkAll",function(){
			 $(".check").prop("checked", $(this).prop("checked"));
		 });
		 
		////////////////////////////////////////////////////
		$("#result").on("click",".check",function(){
			var result = true; //하나라도 이상하면 true
			 $(".check").each(function(){
				 if(!$(this).prop("checked")){
					 result = false;
				 }
			 });
			 
			 
			 $("#checkAll").prop("checked",result);
		});
	
	

		 
		 /////////////////////////////////
		 
		 $("#del").click(function(){
			 
			 /*  if($(".check").prop("checked")){
			 	  alert($(".check").parent().parent().closest("td").html()); 
				  alert($(".se").text());
			
			 }   */
			 /////////////////////////////////////////
			 
			 $("#result").on("click", "#del", function() {
				 var ids = [];//빈 배열 생성
				 
					$(".check").each(function(){
						if($(this).prop("checked")){
							//var id = $(this).attr("title");
							//alert($("#"+id).text());
							
							//alert($(this).attr("id"));
						
							ids.push($(this).attr("id"));
						}
					});
					 
					 
					 
					 console.log(ids);
					 //foreach 끝
					 
					 
					 
					 
					 
					$.ajax({
						type:"get",
						url:"./memberDeletes",
						traditional : true,
						data: {
							ids:ids
						},
						success:function(data){
							$.get("./memberLists",function(data){
								$("#result").html(data.trim());
							});
						}
							
					});
					 
				 });
			 });
			 
			
		
		 
		 
	});

	
		
	</script>
	
	
</body>
</html>