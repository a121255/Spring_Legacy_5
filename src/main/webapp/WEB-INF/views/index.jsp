<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<c:import url="./template/boot.jsp"></c:import>
	</head>
	<body>
		<c:import url="./template/header.jsp"></c:import>
		<button id="btn">BUTTON</button>
		<button id="btn2">BUTTON2</button>
		
		<script type="text/javascript">
		
		$("#btn2").click(function(){
			
			$.get("https://api.manana.kr/exchange/rate.json?base=KRW&code=KRW,USD,JPY", function(data){
				console.log(data[1].rate)
			});
			
			
		});
		
		
		
		
		
		
		
			$("#btn").click(function(){
				//jquery ajax
				//GET
			//	alert("start");
				$.get("./json/json1", function(data){
					//0. data가 string인지 json object인지 판별
					//console.log(data);     "name":"iu" -> String
					//console.log(data);     object -> json object
					console.log(data);
					
					
					//1.String이라면 Json object 변환
					data = data.trim();
					//data = JSON.parse(data);

					console.log(data);
					console.log(data.num); //키를 알면 꺼내 쓸 수 있다
					
					console.log(data.title);
					                                                                                      
				}); 
			//	alert("finish");
				
			});
		
		</script>
	</body>
</html>