<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        .box-submit {
            text-align: center;
        }
        .box-input{
            text-align: center;
        }
        .box-line-height {
            margin-bottom: 10px;
        }
        .header > h3 {
            text-align: center;
        }
      
    </style>
    <script>
    	var msg = '<%= request.getParameter("msg")%>';
    	
    	window.onload = function(){
    		showMsg();
    	}
    	
    	function showMsg(){
    		
    		
	    	if( msg != null && msg != 'null' && msg != '' ){
	    		alert(msg);
	    	}
    	}
    	
        function verifyField(){
            let element = document.getElementById("id");
            let msg = '아이디 를 입력하세요.';
            if( !isValid (element,msg) ){
                return false;
            }
            element  = document.getElementById("pwd");
            msg = "비밀번호 를 입력하세요.";
            if( !isValid (element,msg) ){
                return false;
            }
           
            return true;
        }
        function isValid(element, msg){
            let result = false;
            if(element.value == ''){
                alert(msg);
                element.focus();
                result = false;
            }else{
                result = true;
            }
            return result;
        }
    </script>
</head>
<body>
    <form action="${ pageContext.servletContext.contextPath }/login" method="post"> 
        <div class="header">
            <h3>로그인</h3>
        </div>
        <div class="box-input">
            <label for="id">아이디 : </label>
            <input type="text" id="id" name="id">
            <div class="box-line-height"></div>
            
            <label for="pwd">비밀번호 : </label>
            <input type="password" id="pwd" name="pwd">
            <div class="box-line-height"></div>
            
          
        </div>
        <div class="box-line-height"></div>
        <div class="box-submit">
            <input type="submit" value="로그인" onclick="return verifyField();">
            <a href="<%=request.getContextPath()%>/join">회원가입</a>
        </div>
        
    </form>
</body>
</html>



