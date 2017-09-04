<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<link href="../source/css/page.css" rel="stylesheet">
<div class="col-xs-6">
    <div class="dataTables_paginate paging_simple_numbers" id="datatable_paginate">
        <c:if test="${page.result eq null || fun:length(page.result) <= 0 }">没有符合条件的结果 </c:if>
        <c:if test="${page.result eq null || fun:length(page.result) > 0 }">
            <ul class="pagination">
                <li class="paginate_button previous" tabindex="0" aria-controls="datatable"><a href="javascript:nowPage(1);">首页</a></li>
                <c:choose>
                    <c:when test="${page.previousPage == 1}">
                        <li class="paginate_button previous" tabindex="0" aria-controls="datatable"><a href="javascript:nowPage(${page.currentPageNum - 1});" class="butNav">&laquo;上一页</a></li>
                    </c:when>
                </c:choose>
                <!-- 分页小页 -->
                <c:choose>
                    <c:when test="${page.pageNum<=3}">
                        <c:forEach var="pageindex" begin="1" end="${page.pageNum}" step="1">
                            <li <c:if test="${pageindex==page.currentPageNum}">class="active"</c:if>><a href="javascript:nowPage( ${pageindex});">${pageindex}</a></li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <c:choose>
                            <c:when test="${page.currentPageNum<3}">
                                <c:forEach var="pageindex" begin="1" end="3" step="1">
                                    <li <c:if test="${pageindex==page.currentPageNum}">class="active"</c:if>><a href="javascript:nowPage( ${pageindex});">${pageindex}</a></li>
                                </c:forEach>
                                <li <c:if test="${pageindex==page.currentPageNum}">class="active"</c:if>><a href="javascript:nowPage( ${page.pageNum})">${page.pageNum}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:nowPage( 1)" class="butNav">1</a></li>
                                <li><a>...</a></li>
                                <c:choose>
                                    <c:when test="${page.currentPageNum+3<=page.pageNum}">
                                        <c:forEach var="pageindex" begin="${page.currentPageNum-1}" end="${page.currentPageNum}" step="1">
                                            <li <c:if test="${pageindex==page.currentPageNum}">class="active"</c:if>><a href="javascript:nowPage( ${pageindex});">${pageindex}</a></li>
                                        </c:forEach>
                                        <c:forEach var="pageindex" begin="${page.currentPageNum+1}" end="${page.currentPageNum+2}" step="1">
                                            <li <c:if test="${pageindex==page.currentPageNum}">class="active"</c:if>><a href="javascript:nowPage( ${pageindex});">${pageindex}</a></li>
                                        </c:forEach>
                                        <li <c:if test="${pageindex==page.currentPageNum}">class="active"</c:if>><a href="javascript:nowPage( ${page.pageNum})">${page.pageNum}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="pageindex" begin="${page.currentPageNum-1}" end="${page.pageNum}" step="1">
                                            <li <c:if test="${pageindex==page.currentPageNum}">class="active"</c:if>><a href="javascript:nowPage( ${pageindex});">${pageindex}</a></li>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <!-- 分页小页结束 -->
                <c:choose>
                    <c:when test="${page.nextPage == 1}">
                        <li  class="paginate_button previous" ><a href="javascript:nowPage(${page.currentPageNum + 1});">下一页&raquo;</a></li>
                    </c:when>
                </c:choose>
                <li  class="paginate_button previous"><a href="javascript:nowPage( ${page.pageNum});">尾页</a></li>
            </ul>
        </c:if>

    </div>
</div>

