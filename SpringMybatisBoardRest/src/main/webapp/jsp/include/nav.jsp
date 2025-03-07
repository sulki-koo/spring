<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="requestURI" value="${pageContext.request.requestURI}" />

<c:if test="${fn:contains(requestURI, '/article')}">
	<c:set var="articleActive" value=" active" />
</c:if>
<c:if test="${fn:contains(requestURI, '/board')}">
	<c:set var="boardActive" value=" active" />
</c:if>
<c:if test="${fn:contains(requestURI, '/member')}">
	<c:set var="memberActive" value=" active" />
</c:if>

<nav>
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a href="/article/articles" class="nav-link${articleActive}">게시물관리</a></li>
		<li class="nav-item"><a href="/board/boards" class="nav-link${boardActive}">게시판관리</a></li>
		<li class="nav-item"><a href="/member/members" class="nav-link${memberActive}">회원관리</a></li>
	</ul>
</nav>