<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		.a {
			padding-left: 30px;
			padding-right: 30px;
		}
	</style>
</head>
<body>
	
	<table border="1" style="width: 100%">
	<tr>
	
		<td align="center"> ${vod.getMovieName() }</td>
		<td>${vod.getMovieName() } 상세내용</td>
	</tr>
	
	<tr>
		<td>
		<img src="${path}/resource/moviePoster/${vod.getMovieFileName() }">
		</td>
		<td>
		<div>
		개봉 날짜 : ${vod.getMovieYear() }<br><br>
		</div>
		<div>
		줄거리 : ${vod.getMovieContnet() }<br><br>
		</div>
		<div>
		OTT서비스 : ${vod.getMovieKind() }
		</div>
		</td>
	</tr>
	</table>
</body>
</html>