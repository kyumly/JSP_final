<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel = "stylesheet" href="${path }/resource/css/bootstrap.css">
<link rel = "stylesheet" href="${path }/resource/js/bootstrap.js">
</head>
<body>
	<script type="text/javascript">
		var confirm = false;
		function pwTest() {
		      var p1 = document.getElementById('pw').value;
		      var p2 = document.getElementById('pw1').value;

		      var pwRegExp = /^[a-zA-z0-9]{4,12}$/;
		      //var pwRegExp =  /^.*(?=^.{5,10}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
		      
		      
		      if(!p1){
		    	  alert("비밀번호가 없습니다.")
		    	  return false;
		      }
		      if(p1 != p2){
		          alert("비밀번호가 일치 하지 않습니다");
		          return false;
		      }else{
				  if(!pwRegExp.test(p1)) {
			            alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
			            register.userPw.value = "";
			            register.userPwConfirm.value = "";
			            register.userPw.focus();
			            return false;
			      }
		          alert("비밀번호가 일치합니다");
		          confirm = true;
		          return true;
		      }
		      

		      
		}
		function pwCheck(){
			if(!confirm){
		          alert("비밀번호 중복버튼을 클릭해 주세요!");
		          return false;
			}
		}
		
	</script>

	<% 
		request.setCharacterEncoding("utf-8");
		response.sendRedirect("mylist.do");
	%>
	<div class="wrap contaner">
		<jsp:include page="/menu.jsp" flush="false"/>
	</div>
	<form action="mypageUpdate.do" method="post" onsubmit="return pwCheck()" accept-charset="utf-8">
	<div class="container">
	<table style="width: 100%" class = "table">
	<thead>
	<tr>
	</tr>
	</thead>
	<tbody>

	<tr>
		<td colspan="2" style="padding-bottom: 25px; padding-left: 30px; padding-top: 10px"><div class="container">
		<h1 style="font-size: 50px">회원 정보 수정 양식</h1></div></td>
	</tr>
	<tr>
		<td style="padding-left: 30px" width="160px">아이디</td>
		<td style="margin-left: 30px">${member.getUserId() }</td>
	</tr>
	
	<tr>
		<td style="padding-left: 30px">비밀번호 입력  </td>
		<td><input type="password" placeholder="영문 대소문자와 숫자 4~12자리" size="25px" id = "pw"
		name="userPw">
		<input type="button" onclick="pwTest()" value="비밀번호 중복 확인">
		</td>
	</tr>
	
	<tr>
		<td style="padding-left: 30px">비밀번호 확인  </td>
		<td><input type="password" placeholder="비밀번호 재입력" size="25px" id = "pw1"></td>
	</tr>
	
	<tr>
		<td style="padding-left: 30px">이름  </td>
		<td style="margin-left: 30px">${member.getUserName() }</td>
	</tr>
	
	<tr>
	<td style="padding-left: 30px;">이메일 </td>
			<td><input type="email" value= ${member.getEamil() } size="25px" name="userEmail"></td>
	</tr>
	
	<tr>
	</tr>
	
	<tr>
		<td colspan="2" align="right">
		<input type="hidden" value="${member.getUserId() }" name = "userId">
		<input type="hidden" value="${member.getUserName() }" name = "userName">
		<button type="submit" class = "btn btn-primary" style="font-size: 20px" >수정하기</button>
		<button type="button" class = "btn btn-dark" onclick="location.href='${path}/index.jsp';" style="font-size: 20px; background-color: block;">돌아가기</button>
	</tr>
	</tbody>


	</table>
	</div>
	</form>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resource/js/bootstrap.js"></script>
</body>
</html>