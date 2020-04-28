/**
 * 
 */

	/* 	var btn = document.getElementById("btn");
		btn.addEventListener("click", function(){
			alert('test');
		}); */
	
		
	
		var count = 1;
		
		
		function setCount(c){
			count = count + c;
		}
		
		
		$("#add").click(function() {
			if(count<6){
				$("#file").append('<div class="form-group fileg" > <label for="file"> File :</label> <input type="file" class="form-control files" name="files"> <i class="glyphicon glyphicon-remove remove"></i></div> ');
				count++;
			}else {
				alert("파일은 최대 5개 만 가능");
			}
		});
		
		
		//이벤트 위임
		$("#file").on("click",".remove",function(){
			$(this).parent().remove();
			count--;
		});
		
		
		
		$("#btn").click(function() {
			//title, contents 데이터 유무 검증
			var title = $("#title").val();
			var contents = $("#contents").summernote('code');
		

		
			
			var ch3 = true;
			
			$(".files").each(function() {
				console.log("val : "+$(this).val());
				if($(this).val()==""){
					ch3 = false;
				}
			});
			
			
			var ch1 = title != "";
			var ch2 = $("#contents").summernote('isEmpty');

		

			
 	 		if(ch1 && !ch2 && ch3){//둘 다 true라면
				//form을 전송 (submit event 강제 발생)
				$("#frm").submit(); //강제 발생은 여기서 끝남	
			
			}else{//하나라도 비었다면
				//submin event 종료
				alert("필수 요소 다 입력하세요");
			}  
 	 		
 	 		
 	 		
			//null로 하면 false만 나옴 어떻게 해야 true가 나올까 -> '', length
			/* 		console.log(title=='');
					console.log(contents=="");
					console.log(title.length);
					console.log(contents.length); */
			//아래는 summernote 쓸 때 가져오는 코드
			/* contents = $("#contents").summernote('code');
			console.log($("contents").summernote('isEmpty'));
			 */
			
		});
	
	
	
		
		
	
	
		//${"선택자"}.action{};
		$("#contents").summernote({
			height:400,
			callbacks: {
				onImageUpload: function(file) {
				      console.log("upload");
				}
			}
			
		});
		