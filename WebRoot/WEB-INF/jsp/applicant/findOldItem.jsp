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

<%@taglib prefix="s" uri="/struts-tags"%>
<title>大学生创新管理系统</title>
</head>
<body>
	<div id="wrapper">
    	<%@include file="../nav.jsp"%>
	    <div id="page-wrapper">
	    	<h1 class="text-center"><span class="alert alert-info">历史申报项目</span></h1>
	    	<a href="applicantShowItemNew.action" class="btn btn-primary pull-right">申报新项目</a>
	        <table border="1" width="400" class="table table-hover table-bordered table-responsive table-condensed" id="table">
				<tr class="info">
				    <th class="hide">项目ID</th>
				    <th>项目名称</th>
				    <th>项目总经费</th>
				    <th>项目发布时间</th>
				    <th>项目发布人</th>
				    <th>项目申报总人数</th>
			 	</tr>
 				<s:iterator value="#request.itemOldList" var="itemOld">
	 				<tr>
	                	<td align="center" class="hide"><s:property value="#itemOld.id"/> </td>
	      				<td align="center"><s:property value="#itemOld.itemName"/> </td>
	      				<td align="center"><s:property value="#itemOld.money"/> </td>
	      				<td align="center"><s:property value="#itemOld.publishTime"/> </td>
						<td align="center"><s:property value="#itemOld.publisher.name"/> </td>
						<td align="center"><s:property value="#itemOld.applicants.size()"/> </td>   
	   				</tr>   
   				</s:iterator>
   			</table>
   			
   			<center>
   					<ul class="pagination" id="menu">
   						<li class="">
   							<a href="applicantFindOldHistory.action?currentPage=<s:property value="#request.page.firstPage" />">
   							<span class="glyphicon glyphicon-chevron-left"></span>首页</a>
   						</li>
   						<s:if test="%{#request.page.hasPrePage}">
   							<li class=""><a href="applicantFindOldHistory.action?currentPage=<s:property value="#request.page.prePage" />">上一页</a></li>
   						</s:if>
   						<s:bean name="org.apache.struts2.util.Counter" var="counter">
		                    <s:param name="first" value="#request.page.startPage" />
		                    <s:param name="last" value="#request.page.endPage" />
		                    <s:iterator status="st">
		                        <li><a href="applicantFindOldHistory.action?currentPage=<s:property/>"><s:property /></a></li>
		                    </s:iterator>
                		</s:bean>	
   						<s:if test="%{#request.page.hasNextPage}">
   							<li class=""><a href="applicantFindOldHistory.action?currentPage=<s:property value="#request.page.nextPage" />">下一页</a></li>
   						</s:if>
   						<li class=""><a href="applicantFindOldHistory.action?currentPage=<s:property value="#request.page.lastPage"/>">尾页
   						 <span class="glyphicon glyphicon-chevron-right"></span>
   						</a></li>
   						<li class="alert alert-info text-primary">
   							
   								共<s:property value="#request.page.totalPages"/>页 当前第<s:property value="#request.page.currentPage"/>页
   							
   						</li>
   					</ul>
	   			
   			</center>
			
	    </div>
	</div>

    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script> 
    <script src="<%=basePath%>js/table.js"></script>  
</body>
</html>