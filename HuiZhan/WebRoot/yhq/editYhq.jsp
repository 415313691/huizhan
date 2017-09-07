<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户后台管理</title>
 <link href="<%=basePath %>source/images/logo1.png" type="image/x-icon" rel="shortcut icon" />
<!-- Bootstrap core CSS -->
<link href="<%=basePath %>source/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath %>source/css/jquery.mmenu.css" rel="stylesheet">

<!-- css页面 -->
<link href="<%=basePath %>source/css/font-awesome.min.css" rel="stylesheet">

<!-- 模板的自定义样式 -->
<link href="<%=basePath %>source/css/style.min.css" rel="stylesheet">
<link href="<%=basePath %>source/css/add-ons.min.css" rel="stylesheet">

<link href="<%=basePath %>source/css/atom-style.css" rel="stylesheet">
<link href="<%=basePath %>source/css/minimal.css" rel="stylesheet">
<link href="<%=basePath %>source/css/iconfont.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath %>source/css/fileUpload.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="<%=basePath %>source/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>source/js/fileUpload.js"></script>
<script type="text/javascript" src="<%=basePath %>/source/js/laydate.dev.js"></script>
<script type="text/javascript" src="<%=basePath %>/source/js/jquery.validate.min.js"></script>

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
<jsp:include page="../public/left.jsp"/>
 <!-- start: Content -->
<div class="main" style="min-height:850px;">
	<div class="row">
			<div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2><i class="fa fa-pencil-square-o"></i><span class="break"></span><strong>活动信息</strong></h2>
                    </div>
                    <div class="panel-body">
                    <form name="editForm" id="editForm" method="post" action="yhqAction_saveYhq" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-2 control-label">所属活动：</label>
                            <div class="col-md-4">
                                <select name="yhq.activityId" id="activityId" class="form-control">
                                	 <option value="">------请选择 ------</option>
                                	 <c:forEach items="${activitys }" var="activity">
                                	 <option <c:if test="${yhq.activityId ==activity.activityId}">selected="selected"</c:if> value="${activity.activityId }">${activity.activityName } </option>
                                	 </c:forEach>
                                </select>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="col-md-2 control-label">优惠券名称：</label>
                            <div class="col-md-4">
                                <input name="yhq.yhqName" value="${yhq.yhqName }" type="text" id="yhqName" class="form-control">
                            </div>
                        </div> 
                        
                       
                        <div class="form-group">
                            <label class="col-md-2 control-label">开始时间：</label>
                             <div class="col-md-4">
                                <input name="yhq.yhqBegintime" type="text" id="yhqBegintime" class="form-control" value="<fmt:formatDate value="${yhq.yhqBegintime}" type="date"/>" >
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">结束时间：</label>
                            <div class="col-md-4">
                                <input name="yhq.yhqEndtime" type="text" id="yhqEndtime" class="form-control" value="<fmt:formatDate value="${yhq.yhqEndtime}" type="date" />">
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">使用地点：</label>
                            <div class="col-md-4">
                                 <input name="yhq.yhqAddress" value="${yhq.yhqAddress }" type="text" id="yhqAddress" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">店名：</label>
                            <div class="col-md-4">
                                 <input name="yhq.yhqCompany" value="${yhq.yhqCompany }" type="text" id="yhqCompany" class="form-control">
                                
                            </div>
                        </div>
                       
                           <div class="form-group">
                            <label class="col-md-2 control-label">联系电话：</label>
                            <div class="col-md-4">
                                 <input name="yhq.yhqPhone" value="${yhq.yhqPhone}" type="text" id="yhqPhone" class="form-control">
                                
                            </div>
                        </div>
                        
                         <div class="form-group">
                            <label class="col-md-2 control-label">优惠券数量：</label>
                            <div class="col-md-4">
                                 <input name="yhq.yhqCount" value="${yhq.yhqCount}" type="text" id="yhqCount" class="form-control">
                                
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-md-2 control-label">活动介绍：</label>
                            <div class="col-md-4">
                                 <input name="yhq.yhqDesc" value="${yhq.yhqDesc}" type="text" id="yhqDesc" class="form-control">
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 control-label"></div>
                            <div class="col-md-10">
                                <input name="submitSaveEdit" type="submit" id="submitSaveEdit" class="btn btn-danger btn-lg" value="确认">
                                <input type="button" class="btn btn-danger btn-lg"  onclick='window.history.go(-1)' value="返回">
                            </div>	
                        </div> 
                         <input type="hidden" name="yhq.yhqId" id="yhqId" value="${yhq.yhqId }"/>              
                    </form>
                    
                    
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
					后台管理系统
				</div>
			</div>
		</footer>
</div><!--warp-->
    
    <script type="text/javascript">
  
    
     laydate({
            elem: '#yhqBegintime'

        });
         laydate({
            elem: '#yhqEndtime'

        });
        
        
        $(document).ready(function() {
        jQuery.validator.addMethod("isPhone", function(value,element) {
			  var length = value.length;
			  var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;
			  var tel = /^\d{3,4}-?\d{7,9}$/;
			  return this.optional(element) || (tel.test(value) || mobile.test(value));
			
			}, "请正确填写您的联系电话"); 
        $("#editForm").validate({
            rules: {
                "yhq.activityId": {
                    required: true
                },
                "yhq.yhqName": {
                    required: true
                },
                "yhq.yhqBegintime": {
                    required: true
                },
                "yhq.yhqEndtime": {
                   required: true
                },
                "yhq.yhqPhone": {
                    required: true,
                    isPhone:true
                },
                "yhq.yhqCount": {
                    number: true
                }
                
            },
            messages: {
                "yhq.activityId": {
                    required: "请选择活动名称！"
                },
                "yhq.yhqName": {
                    required: "请输入优惠券名称！"
                },
                "yhq.yhqBegintime": {
                    required: "请选择开始时间！"
                },
                "yhq.yhqEndtime": {
                    required: "请选择结束时间！"
                },
                "yhq.yhqPhone": {
                    required: "请输入联系电话！",
                    isPhone:"请正确输入联系电话"
                } ,
                "yhq.yhqCount": {
                    number: "数量必须为数字！"
                } 
                
            }
        });
    });
</script>
</body>
</html>
