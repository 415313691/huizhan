<%@ page language="java" import="java.util.*,java.io.*,com.huizhan.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

RearProperties reader = new RearProperties();
String targetPath =reader.getValue("path.properties", "read_file");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户后台管理</title>
 <link href="<%=basePath %>source/images/logo1.png" type="image/x-icon" rel="shortcut icon" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="<%=basePath %>source/css/bootstrap.min.css" />

<link href="<%=basePath %>source/css/jquery.mmenu.css" rel="stylesheet">

<!-- css页面 -->
<link href="<%=basePath %>source/css/font-awesome.min.css" rel="stylesheet">

<!-- 模板的自定义样式 -->
<link href="<%=basePath %>source/css/style.min.css" rel="stylesheet">
<link href="<%=basePath %>source/css/add-ons.min.css" rel="stylesheet">

<link href="<%=basePath %>source/css/atom-style.css" rel="stylesheet">
<link href="<%=basePath %>source/css/minimal.css" rel="stylesheet">

<script type="text/javascript" src="<%=basePath %>source/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="wrap">
    <!-- start: Header -->
<div class="navbar" role="navigation">
    <!--logo start-->
    <div class="profile">
        <div class="logo"><a href="#"><img src="<%=basePath %>source/images/logo_03.png" alt=""></a></div>
    </div>
    <!--logo end-->  
</div>
<!-- end: Header -->


<jsp:include page="../public/left.jsp"></jsp:include>
 <!-- start: Content -->
<div class="main" style="min-height:850px;">
 
		<div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div data-original-title="" class="panel-heading">
                        <h2><i class="fa fa-user"></i><span class="break"></span>优惠券列表</h2>
                        
                    </div>
                    
                    <div class="panel-body">
                        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline no-footer">

                            <table id="datatable" class="table table-striped table-bordered bootstrap-datatable" cellspacing="0" width="100%">
                            <thead>
                            <tr role="row">
                                <th>活动名称</th>
                                <th>优惠券名称</th>
                                <th>优惠券唯一码</th>
                                <th>奖励时间</th>
                                <th>状态</th>
                                <th>有效期</th>
                            </tr>
                            </thead>
                            <tbody>
                             <c:forEach items="${page.result}" var="obj">
                             <tr role="row">
                                     <td>${obj.activityName }</td>
                                     <td>${obj.yhqName }</td>
                                     <td>${obj.yhqPassword }</td>
                                     <td><fmt:formatDate value="${obj.yhqDatetime }" type="date" dateStyle="full"/></td>
                                     <td>
                                      <c:if test="${obj.yhqIswriteoff=='0'}">已使用</c:if>
                                      <c:if test="${obj.yhqIswriteoff=='1'}">未使用</c:if>
                                     </td>
                                      <td>${obj.beginTime }至${obj.endTime }</td>
                                </tr>
                             </c:forEach>
                            </tbody>
                            </table>
                          <jsp:include page="../public/page.jsp"/>
                            <form action="<%=basePath%>userAction_findYhq" method="post" id="pageForm">
       					 	<input type="hidden" name="currentPage" id="curPage" />
    						</form>
                        </div><!--row-->            
                    </div>
                </div>
            </div>
        </div>
        
</div><!--main-->
    <!-- end: Content -->
	<footer>
			<div class="row">
				<div class="col-sm-6">
				 Copyright &copy;2015-2016 dataingbank.com All Rights Reserved.
				</div>
				<div class="col-sm-6">
					用户后台管理系统
				</div>
			</div>
		</footer>
</div><!--warp-->

</body>
<script type="text/javascript">
    function nowPage(pageNum) {
        document.getElementById("curPage").value = pageNum;
        document.getElementById("pageForm").submit();
    }
</script>
</html>
