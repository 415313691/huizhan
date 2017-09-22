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
                        <h2><i class="fa fa-pencil-square-o"></i><span class="break"></span><strong>广告信息</strong></h2>
                    </div>
                    <div class="panel-body">
                    <form name="editForm" id="editForm" method="post" action="adAction_saveAd" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-2 control-label">广告位置：</label>
                            <div class="col-md-4">
                                <select id="adLocation" name="ad.adLocation" class="form-control">
                                	<option <c:if test="${ad.adLocation=='0' }">selected="selected"</c:if>  value="0">首页上方</option>
                                	<option <c:if test="${ad.adLocation=='1' }">selected="selected"</c:if>  value="1">首页下方</option>
                                </select>
                            </div>
                        </div> 
                        
                        <div class="form-group">
                            <label class="col-md-2 control-label">开始时间：</label>
                             <div class="col-md-4">
                                <input name="ad.adBegindate" type="text" id="adBegindate" class="form-control" value="<fmt:formatDate value="${ad.adBegindate}" type="date"/>" >
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">结束时间：</label>
                            <div class="col-md-4">
                                <input name="ad.adEnddate" type="text" id="adEnddate" class="form-control" value="<fmt:formatDate value="${ad.adEnddate}" type="date" />">
                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">状态：</label>
                            <div class="col-md-4">
                                <select name="ad.adIsdel" id="adIsdel" class="form-control">
                                	<option value="0" <c:if test="${ad.adIsdel=='0' }">selected="selected"</c:if> >可用</option>
                                	<option value="1" <c:if test="${ad.adIsdel=='1' }">selected="selected"</c:if> >不可用</option>
                                </select>
                            </div>
                        </div>
                       
                         <div class="form-group">
                            <label class="col-md-2 control-label">广告图片：</label>
                            <div class="col-md-5">
                            	<div class="input-group" style="position:relative;">
                                	 <div id="fileUploadContent2" class="fileUploadContent">
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
                         <input type="hidden" name="ad.adId" id="adId" value="${ad.adId }"/>              
                         <input type="hidden" name="ad.adPic" id="adPic" value="${ad.adPic }"/>                  
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
    $("#fileUploadContent2").initUpload({
        "uploadUrl":"createFileAction_create.action",//上传文件信息地址
        "size":500,//文件大小限制，单位kb,默认不限制
        "maxFileNumber":1,//文件个数限制，为整数
        "onUpload":onUploadFun,//在上传后执行的函数
        "autoCommit":true,//文件是否自动上传
        "fileType":['png','jpg','PNG','JPG'],//文件类型限制，默认不限制，注意写的是文件后缀
    });
    function onUploadFun(opt,data){
    	if(data!=null&&data!=undefined&&data!=''){
    		$("#adPic").val(data);
    	}
 
    }
     laydate({
            elem: '#adBegindate'

        });
         laydate({
            elem: '#adEnddate'

        });
        
        
        $(document).ready(function() {
        $("#editForm").validate({
            rules: {
               
                "ad.adBegindate": {
                    required: true
                },
                "ad.adEnddate": {
                    required: true
                } ,
                "ad.adIsdel": {
                    required: true
                } ,
                "ad.adPic": {
                    required: true
                }
            },
            messages: {
                "ad.adBegindate": {
                    required: "请输入开始时间！"
                },
                "ad.adEnddate": {
                    required: "请输入结束时间！"
                },
                "ad.adIsdel": {
                    required: "请选择状态"
                },
                "ad.adPic": {
                    required: "请上传图片"
                }
                
            }
        });
    });
</script>
</body>
</html>
