<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>顶部轮播管理</title>
<link href="${pageContext.request.contextPath}/css/public.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/Brand_category.css"
	rel="stylesheet" type="text/css" />
<!--选项卡-->
<script src="${pageContext.request.contextPath}/js/xxk.js"></script>
<!--select下拉美化-->
<script src="${pageContext.request.contextPath}/js/js.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>

<!--收缩菜单-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/shrink1.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/common/jquery.upload.js" > </script>
<script type="text/javascript" src="<%=basePath%>/js/common/dialog.js" > </script>
<script type="text/javascript" src="<%=basePath%>/js/common/moveAd.js" > </script>
<script type="text/javascript" src="<%=basePath%>/js/common/uploadImage.js" > </script>
<script type="text/javascript" src="<%=basePath%>/js/common/secondSelected.js"> </script>
<!--弹出框-->
<script type="text/javascript">
function release() {
	var imgFlag = 0;
	$(".imageUrlValue").each(function(index){
		if($(this).val() == null || $(this).val() == ""){
			imgFlag++;
		}
	});
	var urlFlag = 0;
	$("input[name='accessUrls']").each(function(index){
		if($(this).val() == null || $(this).val() == ""){
			urlFlag++;
		}
	});
	if(imgFlag > 0){
		alert("请上传图片");
		return;
	}
	if(urlFlag > 0){
		alert("请填写广告访问链接");
		return;
	}
	
	$.ajax({
				url : "${pageContext.request.contextPath}/naked/imageAd/releaseImageAd.json",
				type : "post", //请求类型
				async : false,//默认true异步请求 ，false同步请求 
				data : $('#topCarouselForm').serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
				success : function(data) {
					if (500 == data) {
						//系统内部异常
						alert('系统内部异常');
					} else if (501 == data) {
						//用户未登录，请求被拦截
						alert('未登录');
					} else {
						//正确返回结果
						if(data.result==1){
							alert("发布成功");
						}else{
							alert("发布失败");	
						}
					}
				}
			});

}




function toCategoryPage() {
		var categoryOne = $("#categoryOne").val();
		var categoryTwo = $("#categoryTwo").val();
		if (categoryOne == 0 && categoryTwo == 0) {
			alert("请选择类目");
			return false;
		} else {
			location = "${pageContext.request.contextPath}/naked/getTopCarousel.htm?categoryOne="
					+ categoryOne + "&categoryTwo=" + categoryTwo;
		}
	}
	$(
			function() {

				$(".showbox").click(
						function() {
							$("#TB_overlayBG").css({
								display : "block",
								height : $(document).height()
							});
							$(".box").css(
									{
										left : ($("body").width() - $(".box")
												.width())
												/ 2 - 20 + "px",
										top : ($(window).height() - $(".box")
												.height())
												/ 2
												+ $(window).scrollTop()
												+ "px",
										display : "block"
									});
						});

				$(".close").click(function() {
					$("#TB_overlayBG").css("display", "none");
					$(".box ").css("display", "none");
				});
				$
						.ajax({

							url : "${pageContext.request.contextPath}/category/getCategory.json",
							type : "get", //请求类型
							async : false,//默认true异步请求 ，false同步请求 
							data : "categoryId=0",
							success : function(data) {
								var list = data.categorys;
								var categoryId=$("#categoryId").val();
							
								for (var i = 0; i < list.length; i++) {
									var html;
									
									if (categoryId == list[i].id) {
									 html = "<option selected='selected' value='"+list[i].id +"'>"
												+ list[i].name
												+ "</option>";
									} else {
										 html = "<option value='"+list[i].id +"'>"
												+ list[i].name
												+ "</option>";
									}
									$("#categoryOne").append(html);
								}
							}
						});
				$("#categoryOne")
						.change(
								function() {

									$
											.ajax({

												url : "${pageContext.request.contextPath}/category/getCategory.json",
												type : "get", //请求类型
												async : false,//默认true异步请求 ，false同步请求 
												data : "categoryId="
														+ $(this).val(),
												success : function(data) {
													var list = data.categorys;
													var html1="<option value='0' >请选择</option>";
													$("#categoryTwo").empty();
													$("#categoryTwo").append(html1);
													for (var i = 0; i < list.length; i++) {
															var html = "<option value='"+list[i].id +"'>"+ list[i].name;
															$("#categoryTwo").append(html);
													}
												}
											});
									//location="${pageContext.request.contextPath}/naked/second/getTopCarousel.htm?categoryId="+$(this).val();
								});

			})
</script>



<!--缩略图-->
<script src="${pageContext.request.contextPath}/js/main.js"
	type="text/javascript"></script>

</head>
<body>
<div id="wapper">

	<div class="main">
		
		<!-- 顶部菜单 -->
		<%@include file="/WEB-INF/jsps/naked/includes/topMenu.jsp"%>
		
		<div class="classify fixed">
			<h2>
				<a href="#">综合管理后台</a> &gt; <a href="#">页面管理</a> &gt; <a href="#">裸价体验二级分类页</a> &gt;
				<em class="green">顶部轮播管理</em>
			</h2>

			<div class="fl">
				<div class="shrink">
					<div class="vtitle1 current">
						<a
							href="${pageContext.request.contextPath}/naked/second/getTopCarousel.htm?categoryId=${categoryId}">顶部轮播管理</a>
					</div>
					<div class="vtitle1 ">
						<a
							href="${pageContext.request.contextPath}/naked/second/getFocusCarousel.htm?categoryId=${categoryId }">焦点活动管理</a>
					</div>
										<div class="vtitle1"><a
								href="${pageContext.request.contextPath}/naked/second/getRecommendProduct.htm?categoryId=${categoryId }">最热商品推荐</a></div>
					<%-- <div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/naked/second/getRightCarousel.htm?categoryId=${categoryId}&locationFloor=1">右侧广告轮播管理</a>
						</div>
					<div class="vtitle1"><a
								href="${pageContext.request.contextPath}/naked/second/getImage6Ad.htm?categoryId=${categoryId }&locationFloor=1">右侧标准广告位管理</a>
						</div> --%>
					
				</div>
				<div class="breviary top15">
					<h3>页面位置缩略图</h3>
					<p>
						<a href="#" rel="images/img_08.jpg" class="preview"><img
							src="${pageContext.request.contextPath}/images/img_06.jpg"
							width="198" height="198" /></a>
					</p>
				</div>

			</div>
			
				<div class="fr_ty">
					<h3 class="fixed">
						<span>默认显示5个</span> <span>最多显示12个</span> <span><input
							type="submit" name="button3" id="button3" value="+增加轮播图"
							class="lb" /></span> <span>轮播间隔时间<input type="text"
							name="loopTime" id="textfield" class="sj" value="3" />秒
						</span>
					</h3>

					<div class="border top10 fixed">
						<form id="topCarouselForm"
							action="${pageContext.request.contextPath}/naked/imageAd/releaseImageAd.htm"
							method="post">
								<input type="hidden" name="pageType" value="301" />
								<input type="hidden" name="locationType" value="1" />
								<input id="categoryId" type="hidden" name="category" value="${categoryId }" />
								<input type="hidden" name="floor" value="0" />
							<table border="0" cellspacing="1" cellpadding="0" class="top_img">

								<tr class="img_bj fixed">
									<td colspan="2" align="center" valign="middle" class="width331"><div>大图</div></td>
									<td align="center" valign="middle" class="width255"><div>链接</div></td>
									<td align="center" valign="middle" class="width95"><div>发布</div></td>
									<td align="center" valign="middle" class="width95"><div>操作</div></td>
								</tr>
							
								<c:forEach items="${imageAds}" var="p" varStatus="pp">
									<tr class="img_txt fixed">

										
										
										<td align="center" valign="middle" class="width12"><div>${pp.index+1 }</div></td>
										<td align="center" valign="middle" class="width318">
											<div>
												<a href="javascript:openDialog(${p.locationId},'${p.note}');"
													class="showbox c1">选择图片</a> <input type="hidden"
													name="locationIds" id="textfield2" class="site2"
													value="${p.locationId}" /> <a href="javascript:void(0);"
													class="c2"> <input class="imageUrlValue"
													id="input_${p.locationId}" type="hidden" name="imageUrls"
													value="${p.imageUrl}" /> <img class="imageUrlShow"
													src="<%=imagePath %>/${p.imageUrl}" width="290" height="60"
													id="img_${p.locationId}" /></a>
											</div>
										</td>
										<td valign="middle" class="width255">
											<div>

												<label for="textfield2">1920*400 ${p.note}</label> <input type="text" maxlength="100"
													name="accessUrls" id="accessUrl_${p.locationId}"
													class="site" value="${p.accessUrl }" />

											</div>
										</td>
										<td align="center" valign="middle" class="width95"><input
											type="checkbox" name="showState" id="checkbox" /> <label
											for="checkbox"></label></td>
										<td align="center" valign="middle" class="w95">
											<div>
												<a href="javascript:moveUp(${p.locationId});" class="b1"></a>
												<a href="javascript:moveDown(${p.locationId});" class="b2"></a>
												<a
													href="javascript:deleteImageAd('${p.id}','${p.adId}',${p.locationId});"
													class="b3"></a>
											</div>
										</td>
									</tr>
								</c:forEach>

							</table>



							<p class="submit">
								<input type="button" name="button4" id="button4" value="预览"
									class="preview" /><input type="button" name="button4"
									id="button4" onclick="release();" value="发布" class="issue" />
							</p>
						</form>
					</div>




				</div>

			</div>



		</div>




		<div id="TB_overlayBG"></div>
		<c:import url="/image/getAll.htm"></c:import>
	</div>
</body>
</html>
