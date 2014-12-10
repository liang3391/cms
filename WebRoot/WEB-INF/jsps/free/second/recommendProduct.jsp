<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>最热商品推荐</title>
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
<!--缩略图-->
<script src="${pageContext.request.contextPath}/js/main.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	function release() {
		popStatus(3, '玩命发布中，等待……', 50);
		var imgFlag = 0;
		$(".imageUrlValue").each(function(index){
			if($(this).val() == null || $(this).val() == ""){
				imgFlag++;
			}
		});
		if(imgFlag > 0){
			//alert("请上传图片");
			popStatus(2, '请上传图片', 3);
			return;
		
		}
		var commodityIdsFlag = 0;
		var reg=/^[-+]?\d*$/; 
		$("input[name='commodityIds']").each(function(index){
			if($(this).val() == null || $(this).val() == "" || !reg.test($(this).val())){
				commodityIdsFlag++;
			}
		});
		if(commodityIdsFlag > 0){
			
			popStatus(2, '产品ID必须正整数且不能为空', 3);
			return;
			
		}
		var titlesFlag = 0;
		$("input[name='titles']").each(function(index){
			if($(this).val() == null || $(this).val() == ""){
				titlesFlag++;
			}
		});
		if(titlesFlag > 0){
			popStatus(2, '标题不能为空', 3);
			return;
		
		}
		var doubReg=/^[-\+]?\d+(\.\d+)?$/; 
		var nakedPriceFlag = 0;
		$("input[name='nakedPrices']").each(function(index){
			if($(this).val() == null || $(this).val() == "" || !doubReg.test($(this).val())){
				nakedPriceFlag++;
			}
		});
		if(nakedPriceFlag > 0){
			popStatus(2, '裸价必须为数字且不能为空', 3);
			return;
			
		}
		var openCountFlag = 0;
		$("input[name='openCounts']").each(function(index){
			if($(this).val() == null || $(this).val() == "" || !reg.test($(this).val())){
				openCountFlag++;
			}
		});
		if(openCountFlag > 0){
			popStatus(2, '裸价必须为数字且不能为空', 3);
			return;
			
		}
		var commodityUrlFlag = 0;
		$("input[name='commodityUrls']").each(function(index){
			if($(this).val() == null || $(this).val() == ""){
				commodityUrlFlag++;
			}
		});
		if(commodityUrlFlag > 0){
			popStatus(2, '链接不能为空', 3);
		
			return false;
		}
		
	$.ajax({
				url : "${pageContext.request.contextPath}/free/commodityAd/releaseCommodityAd.json",
				type : "post", //请求类型
				async : false,//默认true异步请求 ，false同步请求 
				data : $('#commodityIdform').serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
				success : function(data) {
					if (500 == data) {
						//系统内部异常
						popStatus(4, '为何你点它会错误？给我个理由~！', 3);
					} else if (501 == data) {
						//用户未登录，请求被拦截
						popStatus(2, '你还没有登录，你家人知道吗？', 3);
					} else {
						//正确返回结果
						if(data.result==1){
							popStatus(1, '终于发布成功了', 3);
						}else{
							popStatus(4, '发布失败了！', 3);
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
			location = "${pageContext.request.contextPath}/free/getTopCarousel.htm?categoryOne="
					+ categoryOne + "&categoryTwo=" + categoryTwo;
		}
	}
	$(
			function() {
				$("#locationCount").change(function(){
					
					$.ajax({
						
						url : "${pageContext.request.contextPath}/free/second/getImage6Ad.json",
						type : "post", //请求类型
						async : false,//默认true异步请求 ，false同步请求 
						data :"locationFloor="+$(this).val()+"&categoryId="+$("#categoryId").val(),
						success : function(data) {
							var list=data.imageAds;
						
							for(var i=0;i<list.length;i++){
								var $img =  "<img src='<%=imagePath%>/"+ list[0].imageUrl +"'  width='230' height='450'/>";
								$("#imageA").html($img);
								$("#boardName").val(list[0].boardName);
								$("#locationId").val(list[0].locationId);
								$("#imageUrl2").val(list[0].imageUrl);
								$("#accessUrl3").val(list[0].accessUrl);
								
							}
						}
					});
				});

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

								var categoryId = $("#categoryId").val();
								for (var i = 0; i < list.length; i++) {
									var html;
									if (categoryId == list[i].id) {
										html = "<option selected='selected' value='"+list[i].id +"'>"
												+ list[i].name + "</option>";
									} else {
										html = "<option value='"+list[i].id +"'>"
												+ list[i].name + "</option>";
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
													var html1 = "<option value='0' >请选择</option>";
													$("#categoryTwo").empty();
													$("#categoryTwo").append(
															html1);
													for (var i = 0; i < list.length; i++) {

														var html = "<option value='"+list[i].id +"'>"
																+ list[i].name
																+ "</option>";
														$("#categoryTwo")
																.append(html);
													}
												}
											});
									//location="${pageContext.request.contextPath}/free/second/getTopCarousel.htm?categoryId="+$(this).val();
								});

			})
			
</script>
</head>

<body>
	<div id="wapper">

		<div class="main">

			<!-- 顶部菜单 -->
		<%@include file="/WEB-INF/jsps/free/includes/topMenu-free.jsp"%>

			<div class="classify fixed">
				<h2>
					<a href="#">综合管理后台</a> &gt; <a href="#">页面管理</a> &gt; <a href="#">免费试用二级分类页</a>
					&gt; <em class="green">最热商品推荐</em>
				</h2>

				<div class="fl">
					<div class="shrink">
						<div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/free/second/getTopCarousel.htm?categoryId=${categoryId}">顶部轮播管理</a>
						</div>
						<div class="vtitle1 ">
							<a
								href="${pageContext.request.contextPath}/free/second/getFocusCarousel.htm?categoryId=${categoryId}">焦点活动管理</a>
						</div>
						<div class="vtitle1 current">
							<a
								href="${pageContext.request.contextPath}/free/second/getRecommendProduct.htm?categoryId=${categoryId }">最热商品推荐</a>
						</div>
							<%-- <div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/free/second/getRightCarousel.htm?categoryId=${categoryId}&locationFloor=1">右侧广告轮播管理</a>
						</div>
						<div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/free/second/getImage6Ad.htm?categoryId=${categoryId }&locationFloor=1">右侧标准广告位管理</a>
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
					<input id="categoryId" type="hidden" name="category" value="${categoryId}" />
				<div class="fr_ty">
				<form id="commodityIdform" name="form1" method="post" class="padding6">
					<input type="hidden" name="pageType" value="201" />
					<input type="hidden" name="locationType" value="7" />
					<input type="hidden" name="category" value="${categoryId}" />
					<input type="hidden" name="floor" value="0" />
					<c:forEach items="${commodityAds}" var="p" varStatus="pp">
					<div class="border top10 fixed">
						<input type="hidden" name="nakedPrices" value="0"/>
					
					
						<table border="0" cellspacing="1" cellpadding="0" class="top_img">
							<tr class="img_bj fixed">
								<td align="center" valign="middle" class="w320"><div>大图</div></td>
								<td align="center" valign="middle" class="w448">
									<div>信息</div>
								</td>
							</tr>
							<tr class="fixed" style="padding: 20px 0">

								<td align="center" valign="middle" class="w320"><span
									class="relative">${pp.index+1}</span>
									<div>
										<a href="javascript:openDialog(${p.locationId},'${p.note}');" class="showbox g1">选择图片</a> <a
											href="javascript:void(0);" class="h2"><img class="imageUrlShow" id="img_${p.locationId}"  
											src="<%=imagePath %>/${p.imageUrl }"
											width="230" height="230" /></a>
											<input type="hidden" class="imageUrlValue" id="input_${p.locationId}" name="imageUrls" value="${p.imageUrl}"/>
											<input type="hidden" name="locationIds" value="${p.locationId}"/>
									</div></td>
								<td class="w448">
									
										<p>
											<label for="textfield2" class="fl">产品ID：</label> <input
												type="text" name="commodityIds"  maxlength="30"
												class="site350" value="${p.commodityId }"/>
										</p>
										<p>
											<label for="textfield2" class="fl">标题：</label> <input
												type="text" name="titles" maxlength="30"
												class="site350" value="${p.title }"/>
										</p>
										<%-- <p>
											<label for="textfield2" class="fl">裸价：</label> <input
												type="text" name="freePrices" maxlength="10"
												class="site150" value="${p.freePrice}"/>
										</p> --%>
										<p>
											<label for="textfield2" class="fl">数量：</label> <input
												type="text" name="openCounts" maxlength="30"
												class="site150" value="${p.openCount }"/>
										</p>
										<p class="top35">
											<label for="textfield2" class="fl top20">链接：</label>320*280 ${p.note}
											 <input type="text" name="commodityUrls" maxlength="100"
												 class="site350" style="margin-top: 5px" value="${p.commodityUrl }" />
										</p>
									

								</td>
							</tr>
						</table>
						
					</div>
					</c:forEach>
					</form>
					<p class="submit">
						<input type="button" name="button4" id="button4" value="预览"
							class="preview" /><input type="button" name="button4"
							id="button4" value="发布" class="issue" onclick="release()" />
					</p>
				</div>
			</div>
		</div>



		<div id="TB_overlayBG"></div>
		<c:import url="/image/getAll.htm"></c:import>
	</div>
</body>
</html>
