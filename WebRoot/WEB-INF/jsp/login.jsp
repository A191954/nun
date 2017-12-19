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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/flat-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/jQuery.niceTitle.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css"/>
<title>大学生创新管理系统首页</title>
<style>
	html{
		width: 100%;
	}
	body {
		width: 100%;
		font-family: microsoft yahei;
	}
	.errorMessage {
		display: block;
		color: #f1c40f;
    	position: absolute;
    	bottom: 78px;
    	width: 100%;
    	text-align: center;
    	background: rgba(23, 4, 10, 0.34);
    	font-size: 15px;
	}
</style>
</head>
<body>
	
		<!-- head start -->
		<div class="head" style="width: 100%; height:99px; background: #33CC99; position: absolute; top: 0px; z-index: 6;">
			<img alt="" src="<%=basePath%>image/head.png" style=""/>
			<img alt="" src="<%=basePath%>image/head1.png" style="float: right;margin-top: 20px;margin-right: 50px;"/>
		</div>
		<!-- head end -->
		
		<!-- bd start -->
		<div class="bd" style="width: 100%; height: 570px; position: absolute; top: 99px; z-index: 6;">
			
			<div class="form" style="width: 500px; margin:0px auto; padding-top: 80px; box-shadow:0px 0px 17px 3px rgb(198, 198, 154); border-radius: 20px; background: rgba(237, 232, 229, 0.32);" title="请登录">
				<form role="form" action="" method="post" id="form">
					<div class="form-group" title="亲！请输入用户名">
						<label for="username">用户名:</label>
						<s:textfield class="form-control" name="username" id="username" placeholder="请输入用户名"/>
					</div>	
					<div class="form-group" title="亲！请不要忘了输入密码哟">
						<label for="password">密码:</label>
						<s:password class="form-control" name="password" id="password" placeholder="请输入密码"/>
					</div>
					
					<div class="form-group" title="亲！ 请选择身份">
						<label for="usertype">请选择身份:</label>
				        <select data-toggle="select" class="form-control select select-primary select-lg" name="usertype" id="usertype">
						  <option value="publisher">项目发布人</option>
						  <option value="applicant">项目申请人</option>
						  <option value="checkor">审核人员</option>
				        </select>
		      		</div>
		      		<div class="form-group" style="" title="没有用户名, 请注册一个哟">
		    			<label style="color: white; font-size: 12px; margin-left: 34px;"><input type="checkbox">     记住我</label>
		    			<a id="myBtn" href="register.jsp" style="float: right; color: white; font-size: 12px; margin-right: 30px;">注册</a>
		  			</div>
		  			
		  			<div class="form-group" title="请登录">
		  				<input type="submit" class="btn btn-primary btn-block" id="formSub" style="background:#34495E" value="登陆"/>
		  			</div>
				</form>
			</div>
		</div>
		<!-- bd end -->
		
		<!-- footer start -->
		<div class="head" style="width: 100%; height: 10px; position: absolute; top:669px; z-index: 5; color: white;"><h6 class="text-center">版权所有</h6></div>
	   	<!-- footer end -->
	   	
	   	<!-- backgroundImages start -->
	   	<div class="slideshow" style="">
			<div class="slideshow-image" style="background-image: url('<%=basePath%>image/1.jpg')"></div>
			<div class="slideshow-image" style="background-image: url('<%=basePath%>image/2.jpg')"></div>
			<div class="slideshow-image" style="background-image: url('<%=basePath%>image/3.jpg')"></div>
			<div class="slideshow-image" style="background-image: url('<%=basePath%>image/4.jpg')"></div>
		</div>
		<!-- backgroundImages end -->
		
		

    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/flat-ui.min.js"></script>
    <script src="<%=basePath%>js/application.js"></script>
    <script src="<%=basePath%>js/jQuery.niceTitle.js"></script>
    <script>
      $(document).ready(function(){
        $('select[name="inverse-dropdown"], select[name="inverse-dropdown-optgroup"], select[name="inverse-dropdown-disabled"]').select2({dropdownCssClass: 'select-inverse-dropdown'});

        $('select[name="searchfield"]').select2({dropdownCssClass: 'show-select-search'});
        $('select[name="inverse-dropdown-searchfield"]').select2({dropdownCssClass: 'select-inverse-dropdown show-select-search'});
        $("div.form, form, div.form-group").niceTitle({showLink: false});
        /*for modal*/
        $("#myBtn").click(function(){
            $("#myModal").modal();
        });
		/*表单提交*/
        $("#formSub").click(function(){
            var usertype = $("#usertype").val();
            var actionUrl = "";
            $(this).val("登陆中");
            if(usertype == "publisher"){
            	actionUrl = "publisherLoginAction.action";
            	$("#form").attr("action", actionUrl);
                $("#form").submit();
            }
            else if(usertype == "applicant"){
            	actionUrl = "applicantLoginAction.action";
            	$("#form").attr("action", actionUrl);
                $("#form").submit();
            }
            else{
            	actionUrl = "checkorLoginAction.action";
            	$("#form").attr("action", actionUrl);
                $("#form").submit();
            }
        });
      });
      
     
      
    </script>
</body>
</html>