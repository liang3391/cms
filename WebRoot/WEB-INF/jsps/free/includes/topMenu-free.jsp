<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <div id="header" class="fixed">
  <a href="${pageContext.request.contextPath}/toPage.htm" class="logo"></a>
  <a href="#" class="category">&gt;&nbsp;页面管理</a>
  <a href="${pageContext.request.contextPath}/toPage.htm" class="manage green">查看其它管理</a>
  <span>欢迎您，我就是别跑 <a href="#" class="green">[退出]</a></span>
 </div>
		<div class="banner top30">
			<a href="#"><img
				src="${pageContext.request.contextPath}/images/img_01.jpg"
				width="1000" height="60" /></a>
		</div>
		<div class="scroll_banner top15 fixed">
			<span class="fl">美试卖家年会，夏季分享2014美试市场活动节奏，夏季分享2014美试市</span> <span
				class="fr">美试卖家年会，夏季分享2014美试市场活动节奏，夏季分享2014美试市</span>
		</div>
		<div class="Channel_Separation top30 fixed">
			<div class="fl244">
				<h2>
					<span></span><a href="${pageContext.request.contextPath}/toPage.htm" class="yellow">查看其它频道</a>
				</h2>
				<p class="bj03">免费试用频道</p>
			</div>

			<table width="350" border="0" cellspacing="1" cellpadding="0"
				class="fla">
				<tr>
					<td colspan="3" align="center" valign="middle" class="height30"><div
							class="green">页面分类</div></td>
				</tr>
				<tr>
					<td rowspan="2" align="center" valign="middle" class="width185" id="firstMenuTd"><div><a
								href="${pageContext.request.contextPath}/free/first/getTopCarousel.htm">频道首页</a></div></td>
					<td align="center" valign="middle"  class="width237" id="secondMenuTd"><div>二级分类页</div></td>
					<td align="center" valign="middle" class="width237" id="thirdMeunTd"><div>三级分类页</div></td>
				</tr>
				<tr>
					<td align="center" valign="middle" class="width237">
						<div class="downb">
							<select id="categoryOne">
								<!-- Notice the HTML5 data attributes -->
								<option value="0">请选择</option>

							</select>
						</div>
					</td>
					<td align="center" valign="middle" class="width237">
						<div class="downb">
							<select id="categoryTwo" name="categoryTwo">
								<!-- Notice the HTML5 data attributes -->
								<option value="0">请选择</option>
								<c:forEach items="${categorys}" var="p">
									<option value="${p.id}">${p.name}</option>
								</c:forEach>

							</select>
						</div>
					</td>
				</tr>
			</table>

			<a href="#" onclick="toCategoryPage();" class="fr">页面选择请确认&lt;</a>
		</div>
		