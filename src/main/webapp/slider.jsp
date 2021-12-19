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
		<div id = "carousel-example-generic" class = "carousel slide" data-ride="carousel">
		
			<ul class = "carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ul>
			<div class="carousel-inner" role="listbox">
				<div class="item active">
				 	<img src="${path }/resource/image/영화.jpg" style="width: 300px; height: 100px; padding: 10px;"  alt="사진1">
				 	<div class="carousel-caption">
					</div>
				</div>
				
				<div class = "item">
					<img src="${path }/resource/image/영화2.jpg" style="width: 300px; height: 100px; padding: 10px;" alt="...">
      				<div class="carousel-caption">
      				</div>
				</div>
				
				<div class = "item">
					<img src="${path }/resource/image/영화3.jpg" style="width: 300px; height: 100px; padding: 10px;" alt="...">
      				<div class="carousel-caption">
      				</div>
				</div>
			</div>
		</div>
		<a class="carousel-control-prev" href="#demo" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
		</a>
		<a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
		</a>
</body>
</html>