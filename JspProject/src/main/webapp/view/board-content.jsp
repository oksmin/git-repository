<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.7.0.js" integrity="sha256-JlqSTELeR4TLqP0OG9dxM7yDPqX1ox/HfgiSLBj8+kM=" crossorigin="anonymous"></script>
  <style type="text/css">
  </style>
  <script>
  	window.onload = function(){
  		initClass();
  	}
  	
  	function adoptMethod(type){
  		$("input[name='method']").val(type);
  		initClass();
  	}
  	
  	function initClass(){
  		
  		// modify
  		$("textarea").removeClass("modify");
  		$("input[type='text']").removeClass("modify");
  		
  		// register
  		$("textarea").removeClass("register");
  		$("input[type='text']").removeClass("register");
  		
  		// get
  		$("textarea").removeClass("get");
  		$("input[type='text']").removeClass("get");
  		
  		const method = $("input[name='method']").val();
  		$("textarea").addClass(method);
  		$("input[type='text']").addClass(method);
  		
  		switch(method){
  			case "get" : 
  				$(".get").attr("readonly", true);
  				break;
  			case "modify" : 
  				$(".modify").attr("readonly", false);
  				break;
  			case "register" : 
  				$(".register").attr("readonly", false);
  				break;
  		}
  		
  	}
  	function goSubmit(){
  		 //const data = { opKey : 123 };
  		const data = $("form").serialize();
  		console.log(data);
         $.ajax(
                 {
                     url: "/project/api/board"
                     ,async:true // 비동기 쓰레드,false : 동기식(응답 받을때까지 대기함)
                     ,contentType: 'application/x-www-form-urlencoded; charset=UTF-8' // 전송타입
                     ,type:"POST" //method
                     ,data : data
                     ,dataType:"json" // 수신타입
                     ,success:function(data, textStatus){
                     	console.log(data);
                     	
                     	if(data.result == 1){
                     		var msg ='';
                     		switch(data.method){
                     		case 'modify': msg = data.result +'건 수정되었습니다.'; break;
                     		case 'register': msg = data.result +'건 등록되었습니다.';break;
                     		case 'remove': msg = data.result +'건 삭제되었습니다.';
                     			location.href = "${pageContext.servletContext.contextPath }/main";
                     			break;
                     		}
                     		alert( msg );
                     	}else{
                     		aelrt(data.result + '건 수정실패입니다. \n다시시도하세요.');
                     	}
                     }
                     ,error:function(jqXHR, textStatus, errorThrown){
                         console.log(jqXHR);
                         console.log(textStatus);
                         console.log(errorThrown);
                     }
                 }
             );
			  		
  		
  		return false;
  	}
  	
  	
  </script>
</head>
<body>

<div class="container mt-3">
  <h2 style="text-align: center;">게시글 작성</h2>  
  <form action="/action_page.php" name="form" method="post">
    <div class="row">
        <div class="col"></div>
        <div class="col"></div>
        <div class="mt-3 col p-3">
            <label for="reg_date">작성일:</label>
            <p class="form-control" id="reg_date" name="reg_date">${ requestScope.boardVO.reg_date }</p>
        </div>
    </div>
    
    <div class="row">
        <div class="mb-3 mt-3 col p-3">
	        <label for="title">글제목:</label>
	        <input type="text" class="foarm-control" id="title" placeholder="Enter Title" name="title" value="${ requestScope.boardVO.title }">
        </div>
        <div class="mb-3 mt-3 col p-3">
            <label for="title">작성자:</label>
            <div class="form-control" id="id" name="id">${ requestScope.boardVO.id == null ? sessionScope.SESS_ID : requestScope.boardVO.id }</div>
        </div> 
    </div>
    <div class="mb-3 mt-3">
        <label for="content">글내용:</label>
        <textarea class="form-control" rows="5" id="content" name="content" >${ boardVO.content }</textarea>
     </div>
    <div class="row">
	    <button type="button" class="get col p-3 btn btn-primary" onclick="history.back();">목록</button>
	    <div class="col p-3"></div>
	    <button type="submit" class="register col p-3 btn btn-primary" onclick="return goSubmit();">Submit</button> <!-- style="display: ${ param.method=='get' ? 'none' : ''}"  -->
	    <div class="col p-3"></div>
	    <button type="button"  class="remove col p-3 btn btn-primary" onclick="adoptMethod('remove');return goSubmit();">Remove</button>
	    <div class="col p-3"></div>
	    <button type="button"  class="modify col p-3 btn btn-primary" onclick="adoptMethod('modify');">Modify</button>
	    <div class="col p-3"></div>
    </div>
    <input type="hidden" name="method" value="${param.method }">
    <input type="hidden" name="b_no" value="${param.b_no }">
    <input type="hidden" name="id" value="${boardVO.id == null ? sessionScope.SESS_ID : requestScope.boardVO.id  }">
  </form>
</div>

</body>
</html>
