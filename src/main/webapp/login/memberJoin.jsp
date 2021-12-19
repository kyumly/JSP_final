<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="widh-device-width">
<title>Insert title here</title>
</head>
<style type="text/css">
		* {
	  margin: 0px;
	  padding: 0px;
	  text-decoration: none;
	  font-family:sans-serif;
	
	}


	.memberForm {
	 	position:absolute;
	  	width:400px;
	  	height:700px;
	  	padding: 30px, 20px;
	  	background-color:#FFFFFF;
	  	top:40%;
	  	left:50%;
	  	transform: translate(-50%,-50%);
	  	border-radius: 15px;
		}

	.memberForm h2 	{
		  text-align: center;
		  margin: 30px;
		}

	.textForm {
		  border-bottom: 2px solid #adadad;
		  margin: 30px;
		  padding: 10px 10px;
	  
	}
	.basic {
		  width: 100%;
		  border:none;
		  outline:none;
		  color: #636e72;
		  font-size:16px;
		  height:25px;
		  background: none;
	}

	.btn:hover {
	  	background-position: right;
	}
	
	
</style>
<%
	String exist = null;
%>
<script type="text/javascript">
	var c = false;
	
   	function Idcheck() {
   		if(!frmId.userNameSearch.value){
   			alert("아이디 입력란이 빠졌습니다.");
   			return false;
   		}
   		if(!frmId.userEmailSearch.value){
   			alert("이메일이 빠져 있습니다.");
   			return false;
   		}
   		

	}
   	
	function check() {
		if(!frm.userId.value){
			alert("아이디 입력란이 빠졌습니다.")
			frm.userId.focus;
			return false;
		}
		if(!frm.userPw.value){
			alert("비밀번호 입력란이 빠졌습니다.")
			frm.userPw.focus;
			return false;
		}
		if(!frm.userPwConfirm.value){
			alert("비밀번호 확인 입력란이 빠졌습니다.")
			frm.userPwConfirm.focus;
			return false;
		}
		if(!frm.userName.value){
			alert("이름 입력란이 빠졌습니다.")
			frm.userName.focus;
			return false;
		}
		if(!frm.userEmail.value){
			alert("이메일 란이 빠졌습니다.")
			frm.userEmail.focus;
			return false;
		}
	   	var p1 = document.getElementById('pw1').value;
	   	var p2 = document.getElementById('pw2').value;
	   	var pwRegExp = /^[a-zA-z0-9]{4,12}$/;
		if(p1 != p2){
			alert("비밀번호가 일치 하지 않습니다.");
			return false;
		}
	   	if(!pwRegExp.test(p1)) {
            alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
            frm.userPw.value = "";
            frm.userPwConfirm.value = "";
            frm.userPw.focus();
			return false;
        }
	}


</script>
<body>
	<div class = "row">
		<div class = "modal" id="modal" tabindex = "-1">
			<div class = "modal-dialog">
				<div class = "modal-content">
					<div class = "modal-header">
						회원 가입
					<button class ="close" data-dismiss="modal">취소</button>
					</div>
					<div class = "modal-body" style="align-content: center;">
					<form action="insert.do" method="post" name = "frm" onsubmit="return check()"accept-charset="utf-8 ">
                                                                                               
      				<h2>회원가입</h2>
      				<div class="textForm">
        			<input name="userId" type="text" class="basic" placeholder="아이디"/>
      				</div>
      				<div class="textForm">
        			<input name="userPw" type="password" class="basic" placeholder="비밀번호는 영문 대소문자와 숫자 4~12자리"" id="pw1">
      				</div>
       				<div class="textForm">
        			<input name="userPwConfirm" type="password" class="basic" placeholder="비밀번호 확인" id="pw2">
      				</div>
      				<div class="textForm">
        			<input name="userName" type="text" class="basic" placeholder="이름">
      				</div>
       				<div class="textForm">
        			<input name="userEmail" type="email" class="basic" placeholder="이메일">
      				</div>
      				<div class="col text-center">
      				<input type="submit" class ="btn btn-success" style="width: 80%; height: 40px;" value="회원가입">
     				</div>
      
   					 </form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class = "row">
		<div class = "modal" id="modalSearch" tabindex = "-1">
			<div class = "modal-dialog">
				<div class = "modal-content">
						<div class = "modal-header">
						아이디 찾기
						<button class ="close" data-dismiss="modal">취소</button>
					</div>
					
					<div class = "modal-body" style="align-content: center;">
					<form action="searchId.do" method="post" name = "frmId" onsubmit="return Idcheck()"accept-charset="utf-8 ">
                                                                                               
      				<h2>아이디찾기</h2>
      				<div class="textForm">
        			<input name="userNameSearch" type="text" class="basic" placeholder="이름">
      				</div>
       				<div class="textForm">
        			<input name="userEmailSearch" type="email" class="basic" placeholder="이메일">
      				</div>
      				<div class="col text-center">
      				<input type="submit" class ="btn btn-success" style="width: 80%; height: 40px;" value="아이디찾기">
     				</div>
      
   					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>