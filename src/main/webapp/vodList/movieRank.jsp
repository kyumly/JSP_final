<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>영화순위</title>
	<link rel = "stylesheet" href="${path }/resource/css/bootstrap.css">
	<link rel = "stylesheet" href="${path }/resource/js/bootstrap.js">
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="${path }/resource/js/bootstrap.js"></script>
	<script type="text/javascript">
	var dt = new Date();

	var m = dt.getMonth() + 1;
	if (m < 10) {
		var month = "0" + m;
	} else {
		var month = m + "";
	}

	var d = dt.getDate() - 1;
	if (d < 10) {
		var day = "0" + d;
	} else {
		var day = d + "";
	}

	var y = dt.getFullYear();
	var year = y + "";

	var result = year + month + day;
	$(function() {
		$.ajax({
					url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?key=bf0414422f000b12c2a6dccd0105b589&targetDt="
							+ result + "&itemPerPage=10",
					dataType : "xml",
					success : function(data) {
						var $data = $(data).find("boxOfficeResult>dailyBoxOfficeList>dailyBoxOffice");
						if ($data.length > 0) {
							var table = $("<table/>").attr("class", "table table-dark table-sm table-hover");
							var thead = $("<thead/>").append($("<tr/>"))
									.append(
											$("<th/>").html("순위"),
											$("<th/>").html("영화 제목"),
											$("<th/>").html("영화 개봉일"),
											$("<th/>").html("누적 매출액"),
											$("<th/>").html("누적 관객수"));
							var tbody = $("<tbody/>");
							$.each($data, function(key, value) {
								var $rank = $(value).find("rank").text(); // 순위
								var $movieNm = $(value).find("movieNm").text(); //영화명
								var $openDt = $(value).find("openDt").text();// 영화 개봉일
								var $salesAcc = $(value).find("salesAcc").text();//누적 매출액
								var $audiAcc = $(value).find("audiAcc").text(); //누적 관객수
								var row = $("<tr/>").append(
										$("<td/>").text($rank),
										$("<td/>").text($movieNm),
										$("<td/>").text($openDt),
										$("<td/>").text($salesAcc),
										$("<td/>").text($audiAcc));

								tbody.append(row);
							});
							table.append(thead);
							table.append(tbody);
							$(".wrap").append(table);
						}
					},
					error : function() {
						alert("에러 발생");
					}
				});
	});
</script>

<style type="text/css">
</style>
</head>
<body>
	<div class="wrap contaner">
		<jsp:include page="../menu.jsp" flush="false"/>
	</div>
</body>
</html>
