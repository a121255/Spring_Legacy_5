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
		
		
		
		///summernote
		
		
		$("#contents").summernote({
			height:400,
			callbacks: {
				onImageUpload: function(files, editor) { //< 업로드 파일에 대한 정보, summernote 자체의 선택자
						var formData = new FormData(); //<form></form>폼의 형식으로 보내기 위해 준비
						
						//보내고 싶은 데이터 집어넣기
						formData.append('files', files[0]);	//<input type="file" name="" > ('parameter name',file info)
					
				      $.ajax({
				    	type:"POST",
				    	url:"../boardFile/fileInsert",
				    	data:formData, //parameter name, value가 이미 잇음 >> 모든 parameter는 formData 안에 있기 때문에 formData 보내줌
				    	enctype:"multipart/form-data",
				    	cache:false,
				    	contentType:false,
				    	processData:false,
				    	success:function(imageName){
				    		imageName=imageName.trim();
				    		$("#contents").summernote('editor.insertImage', imageName);
				    	}
				    	//하드디스크에 저장 후 > 저장된 이름 > 이쪽으로 받아줄거임 > img태그 써서 경로명 붙일 거임
				    	
				      });
				      
				},//onImageUpload
				onMediaDelete: function(files){//< 지우려는 파일의 정보, img 태그라고 보면 됨, 배열임
					console.log(files);
					//지우려는 파일명을 보냄, 경로는 정해져있으니 파일명만 보냄
					//files에서 파일명 꺼내기
					var fileName = $(files[0]).attr("src");
					console.log(fileName) //주소가 쭈욱 나옴. 파일명만 보내야 하니 잘라야한다 1) 여기서 자르기 2)서버에서 자르기
					//1) 여기서 잘라보겠다
					//split, substring
					fileName = fileName.substring(fileName.lastIndexOf("/"));
					console.log(fileName);
					
					$.ajax({
						type:"POST",
						url:"../boardFile/summerDelete",
						data:{
							fileName : fileName
						},
						success:function(data){
							console.log(data);
						}
					});
					
					
				}//onMediaDelete
				
				
			}//callback
			
		});
		
		
		//////////////
		
		
		
		
		
		
		
		
		
		
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
		