//=========倒计时=========
function showCountDown(_id,endTime,num,type){
	var time = document.getElementById(_id);
	var now = new Date();
	var endDate = new Date(endTime); 
	endDate.setDate(endDate.getDate()+num);
	endDate.setHours(endDate.getHours()-14);
	var leftTime=endDate.getTime()-now.getTime();
	if(leftTime>0){
		var leftsecond = parseInt(leftTime/1000); 
		var day=Math.floor(leftsecond/(60*60*24)); 
		var hour=Math.floor((leftsecond-day*24*60*60)/3600); 
		var minute=Math.floor((leftsecond-day*24*60*60-hour*3600)/60); 
		var second=Math.floor(leftsecond-day*24*60*60-hour*3600-minute*60);
		if(hour<10)
		   hour="0"+hour;
	    if(minute<10)
	       minute="0"+minute;
	    if(second<10)
	       second="0"+second;
	    if(type=="cn"){
			time.innerHTML = day+" 天 "+hour+" 时 "+minute+" 分 "+second+" 秒";
	    }
	    if(type=="colon"){
	    	time.innerHTML = day+"天"+hour+":"+minute+":"+second+"";
	    }
	}else{
		clearInterval(this);
		if(type=="cn"){
			time.innerHTML ="0 天 0  时 0 分 0秒";
		}
		if(type=="colon"){
			time.innerHTML ="0 天 0:0:0";
		}
	}
}

//倒计时显示中文如 1天1时1分1秒
function countDown_cn(_id,endTime,num){
	showCountDown(_id,endTime,num,"cn");
	timer = setInterval(function(){showCountDown(_id,endTime,num,"cn")},1000);
}

//倒计时，天用中文，时间用:  如1天1:1:1
function countDown_colon(_id,endTime,num){
	//debugger;
	showCountDown(_id,endTime,num,"colon");
	timer = setInterval(function(){showCountDown(_id,endTime,num,"colon")},1000);
}

