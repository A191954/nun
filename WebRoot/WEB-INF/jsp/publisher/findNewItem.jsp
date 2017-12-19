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
	    	<h1 class="text-center"><span class="alert alert-info">新发布项目(只能发布一项)</span></h1>
	    	<a href="publisherFindHistoryPublishItem.action" class="btn btn-primary pull-left"><span class="glyphicon glyphicon-plus"></span>查看历史发布项目</a>
	    	<a href="publisherFindItemNewApplicant.action?itemNewId=<s:property value="#request.itemNew.id"/>" class="btn btn-primary pull-right">查看新项目申请人</a>
	    	<s:if test="%{#request.itemNewList.size() == 0}">
	    		<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#itemNewModal" id="publishItemNew"><span class="glyphicon glyphicon-plus"></span>发布新项目</button>
	    	</s:if>
	    	<div id="itemNewModal" class="modal fade" role="dialog">
	    		<div class="modal-dialog">
	    		
	    			<div class="modal-content">
	    				<div class="modal-header">
	    					<button type="button" class="close" data-dismiss="modal">&times;</button>
	    					<h4 class="modal-title text-center text-info"><span class="glyphicon glyphicon-pencil"></span>发布新项目</h4>
	    				</div>
	    				<div class="modal-body">
	    					<form action="" role="form" class="form-horizontal" id="itemNewForm">
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
	    							<label class="col-sm-2 col-md-2 text-primary" for="money">项目总经费:</label>
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
				    <th>项目内容</th>
				    <th>项目总经费</th>
				    <th>项目发布时间</th>
				    <th>项目申报总人数</th>
				    <th>项目修改</th>
			 	</tr>
 				<s:iterator value="#request.itemNewList" var="itemNew">
	 				<tr>
	                	<td align="center"><s:property value="#itemNew.id"/></td>
	      				<td align="center"><s:property value="#itemNew.itemName"/></td>
	      				<td align="center"><s:property value="#itemNew.content"/></td>
	      				<td align="center"><s:property value="#itemNew.money"/></td>
	      				<td align="center"><s:property value="#itemNew.publishTime"/></td>
						<td align="center"><s:property value="#itemNew.applicants.size()"/></td>
						<td align="center"><a data-toggle="modal" href="#itemNewModal" class="btn btn-primary updateItemNew">修改项目</a></td>   
	   				</tr>   
   				</s:iterator>
   			</table>
   			
			
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
    <script src="<%=basePath%>js/vertically-centered-bootstrap-modals.js"></script>
    <script src="<%=basePath%>js/table.js"></script> 
    <script type="text/javascript">
    	$(".updateItemNew").click(function(){
    		var tds = $(this).parent().siblings();
        	$("#id").val(tds.eq(0).text()); //id
        	$("#itemName").val(tds.eq(1).text());  //itemName
        	$("#content").val(tds.eq(2).text()); //content
        	$("#money").val(tds.eq(3).text());  //money
        	$("#itemNewForm").attr("action", "publisherUpdateItemNew.action");
        });
		$("#publishItemNew").click(function(){
			$("#itemNewForm").attr("action", "publisherAddItemNew.action");
		});
		$("#formSub").click(function(){
			alert($("#itemNewForm").attr("action"));
            $("#itemNewForm").submit(); //单击button 提交表单
            //$("#itemNewForm").attr("action", "publisherAddItemNew.action");
		});
    	$(document).ready(function(){
        	if($("#publisaherNewItem").text() == ""){
        		//$("#publisaherNewItem").text("您还没有发布过新项目呢");
        		$("#modal-h4").html("您还没有发布过新项目呢");
        		$("#isHasitemNewModal").modal();
            }
        	else{
        		$("#isHasitemNewModal").modal();
            }
        })
        
    </script>   
</body>
</html>