$(function(){
	$("#_oTable").rowspan(0);
	defCk();	//默认选中
	prdformValid("subPrd","1");	//提交
	prdformValid("prevPrd","2");	//页面预览
})

//设置提交参数和校验
function subParam(_id){
	var subUrl = basePath;
	editor.sync();	//同步editor
	setSelectName();	//同步名称
	var prdCode = $("#prdCode").val();
	if("subPrd"==_id){
		if($("#fromPage").val()=="endSale"){	//当在体验结束产品管理中编辑产品保存时，因为需要迁出新版本，所以跳到专门处理该操作的接口
			subUrl += "/prd/modifyEndSaleProduct.htm";
		}else if(notEmpty(prdCode)){
			subUrl += "/prd/modifyPrd.htm";
		}else{
			subUrl += "/prd/addPrd.htm";
		}
		$("#prdform").attr({action:subUrl,target:"_self"});
	}else{
		$("#prdform").attr({action:basePath+"/prd/toPreviewPrd.htm",target:"_blank"});
	}
	var validBoo = false;	//验证条形码
	$("input[name='stdDto.id']:checked").each(function(){
		var v = $(this).parent().prev().children().val();	//找到braCode
		if(!notEmpty(v)){
			alert("条形码不能为空!");
			validBoo = true;
			return false;
		}
	});
	$("input[name='stdDto.id']").not(":checked").each(function(i){
		$(this).parent().prev().children().val("");
	});
	return validBoo;
}

function prdformValid(_id,idx){
	$.formValidator.initConfig({validatorGroup:idx,submitButtonID:_id,
		onError:function(msg,obj,errorlist){},
		onSuccess:function(){
			var boo = subParam(_id);
			if(boo){
				return false
			}
			$("#prdform").submit();
		}
	});
	$("#productName").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:" ",onCorrect:" "})
		.inputValidator({min:1,max:32,onError:"产品名称为1-32个字符"})
		.regexValidator({regExp:"str",onError:"产品名称含有非法字符",dataType:"enum"});
	$("#marketPrice").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:"请输入市场价",onCorrect:" "})
	.regexValidator({regExp:"price",onError:"市场价格式不对",dataType:"enum"});
	$("#standard").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:"请输入规格",onCorrect:" "})
		.inputValidator({min:1,max:15,onError:"规格为1-15个字符"});
	$("#s_county").formValidator({
		validatorGroup:idx,
		tipID:"s_countyTip",
		onShow:" ",
		onFocus:" ",
		onCorrect:" "
	}).functionValidator({
	    fun:function(val,elem){
	    	if(val=="0"){
	    		return "请选择区域";
	    	}else if($("#s_province").val()=="0"||$("#s_city").val()=="0"){
	    		return "请选择区域";
	    	}else{
	    		return true;
	    	}
		}
	});
	$("#tel").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:"请输入联系电话",onCorrect:" "})
	.regexValidator({regExp:"telPho",onError:"联系电话格式不对",dataType:"enum"});
	$("#manufacturer").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:" ",onCorrect:" "})
		.inputValidator({min:1,max:50,onError:"产品名称为1-50个字符"})
		.regexValidator({regExp:"str",onError:"生产厂家含有非法字符",dataType:"enum"});
	$("#pmId").formValidator({
		validatorGroup:idx,
		tipID:"pmIdTip",
		onShow:" ",
		onFocus:" ",
		onCorrect:" "
	}).functionValidator({
	    fun:function(val,elem){
	    	if(val=="0"){
	    		return "请选择产品经理";
	    	}
	    	return true;
		}
	});
	/*$("#shopUrl").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:" ",onCorrect:" "})
		.inputValidator({min:1,max:100,onError:"店铺连接为1-100个字符"});*/	//店铺连接不是必填-更改
	$("#shopPic").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:" ",onCorrect:" "})
		.inputValidator({min:1,max:200,onError:"请上传店铺图片"});
}

//设置默认选中
function defCk(){
	var pmId = $("#pmIdSel").val();
	if(notEmpty(pmId)){
		$("#pmId").val(pmId);
	}
}

//upload
function upload(_id,_obj){
	$.ajaxFileUpload({
		url:basePath+"/prd/uploadPrdImg.htm?param="+_id,
		secureuri:false,
		fileElementId:"file",
		dataType: 'json',				
		success: function (data, status){
			if(data.error==0){//成功
				handleImgMsg(data.message,_id,_obj);
			}else{
				alert(data.message);
			}
		},
		error: function (data, status, e){
			alert("上传失败");
		}
	});
}

//处理图片信息
function handleImgMsg(message,_id,_obj){
	var imgUrl = message.split(",");
	if(_id=="master"){
		$(".mainPic input[id$='_m']").each(function(i,o){
			$(o).val(imgUrl[i]);
		});
		$(_obj).prev().children().attr("src",imagePath+"/"+$("#showPic_m").val());
	}else if(_id=="slave"){
		$(".mainPic input[id$='_s']").each(function(i,o){
			var path = $(o).val()+imgUrl[i]+",";
			$(o).val(path);
		});
		$(_obj).prev().children().attr("src",imagePath+"/"+imgUrl[1]);
	}else if(_id=="color"){
		var cid = $(_obj).attr("id");
		$("#"+cid+"Artwork").val(imgUrl[0]);
		$("#"+cid+"Show").val(imgUrl[1]);
		$("#"+cid+"s").attr("src",imagePath+"/"+imgUrl[1]);
		$("#"+cid+"s").show();
		addImg();
	}else{
		$("#"+_id).val(imgUrl);
		if(_id=="shopPic"){
			$("#shopPicTip").text("");	//店铺图片
		}
	}
}

function ck(_id,_obj){
	$("#file").change(function(){
		upload(_id,_obj);
	});
	$("#file").click();
}

function ckPrice(o){
	var v = o.value;
	if(/^\d+\.?\d{0,2}$/.test(v)){
		o.value = v;
	}else{
		o.value = "";
	}
}

/*给地区赋值*/
function setSelectName(){
	$("#countryName").val($("#s_country option:selected").text());
	$("#provinceName").val($("#s_province option:selected").text());
	$("#cityName").val($("#s_city option:selected").text());
	$("#districtName").val($("#s_county option:selected").text());
	$("#pmName").val($("#pmId option:selected").text());
}

//判断是否为空
function notEmpty(v){
	if(v==null||v==""){
		return false;
	}
	return true;
}