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
	    	<h1 class="text-center"><span class="alert alert-info">新项目组成员</span></h1>
	    	<button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#menberModal" id="addMenber"><span class="glyphicon glyphicon-plus"></span>添加组成员</button>
	    	
	    	<div id="menberModal" class="modal fade" role="dialog">
	    		<div class="modal-dialog">
	    		
	    			<div class="modal-content">
	    				<div class="modal-header">
	    					<button type="button" class="close" data-dismiss="modal">&times;</button>
	    					<h4 class="modal-title text-center text-info"  id="modal-h4"><span class="glyphicon glyphicon-plus-sign"></span>添加组成员</h4>
	    				</div>
	    				<div class="modal-body">
	    					<form action="applicantAddMenber.action" role="form" class="form-horizontal" id="menberForm">
	    						<div class="form-group hide">
	    							<label class="col-sm-2 col-md-2 text-primary" for="id">组员ID:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="text" class="form-control" id="id" name="id"/>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="name">组员姓名:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="text" class="form-control" id="name" name="name"/>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="brief">组员基本资料:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<textarea class="form-control" rows="5" id="brief" name="brief"></textarea>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="age">组员年龄:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="text" class="form-control" id="age" name="age"/>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="telephone">组员联系电话:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="text" class="form-control" id="telephone" name="telephone"/>
	    							</div>
	    						</div>
	    						<div class="form-group">
	    							<label class="col-sm-2 col-md-2 text-primary" for="email">组员邮箱地址:</label>
	    							<div class="col-sm-10 col-md-10">
	    								<input type="email" class="form-control" id="email" name="email"/>
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
				    <th class="hide">成员ID</th>
				    <th>成员姓名</th>
				    <th>成员年龄</th>
				    <th>成员电话</th>
				    <th>成员邮箱</th>
				    <th>成员基本资料</th>
				    <th>修改组成员</th>
				    <th>删除组成员</th>
			 	</tr>
 				<s:iterator value="#request.menberList" var="menber">
	 				<tr>
	                	<td align="center" class="hide"><s:property value="#menber.id"/></td>
	      				<td align="center"><s:property value="#menber.name"/></td>
	      				<td align="center"><s:property value="#menber.age"/></td>
	      				<td align="center"><s:property value="#menber.telephone"/></td>
						<td align="center"><s:property value="#menber.email"/></td>
						<td align="center"><s:property value="#menber.brief"/></td>
						<td align="center"><a href="#" class="btn btn-info updateMenber" data-toggle="modal" data-target="#menberModal"><span class="glyphicon glyphicon-pencil"></span>修改</a></td>   
	   					<td align="center"><a href="applicantDeleteMenber.action?menberId=<s:property value="#menber.id"/>" class="btn btn-warning deleteMenber" ><span class="glyphicon glyphicon-remove"></span>删除</a></td>
	   				</tr>   
   				</s:iterator>
   			</table>
   			
   			<s:if test="%{#request.deleteMenberFlag == 'deleteSuccess'}">
   				<div id="deleteMenberFlag" class="hide"><s:property value="#request.deleteMenberFlag"/></div>
   			</s:if>
   			<s:if test="%{#request.addMenberFlag == 'addSuccess'}">
   				<div id="addMenberFlag" class="hide"><s:property value="#request.addMenberFlag"/></div>
   			</s:if>
   			<s:if test="%{#request.updateMenberFlag == 'updateSuccess'}">
   				<div id="updateMenberFlag" class="hide"><s:property value="#request.updateMenberFlag"/></div>
   			</s:if>

	    </div>
	</div>

    <script src="<%=basePath%>js/jquery.min.js"></script>
    <script src="<%=basePath%>js/dialog/mdialog.js"></script>
    <script src="<%=basePath%>js/bootstrap.min.js"></script>
    <script src="<%=basePath%>js/topLeft.js"></script>
	<script src="<%=basePath%>js/vertically-centered-bootstrap-modals.js"></script>
	<script src="<%=basePath%>js/table.js"></script>
	 
	<script type="text/javascript">
		$(document).ready(function(){
			$(".updateMenber").click(function(){
				var tds = $(this).parent().siblings();
				$("#id").val(tds.eq(0).text());
				$("#name").val(tds.eq(1).text());
				$("#age").val(tds.eq(2).text());
				$("#telephone").val(tds.eq(3).text());
				$("#email").val(tds.eq(4).text());
				$("#brief").val(tds.eq(5).text());
			});

			$("#addMenber").click(function(){
				var actionUrl = "applicantAddMenber.action";
				$("#modal-h4").html("<span class='glyphicon glyphicon-plus-sign'></span>添加组成员");
				$("#id").val("");
				$("#name").val("");
				$("#age").val("");
				$("#telephone").val("");
				$("#email").val("");
				$("#brief").val("");
				$("#menberForm").attr("action", actionUrl);
				//alert($("#menberForm").attr("action"));
			});
			$(".updateMenber").click(function(){
				var actionUrl = "applicantUpdateMenber.action";
				$("#modal-h4").html("<span class='glyphicon glyphicon-pencil'></span>修改组成员");
				$("#menberForm").attr("action", actionUrl);
				//alert($("#menberForm").attr("action"));
			});
			$("#formSub").click(function(){
				$("#menberForm").submit();
			});

			if($("#deleteMenberFlag").eq(0) != null){
				if($("#deleteMenberFlag").text() == "deleteSuccess"){
					new TipBox({type:'success',str:'删除成功',hasBtn:true});
					$("#deleteMenberFlag").text("");
				}
			}
			if($("#addMenberFlag").eq(0) != null){
				if($("#addMenberFlag").text() == "addSuccess"){
					new TipBox({type:'success',str:'添加成功',hasBtn:true});
					$("#addMenberFlag").text("");
				}
			}
			if($("#updateMenberFlag").eq(0) != null){
				if($("#updateMenberFlag").text() == "updateSuccess"){
					new TipBox({type:'success',str:'修改成功' ,hasBtn:true});
					$("#updateMenberFlag").text("");
				}
			}

	    })
	</script>
</body>
</html>