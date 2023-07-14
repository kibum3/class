<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="auth.header.login" /></h2>
<h2>
	<c:out value="${error}" />
</h2>
<h2>
	<c:out value="${logout}" />
</h2>
<form method="post" action="/login">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="username"></td>	
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="checkbox" name="remember-me"><spring:message code="auth.rememberMe" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button><spring:message code="action.login" /></button></td>
		</tr>
	</table>
	<sec:csrfInput />
</form>
