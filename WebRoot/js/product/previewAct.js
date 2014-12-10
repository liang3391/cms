$(function(){
	//PrdStat
	$.get(basePath+"/prd/getPrdStat.json",{"productCode":$("#prdCode").val()},function(data){
		var d = data.prdStat;
		if(d!=null){
			getEvaluate("cp_pj",d.goodEvaluate,d.middleEvaluate,d.badEvaluate);
			var ty = d.totalExperience+"人";
			$("#cp_rs").text(ty);
			$("#total_exp").text(ty);
		}
	})
	var totalNum = 0;
	$("td[id^='openNum_']").each(function(){
		var v = $(this).text();
		if(v!=null&&v!=""){
			totalNum += parseInt(v,10);
		}
	})
	$("#totalNum").text(totalNum);
	getDayText();	//设置活动天数
	if($("#checkStatus").val()==2){
		countDown_cn("countDown",$("#onTime1").val(),0);
	}
})

//获取时间text
function getDayText(){
	var onTime = $("#onTime").val();
	var offTime = $("#offTime").val();
	var beforeOnTime = $("#beforeOnTime").val();
	$("#day").text("活动天数："+diffDay(onTime,offTime));
	if(notEmpty(beforeOnTime)){
		$("#beforDay").text("活动展示天数："+diffDay(beforeOnTime,onTime));	
	}
}

function diffDay(startTime,endTime){
	var time = 0;
	if(notEmpty(startTime)&&notEmpty(endTime)){
		var onDate = startTime.split(" ")[0].split("-");
		var offDate = endTime.split(" ")[0].split("-");
		var d1 = new Date(onDate[0]+","+(parseInt(onDate[1])-1)+","+onDate[2]); //new Date(yyyy,mth,dd);
		var d2 = new Date(offDate[0]+","+(parseInt(offDate[1])-1)+","+offDate[2]);
		time = parseInt((d2 - d1)/1000/60/60/24,10);
	}
	return time;
}

//获取评价
function getEvaluate(id,hp,zp,cp){
	hp = fomatNum(hp);
	zp = fomatNum(zp);
	cp = fomatNum(cp);
	$("#"+id+"_1").css("width",hp);
	$("#"+id+"_2").css("width",zp);
	$("#"+id+"_3").css("width",cp);
	$("#"+id+"_1").parent().next().text(hp);
	$("#"+id+"_2").parent().next().text(zp);
	$("#"+id+"_3").parent().next().text(cp);
}

//格式化小数
function fomatNum(num){
	if(num==null||num==0){
		return 0;
	}
	return num.toFixed(1)+"%";
}

//判断是否为空
function notEmpty(v){
	if(v==null||v==""){
		return false;
	}
	return true;
}