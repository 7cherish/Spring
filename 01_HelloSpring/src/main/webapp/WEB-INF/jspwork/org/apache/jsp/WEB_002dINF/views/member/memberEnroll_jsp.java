/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-01-28 10:00:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberEnroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1548663971475L));
    _jspx_dependants.put("jar:file:/E:/Workspaces/sts_workspace/01_HelloSpring/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fn.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/E:/Workspaces/sts_workspace/01_HelloSpring/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
    _jspx_dependants.put("jar:file:/E:/Workspaces/sts_workspace/01_HelloSpring/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/fmt.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_fmt_005frequestEncoding_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!-- '/'WEB-INF 에서 '/'는 webapp을 가리킨다. -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("pageTitle", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("회원등록", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("<div id=\"enroll-container\">\r\n");
      out.write("\t<form name=\"memberEnrollFrm\"\r\n");
      out.write("\t\t  action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/member/memberEnrollEnd.do\"\r\n");
      out.write("\t\t  method=\"post\" onsubmit=\"return validate();\">\r\n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" placeholder=\"아이디 (4글자이상)\" name=\"memberId\" id=\"memberId_\" required> \r\n");
      out.write("\t\t<input type=\"password\" class=\"form-control\" placeholder=\"비밀번호\" name=\"password\" id=\"password_\" required> \r\n");
      out.write("\t\t<input type=\"password\" class=\"form-control\" placeholder=\"비밀번호확인\" id=\"password2\" required> \r\n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" placeholder=\"이름\" name=\"memberName\" id=\"memberName\" required> \r\n");
      out.write("\t\t<input type=\"number\" class=\"form-control\" placeholder=\"나이\" name=\"age\" id=\"age\"> \r\n");
      out.write("\t\t<input type=\"email\" class=\"form-control\" placeholder=\"이메일\" name=\"email\" id=\"email\" required> \r\n");
      out.write("\t\t<input type=\"tel\" class=\"form-control\" placeholder=\"전화번호 (예:01012345678)\" name=\"phone\" id=\"phone\" maxlength=\"11\" required> \r\n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" placeholder=\"주소\" name=\"address\" id=\"address\">\r\n");
      out.write("\t\t<select class=\"form-control\" name=\"gender\" required>\r\n");
      out.write("\t\t\t<option value=\"\" disabled selected>성별</option>\r\n");
      out.write("\t\t\t<option value=\"M\">남</option>\r\n");
      out.write("\t\t\t<option value=\"F\">여</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<div class=\"form-check-inline form-check\">\r\n");
      out.write("\t\t\t취미 : &nbsp; \r\n");
      out.write("\t\t\t<input type=\"checkbox\" class=\"form-check-input\" name=\"hobby\" id=\"hobby0\" value=\"운동\">\r\n");
      out.write("\t\t\t<label for=\"hobby0\" class=\"form-check-label\">운동</label>&nbsp; \r\n");
      out.write("\t\t\t<input type=\"checkbox\" class=\"form-check-input\" name=\"hobby\" id=\"hobby1\" value=\"등산\">\r\n");
      out.write("\t\t\t<label for=\"hobby1\" class=\"form-check-label\">등산</label>&nbsp; \r\n");
      out.write("\t\t\t<input type=\"checkbox\" class=\"form-check-input\" name=\"hobby\" id=\"hobby2\" value=\"독서\">\r\n");
      out.write("\t\t\t<label for=\"hobby2\" class=\"form-check-label\">독서</label>&nbsp;\r\n");
      out.write("\t\t\t<input type=\"checkbox\" class=\"form-check-input\" name=\"hobby\" id=\"hobby3\" value=\"게임\">\r\n");
      out.write("\t\t\t<label for=\"hobby3\" class=\"form-check-label\">게임</label>&nbsp; \r\n");
      out.write("\t\t\t<input type=\"checkbox\" class=\"form-check-input\" name=\"hobby\" id=\"hobby4\" value=\"여행\">\r\n");
      out.write("\t\t\t<label for=\"hobby4\" class=\"form-check-label\">여행</label>&nbsp;\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<br /> \r\n");
      out.write("\t\t<input type=\"submit\" class=\"btn btn-outline-success\" value=\"가입\">&nbsp; \r\n");
      out.write("\t\t<input type=\"reset\" class=\"btn btn-outline-success\" value=\"취소\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("div#enroll-container {\r\n");
      out.write("\twidth: 400px;\r\n");
      out.write("\tmargin: 0 auto;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div#enroll-container input, div#enroll-container select {\r\n");
      out.write("\tmargin-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("/**\r\n");
      out.write(" * 아이디 최소 4자리\r\n");
      out.write(" * 비밀번호 /비밀번호 체크 일치 여부\r\n");
      out.write(" * \r\n");
      out.write(" */\r\n");
      out.write("function validate(){\r\n");
      out.write("   \r\n");
      out.write("   if($(\"#memberId_\").val().trim().length < 4){\r\n");
      out.write("      alert(\"아이디는 4글자 이상 입력해주세요\");\r\n");
      out.write("      return false;\r\n");
      out.write("      \r\n");
      out.write("   }\r\n");
      out.write("   if($(\"#password_\").val() != $(\"#password2\").val()){\r\n");
      out.write("      alert(\"비밀번호가 일치하지 않습니다.\");\r\n");
      out.write("      return false;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_fmt_005frequestEncoding_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:requestEncoding
    org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag _jspx_th_fmt_005frequestEncoding_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag) _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.RequestEncodingTag.class);
    boolean _jspx_th_fmt_005frequestEncoding_005f0_reused = false;
    try {
      _jspx_th_fmt_005frequestEncoding_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005frequestEncoding_005f0.setParent(null);
      // /WEB-INF/views/member/memberEnroll.jsp(6,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005frequestEncoding_005f0.setValue("UTF-8");
      int _jspx_eval_fmt_005frequestEncoding_005f0 = _jspx_th_fmt_005frequestEncoding_005f0.doStartTag();
      if (_jspx_th_fmt_005frequestEncoding_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005frequestEncoding_0026_005fvalue_005fnobody.reuse(_jspx_th_fmt_005frequestEncoding_005f0);
      _jspx_th_fmt_005frequestEncoding_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005frequestEncoding_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005frequestEncoding_005f0_reused);
    }
    return false;
  }
}
