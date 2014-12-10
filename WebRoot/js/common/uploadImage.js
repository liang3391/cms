function doUpload() {
	// 上传方法
	$.upload({
		// 上传地址
		url : basePath+'/dfs/image/upload.json',
		// 文件域名字
		fileName : 'file',
		// 其他表单数据
		params : {
			imageName : $("#locationNote_hidden").val(),
			imageSize : $("#locationSize_hidden").val()
		},
		// 上传完成后, 返回json, text
		dataType : 'json',
		// 上传之前回调,return true表示可继续上传
		onSend : function() {
			return true;
		},
		// 上传之后回调
		onComplate : function(data) {
			var $img =  "<img src='"+imagePath+"/"+data.filePathList +"'  height='365px' width='680px' />";
			$("#imgspan").html($img);
			$("#img_hidden").val(data.filePathList);
		}
	});
}