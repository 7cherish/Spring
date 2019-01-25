<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<fmt:requestEncoding value="UTF-8" />
<!-- '/'WEB-INF 에서 '/'는 webapp을 가리킨다. -->

<!-- 주석 안에 태그가 있으면 파싱할때 주석으로 인식하지 않아서 에러 발생함 <%-- --%> 주석 사용할 것 -->
<%-- <jsp:param value="Demo" /> value에는 header.jsp에 전달할 값을 적어준다. --%> 
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Demo" name="pageTitle" />
</jsp:include>

<div id="demo-container">
		<!-- https://getbootstrap.com/docs/4.1/components/forms/#readonly-plain-text -->
		<form id="devFrm">
			<div class="form-group row">
			<label for="devName" class="col-sm-2 col-form-label">이름</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="devName" name="devName">
			</div>
			</div>
			<div class="form-group row">
			<label for="devAge" class="col-sm-2 col-form-label">나이</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="devAge" name="devAge">
			</div>
			</div>
			<div class="form-group row">
			<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="devEmail" name="devEmail">
			</div>
			</div>
			<!-- https://getbootstrap.com/docs/4.1/components/forms/#inline -->
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="devGender" id="devGender0" value="M">
					<label class="form-check-label" for="devGender0">남</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="devGender" id="devGender1" value="F">
					<label class="form-check-label" for="devGender1">여</label>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">개발언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java">
					<label class="form-check-label" for="devLang0">Java</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C">
					<label class="form-check-label" for="devLang1">C</label>
					</div>
					<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript">
					<label class="form-check-label" for="devLang2">Javascript</label>
					</div>
				</div>
			</div>
			<!-- 전송버튼 -->
			<div class="list-group" >
				<button type="button" onclick="demo1();" class="list-group-item list-group-item-action">
				파라미터 핸들링 - HttpServletRequest
				</button>
				<button type="button" onclick="demo2();" class="list-group-item list-group-item-action">
				파라미터 핸들링 - @RequestParam
				</button>
				<button type="button" onclick="demo3();" class="list-group-item list-group-item-action">
				파라미터 핸들링 - Command객체 - vo
				</button>
				<button type="button" onclick="insertDev();" class="list-group-item list-group-item-action">
				Dev등록(DB)
				</button>
			</div>
		</form>
	</div>

<style>
div#demo-container{
	width:40%;
	padding:15px;
	margin:0 auto;
	border:1px solid lightgray;
	border-radius: 10px;
}
</style>
<script>
function demo1(){
	// 절대주소 : ${pageContext.request.contextPath}/demo/demo1.do
	// 상대주소 : demo1.do -> 현재 디렉토리를 /spring/demo/로 가정함.
	$("#devFrm").attr("action", "${pageContext.request.contextPath}/demo/demo1.do");
	$("#devFrm").submit();
}

function demo2(){
	// 절대주소 : ${pageContext.request.contextPath}/demo/demo2.do
	// 상대주소 : demo2.do -> 현재 디렉토리를 /spring/demo/로 가정함.
	$("#devFrm").attr("action", "demo2.do");
	$("#devFrm").submit();
}

function demo3(){
	// 절대주소 : ${pageContext.request.contextPath}/demo/demo3.do
	// 상대주소 : demo3.do -> 현재 디렉토리를 /spring/demo/로 가정함.
	$("#devFrm").attr("action", "demo3.do");
	$("#devFrm").submit();
}

function insertDev(){
	// 절대주소 : ${pageContext.request.contextPath}/demo/insertDev.do
	// 상대주소 : insertDev.do -> 현재 디렉토리를 /spring/demo/로 가정함.
	$("#devFrm").attr("action", "insertDev.do");
	$("#devFrm").attr("method", "post");
	$("#devFrm").submit();
}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>