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
                        <h2><i class="fa fa-pencil-square-o"></i><span class="break"></span><strong>商品信息</strong></h2>
                    </div>
                    <div class="panel-body">
                    <form name="editForm" id="editForm" method="post" action="productAction_saveProduct" class="form-horizontal">
                        <div class="form-group">
                            <label class="col-md-2 control-label">商品名称：</label>
                            <div class="col-md-4">
                                <input name="product.productName" type="text" id="productName" class="form-control" value="${product.productName}" maxlength="100">
                                
                            </div>
                        </div> 
                        
                        <div class="form-group">
                            <label class="col-md-2 control-label">所需金币：</label>
                            <div class="col-md-4">
                                <input name="product.productPrice" type="text" id="productPrice" class="form-control" value="${product.productPrice }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">商品数量：</label>
                            <div class="col-md-4">
                                <input name="product.productCount" type="text" id="productCount" class="form-control" value="${product.productCount }">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">状态：</label>
                            <div class="col-md-4">
                                <select name="product.productStatus" id="productStatus" class="form-control">
                                	<option value="0" <c:if test="${product.productStatus=='0' }">selected="selected"</c:if> >上架</option>
                                	<option value="1" <c:if test="${product.productStatus=='1' }">selected="selected"</c:if> >下架</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-2 control-label">商品说明：</label>
                            <div class="col-md-4">
                                <textarea rows="5" cols="5" class="form-control" id="productDesc" name="product.productDesc">${product.productDesc }</textarea>
                            </div>
                        </div>
                         
                         <div class="form-group">
                            <label class="col-md-2 control-label">商品图片：</label>
                            <div class="col-md-5">
                            	<div class="input-group" style="position:relative;">
                                	 <div id="fileUploadContent3" class="fileUploadContent">
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
                         <input type="hidden" name="product.productId" id="productId" value="${product.productId }"/>              
                        <input type="hidden" name="product.productPic" id="productPic" value="${product.productPic }"/>                  
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
    $("#fileUploadContent3").initUpload({
        "uploadUrl":"createFileAction_create.action",//上传文件信息地址
        "size":500,//文件大小限制，单位kb,默认不限制
        "maxFileNumber":1,//文件个数限制，为整数
        "onUpload":onUploadFun,//在上传后执行的函数
        "autoCommit":true,//文件是否自动上传
        "fileType":['png','jpg','PNG','JPG'],//文件类型限制，默认不限制，注意写的是文件后缀
    });
    function onUploadFun(opt,data){
    	if(data!=null&&data!=undefined&&data!=''){
    		$("#productPic").val(data);
    	}
 
    }
        $(document).ready(function() {
        $("#editForm").validate({
            rules: {
                "product.productName": {
                    required: true
                },
                "product.productPrice": {
                    required: true,
                    number:true
                },
                "product.productCount": {
                	required: true,
                    number: true
                },
                "product.productDesc": {
                    required: true
                }
               
            },
            messages: {
                "product.productName": {
                    required: "请输入商品名称！"
                },
                "product.productPrice": {
                    required: "请输入所需积分！",
                    number:"积分只能为数字"
                },
                "product.productCount": {
                	required: "商品数量不能为空",
                    number: "商品数量只能为数字"
                },
                "product.productDesc": {
                    required: "商品描述！"
                } 
                
            }
        });
    });
</script>
</body>
</html>
