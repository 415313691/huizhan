<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">
<link href="source/images/logo1.png" type="image/x-icon" rel="shortcut icon" />
<link href="source/css/bootstrap.css" rel="stylesheet">
<link href="source/css/lock.css" rel="stylesheet">
<link href="source/css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="source/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="source/js/jquery.validate.min.js"></script>
 
</head>

<body>
    <div class="logo">
        <h4><a href="#"><img src="source/images/logo.png" alt=""></a></h4>
    </div>
    <form name="Login" id="loginForm" onSubmit="return CheckForm()" action="sysAction_login" method="post">
    <div class="lock-holder">
    	<div class="lock-div">
            <div class="lock-group">   
                <div class="form-group pull-left input-username">
                    <div class="input-group">
                        <input name="UserName" id="userName" type="text" class="form-control " placeholder="用户名">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>    
                    </div>
                </div>
                <div class="form-group pull-right input-password">
                    <div class="input-group">
                        <input name="PassWord" id="passWord" type="password" class="form-control " placeholder="密码" >
                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                    </div>
                </div>
            </div> 
           	<div id="errorTip">${message }</div>
        </div>
    </div> 
    <div class="submit">
        <button type="submit" class="btn btn-primary btn-lg">登陆后台</button>   
    </div>
    </form>

</body>

<script type="text/javascript">
function CheckForm(){
   		var userName = $("#userName").val();
        var userPass = $("#userPass").val();
        var flag =true;
        if(userName==''||userPass==''){
            flag = false;
            alert("用户名或密码不能为空");
        }
        return flag;
	}
</script>
</html>