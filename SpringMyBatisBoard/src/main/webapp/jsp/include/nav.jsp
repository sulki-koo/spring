<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<c:set var="requestURI" value="${requestScope.requestURI}" />
<c:if test="${fn:contains(requestURI, 'Article')}">
	<c:set var="articleActive" value=" active" />
</c:if>
<c:if test="${fn:contains(requestURI, 'Board')}">
	<c:set var="boardActive" value=" active" />
</c:if>
<c:if test="${fn:contains(requestURI, 'Member')}">
	<c:set var="memberActive" value=" active" />
</c:if>

<nav>
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a href="/selectArticle.do" class="nav-link${articleActive}">게시물관리</a></li>
		<li class="nav-item"><a href="/selectBoard.do" class="nav-link${boardActive}">게시판관리</a></li>
		<li class="nav-item"><a href="/selectMember.do" class="nav-link${memberActive}">회원관리</a></li>
	</ul>
</nav>