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
						<em class="green">试用中活动产品管理</em>
					</h2>
					<div class="fl fixed">
						<!--左侧menu-->
						<%@ include file="../left.jsp" %>
						<!--左侧 menu-->
					</div>
					<div class="fr" id="obj_le">
						<div class="right_box">
				          <div class="lt_search">
				          <form id="selectForm" name="selectForm" action="getOnSaleProductList.htm?type=1" method="post">
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
										<label><span>活动编号：</span></label>
										<input name="id" type="text"  value="${searchAct.id}"/>
									</li>
									<li>
										<label><span>活动状态：</span></label>
										<select name="status" >
											<option value="-1" ${searchAct.status==-1?"selected":""}>不限</option>
											<option value="21" ${searchAct.status==21?"selected":""}>等待申请开始</option>
											<option value="22" ${searchAct.status==22?"selected":""}>申请中</option>
											<option value="23" ${searchAct.status==23?"selected":""}>审核中</option>
											<option value="24" ${searchAct.status==24?"selected":""}>订单提交中</option>
										</select>
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
				            <form action="<%=basePath%>/prd/stopOnSaleProduct.htm?type=1" method="post" name="productForm" id="productForm">
				              <table class="_Tabl">
				                <thead>
				                  <tr>
				                     <th width="165	">产品名称</th>
			                         <th width="93">保证金</th>
			                         <th width="125">开放试用人数</th>
			                         <th width="125">累计试用人数</th>
			                         <th width="113">活动状态</th>
			                         <th width="114">操作</th>
				                  </tr>
				                </thead>
				                <c:forEach  items="${po.list}" var="act">
					                <tbody>
					                    <tr class="lt_probm">
					                        <td colspan="6" >
					                          产品编码：<span>${act.productCode}</span>
					                          活动编号：<span>${act.id}</span>
					                          活动时间：<span><fmt:formatDate value="${act.onTime}" pattern="yyyy/MM/dd HH:mm"/>-<fmt:formatDate value="${act.offTime}" pattern="yyyy/MM/dd HH:mm"/></span>
					                        </td>
					                    </tr>
					                    <tr class="lt_main">
					                        <td><!--产品名称-->
					                            <div class="mtd_1"> 
					                                <span><input class="single" id="cbx_0" type="checkbox" name="stopActId" value="${act.id}"></span> 
					                                <strong><img src="<%=imagePath%>/${act.mListPic}" width="60" height="60" alt=""></strong> 
					                                <font> <a href="#">${act.productName}</a> </font>
					                            </div>
					                        </td>
					                        <td><!--体验价-->
					                            <div class="mtd_2">
					                                <p>${act.price}</p>
					                            </div>
					                        </td>
					                        <td><!--开放体验人数-->
					                            <div class="mtd_2">
					                                <p>${act.openExperience}</p>
					                            </div>
					                        </td>
					                        <td><!--累计体验人数-->
					                            <div class="mtd_2">
					                                <p>${act.totalExperience==null?0:act.totalExperience}</p>
					                            </div>
					                        </td>
					                        <td><!--活动状态-->
					                            <div class="mtd_2">
					                            		<c:if test="${act.status==21}">
					                            			<p>等待申请开始</p>
							                                <p class="FF6600">距离申请开始</p>
							                                <p class="FF6600"  id="${act.id}_timer"><script>countDown_colon("${act.id}_timer","${act.onTime}",0)</script></p>
					                            		</c:if>
					                            		<c:if test="${act.status==22}">
					                            			<p class="green">申请中</p>
							                                <p class="FF6600">距离申请结束</p>
							                                <p class="FF6600"  id="${act.id}_timer"><script>countDown_colon("${act.id}_timer","${act.onTime}",<%=Constants.FREE_ACT_TIME_APPLY%>)</script></p>
					                            		</c:if>
					                            		<c:if test="${act.status==23}">
					                            			<p class="green">审核中</p>
							                                <p class="FF6600">距离审核结束</p>
							                                <p class="FF6600"  id="${act.id}_timer"><script>countDown_colon("${act.id}_timer","${act.onTime}",<%=Constants.FREE_ACT_TIME_APPLY+Constants.FREE_ACT_TIME_CHECK%>)</script></p>
					                            		</c:if>
					                            		<c:if test="${act.status==24}">
					                            			<p class="green">订单提交中</p>
							                                <p class="FF6600">距离提交结束</p>
							                                <p class="FF6600"  id="${act.id}_timer"><script>countDown_colon("${act.id}_timer","${act.onTime}",<%=Constants.FREE_ACT_TIME_APPLY+Constants.FREE_ACT_TIME_CHECK+Constants.FREE_ACT_TIME_SUBMIT%>)</script></p>
					                            		</c:if>
					                            </div>
					                        </td>
					                        <td><!--操作-->
					                            <div class="mtd_4">
					                                <ul>
					                                   <li><a class="negativeClass abutton" href="#">终止试用</a></li>
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
				                   <input class="pl_btn batchBtn" type="button" value="批量终止体验">
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
		     <h3>终止试用活动提示</h3>
		     <div class="pop_cont">
		          <ul>
		             <li>终止试用会导致活动立即下线</li>
					 <li>有可能会对品牌产生损失，请慎重选择</li>
		          </ul>
		          <p><input type="button" onclick="javascript:$('#productForm').submit();" class="bg1" value="确认终止">
		          <input type="button" class="bg2 shatdown" value="取消" ></p>
		     </div>
		</div>
		<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/Tools.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/product/activityCheck.js"></script>
		<script>ev_begin($('#recycle'),$('.negativeClass'),$('#mask'),$('.shatdown'))</script>
	</body>
</html>