<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>钢钢好用户后台管理</title>
 <link href="source/images/logo1.png" type="image/x-icon" rel="shortcut icon" />
<!-- Bootstrap core CSS -->
<link href="source/css/bootstrap.min.css" rel="stylesheet">
<link href="source/css/jquery.mmenu.css" rel="stylesheet">

<!-- css页面 -->
<link href="source/css/font-awesome.min.css" rel="stylesheet">

<!-- 模板的自定义样式 -->
<link href="source/css/style.min.css" rel="stylesheet">
<link href="source/css/add-ons.min.css" rel="stylesheet">

<link href="source/css/atom-style.css" rel="stylesheet">
<link href="source/css/minimal.css" rel="stylesheet">
<script type="text/javascript" src="source/js/jquery-3.2.1.min.js"></script>

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

<jsp:include page="public/left.jsp"/>
 <!-- start: Content -->
<div class="main" style="min-height:850px;">
	<div class="row">
			<div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2><i class="fa fa-pencil-square-o"></i><span class="break"></span><strong>新增问题</strong></h2>
                    </div>
                    <div class="panel-body">
                    <form name="editForm" method="post" onSubmit="return CheckForm()" action="sysAction_saveQuestion" class="form-horizontal" >
                    <input type="hidden" name="question.questionId" value="${question.questionId }"/>
                    <input type="hidden" name="question.questionIsdel" value="${question.questionIsdel }"/>
                        <div class="form-group">
                            <label class="col-md-2 control-label">问题内容：</label>
                            <div class="col-md-4">
                                <input name="question.questionTitle" id="titleName" type="text" id="" class="form-control" value="${question.questionTitle }" >
                            </div>
                        </div> 
 
       					 <div class="form-group">
                            <label class="col-md-2 control-label">问题难度：</label>
                            <div class="col-md-4">
                                <select name="question.questionClass" id="questionClass" class="form-control">
                                	<option  value="0" <c:if test="${question.questionClass=='0' }">selected="selected"</c:if>  >简单</option>
                                	<option value="1" <c:if test="${question.questionClass=='1' }">selected="selected"</c:if> >一般</option>
                                	<option value="2" <c:if test="${question.questionClass=='2' }">selected="selected"</c:if>>困难</option>
                                	<option value="3" <c:if test="${question.questionClass=='3' }">selected="selected"</c:if>>科普</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-2 control-label"></div>
                            <div class="col-md-10">
                                <input name="submitSaveEdit" type="submit" id="submitSaveEdit" class="btn btn-danger btn-lg" value="确认修改">
                                <input type="button" class="btn btn-danger btn-lg" onclick='window.history.go(-1)' value="取消">
                            </div>	
                        </div>                   
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
</body>
<script type="text/javascript">
function CheckForm(){
   		var titleName = $("#titleName").val();
        var flag =true;
        if(titleName==''){
            flag = false;
            alert("题目内容不能为空");
        } if(titleName.length>=900){
            flag = false;
            alert("题目长度不能超过900字符");
        }
        return flag;
	}
</script>
</html>
