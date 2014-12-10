<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>

		<div class="banner top30">
			<a href="#"><img src="<%=basePath%>/images/bannk/img_01.jpg" width="1000"
					height="60" />
			</a>
		</div>
		<div class="scroll_banner top15 fixed">
			<span class="fl">美试卖家年会，夏季分享2014美试市场活动节奏，夏季分享2014美试市</span>
			<span class="fr">美试卖家年会，夏季分享2014美试市场活动节奏，夏季分享2014美试市</span>
		</div>
		<div class="scroll_bannera fixed">
		<c:if test="${param.type==0 }">
			<p class="fl">
				裸价体验
			</p>
		</c:if>
		<c:if test="${param.type==1 }">
			<p class="fl02">
				免费试用
			</p>
		</c:if>
			<a href="#" class="manage yellow">查看其它管理</a>
		</div>