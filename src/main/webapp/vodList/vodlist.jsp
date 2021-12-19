<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <c:set var="path" value="${pageContext.request.contextPath}"/>
    <c:set var="i" value="0"/>
    <c:set var="j" value="3"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOD 리스트</title>
</head>
	<link rel = "stylesheet" href="${path }/resource/css/bootstrap.css">
	<link rel = "stylesheet" href="${path }/resource/js/bootstrap.js">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resource/js/bootstrap.js"></script>
	
<script>
	function popup(name) {
		var url = "/202044003_final/vodView.do?id="+name;
		var name = "상세정보";
		
		window.open(url, name, "width=1000, height=350, left=100, top=100");
	}
</script>
<body>
	<c:if test="${empty vodLists}">
			<script type="text/javascript">
				alert("현재 리스트가 없습니다.");
				history.go(-1);
			</script>
	</c:if>
	<div class="wrap contaner">
		<jsp:include page="../menu.jsp" flush="false"/>
	</div>
	
	<table style="width : 100%" border="1" class="table table-dark table-striped table-hover">

	<tbody>
		<c:forEach items="${vodLists}" var="list">
		<c:if test="${i%j == 0}">
		<tr>
		</c:if>
		<td align="center" style="height: 100px;">
			<div>
			<h3>${list.getMovieName() }</h3>
			<a onclick="popup('${list.getMovieId()}')"><img src="${path}/resource/moviePoster/${list.getMovieFileName() }" width="250px" height="300"></a>
			<br><br>
			<p><a class ="btn btn-default" onclick="popup('${list.getMovieId()}')">자세히 보기</a></p>
			</div>
			</td>
		<c:if test="${i%j == j-1 }">
		</tr>
		</c:if>
		<c:set var="i" value="${i+1 }"/>
		</c:forEach>
	</tbody>
	<tfoot>
	<tr>
	<td colspan="6" style="text-align: center;">
		<ul class="pagination justify-content-center">
		<c:forEach var="num" begin="1" end="${counts }">
			<li class = "page-item"><a class="page-link" href="vodList.do?movieKind=${Kind }&&page=${num}">${num}</a>
		</c:forEach>
		</ul>
	
	</tr>
		<tr><td colspan="4" align="center"><jsp:include page="/footer.jsp" flush="false"/></td></tr>
	</tfoot>

	</table>
	
	<jsp:include page="/login/memberJoin.jsp"></jsp:include>
</body>
</html>