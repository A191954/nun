<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//out.print(path);
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/admin/loginStyle.css"/>
<title>大学生创新管理系统管理员</title>
<style>
	html{
		width: 100%;
	}
	body {
		width: 100%;
		font-family: microsoft yahei;
	}
	
</style>
</head>
<body class="login-page">
	<div class="login-form">
	
			<div class="login-content">
	
				<div class="form-login-error">
					<h3>Invalid login</h3>
					<p>Enter <strong>demo</strong>/<strong>demo</strong> as login and password.</p>
					<s:property value="errorMessage"/>
				</div>
	
				<form action="adminLoginAction.action" role="form" id="form_login" method="post">
	
					<div class="form-group">
	
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-user"></span>
							</div>
	
							<input type="text" class="form-control" name="username" id="username" placeholder="用户名" autocomplete="on" />
						</div>
	
					</div>
	
					<div class="form-group">
	
						<div class="input-group">
							<div class="input-group-addon">
								<span class="glyphicon glyphicon-eye-close"></span>
							</div>
	
							<input type="password" class="form-control" name="password" id="password" placeholder="密码" autocomplete="on" />
						</div>
	
					</div>
	
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block btn-login">
							<span class="glyphicon glyphicon-log-in pull-right"></span>
							登录
						</button>
					</div>
	
					
	
				
				</form>
	
				
	
			</div>
	
	</div>


  
</body>
</html>