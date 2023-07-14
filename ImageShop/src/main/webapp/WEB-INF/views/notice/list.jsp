<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h2><spring:message code="notice.header.list" /></h2>

<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="register"><spring:message code="action.new" /></a>
</sec:authorize>

<table border="1">
	<tr>
		<th align="center" width="80"><spring:message code="notice.no" /></th>
		<th align="center" width="320"><spring:message code="notice.title" /></th>
		<th align="center" width="180"><spring:message code="notice.regdate" /></th>
	</tr>
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td colspan="3">
					<spring:message code="common.listEmpty" />
				</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="notice">
				<tr>
					<td align="center">${notice.noticeNo}</td>
					<td align="left"><a href="/notice/read?noticeNo=${notice.noticeNo}"><c:out value="${notice.title}" /></a></td>
					<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${notice.regDate}" /></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

<script>
	var result = "${msg}";

	if (result === "SUCCESS") {
		alert("<spring:message code='common.processSuccess' />");
	}
</script>
