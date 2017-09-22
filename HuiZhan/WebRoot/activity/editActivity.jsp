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
<title>紫弘科技用户后台管理</title>
 <link href="<%=basePath %>source/images/name.png" type="image/x-icon" rel="shortcut icon" />
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
<jsp:include page="../public/head.jsp"></jsp:include>
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
                    <form name="editForm" id="editForm" method="post" action="actAction_saveActivity" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-2 control-label">活动名称：</label>
                            <div class="col-md-4">
                                <input name="activity.activityName" type="text" id="activityName" class="form-control" value="${activity.activityName }" maxlength="100">
                                
                            </div>
                        </div> 
                        <div class="form-group">
                            <label class="col-md-2 control-label">倒计时(秒)：</label>
                            <div class="col-md-4">
                                <input name="activity.activityCounttime" value="${activity.activityCounttime }" type="text" id="activityCounttime" class="form-control">
                            </div>
                        </div> 
                        
                       <!--   <div class="form-group">
                            <label class="col-md-2 control-label">金币：</label>
                            <div class="col-md-4">
                                <input name="activity.activityMoney" type="text" id="activityMoney" class="form-control" value="${activity.activityMoney }">
                            </div>
                        </div>-->
                        <div class="form-group">
                            <label class="col-md-2 control-label">金币数量：</label>
                            <div class="col-md-4">
                                <input name="activity.activityJifen" type="text" id="activityJifen" class="form-control" value="${activity.activityJifen }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">开始时间：</label>
                             <div class="col-md-4">
                                <input name="activity.activityBegintime" type="text" id="activityBegintime" class="form-control" value="<fmt:formatDate value="${activity.activityBegintime}" type="date"/>" >
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">结束时间：</label>
                            <div class="col-md-4">
                                <input name="activity.activityEndtime" type="text" id="activityEndtime" class="form-control" value="<fmt:formatDate value="${activity.activityEndtime}" type="date" />">
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">状态：</label>
                            <div class="col-md-4">
                                <select name="activity.activityIsdel" id="activityIsdel" class="form-control">
                                	<option value="0" <c:if test="${activity.activityIsdel=='0' }">selected="selected"</c:if> >可用</option>
                                	<option value="1" <c:if test="${activity.activityIsdel=='1' }">selected="selected"</c:if> >不可用</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">公司名称：</label>
                            <div class="col-md-4">
                                <input name="activity.activityCompany" type="text" id="activityCompany" class="form-control" value="${activity.activityCompany }"  >
                                
                            </div>
                        </div>
                       
                          <div class="form-group">
                            <label class="col-md-2 control-label">问题难度：</label>
                            <div class="col-md-4">
                                <select name="activity.activityClass" id="activityClass" class="form-control">
                                	<option  value="0" <c:if test="${activity.activityClass=='0' }">selected="selected"</c:if>  >简单</option>
                                	<option value="1" <c:if test="${activity.activityClass=='1' }">selected="selected"</c:if> >一般</option>
                                	<option value="2" <c:if test="${activity.activityClass=='2' }">selected="selected"</c:if>>困难</option>
                                	<option value="3" <c:if test="${activity.activityClass=='3' }">selected="selected"</c:if>>科普</option>
                                </select>
                            </div>
                        </div>
                          <div class="form-group">
                            <label class="col-md-2 control-label">类型(金币/优惠券)：</label>
                            <div class="col-md-4">
                                <input type="radio" name="activity.activityIstype" <c:if test="${activity.activityIstype=='0'||activity.activityIstype==''||activity.activityIstype==null }">checked="checked" </c:if>  value="0"/>金币
                                <input type="radio" name="activity.activityIstype" <c:if test="${activity.activityIstype=='1' }">checked="checked" </c:if>  value="1"/>优惠券
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-md-2 control-label">活动logo：</label>
                            <div class="col-md-5">
                            	<div class="input-group" style="position:relative;">
                                	 <div id="fileUploadContent" class="fileUploadContent">
                                	 </div>
                                </div>
                            </div>
                            </div>
                            
                             <div class="form-group">
                            <label class="col-md-2 control-label">背景图片：</label>
                            <div class="col-md-5">
                            	<div class="input-group" style="position:relative;">
                                	 <div id="fileUploadContent1" class="fileUploadContent">
                                	 </div>
                                </div>
                            </div>
                            </div>
                        <div class="form-group">
                            <div class="col-md-2 control-label"></div>
                            <div class="col-md-10">
                                <input name="submitSaveEdit" type="submit" id="submitSaveEdit" class="btn btn-danger btn-lg" value="确认">
                                <input type="button" class="btn btn-danger btn-lg"  onclick='window.history.go(-1)' value="返回">
                            </div>	
                        </div> 
                         <input type="hidden" name="activity.activityId" id="activityId" value="${activity.activityId }"/>              
                        <input type="hidden" name="activity.activityPic" id="activityPic" value="${activity.activityPic }"/>                  
                        <input type="hidden" name="activity.activityPics" id="activityPics" value="${activity.activityPics }"/>                  
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
    $("#fileUploadContent").initUpload({
        "uploadUrl":"createFileAction_create.action",//上传文件信息地址
        "size":500,//文件大小限制，单位kb,默认不限制
        "maxFileNumber":1,//文件个数限制，为整数
        "onUpload":onUploadFun,//在上传后执行的函数
        "autoCommit":true,//文件是否自动上传
        "fileType":['png','jpg','PNG','JPG'],//文件类型限制，默认不限制，注意写的是文件后缀
    });
    function onUploadFun(opt,data){
    	if(data!=null&&data!=undefined&&data!=''){
    		$("#activityPic").val(data);
    	}
 
    }
    
     $("#fileUploadContent1").initUpload({
        "uploadUrl":"createFileAction_create.action",//上传文件信息地址
        "size":500,//文件大小限制，单位kb,默认不限制
        "maxFileNumber":15,//文件个数限制，为整数
        "onUpload":onUploadFun1,//在上传后执行的函数
        "autoCommit":true,//文件是否自动上传
        "fileType":['png','jpg','PNG','JPG'],//文件类型限制，默认不限制，注意写的是文件后缀
    });
    function onUploadFun1(opt,data){
    	if(data!=null&&data!=undefined&&data!=''){
    		var oldpics = $("#activityPics").val();
    		if(oldpics!=''&&oldpics!=null){
    		 	$("#activityPics").val(oldpics+","+data);
    		}else{
    			$("#activityPics").val(data);
    		}
    		
    	}
    }
    
     laydate({
            elem: '#activityBegintime'

        });
         laydate({
            elem: '#activityEndtime'

        });
        
        
        $(document).ready(function() {
        $("#editForm").validate({
            rules: {
                "activity.activityName": {
                    required: true
                },
                "activity.activityCounttime": {
                    required: true,
                    number:true
                },
                "activity.activityMoney": {
                    number: true
                },
                "activity.activityRewardCount": {
                    number: true
                },
                "activity.activityBegintime": {
                    required: true
                },
                "activity.activityEndtime": {
                    required: true
                } 
            },
            messages: {
                "activity.activityName": {
                    required: "请输入活动名称！"
                },
                "activity.activityCounttime": {
                    required: "请输入倒计时时间！",
                    number:"倒计时只能为数字"
                },
                "activity.activityMoney": {
                    number: "红包金额只能为数字"
                },
                "activity.activityRewardCount": {
                    number: "红包数量只能为数字！"
                },
                "activity.activityBegintime": {
                    required: "请输入开始时间！"
                },
                "activity.activityEndtime": {
                    required: "请输入结束时间！"
                }
                
            }
        });
    });
</script>
</body>
</html>
