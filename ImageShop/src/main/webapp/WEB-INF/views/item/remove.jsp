<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="item.header.remove" /></h2>
<form:form modelAttribute="item" action="remove">
	<form:hidden path="itemId" />
	
	<table>
		<tr>
			<td><spring:message code="item.itemName" /></td>
			<td><form:input path="itemName" disabled="true" /></td>
		</tr>
		<tr>
			<td><spring:message code="item.itemPrice" /></td>
			<td><form:input path="price" disabled="true" />&nbsp;원
			</td>
		</tr>
		<tr>
			<td><spring:message code="item.picture" /></td>
			<td><img src="picture?itemId=${item.itemId}" width="210"></td>
		</tr>			
		<tr>
			<td><spring:message code="item.preview" /></td>
			<td><img src="display?itemId=${item.itemId}" width="210"></td>
		</tr>
		<tr>
			<td><spring:message code="item.itemDescription" /></td>
			<td><form:textarea path="description" disabled="true" /></td>
		</tr>
	</table>
</form:form>

<div>
	<button type="submit" id="btnRemove"><spring:message code="action.remove" /></button>
	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#item");

		$("#btnRemove").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});
</script>
