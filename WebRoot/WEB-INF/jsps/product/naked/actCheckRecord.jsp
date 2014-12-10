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
						<em class="green">复核记录查询</em>
					</h2>
					<div class="fl fixed">
						<!--左侧menu-->
						<%@ include file="../left.jsp" %>
						<!--左侧 menu-->
					</div>
					<div class="fr" id="obj_le">
						<div class="right_box">
				          <div class="lt_search">
				          <form id="selectForm" name="selectForm" action="getActCheckRecord.htm?type=0" method="post">
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
										<label><span>复核状态：</span></label>
										<select name="checkStatus" >
											<option value="-1" ${searchAct.checkStatus==-1?"selected":""}>不限</option>
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
				              <table class="_Tabl">
				                <thead>
				                  <tr>
				                    <th width="165">产品名称</th>
				                    <th width="65">规格</th>
				                    <th width="110">累计体验人数</th>
				                    <th width="65">体验价</th>
				                    <th width="110">开放体验人数</th>
				                    <th width="120">申报来源</th>
				                    <th width="105">复核状态</th>
				                  </tr>
				                </thead>
				                <c:forEach  items="${po.list}" var="act">
					                <tbody>
					                    <tr class="lt_probm">
					                        <td colspan="7" >
					                          产品编码：<span>${act.productCode}</span>
					                          活动编号：<span>${act.id}</span>
					                          活动时间：<span><fmt:formatDate value="${act.onTime}" pattern="yyyy/MM/dd HH:mm"/>-<fmt:formatDate value="${act.offTime}" pattern="yyyy/MM/dd HH:mm"/></span>
					                        </td>
					                    </tr>
					                    <tr class="lt_main">
					                        <td><!--产品名称-->
					                            <div class="mtd_1"> 
					                                <span><input class="single" type="checkbox"></span> 
					                                <strong><img src="<%=imagePath%>/${act.mListPic}" width="60" height="60" alt=""></strong> 
					                                <font> <a href="#">${act.productName}</a> </font>
					                            </div>
					                        </td>
					                        <td><!--规格-->
					                            <div class="mtd_2">
					                                <p>${act.standard}</p>
					                            </div>
					                        </td>
					                        <td><!--累计体验人数-->
					                            <div class="mtd_2">
					                                <p>${act.totalExperience==null?0:act.totalExperience}</p>
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
					                        <td><!--申报类型-->
					                            <div class="mtd_2">
					                                  <p>${act.reportStatus==1?"待售产品申报":"在售产品申报" }</p>
					                            </div>
					                        </td>
					                        <td><!--操作-->
					                           <div class="mtd_2">
					                           		<c:if test="${act.checkStatus==2}">
					                                  <p class="green">复核通过</p>
					                                  <p><a href="#">活动详情</a></p>
								                       <c:choose>
								                       		<c:when test="${act.confirmUserId!=null and act.confirmUserId!=0}">
								                                  <p class="green"><span class="icon_fund online"></span>运营已确认</p>
								                                  <p>ID:${act.confirmUserId}</p>
								                       		</c:when>
								                       		<c:otherwise>
								                       				<p class="orange"><span class="icon_fund outline"></span>运营未确认</p>
								                       		</c:otherwise>
								                       </c:choose>         
					                           		</c:if>
					                           		<c:if test="${act.checkStatus==3}">
					                                  <p class="red">复核未通过</p>
					                                  <p><a href="#">活动详情</a></p>
					                           		</c:if>
					                            </div>
					                        </td>
					                    </tr>
					                </tbody>
				                </c:forEach>
				              </table>
				            </div>
				            <c:if test="${!empty po.list}">
					            <jsp:include page="../page.jsp">
					            	<jsp:param value="selectForm" name="formName"/>
					            </jsp:include>
				            </c:if>
				         </div>
				      </div>
				    </div>
				</div>
			</div> 
		</div>
		<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/Tools.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/product/activityCheck.js"></script>

	</body>
</html>