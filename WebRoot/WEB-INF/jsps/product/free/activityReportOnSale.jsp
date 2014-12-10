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
					<h2><a href="#">综合管理后台</a> > <a href="#">产品及活动管理</a> > <a href="#">免费试用</a> > <em class="green">重新申报产品管理</em></h2>
					<div class="fl fixed">
						<!--左侧menu-->
						<%@ include file="../left.jsp" %>
						<!--左侧 menu-->
					</div>
					<div class="fr" id="obj_le">
		        <div class="right_box">
		          <div class="lt_search">
		           <form id="selectForm" action="getActReportList.htm?type=1&prdStatus=2" method="post">
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
		                             <li id="one1" onclick="setTab('one',1,2)" ><a href="getActReportList.htm?type=1&prdStatus=1">待售产品申报</a></li>
		                             <li id="one2" onclick="setTab('one',2,2)"  class="hover"><a href="javascript:;">在售产品申报</a></li>
		                        </ul>
		                    </div>
		                    <div class="Contentbox">
		                        <!--未发货退款-->
		                        <div id="con_one_1"  style="display:none;">
		                              
		                        </div>
		                         <div id="con_one_2">
		                              <table class="_Tabl">
		                                    <thead>
		                                      <tr>
		                                        <th width="165">产品名称</th>
		                                        <th width="88">规格</th>
		                                        <th width="118">本次开放试用人数</th>
		                                        <th width="118">保证金</th>
		                                        <th width="120">编辑中活动</th>
		                                        <th width="120">操作</th>
		                                      </tr>
		                                    </thead>
		                                    <form action="<%=basePath%>/act/removePrdAct.htm?type=1&prdStatus=2" method="post" id="removeForm">
		                                    <c:forEach items="${po.list}" var="act">
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
		                                                    <span><input class="single" type="checkbox" name="removeAct"  value="${act.productCode}"></span> 
		                                                    <strong><img src="<%=imagePath%>/${act.mListPic}"  width="60" height="60" alt=""></strong> 
		                                                    <font> <a href="#">${act.productName}</a> </font>
		                                                </div>
		                                            </td>
		                                            <td><!--规格-->
		                                                <div class="mtd_2">
		                                                    <p>${act.standard}</p>
		                                                </div>
		                                            </td>
		                                            <td><!--开放体验人数-->
		                                                <div class="mtd_2">
		                                                    <p>${act.openExperience}</p>
		                                                </div>
		                                            </td>
		                                            <td><!--体验价-->
		                                                <div class="mtd_2">
		                                                    <p>${act.price}</p>
		                                                </div>
		                                            </td>
		                                            <td><!--编辑中活动-->
		                                                <div class="mtd_4">
								                            <ul>
									                            <c:if test="${!empty act.modifyTime}">
									                              <li><a target="_blank" href="#">活动详情</a></li>
									                            </c:if>
								                            </ul>
								                         </div>
		                                            </td>
		                                            <td><!--操作-->
		                                               <div class="mtd_4">
		                                                    <ul>
														        <li><a target="_blank" class="abutton" href="<%=basePath%>/prd/getPrd.htm?prdCode=${act.productCode}&ver=${act.version}&type=1&from=report">编辑产品</a></li>
															    <li><a target="_blank" class="abutton" href="<%=basePath%>/prd/getActivity.htm?prdCode=${act.productCode}&ver=${act.version}&type=1&from=report">编辑活动</a></li>
		                                                        <li><a class="negativeClass abutton" href="#">放入回收站</a></li>
		                                                    </ul>
		                                              </div>
		                                            </td>
		                                        </tr>
		                                    </tbody>
		                                    </c:forEach>
		                                    </form>
		                                 </table>
		                               <c:if test="${!empty po.list}">
			              				  <!--全选按钮-->
			                              <div id="allBtn" class="allBtn">
			                                <input class="multiple" type="checkbox"><span>全选</span>
			                                <input class="pl_btn batchBtn" type="button" value="批量放入回收站">
			                              </div>
			                               <!--page-->
								            <jsp:include page="../page.jsp">
								            	<jsp:param value="selectForm" name="formName"/>
								            </jsp:include>
			                                <!--page end-->
								       </c:if>
		                        </div>
		                   </div>
		              </div>
		              <!--Tab1 end-->
		               </div>
		          </div>
		          
		         </div>
		      </div>
		    </div>
		  </div>
		</div>
<!--产品放入回收站弹出框-->
<div id="mask"></div>
 <!--产品放入回收站弹出框-->     
 <div id="recycle" class="pop-box bg_box_green">
     <h3>重新申报提示</h3>
     <div class="pop_cont">
          <ul>
             <li>放入回收站的产品不在前端展示</li>
			 <li>用户将搜索不到产品,也不能进行活动申报。</li>
          </ul>
          <p><input type="button" class="bg1" value="放入回收站" onclick="javascript:$('#removeForm').submit();"><input type="button" class="bg2 shatdown" value="取消" ></p>
     </div>
 </div>
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/Tools.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/activityCheck.js"></script>
<script>
ev_begin($('#recycle'),$('.negativeClass'),$('#mask'),$('.shatdown'),1)
ev_begin($('#recycle'),$('.negativeClass2'),$('#mask'),$('.shatdown'),2)
</script>
</body>
</html>
