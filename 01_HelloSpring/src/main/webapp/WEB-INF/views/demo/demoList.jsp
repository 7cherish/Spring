<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<!-- '/'WEB-INF 에서 '/'는 webapp을 가리킨다. -->
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Dev목록" name="pageTitle" />
</jsp:include>
<table class="table">
	<tr>
		<th scope="col">번호</th>
		<th scope="col">이름</th>
		<th scope="col">나이</th>
		<th scope="col">이메일</th>
		<th scope="col">성별</th>
		<th scope="col">개발가능언어</th>
	</tr>
	<c:if test="${not empty list }">
		<c:forEach var="dev" items="${list }">
			<tr>
				<td>${dev.devNo}</td>
				<td>${dev.devName}</td>
				<td>${dev.devAge}</td>
				<td>${dev.devEmail}</td>
				<td>${dev.devGender}</td>
				<td>
					<c:forEach items="${dev.devLang}" var="lang" varStatus="vs">
                     	${lang}${!vs.last?",":""}  
                  	</c:forEach>
               	</td>
			</tr>

		</c:forEach>
	</c:if>
	<c:if test="${empty list}">
		<tr>
			<td colspan="6" align="center">dev목록이 없습니다.</td>
		</tr>
	</c:if>
</table>


<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>