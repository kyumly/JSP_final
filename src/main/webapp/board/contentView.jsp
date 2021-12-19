<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<style type="text/css">
	#addCommnet, #ListComment { 
		width: 700px; 
		margin: 15px auto; 
	}
	
	#addCommnet { 
		margin-top: 30px; 
	}
	#addCommnet td:nth-child(1) { 
		width: 600px; 
	}
	#addCommnet td:nth-child(2) { 
		width: 100px; 
	}
	
	#ListComment td:nth-child(1) {
		 width: 800px;
	}
	#ListComment td:nth-child(2) { 
		width: 100px; 
	}
	
	#ListComment td {
		position: relative;
		left: 0;
		top: 0;
	}
	
	#ListComment td span {
		position: absolute;
		right: 10px;
		bottom: 5px;
		color: #AAA;
		font-size: 11px;
	}
	
</style>
</head>
	<link rel = "stylesheet" href="${path }/resource/css/bootstrap.css">
	<link rel = "stylesheet" href="${path }/resource/js/bootstrap.js">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resource/js/bootstrap.js"></script>
	<script type="text/javascript">

	 function showConfirm(boardNo) {
		 if (confirm("게시물을 삭제하시겠습니까?"))
		  {
			location.href="boardDelete.do?boradNo="+boardNo;
		  } else {
		   alert("삭제 취소");
		  }
		 }
	
	</script>
<body>

	<%
	String userId = (String)session.getAttribute("userId");	
	%>
	
	<jsp:include page="/menu.jsp" flush="false"/>
	<div class = "container">
			<table class ="table">
			<thead>
				<tr class="table-active">
						<th scope="col" style="width: 60%"> 제목 : ${board.getBoardtitle()  }<br>
						ID : ${board.getUserId() }</th>
						<th scope="col" style="width: 40%" class="text-right">조회수 : ${board.getBoardCount() } &nbsp;&nbsp; 추천수 : ${board.getboardSuggestions() }
						<br> 입력 날짜 : ${board.getBoardDate()}</th>
				</tr>
			</thead>
			
			<tbody>
			<tr>
			<td colspan="2"><div>${board.getBoardContent() }</div>
			</tr>
				<tr>
					<td colspan="2">
						<c:if test="${board.getFileName() != null}">
						<div>
						<img src="${path }/resource/movieImage/${board.getFileName() }">
						</div>
						첨부된 파일 : <a class= "btn" href="${path }/resource/movieImage/${board.getFileName() }" download>${board.getFileName() }</a>
						</c:if>
					</td>
				</tr>
				</tbody>
			</table>

	
			<c:if test="${board.getUserId() == userId }">
			<div class= "btns">
			<button type="button" class="btn btn-primary"
				onclick="location.href='boardModify.do?boradNo=${board.getBoardno() }';">수정하기</button>
				
			<button type="button" class="btn btn-danger"
				onclick= "showConfirm('${board.getBoardno()}');">삭제하기</button>

			</c:if>
			<c:if test="${userId ne null }">
				<button type="button" class="btn btn-default"
				onclick="location.href='boardSuggestions.do?boradNo=${board.getBoardno() }';">추천하기</button>
			</c:if>

			
			<button type="button" class="btn btn-default"
				onclick="location.href='list.do';">돌아가기</button>
			
			</div>
			
			<div class="container">
			<table id="ListComment" class="table table-bordered">
		
				<c:if test="${ comments.size() == 0 }">
				<tr>
					<td colspan="2">댓글이 없습니다.</td>
				</tr>
			</c:if>
		
			<c:forEach items="${ comments }" var="comment">
			<tr>
				<td>
					${ comment.getCommentContent() }
					<span>${ comment.getUserId() }. ${ comment.getDate() }</span>
				</td>
				<td><c:if test="${comment.getUserId() == userId}">
					<button type="button" class="btn btn-danger"
					onclick="location.href='CommentDelete.do?commentNo=${comment.getCommentNo() }&&boardNo=${board.getBoardno()}';">삭제하기</button>
					</c:if>
				</td>
			</tr>
			</c:forEach>	
			</table>
		</div>
			<c:if test="${null ne  userId}">
			<div class="container">
				<form action="boardCommentWrite.do" method="post" accept-charset="UTF-8">
				<table class="table table-bordered" id="addCommnet" >
				<tr>
					<td><input type="text" name="boardContent" class="form-control" required placeholder="댓글을 작성하세요. "/></td>
					<td align="center"><input type="hidden" value="${board.getBoardno() }" name="boardNo"><input type="hidden" value="${userId }" name="userId">
					<input type="submit" value="댓글쓰기" class="btn btn-primary"></td>
				</tr>

			</table>
			</form>
			</div>
			</c:if>
	<jsp:include page="/login/memberJoin.jsp"></jsp:include>
</body>
</html>


