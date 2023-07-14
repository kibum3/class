<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="user.header.modify" /></h2>

<form:form modelAttribute="member" action="modify">
	<form:hidden path="userNo" />
	<table>
		<tr>
			<td><spring:message code="user.userId" /></td>
			<td><form:input path="userId" readonly="true" /></td>
			<td><font color="red"><form:errors path="userId" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="user.userName" /></td>
			<td><form:input path="userName" /></td>
			<td><font color="red"><form:errors path="userName" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="user.job" /></td>
			<td><form:select path="job" items="${jobList}" itemValue="value" itemLabel="label" /></td>
			<td><font color="red"><form:errors path="job" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="user.auth" /> - 1</td>
			<td>
				<form:select path="authList[0].auth">
					<form:option value="" label="=== 선택해 주세요 ===" />
				  <form:option value="ROLE_USER" label="사용자" />
				  <form:option value="ROLE_MEMBER" label="회원" />
				  <form:option value="ROLE_ADMIN" label="관리자" />
				</form:select>
			</td>
			<td><font color="red"><form:errors path="authList[0].auth" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="user.auth" /> - 2</td>
			<td>
				<form:select path="authList[1].auth">
					<form:option value="" label="=== 선택해 주세요 ===" />
				  <form:option value="ROLE_USER" label="사용자" />
				  <form:option value="ROLE_MEMBER" label="회원" />
				  <form:option value="ROLE_ADMIN" label="관리자" />
				</form:select>
			</td>
			<td><font color="red"><form:errors path="authList[1].auth" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="user.auth" /> - 3</td>
			<td>
				<form:select path="authList[2].auth">
					<form:option value="" label="=== 선택해 주세요 ===" />
				  <form:option value="ROLE_USER" label="사용자" />
				  <form:option value="ROLE_MEMBER" label="회원" />
				  <form:option value="ROLE_ADMIN" label="관리자" />
				</form:select>
			</td>
			<td><font color="red"><form:errors path="authList[2].auth" /></font></td>
		</tr>					
	</table>
</form:form>

<div>
	<button type="submit" id="btnModify"><spring:message code="action.modify" /></button>
	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#member");

		$("#btnModify").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});
</script>