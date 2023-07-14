<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" />
	
	<tiles:insertAttribute name="menu" />
	
	<div align="center">
		<tiles:insertAttribute name="content" />
	</div>
	
	<tiles:insertAttribute name="footer" />
</body>
</html>
