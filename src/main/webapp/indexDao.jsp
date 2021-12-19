<%@page import="com.jsp.vod.dao.VodDao"%>
<%@page import="com.jsp.vod.dto.Vod"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	VodDao Dao = new VodDao();
	List<Vod> vod = new ArrayList<>();
	vod = Dao. getVodList();
	request.setAttribute("vodLists", vod);
%>

</body>
</html>