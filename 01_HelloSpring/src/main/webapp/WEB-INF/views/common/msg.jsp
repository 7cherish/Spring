<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<%
	String msg = (String) request.getAttribute("msg");
	String loc = request.getContextPath() + (String) request.getAttribute("loc");
	String script = (String) request.getAttribute("script");
	System.out.printf("[%s %s %s]\n", msg, loc, script);
%>
<script>
alert("<%=msg%>");
<%=script != null ? script : ""%>
location.href = "<%=loc%>";
</script>