<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글쓰기</title>
</head>
	<link rel = "stylesheet" href="${path }/resource/css/bootstrap.css">
	<link rel = "stylesheet" href="${path }/resource/js/bootstrap.js">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resource/js/bootstrap.js"></script>
	
<body>
<%
	String userId = (String)session.getAttribute("userId");
%>
	<table style="width : 100%" class="table">
	<thead>
		<tr>
		<td colspan="4" align="center"><jsp:include page="/menu.jsp" flush="false"/></td>
		</tr>
	</thead>
	<form action="boardWrite.do" method="post" enctype="multipart/form-data">
	<tbody>
		<tr>
			<td>
			<div class = "container">
			<h3>게시글 작성</h3>
			</div>
			</td>
			
			</tr>
			<tr>
			<td>
			<div class="container">
				<div class ="form-group">
					<label for = "boardtitle">제목</label>
					<input type="text" class = "form-control" id="boardtitle" placeholder="제목" name="boardName" required="required">
				</div>
				<div class="form-group">
    				<label for="boardContext">내용</label>
    				<textarea class="form-control" id="boardContext" rows="20" name="boardContext" required="required" style="resize: none;"></textarea>
  				</div>
			<div class="form-group">
  				<input type="file" name= "file" accept="image/*" >
  				</div>
  			</div>
  			
				<div class="container">
				<input type="hidden" value="${userId }" name="userId">
				<input class="btn btn-primary pull-right" type="submit" value="글쓰기">
				</div>
  			
			</td>
			</tr>
			
	</tbody>
	</form>
	<tfoot>
		<tr><td colspan="4" align="center"><jsp:include page="/footer.jsp" flush="false"/></td></tr>
	</tfoot>

	</table>
	
		<jsp:include page="/login/memberJoin.jsp"></jsp:include>
</body>
</html>