<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//out.print(path);
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/topLeft.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/tableStyle.css"/>
<%@taglib prefix="s" uri="/struts-tags"%>
<title>大学生创新管理系统</title>
</head>
<body>
	<div id="wrapper">
    	<%@include file="../nav.jsp"%>
	    <div id="page-wrapper">
	    	<h1 class="text-center"><span class="alert alert-info">您发布的新项目的申请人的详细列表</span></h1>
	    	<a href="publisherFindItemNew.action" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-plus"></span>查看新发布项目</a>
	        <table border="1" width="400" class="table table-hover table-bordered table-responsive table-condensed" id="table">
				<tr class="info">
				    <th>项目申请人ID</th>
				    <th>项目申请人姓名</th>
				    <th>项目申请人年龄</th>
				    <th>项目申请人电话</th>
				    <th>项目申请人邮箱</th>
			 	</tr>
 				<s:iterator value="#request.page.datalist" var="applicant">
	 				<tr>
	                	<td align="center"><s:property value="#applicant.id"/></td>
	      				<td align="center"><s:property value="#applicant.name"/></td>
	      				<td align="center"><s:property value="#applicant.age"/> </td>
	      				<td align="center"><s:property value="#applicant.telephone"/> </td>
	      				<td align="center"><s:property value="#applicant.email"/></td>
	   				</tr>   
   				</s:iterator>
   			</table>
 
	    </div>
	</div>

	<div id="applicantInfo" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
			    <div class="modal-header">
				    <button type="button" class="close" data-dismiss="modal">&times;</button>
				    <h4 class="modal-title text-center" id="modal-title-h"><s:property value="#request.backStr"/></h4>
			    </div> 
		    </div>
		
		  </div>
	 </div>
	

	
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script>
    <script src="<%=basePath%>js/table.js"></script> 
    <script type="text/javascript">
    	if($("#modal-title-h").text() == "input"){
        	$("#modal-title-h").text("目前还没有人申请该项目！");
        	$("#applicantInfo").modal();
        }
    	else if($("#modal-title-h").text() == "none"){
    		$("#modal-title-h").text("你还没有发布新项目呢！");
        	$("#applicantInfo").modal();
        }
    	else{
    		$("#modal-title-h").text("有申请人申请！ 请查看！");
        	$("#applicantInfo").modal();
        }
    </script>
</body>
</html>