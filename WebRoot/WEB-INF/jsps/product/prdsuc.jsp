<%@ include file="../common/import.jsp" %>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>待售产品页</title>
<link href="<%=basePath%>/css/produce_manage.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wapper">
  <div class="main fixed">
    <%@ include file="header.jsp" %>
    <div class="box">
      <h2><a href="#">综合管理后台</a> > <a href="#">产品及活动管理</a> > <a href="#">裸价体验</a> ><a href="#">新产品发布管理</a> > <em class="green">发布成功</em></h2>
      <div class="fl fixed">
        <%@ include file="left.jsp" %>
      </div>
      <div class="fr">
        <div class="cross_right">
          <div class="cross_show">
          <span></span>
            <h3>恭喜您已发布成功</h3>
            <p>产品已放入待售产品管理</p>
            <p><a href="<%=basePath%>/prd/selectForSalePrd.htm?type=${param.type}">点击进入查看</a></p>
          </div>
          <div class="success_btn">
          	<a class="lokpl" target="_blank" href="#">查看该产品</a>
            <a class="lokpr" href="<%=basePath%>/prd/toPrd.htm">继续发布新产品</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
</body>
</html>
