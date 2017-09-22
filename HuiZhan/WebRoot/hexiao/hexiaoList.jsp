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
<title>紫弘科技用户后台管理</title>
 <link href="<%=basePath %>source/images/name.png" type="image/x-icon" rel="shortcut icon" />
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
<link href="<%=basePath %>source/date/css/bootstrap-datetimepicker.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath %>source/date/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>source/date/js/bootstrap.min.js"></script>
<script src="<%=basePath %>source/date/js/moment-with-locales.js"></script>
<script src="<%=basePath %>source/date/js/bootstrap-datetimepicker.js"></script>
</head>
<body>
<div id="wrap">
    <!-- start: Header -->
<jsp:include page="../public/head.jsp"></jsp:include>
<!-- end: Header -->


<jsp:include page="../public/left.jsp"></jsp:include>
 <!-- start: Content -->
<div class="main" style="min-height:850px;">
		<div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div data-original-title="" class="panel-heading">
                        <h2 style="display: block;"><i class="fa fa-user"></i><span class="break"></span>商品兑换列表</h2>
                        <form action="productAction_findUserProduct" method="POST">
                        	<div style="display: inline-block;"><span style="display: inline-block;margin-right: 7px;">状态: </span><select class="form-control" name="states" style="width:180px;display: inline-block;">
                        		<option  value="">请选择</option>
                        		<option <c:if test="${states=='Y' }">selected="selected"</c:if> value="Y">已核销</option>
                        		<option <c:if test="${states=='N' }">selected="selected"</c:if> value="N">未核销</option>
                        	</select>
                        	</div>
                        	<div style="display: inline-block;"><span style="display: inline-block;margin-right: 7px;">核销码:</span><input name="pass" value="${pass }" class="form-control" type="text" style="width:180px;display: inline-block;"/></div>
                        	<div style="display: inline-block;"><span style="display: inline-block;margin-right: 7px;"></span><input class="btn btn-danger btn-lg" style="height:35px;" type="submit" value="查询"/></div>
                        	</form>
                    </div>
                    
                    <div class="panel-body">
                        <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline no-footer">
		
                            <table id="datatable" class="table table-striped table-bordered bootstrap-datatable" cellspacing="0" width="100%">
                            <thead>
                            <tr role="row">
                                <th>产品名称</th>
                                <th>所需金币</th>
                                <th>核销码</th>
                               	<th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                             <c:forEach items="${page.result}" var="obj">
                             <tr role="row">
                                     <td>${obj.productName }</td>
                                     <td>${obj.delJifen }</td>
                                     <td>${obj.puPass }</td>
                                  
                                     <td><c:if test="${obj.puStatus=='N' }">未核销</c:if>
                                     	 <c:if test="${obj.puStatus=='Y' }">已核销</c:if></td>
                                    <td>
                                    <c:if test="${obj.puStatus=='N' }"> 
                                        <a href="productAction_HeXiao?id=${obj.puId }" onclick="if(confirm('确认要核销该记录吗？')==false)return false;" class="btn btn-success"  title="核销">
                                            <i class="fa fa-copy"></i>
                                        </a>
                                        </c:if>
                                        <c:if test="${obj.puStatus=='Y' }">已核销</c:if>
                                    </td>
                                </tr>
                             </c:forEach>
                            </tbody>
                            </table>
                          <jsp:include page="../public/page.jsp"></jsp:include>
                            <form action="<%=basePath%>productAction_findUserProduct" method="post" id="pageForm">
       					 	<input type="hidden" name="currentPage" id="curPage" />
       					 	<input type="hidden" name="states" value="${states}"/>
       					 	<input type="hidden" name="pass" value="${pass}"/>
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
