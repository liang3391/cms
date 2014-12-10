//广告向上移动
function moveUp(locationId){
	var current = 0;
	var id = "input_"+locationId;
	$(".imageUrlValue").each(function(index){
		if(id == $(this).attr("id")){
			current = index;
		}
	});
	if(current == 0){
		//alert("已经到顶了");
		popStatus(2, '向上移不动了！', 3);
	}else{	
		//展示图片 位置互换
		var imgShowSrc = $(".imageUrlShow").eq(current).attr("src");
		$(".imageUrlShow").eq(current).attr("src",$(".imageUrlShow").eq(current-1).attr("src"));
		$(".imageUrlShow").eq(current-1).attr("src", imgShowSrc);
		
		//访问链接 位置互换
		var accessUrlSrc = $("input[name='accessUrls']").eq(current).val();
		$("input[name='accessUrls']").eq(current).val($("input[name='accessUrls']").eq(current-1).val());
		$("input[name='accessUrls']").eq(current-1).val(accessUrlSrc);
		
		//隐藏图片链接 位置互换
		var imgInputSrc = $(".imageUrlValue").eq(current).val();
		$(".imageUrlValue").eq(current).val($(".imageUrlValue").eq(current-1).val());
		$(".imageUrlValue").eq(current-1).val(imgInputSrc);
				
	}
	
	
}
//广告向下移动
function moveDown(locationId){
	var current = 0;
	var id = "input_"+locationId;
	$(".imageUrlValue").each(function(index){
		if(id == $(this).attr("id")){
			current = index;
		}
	});
	if(current == ($(".imageUrlValue").length-1)){
		//alert("已经到底了");
		popStatus(2, '向下移不动了！', 3);
	}else{	
		//展示图片 位置互换
		var imgShowSrc = $(".imageUrlShow").eq(current).attr("src");
		$(".imageUrlShow").eq(current).attr({ src: $(".imageUrlShow").eq(current+1).attr("src"), alt: "焦点活动图片" });
		$(".imageUrlShow").eq(current+1).attr({ src: imgShowSrc, alt: "焦点活动图片" });
		
		//访问链接 位置互换
		var accessUrlSrc = $("input[name='accessUrls']").eq(current).val();
		$("input[name='accessUrls']").eq(current).val($("input[name='accessUrls']").eq(current+1).val());
		$("input[name='accessUrls']").eq(current+1).val(accessUrlSrc);
		
		//隐藏图片链接 位置互换
		var imgInputSrc = $(".imageUrlValue").eq(current).val();
		$(".imageUrlValue").eq(current).val($(".imageUrlValue").eq(current+1).val());
		$(".imageUrlValue").eq(current+1).val(imgInputSrc);
				
	}
}

//删除图片广告
function deleteImageAd(id,adId,locationId){
	$.ajax({
	      url : basePath+"/naked/imageAd/deleteImageAd.json",
	      type : "post", //请求类型
	      async : false,//默认true异步请求 ，false同步请求 
	      data : {id:id,adId:adId},//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
	      success : function(data) { 
	           if (500 == data) {
	              //系统内部异常
	              //alert('系统内部异常');
	              popStatus(4, '系统内部异常！', 3);
	           } else if (501 == data) {
	              //用户未登录，请求被拦截
	              //alert('未登录');
	              popStatus(2, '还没有登录！', 3);
	           } else {
	              //正确返回结果
	              if(data.result == 1){
	            	  $("#img_"+locationId).attr({ src: '', alt: "焦点活动图片" });
	            	  $("#input_"+locationId).val("");
	            	  $("#accessUrl_"+locationId).val("");
	            	  //alert("删除成功");
	            	  popStatus(1, '删除成功！', 3);
	              }else{
	            	  //alert("删除失败");
	            	  popStatus(4, '删除失败！', 3);
	              }
	          }
	     }
	});
}