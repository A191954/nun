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
<link rel="stylesheet" type="text/css" href="<%=basePath%>Font-Awesome/css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/build.css"/>
<%@taglib prefix="s" uri="/struts-tags"%>
<title>大学生创新管理系统</title>
</head>
<body>
	<div id="wrapper">
    	<%@include file="../nav.jsp"%>
	    <div id="page-wrapper">
	    	<h1 class="text-center"><span class="alert alert-info">查看自己已经审核的申请人</span></h1>
	        <table border="1" width="400" class="table table-hover table-responsive table-striped table-condensed" id="table">
				<tr class="info">
				    	<th class="">项目申请人ID</th>
					    <th>项目姓名</th>
					    <th>项目申请人年龄</th>
					    <th>项目申请人电话</th>
					    <th>项目申请人邮箱</th>
					    <th>项目名称</th>
				    	<th>项目经费</th>
				    	<th>项目发布时间</th>
				    	<th>审核状态</th>
				    	<th>审核审核人</th>
			 	</tr>
			 	
 				<s:iterator value="#request.page.datalist" var="applicant">
	 				<tr>
				    		<td align="center" class=""><s:property value="#applicant.id"/></td>
		      				<td align="center"><s:property value="#applicant.name"/></td>
		      				<td align="center"><s:property value="#applicant.age"/></td>
		      				<td align="center"><s:property value="#applicant.telephone"/></td>
							<td align="center"><s:property value="#applicant.email"/></td>
							<td align="center"><s:property value="#applicant.itemNew.itemName"/></td>
							<td align="center"><s:property value="#applicant.itemNew.money"/></td>
							<td align="center"><s:property value="#applicant.itemNew.publisher.name"/></td>
							<td align="center"><s:property value="#applicant.checkedState"/></td>
							<td align="center"><s:property value="#applicant.checkor.name"/></td>
	   				</tr>   
   				</s:iterator>
   			</table>
	    </div>
	</div>

	<center>
		<ul class="pagination" id="menu">
			<li class="">
				<a href="checkorFindCheckedApplicants.action?currentPage=<s:property value="#request.page.firstPage" />">
				<span class="glyphicon glyphicon-chevron-left"></span>首页</a>
			</li>
			<s:if test="%{#request.page.hasPrePage}">
				<li class=""><a href="checkorFindCheckedApplicants.action?currentPage=<s:property value="#request.page.firstPage" />">上一页</a></li>
			</s:if>
			
			<s:bean name="org.apache.struts2.util.Counter" var="counter">
                  <s:param name="first" value="#request.page.startPage" />
                  <s:param name="last" value="#request.page.endPage" />
                  <s:iterator status="st">
                      <li><a href="checkorFindCheckedApplicants.action?currentPage=<s:property/>"><s:property /></a></li>
                  </s:iterator>
             </s:bean>
			<s:if test="%{#request.page.hasNextPage}">
				<li class=""><a href="checkorFindCheckedApplicants.action?currentPage=<s:property value="#request.page.nextPage" />">下一页</a></li>
			</s:if>
			<li class=""><a href="checkorFindCheckedApplicants.action?currentPage=<s:property value="#request.page.lastPage"/>">尾页
			 <span class="glyphicon glyphicon-chevron-right"></span>
			</a></li>
			<li class="alert alert-info text-primary">
				
					共<s:property value="#request.page.totalPages"/>页 当前第<s:property value="#request.page.currentPage"/>页
				
			</li>
		</ul>
  			
 	</center>




    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script>
	<script type="text/javascript">
			

	</script>   
</body>
</html>