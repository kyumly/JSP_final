<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" name="viewport" content="widh-device-width">
<title>메인화면</title>
<link rel = "stylesheet" href="${path }/resource/css/bootstrap.css">
<link rel = "stylesheet" href="${path }/resource/js/bootstrap.js">
<style type="text/css">
	  .carousel-inner > .item > img {
      top: 0;
      left: 0;
      min-width: 100%;
      min-height: 400px;
    } 
</style>
<script type="text/javascript">
function popup(name) {
	var url = "202044003_final/vodView.do?id="+name;
	var name = "상세정보";
	
	window.open(url, name, "width=1000, height=350, left=100, top=100");
}
</script>
</head>
<body>	
	<jsp:include page="/indexDao.jsp"/>
	<table class= "table">
	<thead>
		<tr>
		<td colspan="4"><jsp:include page="menu.jsp" flush="false"/></td>
		</tr>
	</thead>
	<tbody>
		<tr>
		<td colspan="4"><jsp:include page="slider.jsp" flush="false"/></td>
		</tr>
		
		<tr>
		
		<td colspan="4"><div style="margin-left: 30px"><h3>best-NEW-top4</h3></div> </td>
		</tr>
		<tr>		
		<c:forEach items="${vodLists}" var="list">

		<td align="center" style="height: 100px;">
			<h3>${list.getMovieName() }</h3>
			<a onclick="popup('${list.getMovieId()}')"><img src="${path}/resource/moviePoster/${list.getMovieFileName() }" height="250px"></a>
			<br><br>
			<p><a class ="btn btn-default" onclick="popup('${list.getMovieId()}')">자세히 보기</a></p>
			</td>
		</c:forEach>
		</tr>
	</tbody>
	<tfoot>
	<tr><td colspan="4" align="center"><jsp:include page="/footer.jsp" flush="false"/></td></tr>
	</tfoot>
	</table>
	
	
	<jsp:include page="/login/memberJoin.jsp"></jsp:include>
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resource/js/bootstrap.js"></script>
</body>
</html>