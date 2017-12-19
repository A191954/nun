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
	    	<h1 class="text-center"><span class="alert alert-info">查看项目申请人(申请了新项目的人)</span></h1>
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
				    	<th>查看项目申请书</th>
				    	<th class="text-danger">审核通过否？</th>
				    	<th>必须填写未通过原因</th>
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
							
							<s:if test="#applicant.isChecked">
								<td align="center">已审核</td>
							</s:if>
							<s:else>
								<td align="center">未审核</td>
							</s:else>
							
							<s:if test="%{#applicant.appBook != null}">
								<td align="center"><a href="checkorAppBook.action?id=<s:property value="#applicant.id"/>"  class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>查看申请书</a></td>
							</s:if>
							<s:else>
								<td align="center">该人暂未发布</td>
							</s:else>
							
							<td align="center">
								<form>
									<div class="radio radio-danger">
		                                <input type="radio" name="checkedStateOne" id="radioA<s:property value="#applicant.id"/>" value="true" class="radioTrue" />
		                                <label for="radioA<s:property value="#applicant.id"/>">可通过</label>
	                            	</div>
	                            	<div class="radio radio-danger">
		                                <input type="radio" name="checkedStateOne" id="radioB<s:property value="#applicant.id"/>" value="false" class="radioFalse"/>
		                                <label for="radioB<s:property value="#applicant.id"/>">未通过</label>
	                            	</div>
								
								</form>
                            		
							</td>
							
							<td align="center">
									<div class="checkbox checkbox-success">
				                        <input id="checkbox<s:property value="#applicant.id"/>" class="styled reasonInput" type="checkbox">
				                        <label for="checkbox<s:property value="#applicant.id"/>">没通过必须填写</label>
				                        
	                    			</div>
							</td>
	   				</tr>   
   				</s:iterator>
   			</table>
	    </div>
	</div>
	<form action="checkApplicantItemNew.action" class="checkApplicantItemNew hide" method="post" id="form">
		<input type="text" value="12" name="id" class="appId hide" id="appId"/>
		<input type="text" value="" name=checkedState class="checkedState" id="appCheckedState"/>
        <textarea rows="2" cols="5" name="noPassReason" class="" id="appNoPassReason"></textarea>
															
     </form>
     //分页
	<center>
		<ul class="pagination" id="menu">
			<li class="">
				<a href="checkorFindAllPublishItemNewApplicants.action?currentPage=<s:property value="#request.page.firstPage" />">
				<span class="glyphicon glyphicon-chevron-left"></span>首页</a>
			</li>
			<s:if test="%{#request.page.hasPrePage}">
				<li class=""><a href="checkorFindAllPublishItemNewApplicants.action?currentPage=<s:property value="#request.page.firstPage" />">上一页</a></li>
			</s:if>
			
			<s:bean name="org.apache.struts2.util.Counter" var="counter">
                  <s:param name="first" value="#request.page.startPage" />
                  <s:param name="last" value="#request.page.endPage" />
                  <s:iterator status="st">
                      <li><a href="checkorFindAllPublishItemNewApplicants.action?currentPage=<s:property/>"><s:property /></a></li>
                  </s:iterator>
             </s:bean>
			<s:if test="%{#request.page.hasNextPage}">
				<li class=""><a href="checkorFindAllPublishItemNewApplicants.action?currentPage=<s:property value="#request.page.nextPage" />">下一页</a></li>
			</s:if>
			<li class=""><a href="checkorFindAllPublishItemNewApplicants.action?currentPage=<s:property value="#request.page.lastPage"/>">尾页
			 <span class="glyphicon glyphicon-chevron-right"></span>
			</a></li>
			<li class="alert alert-info text-primary">
				
					共<s:property value="#request.page.totalPages"/>页 当前第<s:property value="#request.page.currentPage"/>页
				
			</li>
		</ul>
  			
 	</center>


	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
	  <div class="modal-dialog">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header alert alert-danger">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title text-center">审核未通过的原因</h4>
	      </div>
	      <div class="modal-body">
	        <textarea class="form-control" rows="5" id="noReason"></textarea>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal" id="noReasonSubmit">提交</button>
	      </div>
	    </div>
	
	  </div>
	</div>
    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script>
	<script type="text/javascript">
	$("input:radio.radioTrue").click(function (){
		var checkedState = $(this).val();
		var appId = $(this).parent().parent().parent().siblings().eq(0).text();

		alert(appId);
		$("#appId").val(appId);
		$("#appCheckedState").val(checkedState);
		$("#form").submit();
	});
	$("input:checkbox.reasonInput").click(function (){
		var thisTd = $(this).parent().parent();
		var checkedState = $(this).parent().parent().prev().find("input:radio.radioFalse").val();
		var appId = $(this).parent().parent().siblings().eq(0).text();
		
		console.log(checkedState);
		$("#myModal").css({"background-color":"rgba(240, 173, 78, 0.31)"});
		$("#myModal").modal();
		$("#appId").val(appId);
		$("#appCheckedState").val(checkedState);
		
	});
	//modal按钮提交
	$("#noReasonSubmit").click(function(){
		var appNoPassReason = $("#noReason").val();
		$("#appNoPassReason").val(appNoPassReason);
		$("#noReason").val("");
		$("#form").submit();
	});

	$("input:checkbox.radioFalse").click(function(){
	});
	$("input:radio.radioFalse").attr("checked",true);



	</script>   
</body>
</html>