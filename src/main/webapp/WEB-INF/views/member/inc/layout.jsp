<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- viewport 휴대폰 화면에서 보여질 영역의 크기를 지정 
	user-scalable = 1이면 사용자 zoomin을 허용, 0이면 변화없게 막아두는것 -->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=1">
<link href="/resources/css/style.css" type="text/css" rel="stylesheet" />

<title>Insert title here</title>
</head>
<body>
	<tiles:insertAttribute name="header" /> <!-- name은 페이지 중 하나의 이름 -->
	<tiles:insertAttribute name="main" />
<%-- 	<tiles:insertAttribute name="footer" /> --%>
</body>
</html>