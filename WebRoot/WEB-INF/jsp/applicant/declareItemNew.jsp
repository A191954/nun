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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pageStyle.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/tableStyle.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/dialog/mdialog.css"/>
<%@taglib prefix="s" uri="/struts-tags"%>
<title>大学生创新管理系统</title>
</head>
<body>
	<div id="wrapper">
    	<%@include file="../nav.jsp"%>
	    <div id="page-wrapper">
	    	<h1 class="text-center">新发布项目<span class="alert alert-warning"><span class="glyphicon glyphicon-warning-sign"></span>(每人仅能选一项, 多选无效！)</span></h1>
	        <a href="applicantFindItemNew.action" class="btn btn-primary pull-right"><span class="glyphicon glyphicon-search"></span>查看自己申报的新项目</a>
			<table border="1" width="400" class="table table-hover table-responsive" id="table">
				
					<tr class="info">
					    <th class="hide">项目ID</th>
					    <th>项目名称</th>
					    <th>项目总经费</th>
					    <th>项目发布时间</th>
					    <th>项目发布人</th>
					    <th>项目申报总人数</th>
					    <th>选择申请项目</th>
					    <th class="hide">取消申请</th>
				 	</tr>
				
				 	<s:iterator value="#request.page.datalist" var="itemNew">
		 				<tr>
		                	<td align="center" class="hide"><s:property value="#itemNew.id"/> </td>
		      				<td align="center"><s:property value="#itemNew.itemName"/> </td>
		      				<td align="center"><s:property value="#itemNew.money"/> </td>
		      				<td align="center"><s:property value="#itemNew.publishTime"/> </td>
							<td align="center"><s:property value="#itemNew.publisher.name"/> </td>
							<td align="center"><s:property value="#itemNew.applicants.size()"/> </td>
							<td align="center"><a href="applicantDeclareItemNew.action?itemNewId=<s:property value="#itemNew.id"/>" class="btn btn-info declareItemNew">申请</a></td>
							<td align="center" class="hide"><a href="applicantFindItemNew.action?itemNewId=<s:property value="#itemNew.id"/>"  class="btn btn-info">取消</a></td>    
		   				</tr>   
	   				</s:iterator>
				 
   			</table>
   			
   			<center>
   					<ul class="pagination" id="menu">
   						<li class="">
   							<a href="applicantShowItemNew.action?currentPage=<s:property value="#request.page.firstPage" />">
   							<span class="glyphicon glyphicon-chevron-left"></span>首页</a>
   						</li>
   						<s:if test="%{#request.page.hasPrePage}">
   							<li class=""><a href="applicantShowItemNew.action?currentPage=<s:property value="#request.page.firstPage" />">上一页</a></li>
   						</s:if>
   						<s:bean name="org.apache.struts2.util.Counter" var="counter">
		                  <s:param name="first" value="#request.page.startPage" />
		                  <s:param name="last" value="#request.page.endPage" />
		                  <s:iterator status="st">
		                      <li><a href="applicantShowItemNew.action?currentPage=<s:property/>"><s:property /></a></li>
		                  </s:iterator>
		                </s:bean>
   						<s:if test="%{#request.page.hasNextPage}">
   							<li class=""><a href="applicantShowItemNew.action?currentPage=<s:property value="#request.page.nextPage" />">下一页</a></li>
   						</s:if>
   						<li class=""><a href="applicantShowItemNew.action?currentPage=<s:property value="#request.page.lastPage"/>">尾页
   						 <span class="glyphicon glyphicon-chevron-right"></span>
   						</a></li>
   						<li class="alert alert-info" id="pageInfo">
   							
   								共<s:property value="#request.page.totalPages"/>页 当前第<s:property value="#request.page.currentPage"/>页
   							
   						</li>
   					</ul>
	   			
   			</center>
			
			<!-- 当申请人已经申请则提示申请人已经申请了新项目 -->
			<div id="myModal" class="modal fade" role="dialog">
				  <div class="modal-dialog">
				
				    <!-- Modal content-->
					  <div class="modal-content">
						  <div class="modal-header">
						  	<button type="button" class="close" data-dismiss="modal">&times;</button>
						  	<h4 class="modal-title text-center text-primary">温馨提示:你已经申请了<span id="myP" class="text-primary alert alert-warning"><s:property value="itemNew.itemName" /></span></h4>
						  </div>
						  <div class="modal-body text-center alert alert-danger">
						    <p>你只有自行取消已经申报的项目, 再重新申请！</p>
						  </div>
						  <div class="modal-footer">
						    <a type="button" class="btn btn-default btn btn-info" href="applicantFindItemNew.action">查看自己申报的项目</a>
						  </div>
					  </div>
				
				  </div>
			</div>
			
	    </div>
	</div>

    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script>
    <script src="<%=basePath%>js/table.js"></script>
    <script src="<%=basePath%>js/dialog/mdialog.js"></script>   
    <script>
    $(document).ready(function(){
    	if($("#myP").text() != ""){
    		$("#myModal").modal("show");
        }
    })
    		
    </script> 
</body>
</html>