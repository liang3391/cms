<%@ page language="java"   pageEncoding="UTF-8" import="java.util.*,com.framelib.common.CommonConstants"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	/*********PATH***********/
	String basePath = request.getContextPath();
	String imagePath = CommonConstants.IMAGE_PATH;
%>

<script type="text/javascript">  
	var basePath = '<%=basePath%>';
	var imagePath = '<%=imagePath%>';
</script>
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.7.2.min.js" > </script>

<!-- 倒计时js -->
<script type="text/javascript" src="<%=basePath%>/js/product/countDown.js" > </script>

<!-- 弹出层引入的资源 -->
<script type="text/javascript" src="<%=basePath%>/js/common/popup.js" > </script>
<link href="${pageContext.request.contextPath}/css/popup.css" rel="stylesheet" type="text/css" />
