<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//out.print(path);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学生创新管理系统</title>
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=basePath%>ckeditor/ckeditor.js">
</script>
</head>
<body>

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog" style="width: 80%;">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      
	      <div class="modal-body" style="height: 735px;">
	      
	      
		      <form action="ckeditorAction.action" method="post" >
				
				<textarea cols="80" id="textBody" name="textBody" rows="10">
					请书写项目申报书:
				</textarea>
				<p>
					<input type="submit" value="提交申请书" class="btn btn-info pull-right"/>
				</p>
			  </form>
			  <!-- 
			  
			  <ckeditor:replace  replace="textBody" basePath="../ckeditor/" />
			   -->
	      </div>
	      
	    </div>
	
	  </div>
	</div>


	
	
	<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
	
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>

	<script type="text/javascript">
		
		$(function () {
			$("#myModal").modal();
		    var myeditor = CKEDITOR.replace('textBody', { height: '545px', width: '100%' , uiColor: '#14B8C4'});
			});
	</script>
</body>
</html>