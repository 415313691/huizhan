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
                        <h2><i class="fa fa-pencil-square-o"></i><span class="break"></span><strong>答案设置</strong></h2>
                    </div>
                    <div class="panel-body">
                     
                   
  <div class="container" style="max-width: 1000px">

    <div class="row">
        <div class="col-sm-5">

            <form class="addel"
                  data-addel-hide="true"
                  data-addel-add="3"
                  data-addel-animation-duration="1000">

            </form>

        </div>
        <div class="col-sm-5 col-sm-offset-2">
            <form class="addel">
            <c:forEach items="${answers }" var="answer">
                <div class="form-group addel-target">
                    <label for="person" class="control-label">
                        答案
                    </label>
                    <div class="input-group">
                        <input type="text" id="${answer.answerId }" iswrong="${answer.answerIsworg }" isdel="${answer.answerIsdel }" value="${answer.answerContent }" name="contacts[]" class="form-control">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-danger addel-delete" >删除</button>
                            <button type="button" class="btn btn-danger addel-save" onclick="saveAnswer('${questionId}',this)">保存</button>
                            
                            
                            <c:if test="${answer.answerIsworg==''||answer.answerIsworg==null||answer.answerIsworg=='1' }">
                            <button type="button" class="btn btn-danger" bid="${answer.answerId }" onclick ="setWrong(this,0)" <c:if test="${answer.answerId==''||answer.answerId==null }"> disabled="disabled"</c:if>  >设为正确答案</button>
                            </c:if>
                             <c:if test="${answer.answerIsworg!=''&&answer.answerIsworg!=null&&answer.answerIsworg=='0' }">
                            <button type="button" class="btn btn-danger" bid="${answer.answerId }" onclick ="setWrong(this,1)" <c:if test="${answer.answerId==''||answer.answerId==null }"> disabled="disabled"</c:if>  >取消正确答案</button>
                            </c:if>
                            
                            
                        </span>
                        
                    </div>
                </div>
               </c:forEach>
		<div class="form-group addel-target">
                    <label for="person" class="control-label">
                        答案
                    </label>
                    <div class="input-group">
                        <input type="text" id="" iswrong="" isdel="" name="contacts[]" class="form-control">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-danger addel-delete" >删除</button>
                            <button type="button" class="btn btn-danger addel-save" onclick="saveAnswer('${questionId}',this)">保存</button>
                            <button type="button" class="btn btn-danger" bid="" onclick ="setWrong(this,0)"   disabled="disabled"   >设为正确答案</button>
                        </span>
                        
                    </div>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-success btn-block addel-add">
                        <i class="fa fa-plus"></i>
                    </button>
                </div>

            </form>

        </div>

    </div>

</div>
  
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
<script type="text/javascript" src="source/js/addel.jquery.js"></script>
<script type="text/javascript">
 $(document).ready(function () {
        $('.addel').addel({
            events: {
                added: function (event) {
                    console.log('Added ' + event.added.length);
                }
            }
        }).on('addel:delete', function (event) {
            if (window.confirm('确定要删除该答案吗: ' + '"' + event.target.find(':input').val() + '"?')) {
                 var answerid =event.target.find(':input').attr("id");
                  $.ajax({
			            type: "POST",
			            url: "sysAction_delAnswerById",
			            async: true,
			            data: {
			                answerId:answerid
			            },
			            success: function (datas) {
			                if(datas=="true"){
			                  alert('删除成功');
			                  event.preventDefault();
			                }else{
			                	alert('删除失败');
			                }
			            }
        		});
               
            }
        });
    });
    
    function saveAnswer(questionId,obj){
    	var answerval = $(obj).parent().parent('.input-group').find('input').eq(0).val();
    	var answerid = $(obj).parent().parent('.input-group').find('input').eq(0).attr("id");
    	var iswrong = $(obj).parent().parent('.input-group').find('input').eq(0).attr("iswrong");
    	var isdel = $(obj).parent().parent('.input-group').find('input').eq(0).attr("isdel");
    	if(answerval!=''&&answerval!=null){
    	 $.ajax({
            type: "POST",
            url: "sysAction_saveAnswer",
            async: false,
            data: {
                questionId: questionId,
                answerval:answerval,
                answerId:answerid,
                iswrong:iswrong,
                isdel:isdel
            },
            success: function (datas) {
                if(datas!=""&&datas!=null){
                alert('保存成功');
                $(obj).parent().parent('.input-group').find('input').eq(0).attr("id",datas);
                $(obj).next().removeAttr("disabled"); 
                $(obj).next().attr("bid",datas); 
                }else{
                	alert('保存失败');
                }
            }
        });
        }else{
        	alert("答案内容不能为空");
        }
    }
    
   function setWrong(obj,status){
   		var answerId = $(obj).attr("bid");
      $.ajax({
            type: "POST",
            url: "sysAction_setWrong",
            async: false,
            data: {
                answerId:answerId,
                iswrong:status
            },
            success: function (datas) {
                if(datas=="true"){
                	alert('设置成功');
                	if(status=='0'){
                	$(":button[bid="+answerId+"]").replaceWith("<button type='button' class='btn btn-danger' bid='"+answerId+"' onclick ='setWrong(this,1)'    >取消正确答案</button>");
                	}else{
                	$(":button[bid="+answerId+"]").replaceWith("<button type='button' class='btn btn-danger' bid='"+answerId+"' onclick ='setWrong(this,0)'   >设为正确答案</button>");
                	}
                	
                }else{
                	alert('设置失败');
                }
            }
        });
   }
</script>
</html>
