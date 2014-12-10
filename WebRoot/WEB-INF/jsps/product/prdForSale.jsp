<%@ include file="../common/import.jsp" %>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>待售产品管理</title>
<link href="<%=basePath%>/css/produce_manage.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wapper">
  <div class="main fixed">
    <%@ include file="header.jsp" %>
    <div class="box">
      <h2><a href="#">综合管理后台</a> > <a href="#">产品及活动管理</a> > <a href="#">${param.type==0?'裸价体验':'免费试用' }</a> > <em class="green">待售产品管理</em></h2>
      <div class="fl fixed">
          <%@ include file="left.jsp" %>
      </div>
      <div class="fr" id="obj_le">
        <div class="right_box">
          <form action="<%=basePath %>/prd/selectForSalePrd.htm?type=${param.type}" name="saleform" id="saleform" method="post">
          <div class="lt_search">
              <div class="search_title">
                <span>
                <input type="reset" value="清空条件">
                </span></div>
              <div class="search_show">
                <ul>
                  <li>
                    <label><span>品牌ID：</span></label>
                    <input name="brandId" type="text" value="${prd.brandId}"/>
                  </li>
                  <li>
                    <label><span>产品编码：</span></label>
                    <input name="productCode" type="text" value="${prd.productCode}"/>
                  </li>
                 </ul>
              </div>
              <p class="lt_btn">
                <input type="submit" value="搜索" />
              </p>
          </div>
          <!--所有代售产品开始-->
          <div class="sales">
            <div id="sales_pro" class="sales_products">
              <table>
                <thead>
                  <tr>
                    <th width="240">产品名称</th>
                    <th width="80">市场价</th>
                    <th width="95">发布时间</th>
                    <th width="95">编辑中活动</th>
                    <th width="115">操作</th>
                  </tr>
                </thead>
                <tbody>
                 <c:forEach items="${po.list}" var="prdOne">
                 	<tr class="lt_probm">
                    	<td colspan="5" >产品编码：<span>${prdOne.productCode}</span></td>
	                </tr>
	                <tr class="lt_main">
	                    <td>
                        <div class="brpr_3"> 
                           <span><input class="single" name="ids" value="${prdOne.productId}" type="checkbox"></span>
                            <dl class="cppl">
                              <a href="<%=basePath%>/prd/getPreviewPrd.htm?productCode=${prdOne.productCode}&version=${prdOne.version}" class="ler"><img src="<%=imagePath%>/${prdOne.mListPic}" width="60px" height="60px"></a>
                              <dt class="ler"><a href="<%=basePath%>/prd/getPreviewPrd.htm?productCode=${prdOne.productCode}&version=${prdOne.version}">${prdOne.productName}</a></dt>
                            </dl>
                        </div>
	                    </td>
	                    <td>
	                       <div class="mtd_2">
	                        <p>${prdOne.marketPrice}</p>
	                       </div>
	                    </td>
	                    <%--<td>
	                    	<div class="mtd_2">
	                        <p>${prdOne.pmName}</p>
	                      	</div>
	                    </td>
	                    --%><td>
	                    	<div class="mtd_3">
	                        <p>
	                        	<fmt:formatDate value="${prdOne.prdCreateTime}" pattern="yyyy-MM-dd"/>
	                        </p>
	                        <p>
	                        	<fmt:formatDate value="${prdOne.prdCreateTime}" pattern="HH:mm"/>
	                        </p>
	                        <%--<p>13:03:09</p>--%>
	                      	</div>
	                    </td>
	                    <td>
                        	<div class="mtd_4">
	                            <ul>
	                            <c:if test="${!empty prdOne.createTime}">
	                              <li><a target="_blank" href="#">活动详情</a></li>
	                            </c:if>
	                            </ul>
	                         </div>
                      </td>
	                    <td>
	                      <div class="mtd_4">
	                        <ul>
	                          <li><a class="abutton" href="<%=basePath %>/prd/getPrd.htm?prdCode=${prdOne.productCode}&ver=${prdOne.version}&from=forsale&type=${prdOne.type}">编辑产品</a></li>
	                          <li><a class="abutton" href="<%=basePath %>/prd/getActivity.htm?prdCode=${prdOne.productCode}&ver=${prdOne.version}&type=${prdOne.type}">编辑活动</a></li>
	                          <li><a class="abutton negativeClass" href="">放入回收站</a></li>
	                        </ul>
	                      </div>
	                      <%--<input type="button" id="modifyPrd" style="display: none;" value="/prd/getPrd.htm?prdCode=${prdOne.productCode}&ver=${prdOne.version}"/>
	                      <input type="button" id="modifyAct" style="display: none;" value="/prd/getPrd.htm?prdCode=${prdOne.productCode}&ver=${prdOne.version}&type=${prdOne.type}"/>--%>
	                    	<%--<a id="aaa1" href="<%=basePath %>/prd/getPrd.htm?prdCode=${prdOne.productCode}&ver=${prdOne.version}">aaa1</a>--%>
	                    </td>
	                 </tr>                
                 </c:forEach>
                </tbody>
              </table>
            <c:if test="${!empty po.list}">
          	<!--全选按钮-->
          	<div id="allBtn" class="allBtn">
           	 <input class="multiple" type="checkbox"><span>全选</span>
           	 <input class="pl_btn batchBtn" type="button" value="批量放入回收站">
          	</div>
            </c:if>
            </div>
	          <c:if test="${!empty po.list}">
	            <jsp:include page="page.jsp">
	            	<jsp:param value="saleform" name="formName"/>
	            </jsp:include>
	          </c:if>
          </div>
          
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
<!--产品放入回收站弹出框-->
   <div id="mask"></div>
   <div id="recycle" class="pop-box bg_box_green">
     <h3>放入回收站提示</h3>
     <div class="pop_cont">
          <ul>
             <li>放入回收站的产品不在前端展示</li>
			 <li>用户将搜索不到产品</li>
          </ul>
          <p><input type="button" class="bg1" id="del" value="放入回收站"><input type="button" class="bg2 shatdown" value="取消" ></p>
     </div>
 </div>
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript">
ev_begin($('#recycle'),$('.negativeClass'),$('#mask'),$('.shatdown'))
$(function(){
	$("#del").click(function(){
		$("#saleform").attr("action",basePath+"/prd/modifyPrdStd.htm?type="+${param.type});
		$("#saleform").submit();
	})
})
</script>
</body>
</html>