<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<!-- jstl 사용을 위한 설정  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
<c:forEach var="list" items="${list}">
<p>${list.bno}</p>
<p>${list.email}</p>
<p>${list.title}</p>
<p>${list.content}</p>
<p>${list.ip}</p>

</c:forEach>
</section>

<%@include file="../include/footer.jsp"%>