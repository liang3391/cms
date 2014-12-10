<%@page import="com.qianqian.order.utils.OrderConstants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsps/common/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>咨询管理</title>
<link href="<%=basePath %>/css/brand.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/brandargement.js" defer="defer"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js" defer ="defer"></script>
<script type="text/javascript">
$(function() {
	$('#reset_btn').click(function() {
		$(':input','#form1')
		.not(':button, :submit, :reset, :hidden')
		.val('')
		.removeAttr('checked')
		.removeAttr('selected');
	});
	$('#del_btn').click(function() {
		var consult_id = $('#consult_id').val();
		var flag = $('#flag').val();
		window.location.href = '${pageContext.request.contextPath}'+'/consult/deleteConsult.htm?consultId='+consult_id+'&flag='+flag;
	});
});
</script>
<body>
<div class="main">
    <h2 class="current_location"><a  class="plc" href="#">综合管理后台</a>&gt;<a href="#">申请单及订单管理</a>&gt;<em class="green">咨询管理</em></h2>
</div>
<!--品牌详情end-->
<div class="brandCont">
<!--左侧导航-->
 <div id="oPro_menu" class="oPro_menu">
        <ul>
           <li class="on"><a href="#">咨询管理</a></li>
           <li><a href="#">申请单查询</a></li>
           <li class="colis_0"><a href="javascript:;">订单查询</a><i class="bg2"></i></li>
           <ol style="display:block">
                <li><em>-</em><a href="#">免费订单查询</a></li>
                <li><em>-</em><a href="#">裸价订单查询</a></li>
           </ol>
           <li class="colis_0" ><a href="javascript:;">退款管理</a><i class="bg2"></i></li>
           <ol style="display:block">
                <li><em>-</em><a href="#">免费试用</a></li>
                <li><em>-</em><a href="#">裸价体验</a></li>
           </ol>
           <li><a href="#">发货查询</a></li>
           <li><a href="#">发货赔偿</a></li>
           <li><a href="#">评价管理</a></li>
           <li class="ping"><a href="#">报告管理</a></li>
        </ul>
</div>
    <!--menu end-->
    <div class="right_box wpro">
         <div class="lt_search">
            <form action="${pageContext.request.contextPath}/consult/getConsultReply.htm" method="post" id="form1">
              <div class="search_title">
                <h3><em></em>搜索条件：</h3>
                <span>
                <input type="button" value="清空条件" id="reset_btn">
                </span>
              </div>
              <div class="search_show">
                <ul>
                  <li>
                    <label><span>品牌ID：</span></label>
                    <input type="text" class="textbox" name="brandId" value="${query.brandId}">
                  </li>
                  <li>
                    <label><span>产品名称：</span></label>
                    <input type="text" class="textbox" name="productName" value="${query.productName}">
                  </li>
                  <li>
                    <label><span>用户ID：</span></label>
                    <input type="text" class="textbox" name="userId" value="${query.userId}">
                  </li>
                </ul>
              </div>
              <p class="lt_btn">
                <input type="submit" value="搜索" />
              </p>
            </form>
          </div>
          <div id="sales_pro" class="sales_products wid785">
          		<table class="brand_table">
                                            <thead>
                                              <tr>
                                                <th width="160">产品名称</th>
                                                <th width="400">咨询内容</th>
                                                <th width="110">用户ID</th>
                                                <th width="90">咨询回复状态</th>
                                              </tr>
                                            </thead>
                                            <c:forEach items="${pageBean.currentList }" var="consult">
	                                            <tbody>
	                                                <tr class="brand_show <c:if test="${consult.replyState==1}">noline</c:if>">
	                                                    <td><!--产品名称-->
															<div class="brpr_3">
																<dl>
	                                                              <a href="#"><img src="<%=imagePath %>/${consult.productPic}" width="60" height="60"></a>
	                                                              <dt><a href="#">${consult.productName}</a></dt>
	                                                            </dl>
	                                                        </div>
	                                                    </td>
	                                                    <td><!--评价内容-->
	                                                        <div class="brpr_4">
	                                                        	<c:if test="${consult.state==0}">
	                                                       			<p class="padown">${consult.consultContent}</p>
	                                                       			<p><a class="ff66 remove" href="javascript:;" onclick="javascript:$('#consult_id').val('${consult.id}');$('#flag').val('0');">删除</a><em>[<fmt:formatDate value="${consult.consultDateTime}" pattern="yyyy/MM/dd HH:mm:ss"/>]</em></p>
	                                                       		</c:if>
	                                                       		<c:if test="${consult.state==1}">
	                                                       			<p class="exist orange"><span class="icon_fund outline "></span>内容已删除&nbsp;&nbsp;&nbsp;美试ID：${consult.shield.handleUserId}&nbsp;&nbsp;[<fmt:formatDate value="${consult.shield.handleDateTime}" pattern="yyyy/MM/dd HH:mm:ss"/>]</p>
	                                                       			<p><em>[<fmt:formatDate value="${consult.consultDateTime}" pattern="yyyy/MM/dd HH:mm:ss"/>]</em></p>
	                                                       		</c:if>
	                                                        </div>
	                                                    </td>
	                                                    <td><!--用户ID-->
	                                                        <div class="brpr_3">
	                                                           <dl>
	                                                              <a href="#"><img src="<%=imagePath%>/${consult.headPic}" width="40" height="40"/></a>
	                                                              <dt><a href="#">${consult.nickname}</a></dt>
		                                                          <dd>ID:${consult.userId}</dd>
	                                                            </dl>
	                                                        </div>
	                                                    </td>
	                                                    <td><!--退款状态-->
	                                                        <div class="brpr_2">
	                                                            <ul>
	                                                            	<c:if test="${consult.replyState==0}"><li class="remo bload">待回复</li></c:if>
	                                                            	<c:if test="${consult.replyState==1}"><li class="green">已回复</li></c:if>
	                                                            </ul>
	                                                        </div>
	                                                    </td>
	                                                </tr>
	                                                <c:if test="${consult.replyState==1}">
		                                                <tr class="answer">
		                                                  <td colspan="4">
		                                                     <div class="an_show">
		                                                     	<h3 class="title"><img src="<%=imagePath%>/${consult.brandLogo}" width="30" height="30"/>${consult.brandName}</h3>
		                                                     	<c:if test="${consult.replyState==1}">
		                                                     		<c:if test="${consult.reply.state==0}">
		                                                     			<em>回复：</em><p class="exist">${consult.reply.replyContent}</p>
		                                                     		</c:if>
		                                                     		<c:if test="${consult.reply.state==1}">
		                                                     			<em>回复：</em>
		                                                     			<p class="exist orange">
			                                                     			<span class="icon_fund outline "></span>内容已删除&nbsp;&nbsp;&nbsp;美试ID：${consult.shield.handleUserId}&nbsp;&nbsp;
			                                                     			[<fmt:formatDate value="${consult.shield.handleDateTime}" pattern="yyyy/MM/dd HH:mm:ss"/>]
			                                                     		</p>
			                                                     	</c:if>
		                                                     	</c:if>
		                                                       <h4>
		                                                       	<c:if test="${consult.replyState==1 && consult.reply.state==0}"><a class="ff66 remove" href="javascript:;" onclick="javascript:$('#consult_id').val('${consult.id}');$('#flag').val('1');">删除</a></c:if>
			                                                    [<fmt:formatDate value="${consult.reply.replyDateTime}" pattern="yyyy/MM/dd HH:mm:ss"/>]
			                                                   </h4>
		                                                     </div>
		                                                  </td>
		                                                </tr>
	                                                </c:if>
	                                            </tbody>
                                            </c:forEach>
                                  </table>	
                                 <!--page-->
                                 <c:choose>
				              		<c:when test="${not empty pageBean.currentList}">
				              			<%@include file="/WEB-INF/jsps/common/page.jsp"%>
				                	</c:when>
				              		<c:otherwise>
				              			<em>找不到相应的内容，请尝试其他的搜索方式进行查找</em>
				              		</c:otherwise>
				              	</c:choose>
                                <!--page end-->
          </div>
    </div>
    <!--right_box end-->   
</div>
<!--删除提示-->
<div id="remove" class="adopt optcolor">
	 <input type="hidden" id="consult_id" />
	 <input type="hidden" id="flag"/>
     <h3 class="title">删除咨询回复提示</h3>
     <div class="conbox">
         <ul>
           <li class="text">删除咨询内容后，内容将不可恢复，请谨慎操作。</li>
           <li class="input">
            <input type="button" class="bg1" value="确认" id="del_btn" /><input class="boxdown bg2" type="button" value="取消" onclick="javascript:$('#consult_id').val('');$('#flag').val('');"/>
          </li>
         </ul>
     </div>
</div>
<div id="abk"></div>
<script>
$(function(){
    oTk($('#remove'),$('#abk'), $('.boxdown'),$('.remove'))
   //Clickshow({box:$("#remove"),obj:$(".remove"),left:-$("#remove").width()/2,top:-$("#remove").height()-20,oClose:$(".boxdown"),onOF:false})
})
</script>
</body>
</html>