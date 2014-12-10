
//左侧menu展开收缩
oMenu({slidedClass:"colis",oLi:$('.oBrand_menu ul li'),oOlli:$('.oBrand_menu ol li')})
function oMenu(json){
	$("."+json.slidedClass+"").click(function(){
		if($(this).next().is(":hidden")){
			$(this).next().slideDown();
			if($(this).hasClass("on")){
			 $(this).children().last().removeClass('i1')	;
			}else{
				$(this).children().last().removeClass('bg1').addClass('bg2');
			}
		}else{
		    $(this).next().slideUp();
			if($(this).hasClass("on")){
				$(this).children().last().addClass('i1');
			}else{
		    	$(this).children().last().removeClass('bg2').addClass('bg1');
			}
		}
 	})
	json.oLi.click(function(){
	    if(!$(this).hasClass(json.slidedClass)){
			json.oLi.removeClass("on");
		  	$(this).addClass('on');
		}	
	})
	json.oOlli.click(function(){
	    json.oOlli.removeClass('on');
		$(this).addClass('on');
		$(this).parent().prev().addClass("on");
	})
}
//评价回复功能
//判断回复的内容是否存在
judgeExist($('.oAnswerJs'))
function judgeExist(_this){
	$('.exist').each(function(index, element) {
		 if($(this).html()!=''){
			$(this).parent().show()
			$(this).parents('tr').show()
		 }else{
			 $(this).parent().hide()
			 $(this).parents('tr').hide()
			 if(_this){	
             	_this.parents("tr").removeClass('noline');
			 }
		 }
	});
}
$('.oAnswerJs').on("click",function(event){
	event.stopPropagation();
	 judgeExist($(this))
	  var _this = $(this)
	  var _that = $(this).parents("tr").next().children().children().first()
	  $(this).parents("tr").addClass('noline')
	  $(this).parents("tr").next().show()
	  _that.show()
	  $(this).parents("tr").next().children().find("input[type=button]").on("click",function(){
			  _this.parent().prev().prev().html("手动回复").end().prev().addClass("green");
			   if(_this.parent().prev().attr("class")=="remo"){
				  _this.parent().prev().html("手动回复").end().prev().addClass("green");
			   }
			  _this.parents("tr").next().children().find(".exist").html($(this).prev().prev().val())
			  _that.hide();
			  _this.hide();
			  judgeExist();
	  })
	  $('.answer').on("click",function(event){
		  event.stopPropagation();
		   $(this).show()
	  });
	   $(document).on("click",function(event){
				  event.stopPropagation();
					judgeExist(_this)
		});
	  
})

//评价回复 end
//打分功能
var arrgrade = [];
function grade(index){
	   if(!$(".oGval")){return};
	   $(".oGval").val("");
	   arrgrade.push(index);
	   $('.gradeSure input.sure').click(function(){
		  var oGrade = $(this).parent().prev().children().val();
		  var oElement = $(".grade").eq(arrgrade[arrgrade.length-1])
		  oElement.parent().hide();
		  if(oElement.parent().prev().length>0){
		    oElement.parent().prev().html('手动打分');
		  }else{
			  //报告打分的待打分改为手动打分
			 $(".Statewho").eq(arrgrade[arrgrade.length-1]).html("手动打分")
		  }
		  if(oElement.parent().next().length>0){
		    oElement.parent().next().html(oGrade+"分").end().next().addClass("bload");
		  }else{
			  //报告打分的待打分改为手动打分
		     $(".States").eq(arrgrade[arrgrade.length-1]).html(oGrade+"分")
		  }
		  
		  $(this).parent().parent().parent().hide();
	   })
}