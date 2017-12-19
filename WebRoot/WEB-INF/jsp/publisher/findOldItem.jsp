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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pageStyle.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/topLeft.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/tableStyle.css"/>
<%@taglib prefix="s" uri="/struts-tags"%>
<title>大学生创新管理系统</title>
</head>
<body>
	<div id="wrapper">
    	<%@include file="../nav.jsp"%>
	    <div id="page-wrapper">
	    	<h1 class="text-center"><span class="alert alert-info">历史发布项目</span></h1>
	    	<a href="publisherFindItemNew.action" class="btn btn-primary pull-left"><span class="glyphicon glyphicon-plus"></span>查看新发布项目</a>
	    	<button type="button" class="btn btn-primary pull-right" id="addItemNew"><span class="glyphicon glyphicon-plus"></span>发布新项目</button>
	    	<div id="itemNewModal" class="modal fade" role="dialog">
	    		<div class="modal-dialog">
	    		
	    			<div class="modal-content">
	    				<div class="modal-header">
	    					<button type="button" class="close" data-dismiss="modal">&times;</button>
	    					<h4 class="modal-title text-center text-info"  id="modal-h4"><span class="glyphicon glyphicon-plus-sign"></span>添加新项目</h4>
	    				</div>
	    				<div class="modal-body">
	    					<form action="publisherAddItemNew.action" role="form" class="form-horizontal" id="itemNewForm">
	    						<div class="form-group hide">
	    							<label class="col-sm-2 col-md-2 text-primary" for="id">新项目ID:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="text" class="form-control" id="id" name="id"/>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="itemName">项目名称:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="text" class="form-control" id="itemName" name="itemName"/>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="content">项目简介:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<textarea class="form-control" rows="5" id="content" name="content"></textarea>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="money">项目发总经费:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="text" class="form-control" id="money" name="money"/>
	    							</div>
	    						</div>
	    						<div class="form-group"> 
                                	<div class="col-sm-offset-2 col-sm-10 col-md-offset-2 col-md-10">
                                    	<button type="submit" class="btn btn-primary" id="formSub">提交</button>
                                    </div>
                                </div>
	    					</form>
	    				</div>
	    				<div class="modal-footer"></div>
	    			</div>
	    			
	    		</div>
	    	</div>
	  
	        <table border="1" width="400" class="table table-hover table-bordered table-responsive table-condensed" id="table">
				<tr class="info">
				    <th>项目ID</th>
				    <th>项目名称</th>
				    <th>项目总经费</th>
				    <th>项目发布时间</th>
				    <th>项目申报总人数</th>
			 	</tr>
 				<s:iterator value="#request.itemOldList" var="itemOld">
	 				<tr>
	                	<td align="center"><s:property value="#itemOld.id"/> </td>
	      				<td align="center"><s:property value="#itemOld.itemName"/> </td>
	      				<td align="center"><s:property value="#itemOld.money"/> </td>
	      				<td align="center"><s:property value="#itemOld.publishTime"/> </td>
						<td align="center"><s:property value="#itemOld.applicants.size()"/> </td>   
	   				</tr>   
   				</s:iterator>
   			</table>
   			
   			<center>
   					<ul class="pagination" id="menu">
   						<li class="">
   							<a href="publisherFindHistoryPublishItem.action?currentPage=<s:property value="#request.page.firstPage" />">
   							<span class="glyphicon glyphicon-chevron-left"></span>首页</a>
   						</li>
   						<s:if test="%{#request.page.hasPrePage}">
   							<li class=""><a href="publisherFindHistoryPublishItem.action?currentPage=<s:property value="#request.page.firstPage" />">上一页</a></li>
   						</s:if>
   						
   						<s:bean name="org.apache.struts2.util.Counter" var="counter">
		                  <s:param name="first" value="#request.page.startPage" />
		                  <s:param name="last" value="#request.page.endPage" />
		                  <s:iterator status="st">
		                      <li><a href="publisherFindHistoryPublishItem.action?currentPage=<s:property/>"><s:property /></a></li>
		                  </s:iterator>
		                </s:bean>
   						<s:if test="%{#request.page.hasNextPage}">
   							<li class=""><a href="publisherFindHistoryPublishItem.action?currentPage=<s:property value="#request.page.nextPage" />">下一页</a></li>
   						</s:if>
   						<li class=""><a href="publisherFindHistoryPublishItem.action?currentPage=<s:property value="#request.page.lastPage"/>">尾页
   						 <span class="glyphicon glyphicon-chevron-right"></span>
   						</a></li>
   						<li class="alert alert-info text-primary">
   							
   								共<s:property value="#request.page.totalPages"/>页 当前第<s:property value="#request.page.currentPage"/>页
   							
   						</li>
   					</ul>
	   			
   			</center>
			
	    </div>
	</div>

	<div id="isHasitemNewModal" class="modal fade" role="dialog">
   		<div class="modal-dialog">
   		
   			<div class="modal-content">
   				<div class="modal-header">
   					<button type="button" class="close" data-dismiss="modal">&times;</button>
   					<h4 class="modal-title text-center text-info"  id="modal-h4">你已经发布了<span id="publisaherNewItem" class="alert alert-warning"><s:property value="#request.itemNew.itemName"/></span></h4>
   				</div>
   				<div class="modal-body hide">
   					
   				</div>
   				<div class="modal-footer hide"></div>
   			</div>
   			
   		</div>
   	</div>

    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script>
    <script src="<%=basePath%>js/table.js"></script>   
      <script>
    $(document).ready(function(){
		$("#addItemNew").click(function(){
			if($("#publisaherNewItem").text() != ""){
				$("#isHasitemNewModal").modal("show");
			}
			else{
				$("#itemNewModal").modal("show");
			}
		});
    })
    		
    </script> 
</body>
</html>