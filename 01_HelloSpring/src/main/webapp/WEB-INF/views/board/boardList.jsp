<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시판" name="pageTitle"/>
</jsp:include>
<style>
/*글쓰기버튼*/
input#btn-add{float:right; margin: 0 0 15px;}
</style>
<script>
function fn_goBoardForm(){
	location.href = "${pageContext.request.contextPath}/board/boardForm.do";
}
</script>
<section id="board-container" class="container">
	<!-- @실습문제 2 : 전체게시글 출력 -->
	<p>총 ${totalContents }건의 게시물이 있습니다.</p>
	<input type="button" value="글쓰기" id="btn-add" class="btn btn-outline-success" onclick="fn_goBoardForm();"/>
	<table id="tbl-board" class="table table-striped table-hover">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>첨부파일</th>
			<th>조회수</th>
		</tr>
		<!-- @실습문제 1 : 목록뿌리기 (첨부파일이 있으면, file.png를 노출시킨다.) -->
      <c:if test="${not empty list }">
      <c:forEach items="${list}" var="board" >
         <tr>
            <td>${board["BOARDNO"]}</td>
            <td>${board["BOARDTITLE"]}</td>
            <td>${board["BOARDWRITER"]}</td>
            <td>${board["BOARDDATE"]}</td>
            <td>
	            <c:if test ="${ board['FILECOUNT'] > 0 }" >
	            <img alt="" src="${pageContext.request.contextPath }/resources/images/file.png"">
            	</c:if>
            </td>
            <td>${board["BOARDREADCOUNT"]}</td>
         </tr>
      </c:forEach>
      
      </c:if>
	</table>
	<!-- @실습문제 3 : 페이지바 -->
	<%
		int totalContents = (int)request.getAttribute("totalContents");
		int numPerPage = (int)request.getAttribute("numPerPage");
		int cPage = (int)request.getAttribute("cPage");
	%>
<nav aria-label="Page navigation example">
  	 <ul class="pagination justify-content-center">
		<%=com.kh.spring.common.util.Utils.getPageBar(totalContents, cPage, numPerPage, "boardList.do")%>
     </ul>
</nav>
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="게시판" name="pageTitle"/>
</jsp:include>
<style>
/*글쓰기버튼*/
input#btn-add{float:right; margin: 0 0 15px;}
</style>
<script>
function fn_goBoardForm(){
	location.href = "${pageContext.request.contextPath}/board/boardForm.do";
}
$(function(){
	$("tr[no]").on("click",function(){
		var boardNo = $(this).attr("no");
		console.log("bordNo="+boardNo);
		location.href = "${pageContext.request.contextPath}/board/boardView.do?no="+boardNo;
	});
});
</script>
<section id="board-container" class="container">
	<p>총 ${totalContents }건의 게시물이 있습니다.</p>
	<input type="button" value="글쓰기" id="btn-add" class="btn btn-outline-success" onclick="fn_goBoardForm();"/>
	<table id="tbl-board" class="table table-striped table-hover">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>첨부파일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="b"> 
		<tr no="${b.BOARDNO}">
			<td>${b.BOARDNO}</td>
			<td>${b.BOARDTITLE}</td>
			<td>${b.BOARDWRITER}</td>
			<td>${b.BOARDDATE}</td>
			<td align="center">
				<c:if test="${b.FILECOUNT>0}">
					<img alt="첨부파일" src="${pageContext.request.contextPath}/resources/images/file.png" width=16px>
				</c:if>
			</td>
			<td>${b.BOARDREADCOUNT }</td>
		</tr>
		</c:forEach>
	</table>
	<%-- @실습문제 : 페이비바를 작성하는 Utils의 정적메소드작성하기 --%> 
	<% 
		//int totalContents = Integer.parseInt(String.valueOf(request.getAttribute("totalContents")));
		//int numPerPage = Integer.parseInt(String.valueOf(request.getAttribute("numPerPage")));
		int totalContents = (int)request.getAttribute("totalContents");
		int numPerPage = (int)request.getAttribute("numPerPage");
		
		//파라미터 cPage가 null이거나 "", "가나다"일때는 기본값 1로 세팅함.  
		String cPageTemp = request.getParameter("cPage");
		int cPage = 1;
		try{
			cPage = Integer.parseInt(cPageTemp);
		} catch(NumberFormatException e){
			
		}
		
	%>
	<%= com.kh.spring.common.util.Utils.getPageBar(totalContents, cPage, numPerPage, "boardList.do") %>
</section> 

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>