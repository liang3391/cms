<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>页面管理</title>
<link href="${pageContext.request.contextPath}/css/public.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/Brand_category.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wapper">
 <div id="header" class="fixed">
  <a href="#" class="logo"><img src="${pageContext.request.contextPath}/images/logo.jpg"/></a>
  <a href="#" class="category">&gt;&nbsp;页面管理</a>
  <a href="#" class="manage green">查看其它管理</a>
  <span>欢迎您，我就是别跑 <a href="#" class="green">[退出]</a></span>
 </div>
 <div class="main index fixed">
  <ul class="fixed">
   <li><a href="${pageContext.request.contextPath}/toIndex.htm" class="ibj01">美试网首页</a></li>
   <li><a href="${pageContext.request.contextPath}/toFree.htm" class="ibj02">免费试用频道</a></li>
   <li><a href="${pageContext.request.contextPath}/toNaked.htm" class="ibj03">裸价体验频道</a></li>
   <li><a href="#" class="ibj04">美试指数频道</a></li>
   <li><a href="#" class="ibj05">消费真相频道</a></li>
   <li><a href="#" class="ibj06">产品经理频道</a></li>
   <li><a href="#" class="ibj07">最牛粉丝频道</a></li>
   <li><a href="#" class="ibj08">大牌活动频道</a></li>
   <li><a href="#" class="ibj09">拼手气频道</a></li>
  </ul>
 </div>
</div>
</body>
</html>
