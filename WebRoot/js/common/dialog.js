// 打开弹出框
function openDialog(locationId,locationNote){
	$("#locationId_hidden").val(locationId);
	$("#locationNote_hidden").val(locationNote);
	$("#TB_overlayBG").css({
		display:"block",height:$(document).height()
	});
	$(".box").css({
		left:($("body").width()-$(".box").width())/2-20+"px",
		top:($(window).height()-$(".box").height())/2+$(window).scrollTop()+"px",
		display:"block"
	});
}
//关闭弹出框
function closeDialog(){
	$("#TB_overlayBG").css("display","none");
	$(".box ").css("display","none");
	$("#imgspan").html("");
	$("#img_hidden").val("");
}
//点击确定按钮
function onEnterImg(){
	var locationId = $("#locationId_hidden").val();
	var imgUrl = $("#img_hidden").val();
	$("#img_"+locationId).attr("src",imagePath+"/"+imgUrl);
	$("#input_"+locationId).val(imgUrl);
	closeDialog();
}
function selectImage(imageUrl){
	var locationId = $("#locationId_hidden").val();
	
	$("#img_"+locationId).attr("src",imagePath+"/"+imageUrl);
	$("#input_"+locationId).val(imageUrl);
	closeDialog();
}