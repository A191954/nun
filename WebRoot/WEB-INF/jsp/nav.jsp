<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="background: url('/nun/image/main.jpg');">
	       <ul class="nav navbar-right top-nav">         
            <li class="dropdown">
                <a href="#"><s:property value="#session.username"/>&nbsp;&nbsp;<b class="glyphicon glyphicon-user"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span>个人简介</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-pencil"></span>修改密码</a></li>
                    <li class="divider"></li>
                    <s:if test="%{#session.usertype == 'applicant'}">
                    	<li><s:a href="applicantLoginOutAction.action"><span class="glyphicon glyphicon-off"></span>退出系统</s:a></li>
                    </s:if>
                    <s:elseif test="%{#session.usertype == 'publisher'}">
                    	<li><s:a href="publisherLoginOutAction.action"><span class="glyphicon glyphicon-off"></span>退出系统</s:a></li>
                    </s:elseif>
                    <s:else>
                    	<li><s:a href="applicantLoginOutAction.action"><span class="glyphicon glyphicon-off"></span>退出系统</s:a></li>
                    </s:else>
                </ul>
            </li>
		  </ul>
		  
		   <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li>
                    <a href="#"><p><span class="glyphicon glyphicon-user"></span>用户中心</p></a>
                    <ul id="submenu-1" class="collapse">
                        <li><a href="#"><p><span class="glyphicon glyphicon-pencil"></span>修改登录密码</p></a></li>
                        <li><a href="#"><p><span class="glyphicon glyphicon-info-sign"></span>查看个人信息</p></a></li>
                        <li><a href="#"><p><span class="glyphicon glyphicon-pencil"></span>修改个人信息</p></a></li>
                    </ul>
                </li>
                <s:if test="%{#session.usertype == 'applicant'}">
                <li>
                    <a href="#"><p><span class="glyphicon glyphicon-th-large"></span>项目管理</p></a>
                    <ul id="submenu-2" class="collapse">
						<li><a href="applicantFindOldHistory.action"><p><span class="glyphicon glyphicon-search"></span>查看历史申报项目</p></a></li>
                        <li><a href="applicantShowItemNew.action"><p><span class="glyphicon glyphicon-inbox"></span>申报新项目</p></a></li>
                        <li><a href="applicantFindItemNew.action"><p><span class="glyphicon glyphicon-search"></span>查看新申报项目</p></a></li>
                        <li><a href="applicantFindMenbers.action"><p><span class="glyphicon glyphicon-th-list"></span>查看组成员</p></a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-ice-lolly"></span>经费管理</a>
					<ul id="submenu-3" class="collapse">
						<li><a href="#"><p><span class="glyphicon glyphicon-plus"></span>第一次报账</p></a></li>
						<li><a href="#"><p><span class="glyphicon glyphicon-plus"></span>第二次报账</p></a></li>
						<li><a href="#"><p><span class="glyphicon glyphicon-plus"></span>第三次报账</p></a></li>
					</ul>
                </li>
                </s:if>
                <s:elseif  test="%{#session.usertype == 'publisher'}">
                 <li>
                	<a href="#"><span class="glyphicon glyphicon-th-large"></span>项目管理</a>
					<ul id="submenu-3" class="collapse">
						<li><a href="publisherFindHistoryPublishItem.action"><p><span class=""></span>查看历史发布项目</p></a></li>
						<li><a href="publisherFindItemNew.action"><p><span class=""></span>查看新项目</p></a></li>
					</ul>
				 </li>
                </s:elseif>
                <s:elseif  test="%{#session.usertype == 'checkor'}">
                 <li>
                	<a href="#"><span class="glyphicon glyphicon-th-large"></span>项目审核</a>
					<ul id="submenu-3" class="collapse">
						<li><a href="checkorFindAllPublishItemNewApplicants.action"><p><span class=""></span>查看已申请的项目申请人</p></a></li>
						<li><a href="checkorFindCheckedApplicants.action"><p><span class=""></span>查看自己审核的项目申请人</p></a></li>
					</ul>
				 </li>
                </s:elseif>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-scale"></span>报表统计</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-alert"></span>关于系统</a>
                </li>
            </ul>
        </div>
	    </nav>