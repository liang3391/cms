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
					<h2>
						<a href="#">综合管理后台</a> >
						<a href="#">产品及活动管理</a> >
						<a href="#">免费试用</a> >
						<em class="green">在售产品管理 - 编辑中产品管理</em>
					</h2>
					<div class="fl fixed">
						<!--左侧menu-->
						<%@ include file="../left.jsp" %>
						<!--左侧 menu-->
					</div>
					<div class="fr" id="obj_le">
						<div class="right_box">
				          <div class="lt_search">
				          <form id="selectForm" name="selectForm" action="getEditingProductList.htm?type=1" method="post">
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
				                </ul>
				              </div>
				              <p class="lt_btn">
				                <input type="submit" value="搜索" />
				              </p>
				            </form>
				          </div>
				          <!--所有待售产品开始-->
				          <div class="sales">
				            <div id="sales_pro" class="sales_products">
				            <form action="<%=basePath%>/prd/removeEndSaleProduct.htm?redirectUrl=/prd/getEditingProductList.htm?type=1" method="post" name="productForm" id="productForm">
				              <table class="_Tabl">
				                <thead>
				                  <tr>
				                     <th width="165	">产品名称</th>
			                         <th width="93">保证金</th>
			                         <th width="125">累计试用人数</th>
			                         <th width="125">累计产品喜好度</th>
			                         <th width="113">编辑中的活动</th>
			                         <th width="114">操作</th>
				                  </tr>
				                </thead>
				                <c:forEach  items="${po.list}" var="act">
					                <tbody>
					                    <tr class="lt_probm">
					                        <td colspan="6" >
					                          产品编码：<span>${act.productCode}</span>
					                        </td>
					                    </tr>
					                    <tr class="lt_main">
					                        <td><!--产品名称-->
					                            <div class="mtd_1"> 
					                                <span><input class="single" id="cbx_0" type="checkbox" name="removePrd" value="${act.productCode}"></span> 
					                                <strong><img src="<%=imagePath%>/${act.mListPic}" width="60" height="60" alt=""></strong> 
					                                <font> <a href="#">${act.productName}</a> </font>
					                            </div>
					                        </td>
					                        <td><!--市场价-->
					                            <div class="mtd_2">
					                                <p>${act.marketPrice}</p>
					                            </div>
					                        </td>
					                        <td><!--累计体验人数-->
					                            <div class="mtd_2">
					                                <p>${act.totalExperience}</p>
					                            </div>
					                        </td>
					                        <td><!--累计产品喜好度-->
					                            <div class="mtd_2">
					                                <p>${act.totalGoodEvaluate}%</p>
					                            </div>
					                        </td>
					                        <td><!--编辑中的活动-->
					                            <div class="mtd_4">
					                                <ul>
						                                <c:if test="${act.modifyTime!=null}">
						                                   <li><a href="#">活动详情</a></li>
					                                   </c:if>
					                                </ul>
					                            </div>
					                        </td>
					                        <td><!--操作-->
					                             <div class="mtd_4">
					                                <ul>
													    <li><a target="_blank" class="abutton" href="<%=basePath%>/prd/getPrd.htm?prdCode=${act.productCode}&ver=${act.version}&type=1&from=editing">编辑产品</a></li>
													     <li><a target="_blank" class="abutton" href="<%=basePath%>/prd/getActivity.htm?prdCode=${act.productCode}&ver=${act.version}&type=1&from=editing">编辑活动</a></li>
					                                    <li><a class="negativeClass abutton" href="#">放入回收站</a></li>
					                                </ul>
					                            </div>
					                        </td>
					                    </tr>
					                </tbody>
				                </c:forEach>
				              </table>
				            <c:if test="${!empty po.list}">
					              <!--全选按钮-->
				                <div id="allBtn" class="allBtn">
				                   <input class="multiple" type="checkbox"><span>全选</span>
				                   <input class="pl_btn batchBtn" type="button" value="批量放入回收站">
				                </div>
					            <jsp:include page="../page.jsp">
					            	<jsp:param value="selectForm" name="formName"/>
					            </jsp:include>
				            </c:if>
				            </form>
				            </div>
				         </div>
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
					 <li>用户将搜不到产品，也不能进行活动申报。</li>
		          </ul>
		          <p><input type="button" onclick="javascript:$('#productForm').submit();" class="bg1" value="放入回收站">
		          <input type="button" class="bg2 shatdown" value="取消" ></p>
		     </div>
		</div>
		<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/Tools.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/product/activityCheck.js"></script>
		<script>ev_begin($('#recycle'),$('.negativeClass'),$('#mask'),$('.shatdown'))</script>
	</body>
</html>