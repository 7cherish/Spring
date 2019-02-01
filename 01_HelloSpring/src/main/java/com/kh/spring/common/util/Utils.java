/*
 * package com.kh.spring.common.util;
 * 
 * public class Utils {
 * 
 * 
 * 
 * //com.kh.spring.common.util.Utils.getPageBar(totalContents , cPage ,
 * numPerPage , "boardList.do")
 * 
 * public static String getPageBar(int totalContent , int cPage , int numPerPage
 * , String root) {
 * 
 * 
 * 
 * int totalPage = (int)Math.ceil((double)totalContent/numPerPage);
 * 
 * 
 * String pageBar = ""; //페이지바 길이 int pageBarSize = 5;
 * 
 * int startPage = ((cPage-1)/pageBarSize)*pageBarSize +1 ; int endPage =
 * startPage + pageBarSize - 1;
 * 
 * int pageNo = startPage;
 * 
 * //[이전]section if(pageNo == 1) {
 * 
 * }else { pageBar +=
 * "<li class='page-item '><a class='page-link' href='"+root+"?cPage="
 * +(pageNo-1)+"&numPerPage=" +numPerPage+"'>[이전]</a></li>";
 * 
 * }
 * 
 * //[페이지]section while(pageNo <= endPage && pageNo <= totalPage) { if(cPage ==
 * pageNo) {
 * 
 * pageBar +=
 * " <li class='page-item disabled'><a class='page-link' href='#'>"+pageNo+
 * "</a></li>";
 * 
 * }else { pageBar +=
 * " <li class='page-item'><a class='page-link' href='"+root+"?cPage="
 * +pageNo+"&numPerPage=" +numPerPage+"'>"+pageNo+"</a></li>"; } pageNo++;
 * 
 * }
 * 
 * //[다음]section if(pageNo > totalPage) {
 * 
 * }else { pageBar +=
 * " <li class='page-item'><a class='page-link' href='"+root+"?cPage="
 * +pageNo+"&numPerPage=" +numPerPage+"'>[다음]</a></li>"; } return pageBar; }
 * 
 * 
 * }
 */

package com.kh.spring.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static String getPageBar(int totalContents, int cPage, int numPerPage, String url ){
		String pageBar = "";
		int pageBarSize = 5;
		cPage = cPage==0?1:cPage;
		
		//총페이지수 구하기
		int totalPage = (int)Math.ceil((double)totalContents/numPerPage);
		
		//1.pageBar작성
		//pageBar순회용변수 
		int pageNo = ((cPage - 1)/pageBarSize) * pageBarSize +1;
		//종료페이지 번호 세팅
		int pageEnd = pageNo+pageBarSize-1;
		System.out.println("pageStart["+pageNo+"] ~ pageEnd["+pageEnd+"]");
		
		pageBar += "<ul class='pagination justify-content-center pagination-sm'>";
		//[이전]section
		if(pageNo == 1 ){
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#' tabindex='-1'>이전</a>";
			pageBar += "</li>";
		}
		else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:fn_paging("+(pageNo-1)+")'>이전</a>";
			pageBar += "</li>";
		}
		
		// pageNo section
		while(!(pageNo>pageEnd || pageNo > totalPage)){
			if(cPage == pageNo ){
				pageBar += "<li class='page-item active'>";
				pageBar += "<a class='page-link'>"+pageNo+"</a>";
				pageBar += "</li>";
			} 
			else {
				pageBar += "<li class='page-item'>";
				pageBar += "<a class='page-link' href='javascript:fn_paging("+pageNo+")'>"+pageNo+"</a>";
				pageBar += "</li>";
			}
			pageNo++;
		}
		
		//[다음] section
		if(pageNo > totalPage){
			pageBar += "<li class='page-item disabled'>";
			pageBar += "<a class='page-link' href='#'>다음</a>";
			pageBar += "</li>";
			
		} else {
			pageBar += "<li class='page-item'>";
			pageBar += "<a class='page-link' href='javascript:fn_paging("+pageNo+")'>다음</a> ";
			pageBar += "</li>";
		}
		
		pageBar += "</ul>";
		
		//2.스크립트 태그 작성
		//fn_paging함수
		pageBar += "<script>";
		pageBar += "function fn_paging(cPage){";
		pageBar += "location.href='"+url+"?cPage='+cPage;";
		pageBar += "}";
		pageBar += "</script>";
		
		return pageBar; 
	}

	public static String getRenamedFileName(String originalFileName) {
		// 확장자 분리
		String ext = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
		
		// 파일명
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
		
		// 난수생성
		int rndNum = (int)(Math.random() * 1000);
		
		return sdf.format(new Date()) + "_" + rndNum + "." + ext;
	}

}
