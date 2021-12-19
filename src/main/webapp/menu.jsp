<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userId =(String)session.getAttribute("userId");
	%>

	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
		<div class = "container-fluid">
			<div class = "navbar-header">
				<button type="button" class = "navbar-toggle collapsed" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1" aria-expanded = "false">
					<span class = "sr-only"></span>
					<span class = "incon-bar"></span>
					<span class = "incon-bar"></span>
					<span class = "incon-bar"></span>
				</button>
				<a class = "navbar-brand" href="${path }/index.jsp">인하 VOD정보 사이트</a>
			</div>
			<!--개별적인 링크  -->
			<div class = "collapse navbar-collapse" id = "bs-example-navbar-collapse-1">
				<ul class = "nav navbar-nav">
					<li class = "dropdown">
						<a href="#" class = "dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">VOD<span class="caret"></span></a>
					<ul class ="dropdown-menu">
						<li><a href="${path }/vodList/netflix.jsp">넷플릭스</a>
						<li><a href="${path }/vodList/tving.jsp">티빙</a>
						<li><a href="${path }/vodList/disney.jsp">디즈네+</a>
						<li><a href="${path }/vodList/movieRank.jsp">현재 실시간 영화 순위</a>
					</ul>
					</li>
				</ul>
				<c:if test="${null eq userId }">
					<form class="navbar-form navbar-left" action="loginAction.do" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<div class= "form-group">
						<input type="text" class = "form-control" placeholder="아이디" name="id">
					</div>
					
					<div class= "form-group">
						<input type="password" class = "form-control" placeholder="비밀번호" name="pw">
					</div>
					<button type="submit" class = "btn btn-default">로그인</button>
				</form>
				</c:if>
				
				<c:if test="${null ne  userId}">
					
					<form class="navbar-form navbar-left" action="logoutAction.do" method="post">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${userId }님 안녕하세요&nbsp;&nbsp;<button type="submit" class = "btn btn-default">로그아웃</button>
					</form>
				</c:if>
				
				<ul class = "nav navbar-nav navbar-right">
					<li class = "dropdown">
						<a href="#" class = "dropdown-toggle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded="false">더보기<span class="caret"></span></a>
					<ul class ="dropdown-menu">
						<c:if test="${null eq userId }">
							<li><a href="${path }/login/memberjoin.jsp" data-target = "#modal" data-toggle="modal" >회원가입</a>
						</c:if>
						<li><a href="${path }/board/movieBoard.jsp">게시판</a>
						<c:if test="${null ne  userId}">
							<li><a href="${path}/login/mypage.jsp">개인 정보</a>
						</c:if>
					</ul>
					</li>
				</ul> 
				</div>
			</div>
	</nav>
</body>
</html>