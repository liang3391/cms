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
})

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