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
						<a href="#">裸价体验</a> >
						<em class="green">复核活动产品管理</em>
					</h2>
					<div class="fl fixed">
						<!--左侧menu-->
						<%@ include file="../left.jsp" %>
						<!--左侧 menu-->
					</div>
					<div class="fr" id="obj_le">
						<div class="right_box">
							<div class="lt_search">
								<form id="selectForm" name="selectForm" action="getActCheckList.htm?type=0&prdStatus=1" method="post">
									<input type="hidden" id="pagenum" name="pagenum" value="" />
									<div class="search_title">
										<span> <input type="button" value="清空条件" onclick="javascript:clearSelectForm();"> </span>
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
												<label><span>复核状态：</span></label>
												<select name="checkStatus" >
													<option value="-1" ${searchAct.checkStatus==-1?"selected":""}>不限</option>
													<option value="1" ${searchAct.checkStatus==1?"selected":""}>等待复核</option>
													<option value="2" ${searchAct.checkStatus==2?"selected":""}>复核通过</option>
													<option value="3" ${searchAct.checkStatus==3?"selected":""}>复核未通过</option>
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
									<div id="Tab1">
										<div class="Menubox ">
											<ul class="flag_tab">
												<li id="one1" onclick="setTab('one',1,2)" class="hover">
													<a href="javascript:;">待售产品复核</a>
												</li>
												<li id="one2" onclick="setTab('one',2,2)">
													<a href="getActCheckList.htm?type=0&prdStatus=2">在售产品复核</a>
												</li>
											</ul>
										</div>
										<div class="Contentbox">
											<!--未发货退款-->
											<div id="con_one_1">
													<form action="<%=basePath%>/act/reportActivity.htm?type=0&prdStatus=1" method="post" name="reportForm" id="reportForm">
												<table class="_Tabl">
													<thead>
														<tr>
															<th width="165"> 产品名称 </th>
															<th width="65"> 规格 </th>
															<th width="110"> 累计体验人数 </th>
															<th width="65"> 体验价 </th>
															<th width="110"> 开放体验人数 </th>
															<th width="125"> 复核状态 </th>
															<th width="100"> 操作 </th>
														</tr>
													</thead>
													<c:forEach items="${po.list}" var="act">
													<tbody>
														<tr class="lt_probm">
															<td colspan="7">产品编码：
																<span>${act.productCode}</span> 活动编号：
																<span>${act.id}</span> 活动时间：
																<span><fmt:formatDate value="${act.onTime}" pattern="yyyy/MM/dd HH:mm"/>-<fmt:formatDate value="${act.offTime}" pattern="yyyy/MM/dd HH:mm"/></span>
															</td>
														</tr>
														<tr class="lt_main">
															<td>
																<div class="mtd_1">
																	<span><input type="checkbox" name="reportAct"  value="${act.id}" <c:choose><c:when test="${act.checkStatus!=3}">disabled="true" class="nosingle" </c:when><c:otherwise> class="single"</c:otherwise></c:choose>>
																	</span>
																	<strong>
																		<img src="<%=imagePath%>/${act.mListPic}" width="60" height="60" alt="">
																	</strong>
																	<font> <a href="<%=basePath%>/prd/getPreviewPrd.htm?productCode=${act.productCode}&version=${act.version}">${act.productName}</a>
																	</font>
																</div>
															</td>
															<td>
																<div class="mtd_2"> <p>${act.standard}</p></div>
															</td>
															<td>
																<div class="mtd_2"><p>${act.totalExperience==null?0:act.totalExperience}</p></div>
															</td>
															<td>
																<div class="mtd_2"><p>${act.price}</p></div>
															</td>
															<td>
																<div class="mtd_2"><p>${act.openExperience}</p></div>
															</td>
															<td>
																<div class="mtd_2">
																<c:choose>
																	<c:when test="${act.checkStatus==1}">
																		<p>等待复核</p>
																		<p class="FF6600">距离自动通过</p>
																		<p class="FF6600" id="${act.id}_timer"><script>countDown_colon("${act.id}_timer","${act.modifyTime==null?act.createTime:act.modifyTime}",<%=Constants.AUTO_HANDLE_TIME_CHECK%>)</script></p>
																		<p><a href="javascript:;">活动详情</a></p>
																	</c:when>
																	<c:when test="${act.checkStatus==2}">
																		<p class='green'>复核通过</p>
																		<p class="FF6600">距离活动展示</p>
																		<p class="FF6600" id="${act.id}_timer"><script>countDown_colon("${act.id}_timer","${act.beforeOnTime}",0)</script></p>
																		<p><a href="javascript:;">活动详情</a></p>
																	</c:when>
																	<c:when test="${act.checkStatus==3}">
																		<p class='red'>复核未通过</p>
																		<p class="FF6600">距离重新申报</p>
																		<p class="FF6600" id="${act.id}_timer"><script>countDown_colon("${act.id}_timer","${act.checkTime}",<%=Constants.AUTO_HANDLE_TIME_REPORT%>)</script></p>
																		<p><a href="javascript:;">活动详情</a></p>
																	</c:when>
																</c:choose>
																	
																</div>
															</td>
															<td>
																<div class="mtd_4">
																	<c:choose>
																	<c:when test="${act.checkStatus==2}">
																		<ul>
					                                                        <li class="tabli3">
					                                                        	<input type="hidden" id="${act.id}_bot" value="${act.beforeOnTime}">
					                                                        	<input type="hidden" id="${act.id}_ot" value="${act.onTime}">
					                                                        	<input class="campaign" type="button" value="活动展示确认" onclick="javascript:showConfirmDialog('${act.id}',this,'${act.productCode}','${act.version}');">
					                                                        </li>
					                                                        <li class="msId tabli1" id="${act.id}_userid"></li>
					                                                    </ul>
																	</c:when>
																	<c:when test="${act.checkStatus==3}">
																		<ul>
																			<li><a class="negativeClass abutton" href="#">重新申报</a></li>
																		</ul>
																	</c:when>
																</c:choose>
																</div>
															</td>
														</tr>
													</tbody>
													</c:forEach>
													
												</table>
													 <c:if test="${!empty po.list}">
												<!--全选按钮-->
													<div id="allBtn" class="allBtn">
														<input class="multiple" type="checkbox">
														<span>全选</span>
														<input class="pl_btn batchBtn" type="button" value="批量重新申报">
													</div>
											            <jsp:include page="../page.jsp">
											            	<jsp:param value="selectForm" name="formName"/>
											            </jsp:include>
											          </c:if>
											          </form>
											</div>
											<div id="con_one_2" style="display: none;">
											</div>
										</div>
									</div>
									<!--Tab1 end-->
								</div>
								<!--sales_products end-->
							</div>
							<!--sales end-->
						</div>
					</div>


				</div>
			</div> 
		</div>
		<!--遮罩层-->
		<div id="mask"></div>
		<!--活动展示确认提示-->
		<div id="abk"></div>
		<div id="tk2" class="tk2">
			<h3>
				商家已复核通过
			</h3>
			<div class="lt_text">
				<p>
					确认提前展示
					<span id="beforeOnTime"></span>天
				</p>
				<h4>
					距离活动展示剩余
					<span id="showCountDown"></span>
				</h4>
				<div class="re_btn">
					<input class="lt_re1" type="button" value="确认">
				</div>
			</div>

		</div>
		<!--重新申报提示-->
		<div id="recycle" class="pop-box bg_box_green">
			<h3>
				重新申报提示
			</h3>
			<div class="pop_cont">
				<ul>
					<li>
						品牌复核活动未通过的产品，将立即放入重新申报产品。
					</li>
					<li>
						确认后可以重新编辑并发布活动。
					</li>
				</ul>
				<p>
					<input type="button" class="bg1" onclick="javascript:$('#reportForm').submit();" value="确认">
					<input type="button" class="bg2 shatdown" value="取消">
				</p>
			</div>
		</div>
		<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/Tools.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/product/activityCheck.js"></script>

<script>
	$(function() {
		//ev2_n($('#tk2'), $(".campaign"), $('#abk'), $('.lt_re1'))
		ev_begin($('#recycle'), $(".negativeClass"), $('#mask'), $('.shatdown'), 1);
		ev_begin($('#recycle'), $(".negativeClass2"), $('#mask'), $('.shatdown'), 2);
	})
</script>
	</body>
</html>