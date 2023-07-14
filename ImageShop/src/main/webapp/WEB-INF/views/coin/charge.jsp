<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="coin.header.chargeCoin" /></h2>

<form:form modelAttribute="chargeCoin" action="charge">
	<table>
		<tr>
			<td><spring:message code="coin.amount" /></td>
			<td><form:input path="amount" /></td>
			<td><font color="red"><form:errors path="amount" /></font></td>
		</tr>
	</table>
</form:form>

<div>
	<button type="submit" id="btnCharge"><spring:message code="action.charge" /></button>
	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#chargeCoin");

		$("#btnCharge").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});
</script>
