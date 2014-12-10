$(function(){
	_init_province();	//初始化省
	$("#city_sec").change(checkNum);
	defCk();	//设置默认选中;
	$("#stdTable").rowspan(0);	//合并表格列
	initData();	//初始化项
	getStore();	//获取库存
	formValid("subAct","1");	//valid 表单
	formValid("addAct","2");	//valid 表单
	formValid("prevAct","3");
})

function formValid(_id,idx){
	$.formValidator.initConfig({validatorGroup:idx,submitButtonID:_id,
		onError:function(msg,obj,errorlist){},
		onSuccess:function(){
			if(!notEmpty($("#onTime").val())||!notEmpty($("#onTime").val())){
				alert("请输入活动时间");
				return;
			}else if($("input[type='checkbox']:checked").length<1){
				alert("请选择地区");
				return;
			}else{
				setCkbox();	//设置省份
				if(_id=="subAct"){	//提交复核
					$("#actfrom").attr({"action":basePath+"/prd/modifyPrdAct.htm",target:"_self"});
				}else if(_id=="addAct"){
					$("#actfrom").attr({"action":basePath+"/prd/addPrdAct.htm",target:"_self"});
				}else{
					$("#actfrom").attr({"action":basePath+"/prd/toActPrev.htm",target:"_blank"});
				}
				$("#actfrom").submit();
			}
		}
	});
	$("#price").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:"请输入体验价",onCorrect:" "})
	.regexValidator({regExp:"price",onError:"体验价格式不对",dataType:"enum"});
	$("#purpose").formValidator({validatorGroup:idx,empty:false,onShow:" ",onFocus:"请输入体验目的",onCorrect:" "})
		.inputValidator({min:1,max:30,onError:"1-30个字符"})
		.regexValidator({regExp:"str",onError:"含有非法字符",dataType:"enum"});
	$("#ageMin").formValidator({
		validatorGroup:idx,
		tipID:"ageTip",
		onShow:" ",
		onFocus:" ",
		onCorrect:" "
	}).functionValidator({
	    fun:function(val,elem){
	    	if(!notEmpty(val)||!notEmpty($("#ageMin").val())){
	    		return "请输入年龄";
	    	}else if(parseInt($("#ageMin").val(),10)>parseInt($("#ageMax").val(),10)){
	    		return "年龄输入不对";
	    	}else{
	    		return true;
	    	}
		}
	});
	$("#ageMax").formValidator({
		validatorGroup:idx,
		tipID:"ageTip",
		onShow:" ",
		onFocus:" ",
		onCorrect:" "
	}).functionValidator({
	    fun:function(val,elem){
	    	if(!notEmpty(val)||!notEmpty($("#ageMin").val())){
	    		return "请输入年龄";
	    	}else if(parseInt($("#ageMin").val(),10)>parseInt($("#ageMax").val(),10)){
	    		return "年龄输入不对";
	    	}else{
	    		return true;
	    	}
		}
	});
}

//活动显示预览
function showPreview(){
	var prev = [];
	prev[0] = $("#purpose").val();
	prev[1] = $("#xb_tj  option:selected").text();
	var age = "";
	var ageMin = $("#ageMin").val();
	var ageMax = $("#ageMax").val();
	if(notEmpty(ageMin)&&notEmpty(ageMax)){
		if(ageMin==1&&ageMax==100){
			age = "不限";
		}else{
			age = ageMin+" - "+ageMax;
		}
	}
	prev[2] = age;
	prev[3] = $("#classHY  option:selected").text();
	var grade = "";
	var gradeLow = $("#lv_tj").val();
	var gradeHigh = $("#lv_tj1").val();
	if(gradeLow==-1||gradeHigh==-1){
		grade = "不限";
	}else{
		grade = $("#lv_tj option:selected").text()+" - "+$("#lv_tj1 option:selected").text();
	}
	prev[4] = grade;
	var brand = "";
	var brandNum = $("#brand  option:selected").val();
	if(brandNum==-1){
		brand = "不限";
	}else{
		brand = $("#brand  option:selected").text()+"个以上";
	}
	prev[5] = brand
	prev[6] = $("#city_sec  option:selected").text();
	var areaVal = $("#city_sec  option:selected").val();
	if(areaVal!=2){
		var area = "";
		$("input[type='checkbox']:checked").each(function(){
			area += $(this).next().text()+" ";
		});
		prev[7] = area;
	}else{
		prev[7] = "不限";
	}
	$("#oE_p1").text(prev[0]);
	$("span[id^='oEs_']").each(function(i){
		$(this).text(prev[i+1]);
	});
}

function _init_province(){
	var proStr = "";
	for(var i=0;i<province.length;i++){
		var pro = province[i].split("-");
		proStr += "<li><input value='"+pro[1]+"' type='checkbox' name='areaBox'><span>"+pro[2]+"</span></li>";
	}
	$("#oE_ol").html(proStr);
	checkNum();
}

/*限制选中格式*/
function checkNum(){
	$("#oE_ol input[type='checkbox']").click( function() {
	    if ($("input[type='checkbox']:checked").length>3) {
	        $(this).attr("checked",false);
	    }
	});
	var v = $("#city_sec option:selected").val();
	if(v==2){
		$("#oE_ol :checkbox").attr({"checked":"checked","disabled":"disabled"});
	}else{
		$("#oE_ol :checkbox").attr({"checked":false,"disabled":false});
	}
}

//设置默认选中
function defCk(){
	var gradeLow = $("#gradeLow").val();
	var gradeHigh = $("#gradeHigh").val();
	var userType = $("#userType").val();
	var brandNum = $("#brandNum").val();
	var areaType = $("#areaType").val();
	var areaId = $("#areaId").val();
	if(notEmpty(gradeLow)){
		$("#lv_tj").val(gradeLow);
	}
	if(notEmpty(gradeHigh)){
		$("#lv_tj1").val(gradeHigh);
	}
	if(notEmpty(userType)){
		$("#classHY").val(userType);
	}
	if(notEmpty(brandNum)){
		$("#brand").val(brandNum);
	}
	if(notEmpty(areaType)){
		$("#city_sec").val(areaType);
		if(areaType==2){
			$("#oE_ol :checkbox").attr({"checked":"checked","disabled":"disabled"});
		}
	}
	if(notEmpty(areaId)){
		var ids = areaId.split(",");
		for(var i=0;i<ids.length;i++){
			$("input:checkbox[value='"+ids[i]+"']").attr('checked','checked');
		}
	}
}

//获取所有checkbox选中的值
function setCkbox(){
	var v = $("#city_sec option:selected").val();
	var vals = "";
	var texts = "";
	if(v!=2){
		$("input[type='checkbox']:checked").each(function(i,obj){
			vals += $(obj).val()+",";
			texts += $(obj).next().text()+" ";
		});
		$("#areaId").val(vals.substring(0,vals.length-1));
		$("#area").val(texts.substring(0,texts.length-1));
	}
}

function ckPrice(o){
	var v = o.value;
	if(/^\d+\.?\d{0,2}$/.test(v)){
		o.value = v;
	}else{
		o.value = "";
	}
}

function ckAge(o){
	var v = o.value;
	if(/[0-9]+$/.test(v)){
		if(v<1){
			v = 1;
		}else if(v>100){
			v = 100;
		}
		o.value = v;
	}else{
		o.value = "";
	}
}

//设置表格中的price
function initData(){
	var price = $("#price").val();	//设置价格
	if(notEmpty(price)){
		$("td[id^='price_']").text(price);
	}
	$("#price").blur(function(){
		var pc = $(this).val();
		$("td[id^='price_']").text(pc);
	});
	getDayText();
	$("#offTime").blur(function(){
		getDayText();
	});	
}

//获取时间text
function getDayText(){
	var time = 0;
	var onTime = $("#onTime").val();
	var offTime = $("#offTime").val();
	if(notEmpty(onTime)&&notEmpty(offTime)){
		//time = parseInt(offTime.split("-")[2],10)-parseInt(onTime.split("-")[2],10);
		var onDate = onTime.split(" ")[0].split("-");
		var offDate = offTime.split(" ")[0].split("-");
		var d1 = new Date(onDate[0]+","+(parseInt(onDate[1])-1)+","+onDate[2]); //new Date(yyyy,mth,dd);
		var d2 = new Date(offDate[0]+","+(parseInt(offDate[1])-1)+","+offDate[2]);
		time = parseInt((d2 - d1)/1000/60/60/24,10);
	}
	$("#day").text("当前选择活动时间天数 : "+time);
}

//获取所有库存
function getStore(){
	var store = 0;
	$("input[id^='store_']").each(function(){
		var v = $(this).val();
		if(notEmpty(v)){
			store+=parseInt(v,10);
		}
	});
	$("#totalStore").val(store);
	$("#store").text(store);
}

//判断是否为空
function notEmpty(v){
	if(v==null||v==""){
		return false;
	}
	return true;
}