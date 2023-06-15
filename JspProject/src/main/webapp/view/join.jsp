<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Join Page</title>
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
        .box-span-on {
            color:green;
            font-weight: bold;
        }
        .box-span-off {
            color:red;
            font-weight: bold;
        }
    </style>
    <script>
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
            element  = document.getElementById("pwd-double-check");
            msg = "비밀번호확인 를 입력하세요.";
            if( !isValid (element,msg) ){
                return false;
            }
            element  = document.getElementById("name");
            msg = "이름 을 입력하세요.";
            if( !isValid (element,msg) ){
                return false;
            }
            element  = document.getElementById("jumin");
            msg = "주민번호 를 입력하세요.";
            if( !isValid (element,msg) ){
                return false;
            }

            // 전송하기전에 불일치를 확인하여야함.
            let originObj =  document.getElementById("pwd");
            let checkObj =  document.getElementById("pwd-double-check");
            if(originObj.value != checkObj.value){
                alert("비밀번호가 불일치 합니다.");
                checkObj.focus();
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
        function doubleCheck(value){
            let origin = document.getElementById("pwd").value;
            let boxSpan = document.getElementById("box-span");
            
            if(origin == value){
                //일치함
                boxSpan.className = "box-span-on";
                boxSpan.textContent = "일치함";
                
            }else{
                //불일치
                boxSpan.className = "box-span-off";
                boxSpan.textContent = "불일치함";
            }

        }
    </script>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath }/join" method="post"> 
        <div class="header">
            <h3>회원가입폼</h3>
        </div>
        <div class="box-input">
            <label for="id">아이디 : </label>
            <input type="text" id="id" name="id">
            <div class="box-line-height"></div>
            
            <label for="pwd">비밀번호 : </label>
            <input type="password" id="pwd" name="pwd">
            <div class="box-line-height"></div>
            
            <label for="pwd-double-check">비밀번호 확인 : </label>
            <input type="password" id="pwd-double-check" onkeyup="doubleCheck(this.value);"><span id="box-span" class="box-span-on"></span>
            <div class="box-line-height"></div>

            <label for="name">이름 : </label>
            <input type="text" id="name" name="name">
            <div class="box-line-height"></div>

            <label for="jumin">주민번호 : </label>
            <input type="text" id="jumin" name="jumin">
            <div class="box-line-height"></div>
        </div>
        <div class="box-line-height"></div>
        <div class="box-submit">
            <input type="submit" value="전송" onclick="return verifyField();">
             <a href="javascript:history.back();">돌아가기</a>
        </div>
        
    </form>
</body>
</html>



