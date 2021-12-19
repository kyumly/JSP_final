<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${commentResult eq '1'}">
	<script type="text/javascript">
		alert("댓글 삭제 성공");
		location.href = "contentView.do?boardNo="+${boardNo};
	</script>
</c:if>

<c:if test="${suggestionResult == 1}">
	<script type="text/javascript">
		alert("추천 성공");
		location.href = "contentView.do?boardNo="+${boardNo};
	</script>
</c:if>

<c:if test="${suggestionResult != 1}">
	<script type="text/javascript">
		alert("추천 삭제");
		location.href = "contentView.do?boardNo="+${boardNo};
	</script>
</c:if>

<c:if test="${commentResult } != 1">
	<script type="text/javascript">
		alert("댓글삭제실패");
		history.go(-1);
	</script>
</c:if>
</body>
</html>