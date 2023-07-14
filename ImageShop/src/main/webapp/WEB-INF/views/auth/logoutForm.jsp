<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="auth.header.logout" /></h2>

<form action="/auth/logout" method="post">
	<sec:csrfInput />
	<button><spring:message code="action.logout" /></button>
</form>
