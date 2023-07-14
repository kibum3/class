<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<h2><spring:message code="pds.header.list" /></h2>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="register"><spring:message code="action.new" /></a>
</sec:authorize>

<table border="1">
	<tr class="header">
		<th align="center" width="80"><spring:message code="pds.itemId" /></th>
		<th align="center" width="320"><spring:message code="pds.itemName" /></th>
		<th align="center" width="100"><spring:message code="pds.viewCnt" /></th>
		
		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<th align="center" width="80"><spring:message code="pds.edit" /></th>
			<th align="center" width="80"><spring:message code="pds.remove" /></th>
		</sec:authorize>
	</tr>
	<c:choose>
		<c:when test="${empty itemList}">
			<tr>
			<sec:authorize access="!hasRole('ROLE_ADMIN')">
				<td colspan="3">
					<spring:message code="common.listEmpty" />
				</td>
			</sec:authorize>
			
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<td colspan="5">
					<spring:message code="common.listEmpty" />
				</td>
			</sec:authorize>			
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${itemList}" var="item">
				<tr class="record">
					<td align="center">${item.itemId}</td>
					<td align="left"><a href="/pds/read?itemId=${item.itemId}">${item.itemName}</a></td>
					<td align="right">${item.viewCnt}</td>
					
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td align="center"><a href="/pds/modify?itemId=${item.itemId}"><spring:message code="pds.edit" /></a></td>
					<td align="center"><a href="/pds/remove?itemId=${item.itemId}"><spring:message code="pds.remove" /></a></td>
				</sec:authorize>
					
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>	
</table>
