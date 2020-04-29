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
		<div class="row">
			<div class="form-group">
			  <label for="usr">Writer:</label>
			  <input type="text" class="form-control" id="writer">
			</div>
		

			
			<div class="form-group">
			  <textarea class="form-control" rows="5" id="contents"></textarea>
			</div>
			<button id="btn">Write</button>
		</div>
		
		<div class="row">
			<table  id="result" class="table table-striped">
				<tr>
					<td>NUM</td>
					<td>Contents</td>
					<td>Writer</td>
					<td>Date</td>
				</tr>
			</table>
		</div>
		
		<div>
			<button id="more">더보기</button>
		</div>
		
		
	</div>
	
	
	
	
	
	
	
	
	
	<script type="text/javascript">
	
		var count = 1;
	
	
	
	
	

		function getList(curPage){
			$.get("getList?curPage="+curPage, function(result){
				$("#result").append(result);
			})
		}
		

		
		
		
	
	
		getList(count);
	
		
		$("#more").click(function(){
			count++;
			getList(count);
		});
		
		
		//---------------------------------------------------
		
	
		$("#btn").click(function(){
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			
			
			//이게..뭘위해서 한 걸까?
			$("#writer").val('');
			$("#contents").val('');
			
			
			
			//$.get("url?name=value")
			//$.post("url",{파라미터이름:변수명}
			$.post("./memoInsert",{writer:writer,contents:contents}, function(result){
				//클릭하면 컨트롤러 가서 데이터 갖고 노티스리스트.jsp 가서 뿌려서 보여주는것
				//메모리스트까지는 데이터 없이 가서 뿌려진 후 에이잭스로 디비가서 가지고오는 코드가 자동 실행
				
				//result = result.trim(); >>> 제이슨으로 보내서 trim 안 해줘도 됨
				//alert(result);  /// result 앞뒤로 공백이 있다 > 공백 없애는 작업
				//alert(result=='1');
				
				if(result>0){
					/* count=1;
					getList(count); */
					location.reload();
				}else{
					alert("작성 실패")
				}
			});
		});
	</script>
	
	
</body>
</html>