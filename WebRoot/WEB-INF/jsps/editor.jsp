<%@ include file="../jsps/common/import.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String detail = (String)request.getAttribute("prDetail");
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Kindeditor</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/kindeditor-4.1.10/themes/default/default.css">
	<link rel="stylesheet" href="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.css" />
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/kindeditor-min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/kindeditor-4.1.10/plugins/code/prettify.js"></script>
  </head>
  
  <body>
	<textarea name="prdDto.detail.detail" class="textarea" style="width:730px;height:430px;visibility:hidden;"><%=detail%></textarea>
  </body>
  <script type="text/javascript">
  	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea.textarea', {
			allowFileManager : false,	//不允许选择已经上传的图片
			allowImageRemote : false,	//不允许上传网络图片
			themeType : 'simple',
			resizeType:0,	//不可改变编辑器大小
			cssPath : basePath+'/js/kindeditor-4.1.10/plugins/code/prettify.css',
			uploadJson : basePath+'/jsp/upload_json.jsp',
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
				});
			}
		});
	});
  </script>
</html>
<%!
private String htmlspecialchars(String str) {
	if(str == null) return "";
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%>
