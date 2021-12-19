<%@ page language="java" contentType="text/html; charset=UTF-8" autoFlush="true"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.net.URLEncoder" %>
   	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시글 리스트</title>
<%
	request.setCharacterEncoding("utf-8");
	response.sendRedirect("list.do");
	String userId = (String)session.getAttribute("userId");
%>

<style type="text/css">
	.table th:nth-child(1) { width: 60px; }
	.table th:nth-child(2) { width: auto; }
	.table th:nth-child(3) { width: 100px; }
	.table th:nth-child(4) { width: 120px; }
	.table th:nth-child(5) { width: 60px; }
	.table th:nth-child(6) { width: 60px; }
	
	.table td:nth-child(2) { text-align: left; }


		.search {
			text-align: center;		
		}		
		
		.search .form-control {
			display: inline-block;
			width: auto;
		}
		
		.search #search {
			width: 250px;
		}
	
		.search {
			margin: 10px;
			text-align: center;
		}
	
</style>

</head>
	<link rel = "stylesheet" href="${path }/resource/css/bootstrap.css">
	<link rel = "stylesheet" href="${path }/resource/js/bootstrap.js">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resource/js/bootstrap.js"></script>
<body>
	<div class="wrap contaner">
		<jsp:include page="../menu.jsp" flush="false"/>
	</div>
	
	<table style="width : 100%" class = "table table-striped table-hover">
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성일</th>
		<th>글쓴이</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	
	<tbody>
	<c:forEach items="${lists}" var="list">
		<tr>
		<td>${list.getBoardno()}</td>
		<td><a href="contentView.do?boardNo=${list.getBoardno()}">${list.getBoardtitle()}</a></td>
		<td>${list.getBoardDate()}</td>
		<td>${list.getBoardWriter()}</td>
		<td>${list.getBoardCount()}</td>
		<td>${list.getboardSuggestions()}</td>
		</tr>
	</c:forEach>
	</tbody>
	
	<tfoot>
	<tr>
	<td colspan="6">
	<div class="search">
		<form action="listSearch.do" method="get" accept-charset="utf-8">
			<select name="searchKind" class="form-control">
				<option value="boardTitle">제목</option>
				<option value="boardContent">내용</option>
				<option value="boardWriter">이름</option>
			</select>
			<input type="text" name="search" id="search" class="form-control" required 
					placeholder="검색어를 입력하세요."/>
			<input type="submit" value="검색하기" class="btn btn-default" />
			<button type="button" class="btn btn-default" onclick="location.href='list.do';">돌아가기</button>
		</form>
    
	</div>
	</td>
	</tr>
	
	<tr>
	<td colspan="6" style="text-align: center;">
		<ul class="pagination justify-content-center">
		
		<c:forEach var="num" begin="1" end="${counts }">
		<c:if test="${searchCnt == 1}">
				<%
					String text = (String)request.getAttribute("content");
					String encText = URLEncoder.encode(text, "UTF-8") ;
				%>
				<li class = "page-item"><a class="page-link" href="listSearch.do?searchKind=${kind}&&search=<%=encText %>&&page=${num}">${num}</a>
		</c:if>
		<c:if test="${searchCnt != 1}">
				<li class = "page-item"><a class="page-link" href="list.do?page=${num}">${num}</a>
		</c:if>
		</c:forEach>
		</ul>
	<c:if test="${null ne  userId}">
	
		<a href = "boardWrited.do" class = "btn btn-primary pull-right" style="size: 25px">글쓰기</a>
	</c:if>
	</td>
	</tr>
	
			<tr><td colspan="6" align="center"><jsp:include page="/footer.jsp" flush="false"/></td></tr>
	
	</tfoot>
	</table>
	<jsp:include page="/login/memberJoin.jsp"></jsp:include>
</body>
</html>