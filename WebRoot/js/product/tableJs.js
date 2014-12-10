// JavaScript Document
$(function() {
var count = {
	num: 0,
	arr: [],
	m: 0,
	num1: 0,
	arr1: [],
	m1: 0,
	onOff :true,
	trstr:'',
	trstr1:''
}
//获取初始颜色多选框的个数和位置
for (var i = 0; i < $('#co_show input:checkbox').length; i++) {
	if ($('#co_show input:checkbox')[i].checked) {
		 count.arr.push(i);
		 count.num = count.arr.length;
		 count.m = count.arr[count.num - 1];
		$('#oCimg .cimg').eq(count.m).show();
		
	}
}
//获取初始尺码多选框的个数和位置
if ($('#frb input:radio:checked')) {
	 var class_size = $('#frb input:radio:checked').parent().attr('class');
	 var class_fs = $('#frb input:radio:checked').parent().next().attr('class');
	 if ($('#frb input:radio:checked').parent().attr('class') == 'xie_size') {
	 	var class_fs = $('#frb input:radio:checked').parent().next().attr('class');
		count.onOff = false;
	} else {
		var class_fs = $('#frb input:radio:checked').parent().prev().attr('class');
		count.onOff = true;
	}
	for (var i = 0; i < $('.' + class_size + ' input:checkbox.fx').length; i++) {
		if ($('.' + class_size + ' input:checkbox.fx')[i].checked) {
			 count.arr1.push(i);
			 count.num1 = count.arr1.length;
			 count.m1 = count.arr1[count.num1 - 1];
		}
		$('.' + class_size + ' input:checkbox.fx')[i].index = i;
		 $('.' + class_size + ' input:checkbox.fx')[i].onclick = function() {
			raDio($('.' + class_size + ' input:checkbox.fx'), $('.' + class_size + ' .f1'), this.index);
		}
	}
}
hide_show() 
//显示隐藏颜色和尺码部分
function hide_show() {
	 //颜色
	$('.oColor_box').click(function() {
		if (this.checked) {
			$('.co_show').show();
			$('#_oTable').show();
			clickColor()
		} else {
			oTime();
			$('.co_show').hide();
			$('#oCimg .cimg').hide();
			$('#co_show input:checkbox').each(function(index, element) {
				$('#co_show input:checkbox')[index].checked = false;
			});
		}
	});
	//尺码
	$('.oSize_box').click(function() {
		if (this.checked) {
			$('#_oTable').show();
			 $('.si_show').show();
			 clickSize();
		} else {
			oTime1();
			$('.si_show').hide();
			$('#frb input:checkbox').each(function(index, element) {
				$('#frb input:checkbox')[index].checked = false;
			});
		}
	});
}
//ADD增加颜色
clickSize();
clickColor()
function clickColor(){
	for(var i=0;i<$('#co_show .fx').length;i++){
	   	$('#co_show .fx')[i].index = i
		$('#co_show .fx')[i].onclick = function(){
			if (this.checked) {
				count.num++;
				count.m = this.index;
				count.arr.push(this.index);
				addTable();
				$('#prodb .poinp').eq(this.index).attr('readonly', 'readonly');
				$('.btn_none').show();
				$('#oCimg strong').eq(this.index).html($('#prodb .poinp').eq(this.index).val());
				$('#oCimg .cimg').eq(this.index).show();
				addImg()
				//alert(count.arr)
			} else {
				 count.num--;
				 count.m = this.index;
				 delTable();
				 count.arr.splice(arrIndexof(count.arr, count.m), 1);
				 //不选中后可以进行编辑颜色
				 $('#prodb .poinp').eq(this.index).attr('readonly', false);
				 //隐藏对应上传图片的颜色
				 $('#oCimg .cimg').eq(this.index).hide();
			}
		}
	}
	
 }
//点击尺码
function clickSize(){
	$('#frb input:radio').each(function(index, element) {
		$(this).click(function() {//点击选中单选
			class_size = $('#frb input:radio:checked').parent().attr('class');
			class_fs = $('#frb input:radio:checked').parent().next().attr('class');
			if (index == 0 && count.onOff) {
				readonly($('#frb .fu_size input:checkbox'), $('#frb .xie_size input:checkbox'))//设置未选中不能点击 disabled
				 for (var i = 0; i < $('.xie_size input:checkbox.fx').length; i++) {
					$('.xie_size input:checkbox.fx')[i].index = i;
					 $('.xie_size input:checkbox.fx')[i].onclick = function() {
						raDio($('.xie_size input:checkbox.fx'), $('.xie_size .f1'), this.index);
					}
				}
				
				oTime1();//清空尺码
				rowSp();//重置rowspan
				count.onOff = !count.onOff;//设置开关 重复点击无效果
			} else if (index == 1 && !count.onOff) {
				class_size = $('#frb input:radio:checked').parent().attr('class');
				class_fs = $('#frb input:radio:checked').parent().prev().attr('class');
				readonly($('#frb .xie_size input:checkbox'), $('#frb .fu_size input:checkbox'))
				 for (var i = 0; i < $('.fu_size input:checkbox.fx').length; i++) {
					$('.fu_size input:checkbox.fx')[i].index = i;
					 $('.fu_size input:checkbox.fx')[i].onclick = function() {
						raDio($('.fu_size input:checkbox.fx'), $('.fu_size .f1'), this.index);
					}
				}
				oTime1();
				rowSp()
				count.onOff = !count.onOff;
			}
		})
	});
}
//单选清空选中
function readonly(obj, obj1) {
	obj.each(function(index, element) {
		obj[index].checked = false;
		$(this).prev().attr('readonly',false)
		 
	});
	obj.each(function(index, element) {
		obj[index].disabled = true;
		obj1[index].disabled = false;
	});
	
}
//单选后点击
function raDio(obj, val, index) {
	if (obj[index].checked) {
		count.m1 = index;
	    count.num1++;
	    count.arr1.push(index);
	    addSize(function(){
		  addImg()	
		});
		rowSp()
		addImg()
		val.eq(index).attr('readonly', 'readonly');
	} else {
		count.m1=index;
	    count.num1--;
	    delSize();
		
		rowSp()
		
		count.arr1.splice(arrIndexof(count.arr1, count.m1), 1);
		val.eq(index).attr('readonly', false);
	}
}
//清空颜色
function oTime() {
	count.num--
	count.m = count.arr[count.num]
	delTable()
	 if (count.num > 0) {
		oTime()
	} else {
		count.num = 0
		count.m = 0;
		count.arr = []
	}
}
//清空尺码
function oTime1(){
	count.num1--
	count.m1 = count.arr1[count.num1];
	clearSize();
	delSize();
	 if (count.num1 > 0) {
		oTime1();
	} else {
		count.num1 = 0;
		count.m1 = 0;
		count.arr1 = [];
	}	
}
//增加颜色
function addTable(){
	var oTr = '';
	if(count.num==1&&count.num1!=0){//有尺码 无颜色时 添加颜色
		 var tdFirst = "<p><input type='text' class='yanse' name='stdDto.colorName' readonly='readonly' value='"+$('#prodb .poinp').eq(count.m).val()+"'></p><p class='oI'></p>";
		  $("#_oTable tbody tr").each(function(index, element) {
				$(this).children().first().html(tdFirst)
		  });	
	}else if(count.num>=1&&count.num1==0){//无尺码时 添加颜色
		  if(count.num1==0){
			apr('one')
		  }else{
			apr('two')
		  }
	}else if(count.num!=1&&count.num!=0){//有尺码 有颜色 循环添加尺码
		$("#frb input:checkbox:checked").each(function(index, element) {
			apr(index)
		});
	}
	function apr(index){
		oTr +="<tr>"
		oTr +="<td><p><input type='text' class='yanse' name='stdDto.colorName' readonly='readonly' value='"+$('#prodb .poinp').eq(count.m).val()+"'></p><p class='oI'></p></td>";
	    //判断不循环添加时将index改为0
		if(index!='one'&&index!='two')
			{oTr +="<td><input class='chima' readonly='readonly' type='text' name='stdDto.sizeName' value='"+$('.' + class_size + ' input.f1').eq(count.arr1[index]).val()+"'></td>";
		}else if(index=='two'){
			oTr +="<td><input class='chima' readonly='readonly' type='text' name='stdDto.sizeName' value='"+$('.' + class_size + ' input.f1').eq(count.arr1[0]).val()+"'></td>";
		}else if(index=='one'){
			oTr +="<td></td>";
		}
		oTr +="<td><input type='text' readonly='readonly' value='"+$('#marketPrice').val()+"'></td>";
		oTr +="<td><input type='text' readonly='readonly' value=''></td>";
		oTr +="<td><input type='text' name='stdDto.barCode' value=''></td>";
		oTr +="<td><input name='stdDto.id' value='1' type='checkbox'></td>";
		oTr +="</tr>";
	}
	count.trstr = oTr
	$("#_oTable tbody").append(count.trstr)	
	$("#_oTable").rowspan(0);
}
//增加尺码
function addSize(endfn){
	var len
	for(var i=0;i<=count.arr.length;i++){
		//获取相同颜色的个数
		len = $("#_oTable").find("input[value='"+$('#prodb .poinp').eq(count.arr[i]).val()+"']");
		    var oTr1 = '';
			oTr1 +="<tr>"
			oTr1 +="<td><p><input type='text' class='yanse' name='stdDto.colorName' readonly='readonly' value='"+$('#prodb .poinp').eq(count.arr[i]).val()+"'></p><p class='oI'></p></td>";
			oTr1 +="<td><input class='chima' readonly='readonly' name='stdDto.sizeName' type='text' value='"+$('.' + class_size + ' input.f1').eq(count.m1).val()+"'></td>";
			oTr1 +="<td><input type='text' readonly='readonly' value='"+$('#marketPrice').val()+"'></td>";
			oTr1 +="<td><input type='text' readonly='readonly' value=''></td>";
			oTr1 +="<td><input type='text' name='stdDto.barCode' value=''></td>";
			oTr1 +="<td><input name='stdDto.id' value='1' type='checkbox'></td>";
			oTr1 +="</tr>"
			count.trstr1 = oTr1
			if(len.length>=0){
				if(len.length==1&&len.last().parent().parent().next().html()==''){
				    len.last().parent().parent().next().html("<input class='chima' readonly='readonly' name='stdDto.sizeName' type='text' value='"+$('.' + class_size + ' input.f1').eq(count.m1).val()+"'>")
				}else if(len.length==0&&count.num==0&&count.num1==1){
					$('#_oTable tbody').append(count.trstr1)
					if($('#_oTable input[value="undefined"]')){
						$('#_oTable input[value="undefined"]').val('')
					}
				}else{
			  		len.last().parent().parent().parent().after(count.trstr1)
				}
			}
	}
	endfn&&endfn()
	rowSp()
	$("#_oTable").rowspan(0);
}

//删除尺码
function delSize(endfn){
	var size = $('.' + class_size + ' input.f1').eq(count.m1).val();
	delSclear(size)
	endfn&&endfn()
}
//清空尺码
function clearSize(){
	var size = $('.' + class_fs + ' input.f1').eq(count.m1).val();
	delSclear(size)
}
function delSclear(size){
  var len = getEquelColorLn(size);
	$("#_oTable input[value='"+size+"']").each(function(index, element) {
		if(count.num!=0){
			if(len[index]>1){
				$(this).parent().parent().next().children().show();
				$(this).parent().parent().remove();
			}else{
				$(this).parent().html('')	
			}
		}else{
		   $(this).parent().parent().next().children().show();
		   $(this).parent().parent().remove();
		   if($('#_oTable input[value="undefined"]')){
				$('#_oTable input[value="undefined"]').val('')
	    	}
		}
	    
	});
	if(count.num==0&&count.num1==0){
	   $('#_oTable tbody tr').remove()
	}
	$("#_oTable").rowspan(0);
	rowSp()
}
//根据尺码找到相同颜色的个数
function getEquelColorLn(size){
	var len = [];
	var color = [];
	$("#_oTable input[value='"+size+"']").each(function(index, element) {
        color[index] = $(this).parent().prev().children().children().val();
    });
	for(var i=0;i<color.length;i++){
		len[i] = $("#_oTable input[value='"+color[i]+"']").length;
	}
	return len;
}
//删除颜色
function delTable(){
	$("#_oTable tbody tr").each(function(index, element) {
		   if($(this).children().find("input").val()==$('#prodb .poinp').eq(count.m).val()){
			   if(count.num==0&&count.num1!=0){
				 //$(this).children().find(".yanse").attr("value","");
				 //alert($(this).children().attr("rowspan"));
			   	 $(this).children().first().html("");
			   }else{
				 $(this).remove();
			   }
		   }
	});	
}
//重置rowSp
function rowSp(){
	var rowVal = 0
	var ozH
    $('#co_show input:checkbox:checked').each(function(index, element) {
			ozhi=$('#_oTable').find("input[value='"+$('#prodb .poinp').eq(count.arr[index]).val()+"']");
				$("#_oTable tbody tr").each(function(index1, element1) {
					ozhi.eq(0).parent().parent().parent().children().first().attr('rowspan',ozhi.length);
			});
				
	 });
	 if($('#co_show input:checkbox:checked').length==0){
		 var oChe  = $('.' + class_size + ' input:checkbox:checked')
		 oChe.each(function(index, element) {
				$("#_oTable tbody tr").each(function(index1, element1) {
				$("#_oTable tbody tr").eq(0).children().first().attr("rowspan",oChe.length)
			});
				
	 }); 
	 }
}
//数组indexof方法
function arrIndexof(arr, v) {
	for (var i = 0; i < arr.length; i++) {
		if (arr[i] == v) {
			return i;
		}
	}
	return - 1;
}	
//改变市场价
$('#marketPrice').change(function(){
	$('#_oTable tbody tr').each(function(index, element) {
   	    $(this).children().first().next().next().children().val($('#marketPrice').val())
	});
})
//点击上传图片
addImg();
})
function addImg(){
	$('#oCimg .upload').each(function(){
		var _that = $(this).prev().html()	
		$("#co_show .poinp").each(function() {
			if($(this).val() == _that ){
				var _this = $(this)
			   $(this).parent().next().next().attr('src')
			   $("#_oTable .yanse").each(function() {
				   if($(this).val() == _this.val()){
					   if(_this.parent().next().next().attr('src')){
					   	//	var oSrc =_this.parent().next().next().attr('src').replace(imagePath,'')
					   		var colorArtwork = _this.parent().next().next().next().val();	//300*300
					   		var colorShow = _this.parent().next().next().next().next().val()	//35*35
							$(this).parent().next().html('<img src="'+imagePath+"/"+colorShow+'"/><input type="hidden" name="stdDto.colorArtwork" value="'+colorArtwork+'" /> <input type="hidden" name="stdDto.colorShow" value="'+colorShow+'" /> ')                      
							_this.parent().next().next().next().attr("value",colorArtwork)
							_this.parent().next().next().next().next().attr("value",colorShow)
						}
				   }
			   });
			}
		});
	})
}