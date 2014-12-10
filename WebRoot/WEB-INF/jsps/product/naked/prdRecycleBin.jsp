<%@ include file="../../common/import.jsp"%>
<%@ page import="com.qianqian.product.common.Constants"%>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>美试网</title>
		<link href="<%=basePath%>/css/produce_manage.css" rel="stylesheet"
			type="text/css" />
	</head>

	<body>
		<div id="wapper">
			<div class="main fixed">
				<%@ include file="../header.jsp" %>
			    <div class="box">
			      <h2><a href="#">综合管理后台</a> > <a href="#">产品及活动管理</a> > <a href="#">裸价体验</a> > <em class="green">产品回收站</em></h2>
			      <div class="fl fixed">
			         <!--左侧menu-->
			         <%@ include file="../left.jsp" %>
			        <!--左侧 menu-->
			      </div>
			      <div class="fr" id="obj_le">
			       <div class="right_box">
			          <div class="lt_search">
			            <form id="selectForm" name="selectForm" action="<%=basePath%>/prd/getRecycleBinList.htm?type=0" method="post">
			           		<input type="hidden" id="pagenum" name="pagenum" value="" />
			              <div class="search_title">
			                <span>
			                <input type="button" value="清空条件" onclick="javascript:clearSelectForm();">
			                </span>
			              </div>
			              <div class="search_show">
			                <ul>
			                  <li>
			                    <label><span>品牌ID：</span></label>
			                    <input name="brandId" type="text"  value="${searchAct.brandId}"/>
			                  </li>
			                  
			                  <li>
			                    <label><span>产品编码：</span></label>
			                    <input name="productCode" type="text"  value="${searchAct.productCode}"/>
			                  </li>
			                  <li>
			                    <label><span>来源类型：</span></label>
			                    <select name="reportStatus" >
									<option value="-1" ${searchAct.reportStatus==-1?"selected":""}>不限</option>
									<option value="1" ${searchAct.reportStatus==1?"selected":""}>待售产品</option>
									<option value="2" ${searchAct.reportStatus==2?"selected":""}>在售产品</option>
								</select>
			                  </li>
			                </ul>
			              </div>
			             <p class="lt_btn">
			                <input type="submit" value="搜索" />
			              </p>
			            </form>
			          </div>
			          <!--所有代售产品开始-->
			          <div class="sales">
			            <div id="sales_pro" class="sales_products">
			              <table class="_Tabl"><!---->
			                <thead>
			                  <tr>
			                    <th width="165">产品名称</th>
			                    <th width="70">市场价</th>
			                    <th width="90">产品喜好度</th>
			                    <th width="100">发布时间</th>
			                    <th width="110">累计体验人数</th>
			                    <th width="110">来源类型</th>
			                    <th width="100">操作</th>
			                  </tr>
			                </thead>
			                <form action="<%=basePath%>/prd/recoverPrdFromRecycle.htm?type=0" method="post" id="recoverForm">
			                <c:forEach  items="${po.list}" var="act">
			                <tbody>
			                    <tr class="lt_probm">
			                        <td colspan="7" >
			                            产品编码：<span>${act.productCode}</span>
			                            进入回收站时间：<span><fmt:formatDate value="${act.prdRecycledTime}" pattern="yyyy/MM/dd HH:mm"/></span>
			                        </td>
			                    </tr>
			                    <tr class="lt_main">
			                        <td><!--产品名称-->
			                            <div class="mtd_1">
			                                <span><input class="single" id="cbx_1" type="checkbox" name="productCode" value="${act.productCode}"></span>
			                                <strong><img src="<%=imagePath%>/${act.mListPic}" width="60" height="60" alt=""></strong> 
			                                <font> <a href="#">${act.productName}</a> </font>
			                            </div>
			                        </td>
			                        <td><!--市场价-->
			                            <div class="mtd_2">
			                                <p>${act.marketPrice}</p>
			                            </div>
			                        </td>
			                        <td><!--产品喜好度-->
			                            <div class="mtd_2">
			                                <p>${act.goodEvaluate==null?'':act.goodEvaluate+'%'}</p>
			                            </div>
			                        </td>
			                        <td><!--发布时间-->
			                            <div class="mtd_2">
			                                <p><fmt:formatDate value="${act.releaseTime}" pattern="yyyy/MM/dd"/></p>
			                                <p><fmt:formatDate value="${act.releaseTime}" pattern="HH:mm"/></p>
			                            </div>
			                        </td>
			                        <td><!--累计体验人数-->
			                            <div class="mtd_2">
			                                <p>${act.totalExperience==null?"0":act.totalExperience}</p>
			                            </div>
			                        </td>
			                        <c:if test="${act.reportStatus==2}">
				                        <td><!-- 来源类型-->
					                        <div class="mtd_2">
					                            <p class="green">在售产品</p>
					                            <p class="blue"><a target="_blank" href="#">活动记录</a></p>
					                        </div>
					                    </td>
				                        <td>
				                            <div class="mtd_4">
				                                <ul>
				                                    <li><a class="negativeClass abutton1" href="#">恢复到体验结束活动产品</a></li>
				                                </ul>
				                            </div>
				                        </td>
			                        </c:if>
			                        <c:if test="${act.reportStatus==1}">
			                        	<td><!--活动结束时间-->
				                        <div class="mtd_2">
				                            <p>待售产品</p>
				                        </div></td>
				                        <td>
				                            <div class="mtd_4">
				                                <ul>
				                                    <li><a class="negativeClass abutton1" href="#">恢复到待售产品</a></li>
				                                </ul>
				                            </div>
				                        </td>
			                        </c:if>
			                    </tr>
			                </tbody>
			                </c:forEach>
			                </form>
			              </table>
			              	<c:if test="${!empty po.list}">
					              <!--全选按钮-->
				                <div id="allBtn" class="allBtn">
				                   <input class="multiple" type="checkbox">
			                        <span>全选</span>
			                        <input class="pl_btn batchBtn" type="button" value="批量恢复">
				                </div>
					            <jsp:include page="../page.jsp">
					            	<jsp:param value="selectForm" name="formName"/>
					            </jsp:include>
				            </c:if>
			            </div>
			                      
			          </div>
			          
			         </div>
			         <!--right box end-->
			      </div>
			    </div>
			  </div>
			</div>
<!--产品放入回收站弹出框-->
<div id="mask"></div>
<div id="recycle" class="pop-box bg_box_green">
     <h3>恢复产品提示</h3>
     <div class="pop_cont">
          <ul>
             <li>需要恢复的产品，根据来源，待售只能恢复到待售产品。</li>
			 <li>在售只能恢复到体验结束的活动产品，并可以在前端展示。</li>
          </ul>
          <p><input type="button" onclick="javascript:$('#recoverForm').submit();" class="bg1" value="恢复产品"><input type="button" class="bg2 shatdown" value="取消" ></p>
     </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/Tools.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/activityCheck.js"></script>

<script>
   ev_begin($('#recycle'),$('.negativeClass'),$('#mask'),$('.shatdown'))	
</script>
</body>
</html>
