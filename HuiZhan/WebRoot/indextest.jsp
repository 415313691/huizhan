<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="source/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="source/js/webuploader.js"></script>
	<script type="text/javascript" src="source/js/createfile/upload.js"></script>
 
    <link rel="stylesheet" href="source/js/createfile/style.css" type="text/css"></link>
  	<link rel="stylesheet" href="source/css/webuploader.css" type="text/css"></link></head>
  	
  	<link rel="stylesheet" href="<%=basePath %>source/dist/basic.min.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath %>source/dist/dropzone-amd-module.min.js"></script>
<link rel="stylesheet" href="<%=basePath %>source/dist/dropzone.min.css" type="text/css"></link>
<script type="text/javascript" src="<%=basePath %>source/dist/dropzone.min.js"></script>
  
  <body>
    This is my JSP page. <br>
    <a href="<%=basePath%>testAction_test">点击拦截</a>
    
    
        <div id="wrapper">
        <div id="container">
            <!--头部，相册选择和格式选择-->

            <div id="uploader">
                <div class="queueList">
                    <div id="dndArea" class="placeholder">
                        <div id="filePicker"></div>
                        <p>或将照片拖到这里，单次最多可选300张</p>
                    </div>
                </div>
                <div class="statusBar" style="display:none;">
                    <div class="progress">
                        <span class="text">0%</span>
                        <span class="percentage"></span>
                    </div><div class="info"></div>
                    <div class="btns">
                        <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    
    <form action="/upload" class="dropzone needsclick dz-clickable" id="demo-upload">

  <div class="dz-message needsclick">
    Drop files here or click to upload.<br>
    <span class="note needsclick">(This is just a demo dropzone. Selected files are <strong>not</strong> actually uploaded.)</span>
  </div>
</form>
  </body>
</html>
