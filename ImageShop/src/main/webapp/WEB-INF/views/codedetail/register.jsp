<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="codedetail.header.register" /></h2>

<form:form modelAttribute="codeDetail" action="register">
	<table>
		<tr>
			<td><spring:message code="codedetail.groupCode" /></td>
			<td><form:select path="groupCode" items="${groupCodeList}" itemValue="value" itemLabel="label" /></td>
			<td><font color="red"><form:errors path="groupCode" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="codedetail.codeValue" /></td>
			<td><form:input path="codeValue" /></td>
			<td><font color="red"><form:errors path="codeValue" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="codedetail.codeName" /></td>
			<td><form:input path="codeName" /></td>
			<td><font color="red"><form:errors path="codeName" /></font></td>
		</tr>
	</table>
</form:form>

<div>
	<button type="submit" id="btnRegister"><spring:message code="action.register" /></button>
	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#codeDetail");

		$("#btnRegister").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});
</script>
