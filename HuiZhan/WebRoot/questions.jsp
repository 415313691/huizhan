<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>后台管理</title>
 <link href="source/images/logo1.png" type="image/x-icon" rel="shortcut icon" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="source/css/bootstrap.min.css" />

<link href="source/css/jquery.mmenu.css" rel="stylesheet">

<!-- css页面 -->
<link href="source/css/font-awesome.min.css" rel="stylesheet">
<link href="plugins/jquery-ui/css/jquery-ui-1.10.4.min.css" rel="stylesheet">	

<!-- 模板的自定义样式 -->
<link href="source/css/style.min.css" rel="stylesheet">
<link href="source/css/add-ons.min.css" rel="stylesheet">

<link href="source/css/atom-style.css" rel="stylesheet">
<link href="source/css/minimal.css" rel="stylesheet">


<!--时间控件-->

        <link href="source/date/css/bootstrap-datetimepicker.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="js/html5shiv.js"></script>
            <script src="js/respond.min.js"></script>
        <![endif]-->
		<script type="text/javascript" src="source/date/js/jquery-2.1.1.min.js"></script>
		<script type="text/javascript" src="source/date/js/bootstrap.min.js"></script>
		<script src="source/date/js/moment-with-locales.js"></script>
		<script src="source/date/js/bootstrap-datetimepicker.js"></script>
</head>
<body>
<div id="wrap">
    <!-- start: Header -->
<div class="navbar" role="navigation">
    <!--logo start-->
    <div class="profile">
        <div class="logo"><a href="#"><img src="source/images/logo_03.png" alt=""></a></div>
    </div>
    <!--logo end-->  
</div>
<!-- end: Header -->


<jsp:include page="public/left.jsp"></jsp:include>
 <!-- start: Content -->
<div class="main" style="min-height:850px;">
 
		<div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div data-original-title="" class="panel-heading">
                        <h2><i class="fa fa-user"></i><span class="break"></span>问题列表</h2>
                        <a href="sysAction_before_editQuestion" class="btn btn-danger" title="下架" style=" float:right; margin-top:3px;">
                         新增问题
                        </a>
                    </div>
                    
                    <div class="panel-body">
                        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline no-footer">

                            <table id="datatable" class="table table-striped table-bordered bootstrap-datatable" cellspacing="0" width="100%">
                            <thead>
                            <tr role="row">
                                <th>题目标题</th>
                                <th>状态</th>
                                <th>难度</th>
                                <th>操作</th>
                                <th>设置答案</th>
                            </tr>
                            </thead>
                            <tbody>
                             <c:forEach items="${page.result}" var="obj">
                             <tr role="row">
                                    <td>${obj.questionTitle }</td>
                                    <td><c:if test="${obj.questionIsdel=='0' }">可用</c:if>
                                    <c:if test="${obj.questionIsdel=='1' }">不可用</c:if>
                                    </td>
                                        <td><c:if test="${obj.questionClass=='0' }">简单</c:if>
                                     	 <c:if test="${obj.questionClass=='1' }">一般</c:if>
                                     	 <c:if test="${obj.questionClass=='2' }">困难</c:if>
                                     	 <c:if test="${obj.questionClass=='3' }">科普</c:if>
                                     </td>
                                    <td>
                                        <a href="sysAction_delQuestion?id=${obj.questionId }" onclick="if(confirm('确认要设置为不可用吗？')==false)return false;" class="btn btn-success"  title="删除">
                                            <i class="fa fa-copy"></i>
                                        </a>
                                        <a href="sysAction_before_editQuestion?id=${obj.questionId }" class="btn btn-info" title="编辑">
                                            <i class="fa fa-edit"></i>
                                        </a>
                                         
                                    </td>
                                     <td>
                                        <a href="sysAction_setAnswer?id=${obj.questionId }" class="btn btn-success"  title="设置答案">
                                            <i class="fa fa-copy"></i>
                                        </a>
                                    </td>
                                </tr>
                             </c:forEach>
                            </tbody>
                            </table>
                          <jsp:include page="public/page.jsp"/>
                            <form action="<%=basePath%>sysAction_findAllQuestion" method="post" id="pageForm">
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
