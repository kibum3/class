<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="item.header.modify" /></h2>

<form:form modelAttribute="item" action="modify" enctype="multipart/form-data">
	<form:hidden path="itemId" />
	<form:hidden path="pictureUrl" />
	<form:hidden path="previewUrl" />

	<table>
		<tr>
			<td><spring:message code="item.itemName" /></td>
			<td><form:input path="itemName" /></td>
			<td><font color="red"><form:errors path="itemName" /></font></td>
		</tr>
		<tr>
			<td><spring:message code="item.itemPrice" /></td>
			<td><form:input path="price" />&nbsp;원
			</td>
			<td><font color="red"><form:errors path="price" /></font></td>
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
			<td><spring:message code="item.itemFile" /></td>
			<td><input type="file" name="picture" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="item.itemPreviewFile" /></td>
			<td><input type="file" name="preview" /></td>
			<td></td>
		</tr>
		<tr>
			<td><spring:message code="item.itemDescription" /></td>
			<td><form:textarea path="description" /></td>
			<td><font color="red"><form:errors path="description" /></font></td>
		</tr>
	</table>
	
</form:form>

<div>
	<button type="submit" id="btnModify"><spring:message code="action.modify" /></button>
	<button type="submit" id="btnList"><spring:message code="action.list" /></button>
</div>

<script>
	$(document).ready(function() {

		var formObj = $("#item");

		$("#btnModify").on("click", function() {
			formObj.submit();
		});

		$("#btnList").on("click", function() {
			self.location = "list";
		});

	});
</script>
