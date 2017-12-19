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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/dialog/mdialog.css"/>
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
	    	<h1 class="text-center"><span class="alert alert-info">新申报项目</span></h1>
	    	<a href="applicantShowItemNew.action" class="btn btn-info pull-left"><span class="glyphicon glyphicon-search"></span>查看新项目</a>
	    	<s:if test="%{#request.itemNewList.size() == 0}">
	    		<a href="applicantShowItemNew.action" class="btn btn-info pull-right"><span class="glyphicon glyphicon-plus"></span>重新申报新项目</a>
	    	</s:if>
	        <table border="1" width="400" class="table table-hover table-bordered table-responsive table-condensed" id="table">
				<tr class="info">
				    	<th>项目ID</th>
					    <th>项目名称</th>
					    <th>项目总经费</th>
					    <th>项目发布时间</th>
					    <th>项目发布人</th>
					    <th>项目申报总人数</th>
				    	<th>项目审核状态</th>
				    	<th>项目审核结果</th>
				    	<s:if test="%{#request.applicantList.get(0).checkedState == '未通过'}">
				    	<th>未通过理由</th>
				    	</s:if>
				    	<th>审核人</th>
				    	<s:if test="%{#request.applicantList.get(0).appBook == null}">
				    		<th>发布项目申请书</th>
				    	</s:if>
				    	<s:else>
				    		<th>查看项目申请书</th>
				    	</s:else>
				    	<th>取消申报</th>
			 	</tr>
			 	
 				<s:iterator value="#request.applicantList" var="applicant">
	 				<tr>
				    		<td align="center"><s:property value="#applicant.itemNew.id"/></td>
		      				<td align="center"><s:property value="#applicant.itemNew.itemName"/></td>
		      				<td align="center"><s:property value="#applicant.itemNew.money"/></td>
		      				<td align="center"><s:property value="#applicant.itemNew.publishTime"/></td>
							<td align="center"><s:property value="#applicant.itemNew.publisher.name"/></td>
							<td align="center"><s:property value="#applicant.itemNew.applicants.size()"/></td>
							<td align="center">
								<s:if test="#applicant.isChecked">已审核</s:if>
								<s:else>未审核</s:else>
							</td>
							<td align="center"><s:property value="#applicant.checkedState"/></td>
							<s:if test="%{#applicant.checkedState == '未通过'}">
								<td align="center"><s:property value="#applicant.noPassReason"/></td>
							</s:if>
							<td align="center"><s:property value="#applicant.checkor.name"/></td>
							<s:if test="%{#request.applicantList.get(0).appBook == null}">
							<td align="center"><a data-toggle="modal" href="#appBookModal"  class="btn btn-primary"><span class="glyphicon glyphicon-remove"></span>发布申请书</a></td>
							</s:if>
							<s:else>
				    		<td align="center"><a href="applicantFindAppBook.action"  class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>查看申请书</a></td>   
				    		</s:else>
							<td align="center"><a href="applicantCancelItemNew.action?itemNewId=<s:property value="#applicant.itemNew.id"/>"  class="btn btn-primary"><span class="glyphicon glyphicon-remove"></span>取消申报</a></td>   
	   				</tr>   
   				</s:iterator>
   			</table>
	    </div>
	    
	    <s:if test="%{#request.declareItemNewFlag == 'declareSuccess'}">
	    	<div id="declareItemNewFlag" class="hide"><s:property value="#request.declareItemNewFlag"/></div>
	    </s:if>
	    
	    <s:if test="%{#request.cancelItemNewFlag == 'cancelSuccess'}">
	    	<div id="cancelItemNewFlag" class="show"><s:property value="#request.cancelItemNewFlag"/></div>
	    </s:if>
	</div>





	<!-- Modal -->
	<div id="appBookModal" class="modal fade" role="dialog">
	  <div class="modal-dialog" style="width: 80%;">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      
	      <div class="modal-body" style="height: 735px;">
	      
	      
		      <form action="applicantPublishAppBook.action" method="post" >
				
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


    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/dialog/mdialog.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script>  
    <script src="<%=basePath%>js/table.js"></script> 
    <script src="<%=basePath%>ckeditor/ckeditor.js"></script> 
    <script type="text/javascript">
    if($("#declareItemNewFlag").eq(0) != null){
		if($("#declareItemNewFlag").text() == "declareSuccess"){
			new TipBox({type:'success',str:'申请成功' ,hasBtn:true});
			$("#declareItemNewFlag").text("");
		}
	}

    if($("#cancelItemNewFlag").eq(0) != null){
		if($("#cancelItemNewFlag").text() == "cancelSuccess"){
			new TipBox({type:'success',str:'项目取消成功' ,hasBtn:true});
			$("#cancelItemNewFlag").text("");
		}
	}

    $("#myModal").modal();
    var myeditor = CKEDITOR.replace('textBody', { height: '545px', width: '100%' , uiColor: '#14B8C4'});
    </script>
    
    
	</body>  
</html>