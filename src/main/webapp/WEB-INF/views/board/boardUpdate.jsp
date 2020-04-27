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
		<h1>${board} Update</h1>
		<form action="./${board}Update" method="POST" >
			<input type="hidden" name="num" value="${vo.num}">
			<p>Title : <input type="text" name="title" value="${vo.title}"></p>
			<p>Writer : <input type="text" name="writer" value="${vo.writer}" disabled="disabled"></p> <!-- read only와 구분해서 사용 -->
			<p>Num : ${vo.num}</p>
			<textarea rows="10" cols="70" name="contents" id="contents">${vo.contents}</textarea>
			
			
			<div>
				<label for="files">Files:</label>
				<c:forEach items="${vo.boardFileVOs}" var="fileVO">
					<p>${fileVO.oriName}<i id="${fileVO.fileNum}" class="glyphicon glyphicon-remove remove fileDelete"></i></p>
				</c:forEach>			
				
			</div>
			
			<input type="submit" value="WRITE" class="btn btn-danger">
		</form>

	
	
	</div>
	

		<script type="text/javascript">
		//${"선택자"}.action{};
		$("#contents").summernote({
			height:400
			
		});
		
		$(".fileDelete").click(function(){
			
			var s = $(this);
			
			
			$.post("../boardFile/fileDelete",{fileNum:$(this).attr("id")},function(data){
				alert(data);
				
				if(data.trim()>0){
					alert("성공");
					alert(data);
					s.parent().remove();
				}else{
					alert(data);
					alert("파일 삭제 실패ㅠㅠ");
				}
			});
			
		}); 
		
		
		
	
	</script>
</body>
</html>