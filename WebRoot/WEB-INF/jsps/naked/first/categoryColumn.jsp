<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/common/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>类目通栏管理</title>
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

<!--弹出框-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tck.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/js/common/jquery.upload.js"> </script>
<script type="text/javascript" src="<%=basePath%>/js/common/dialog.js"> </script>
<script type="text/javascript" src="<%=basePath%>/js/common/moveAd.js"> </script>
<script type="text/javascript" src="<%=basePath%>/js/common/firstSelected.js"> </script>
<script type="text/javascript"
	src="<%=basePath%>/js/common/uploadImage.js"> </script>



<!--缩略图-->
<script src="${pageContext.request.contextPath}/js/main.js"
	type="text/javascript"></script>
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
			//alert("请上传图片");
			popStatus(2, '请上传图片', 3);
			return;
		}
		if(urlFlag > 0){
			//alert("请填写广告访问链接");
			popStatus(2, '请填写广告访问链接', 3);
			return;
		}
		popStatus(3, '玩命发布中，等待……', 50);
		$.ajax({
					url : "${pageContext.request.contextPath}/naked/imageAd/releaseImageAd.json",
					type : "post", //请求类型
					async : false,//默认true异步请求 ，false同步请求 
					data : $('#focusCarouselForm').serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
					success : function(data) {
						if (500 == data) {
							//系统内部异常
							//alert('系统内部异常');
							popStatus(4, '为何你点它会错误？给我个理由~！', 3);
						} else if (501 == data) {
							//用户未登录，请求被拦截
							//alert('未登录');
							popStatus(2, '你还没有登录，你家人知道吗？', 3);
						} else {
							//正确返回结果
							if(data.result==1){
								//alert("发布成功");
								popStatus(1, '终于发布成功了', 3);
							}else{
								//alert("发布失败");	
								popStatus(4, '发布失败了！', 3);
							}
						}
					}
				});

	}
	
	function toCategoryPage(){
		var categoryOne=$("#categoryOne").val();
		var  categoryTwo=$("#categoryTwo").val();
		if(categoryOne==0&&categoryTwo==0){
			alert("请选择类目");
			return false;
		}
		else{
			location="${pageContext.request.contextPath}/naked/getTopCarousel.htm?categoryOne="+categoryOne+"&categoryTwo="+categoryTwo;
		}
	}
	$(function() {
		$("#locationCount").change(function(){
			location="${pageContext.request.contextPath}/naked/first/getCategoryColumn.htm?locationFloor="+$(this).val();
	
		
	});

		$
				.ajax({

					url : "${pageContext.request.contextPath}/category/getCategory.json",
					type : "get", //请求类型
					async : false,//默认true异步请求 ，false同步请求 
					data : "categoryId=0",
					success : function(data) {
						var list = data.categorys;

						for (var i = 0; i < list.length; i++) {
							var html = "<option value='"+list[i].id +"'>"
									+ list[i].name + "</option>";
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
										data : "categoryId=" + $(this).val(),
										success : function(data) {
											var list = data.categorys;
											var html1 = "<option value='0' >请选择</option>";
											$("#categoryTwo").empty();
											$("#categoryTwo").append(html1);
											for (var i = 0; i < list.length; i++) {
												var html = "<option value='"+list[i].id +"'>"
														+ list[i].name
														+ "</option>";
												$("#categoryTwo").append(html);
											}
										}
									});
							//location="${pageContext.request.contextPath}/naked/second/getTopCarousel.htm?categoryId="+$(this).val();
						});
	});
</script>
</head>

<body>
	<div id="wapper">

		<div class="main">

			<!-- 顶部菜单 -->
		<%@include file="/WEB-INF/jsps/naked/includes/topMenu.jsp"%>
			<div class="classify fixed">
				<h2>
					<a href="#">综合管理后台</a> &gt; <a href="#">页面管理</a> &gt; <a href="#">裸价体验首页</a>
					&gt; <em class="green">类目通栏管理</em>
				</h2>

				<div class="fl">
					<div class="shrink">
						<div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/naked/first/getTopCarousel.htm">顶部轮播管理</a>
						</div>
						<div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/naked/first/getFocusCarousel.htm">焦点活动管理</a>
						</div>
						<div class="vtitle1">类目钻展管理</div>
						<div class="vtitle1 current">
							<a
								href="${pageContext.request.contextPath}/naked/first/getCategoryColumn.htm?locationFloor=1">类目通栏管理</a>
						</div>
						<div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/naked/first/getRightCarousel.htm?locationFloor=1">右侧广告轮播管理</a>
						</div>
						<div class="vtitle1">
							<a
								href="${pageContext.request.contextPath}/naked/first/getImage6Ad.htm?locationFloor=1">右侧标准广告位管理</a>
						</div>
						<div class="vtitle1">裸价图片空间管理</div>

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
					<form id="focusCarouselForm"
						action="${pageContext.request.contextPath}/naked/imageAd/releaseImageAd.htm"
						method="post">
						<input type="hidden" name="pageType" value="3" /> <input
							type="hidden" name="locationType" value="4" /> <input
							type="hidden" name="category" value="0" />
						<dl class="fixed">
							<dt class="gray">【选择位置】</dt>
							<dt>
									<select id="locationCount" name="floor"
										style="width: 200px; height: 30px">
										<!-- Notice the HTML5 data attributes -->

										<c:forEach begin="1" end="${count }" var="p" step="1">
											<option value="${p}" <c:if test="${p eq locationFloor }"> selected="selected"</c:if>>位置${p }</option>
										</c:forEach>
									</select>
							</dt>
						</dl>

						<div class="border top25 fixed">
							<div class="w722">
								<c:forEach items="${imageAds}" var="p">
									<input type="hidden" name="locationIds" id="locationId"
										class="site2" value="${p.locationId}" />
									<input class="imageUrlValue" id="input_${p.locationId}"
										type="hidden" name="imageUrls" value="${p.imageUrl}" />
									<span> <a href="javascript:openDialog(${p.locationId},'${p.note}');"
										class="showbox e1">选择图片</a> <a  href="javascript:void(0);"
										class=" e2" id="imageAd"> <img class="imageUrlShow"
											src="<%=imagePath %>/${p.imageUrl}" width="720" height="80"
											id="img_${p.locationId}" /></a>

									</span>

									<label for="textfield2">720*80 ${p.note}</label>
									<input type="text" name="accessUrls" maxlength="100"
										id="accessUrl_${p.locationId}" class="site3"
										value="${p.accessUrl}" />

								</c:forEach>
							</div>

							<p class="submit">
								<input type="button" name="button4" id="button4" value="预览"
									class="preview" /><input type="button" name="button4"
									id="button4" onclick="release();" value="发布" class="issue" />
							</p>
						</div>
					</form>
				</div>

			</div>
		</div>

		<div id="TB_overlayBG"></div>
		<c:import url="/image/getAll.htm"></c:import>
	</div>
</body>
</html>
