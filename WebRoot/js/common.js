//2014-7-18 10:58
function id(id){
 return document.getElementById(id);	
}
//选项卡
function setTab(name,cursel,n){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+i);
var con=document.getElementById("con_"+name+"_"+i);
menu.className=i==cursel?"hover":"";
con.style.display=i==cursel?"block":"none";
}
}
//获取到到页面的绝对距离
function getPos(obj) {
		var pos = {left: 0, top: 0};
		
		while(obj) {
			pos.left += obj.offsetLeft;
			pos.top += obj.offsetTop;
			obj = obj.offsetParent;
		}
		return pos;
}
//判断输入字符的个数
function ControlForm(className){
	
}

function getByteLen(val) {
		var len = 0;
		for (var i = 0; i < val.length; i++) {
			var length = val.charCodeAt(i);
			if (length >= 0 && length <= 128)
			 {
				len += 1;
			}
			 else
			 {
				len += 2;
			}
		}
		return len;
	}
//划过点击显示
//json变量：box(弹出框) - left(根据obj进行定位的left值) - top(根据obj进行定位的top值) - content(输出的内容，按需添加) - obj(被点击的对象) - oClose(关闭点击的对象) - onOF(判断属于哪一类型的方法)- 是否属于打分方法（默认为否）
function Clickshow(o){
	var con_op = { 
	    obj:o.obj||$('.lj_sq em'), 
		box:o.box||$('.wh_cont'), 
		oClose:o.oClose||$('.lj_sq em'),
	    left:o.left||0,
		top:o.top||0,
		onOF:o.onOF,
		grade:o.grade||false
		}
	if(con_op.content){
	   con_op.box.html('<p>'+con_op.content+'</p>');
	}
    if(con_op.onOF==true){//划过类, 划过obj 显示box 划出隐藏
	   con_op.obj.mouseover(function(){
			 con_op.box.css({left:getPos(this).left+con_op.left+"px",top:getPos(this).top- con_op.box.height()-con_op.top+"px"});
			 con_op.box.show();
	   }) 
		con_op.obj.mouseout(function(){
			con_op.box.hide();
	   })
   }else if(con_op.onOF==false){//点击类，点击obj弹出box,点击document隐藏box
      //点击按钮显示
	  con_op.obj.each(function(index,element){
		 $(this).click(function(event){
		   event.stopPropagation();
		   var _this = $(this);
		   if(con_op.left!=undefined&&con_op.top!=undefined){
			   if($(window).height()+$(document).scrollTop()<getPos(this).top+con_op.box.outerHeight(true)){
				   con_op.box.css({left:getPos(this).left+con_op.left+"px",top:getPos(this).top- con_op.box.outerHeight(true)+"px"})
				}else{
			   	   con_op.box.css({left:getPos(this).left+con_op.left+"px",top:getPos(this).top- con_op.box.height()-con_op.top+"px"})
				}
			}
			con_op.box.show();
			//打分函数参数为点击的按钮的索引值
		   if(con_op.grade){ grade(index)}
	   }) 
	  })
	   //点击关闭
	   con_op.oClose.click(function(event){
		    event.stopPropagation();
			con_op.box.hide();
	   })
	   con_op.box.click(function(event){
		    event.stopPropagation();
	   }) 
	   document.onclick = function(){
		      con_op.box.hide();
	   }
	   //以下为授权书效果
   }else if(con_op.onOF == "authoriz"){
	    con_op.obj.on('mouseover',function(){
		$(this).children().first().show() 
			this.style.position ='relative'
			$(this).children().first().css({position:'absolute',left:'35px',zIndex:'77'})
			con_op.obj.css({zIndex:'77'})
		}) 
		con_op.obj.on('mouseout',function(){
			$(this).children().first().hide()
		}) 
   }
}
//end

//单选全选开始
  singlefn({multiple:$(".multiple"),single:".single",batchBtn:".batchBtn"})
  singlefn({multiple:$(".multiple2"),single:".single2",batchBtn:".batchBtn2"})

  function singlefn(json){ 
	//全选
    json.multiple.click(function(){
		   $(json.single).attr('checked',this.checked);
		   checedNum(json.single,json.batchBtn)
	})
	//单选
	$(json.single).click(function(){
		   checedNum(json.single,json.batchBtn)
	})
  }
  //判断checkbox是否被选中
	function checedNum(single,batchBtn){
		if($(single+':checkbox:checked').length>0){
			$(batchBtn).on('click',function(){ 
				 uPbox($('#recycle'),$('#mask'), $('.shatdown'));
			})
		}else{
			$(batchBtn).off('click',null)
		}
	}
	//点击放入回收站等
	
function ev_begin(box,that,oMask,Close,num){
		if(!that){return}
		if(!num){num=1}
		that.each(function(index, element){
			 var thethis = $(this)
			 $(this).on("mousedown",function(){
				 if(num==1){
					 $('.single').each(function(index1, element1) {
					    $(this).attr("id","cbx_"+index1)
				     });
					 if(box&&oMask&&Close){
						uPbox(box,oMask,Close,this,$('#cbx_'+index+''));
					 }
					 $('.single').attr("checked",false);
					 $(".multiple").attr("checked",false)
					 $('#cbx_'+index+'').attr('checked',"checked");
					  checedNum(".single",".batchBtn")
				 }else if(num==2){
					 $('.single2').each(function(index1, element1) {
					    $(this).attr("id","cbx_"+index1+index1)
				     });
					 if(box&&oMask&&Close){
						uPbox(box,oMask,Close,this,$('#cbx_'+index+index+''));
					 }
					 $('.single2').attr("checked",false);
					 $(".multiple2").attr("checked",false)
					 $('#cbx_'+index+index+'').attr('checked',"checked");
					  checedNum(".single2",".batchBtn2")
				 }
			 })
			  
   		 });
  
} 
//end
function oTk(obj,mask,Close,d,li,endfn){
	      d.click(function(){
		  uPbox(obj,mask,Close,li)
		  $('.cash').val($(this).val())
		  endfn&&endfn()
	   })
	   
}
//end
//弹出框函数
function uPbox(obj, mask, Close,val) {
	obj.show();
	Ele_pos()
	mask.show();
	mAsk(mask);
	//关闭
	Close.on('click',function(){
	    mask.hide();
		obj.hide();
	})
	if(val!="stopscroll"){
	window.onscroll = function() {
		if (obj.css('display') == 'block'){Ele_pos();}
	}
	window.onresize = function() {
		if (mask.css('display') == 'block'){mAsk();}
   		if (obj.css('display') == 'block'){Ele_pos();}
 	}
	}
	function Ele_pos(){//获取obj1的位置并赋值
		obj.css({top:($(window).height() - obj.outerHeight()) / 2 + $(document).scrollTop()+ 'px',
		         left:($(window).width() - obj.outerWidth()) / 2 +  $(document).scrollLeft()+ 'px'
				})
	}
	
	//判断添加的文字,链接
	 if(val==true){//退款管理弹出框文字内容
	 /*同意*/
	   var allname =["用户选择的是【未发货退款】，如果您的货物已经发出，但是没有及时上传发货单号，请您及时联系快递公司追回，可以减少损失，但您无法拒绝退款，系统将在用户提交未发货退款申请3天后，默认同意退款。",
		            "用户选择的是【未收货退款】，请及时联系用户和快递公司，核查订单货物签收情况，如果您确认货物未被签收或拒签，请点击同意退款。",
				    "用户选择的是【退货退款】，如果您已经收到退货，并确认完好符合要求，请及时点击同意退款处理。",
				    "如果用户提交的免费试用报告，已符合美试网的报告提交标准，不论报告评价内容好坏，品牌方均须同意退保证金，请及时处理。"]
	 /*拒绝*/
	   var reallname =["",
		           "用户选择的是【未收货退款】，请及时联系用户和快递公司，核查订单货物签收情况，如果您确认货物已被签收或拒签，请点击拒绝退款，以减少损失。",
				   "用户选择的是【退货退款】，如果您已收到退货，但确认退货不符合要求，影响二次销售；或者您在等待收货退款状态快到期时仍未收到退货，您可以点击拒绝退款，并请及时联系用户说明，以减少纠纷。",
				   "如果用户提交的免费试用报告，不符合美试网的报告提交标准，无论报告评价内容好坏，品牌方可以拒绝退保证金，请及时处理。"]
	 }
	 if(val&&obj.attr('id')=="sc"){
	   nam = val.split('|')
		var	_left =Math.abs($('#sc h3').width()-nam[0].length*18-$('#sc h3 em').width()-50)/2+"px";
		   $('#sc h3').html("<em style='top:0px;left:"+_left+"'></em>"+nam[0]);
		   $('#sc a').html("<em></em>"+nam[1]);
		   $('#sc a').attr("href",nam[2]);
	 }else if(val&&obj.attr('id')=="agrmoney"){
		 $('#agrmoney .title').html("同意【"+$('.flag_tab .hover').children().html()+"】提示");
		 output(obj.attr('id'),allname,"同意退款","同意退保证金")
	 }else if(val&&obj.attr('id')=="noagrmoney"){
		 $('#noagrmoney .title').html("拒绝【"+$('.flag_tab .hover').children().html()+"】理由");
		 output(obj.attr('id'),reallname,"拒绝退款","拒绝退保证金")
	 }
		 function output(id,name){
			 if($('.flag_tab .hover').children().html()=="未发货退款"){
				 $('#'+id+' .text').html(name[0])
				 link_on()
			 }else if($('.flag_tab .hover').children().html()=="未收货退款"){
				$('#'+id+' .text').html(name[1])
				link_on()
			 }else if($('.flag_tab .hover').children().html()=="退货退款"){
				$('#'+id+' .text').html(name[2])
				 link_on()
			 }else{
				$('#'+id+' .text').html(name[3])
				 if($('#'+id+' .text').next().attr('class')=="msfree"){
			       $('#'+id+' .text').next().html("<a style='color:#0099ff;' href='#'>《美试网免费试用报告提交标准》</a>")
				}else{
	         		$('#'+id+' .text').after("<p class='msfree' style='padding-top:10px;'><a style='color:#0099ff;' href='#'>《美试网免费试用报告提交标准》</a></p>")	 
			    }	
			 }	
			 function link_on(){
		        if($('#'+id+' .text').next().attr('class')=="msfree"){
			       $('#'+id+' .text').next().remove()
				} 
			 } 
		 }
}
function mAsk(mask){//获取oMask的最大高度 与 最大宽度并赋值
       if(!mask){return}
	    var w = Math.max(document.body.offsetWidth, document.documentElement.clientWidth);
		var h = Math.max($(document).height(), $(document.body).height());
		mask.css({width: w +"px",height:h+ 'px'})
}
//one  end 
//固定调用裸价体验类似模板调用弹框 不居中
function ev2_n(box,that,mas,Close){
	that.each(function(index, element){
		 var thethis = $(this)
         $(this).on("mousedown",function(){
			 var _this = this;
			 if(this.innerHTML!='<span class="icon_fund online"></span>运营已确认'){
					oPbox(box,mas,Close,this)
					Close.on('click' , function() {
						mas.hide();
						box.hide();
						thethis.parent().html('<span class="icon_fund online"></span>运营已确认');
					})
			 }
		     	 
	     })
    });
}
function oPbox(obj, mask, Close,li){
	    obj.show()
		var w = Math.max(document.body.offsetWidth, document.documentElement.clientWidth);
		var h = Math.max($(document).height(), $(document.body).height());
		mask.css({width: w +"px",height:h+ 'px',display:'block'})
		obj.css({
			     top:getPos(li).top+li.offsetHeight+ 'px',
		         left:getPos(li).left-obj.width()+li.offsetWidth+ 'px'
				})
		Close.on('click',function(){
			mask.hide();
			obj.hide();
	    })
}

xlk({
	  nav:$('#produce .vtitle'),
	  className:'vcon',
	  classtwo:$('#produce .vcon'),
	  icon:$('#produce .vtitle em'),
	  json1:{background:'url("123/images/icon/vicon.png") no-repeat scroll 0 -16px'},
	  json2:{background:'url("123/images/icon/vicon.png") no-repeat scroll 0 0'}
	})
	
	//下拉菜单
	
	function xlk(json){
		
	 var oi=0
	 for(var i=0;i<json.nav.length;i++){
		 if(json.nav.eq(i).next().hasClass(json.className)){
			 pro(json.nav[i],json.nav.eq(i).next().hasClass(json.className),oi,i) 
			 oi ++
         }
	 }
	 json.classtwo.show() 
	 function pro(a,b,i,ii){
		 if(!b){return}
	 	 a.onclick = function(){
			 if(json.classtwo.eq(i).is(':hidden')){
				 json.classtwo.eq(i).slideDown()
				 json.icon.eq(i).css({background:'url("../../../../images/icon/vicon.png") no-repeat scroll 0 -16px'})
				 //json.nav.eq(ii).addClass('current')
			 }else{
			     json.classtwo.eq(i).slideUp()
				json.icon.eq(i).css({background:'url("../../../../images/icon/vicon.png") no-repeat scroll 0 0'})
				//json.nav.eq(ii).removeClass('current')	 
			 }
			 return false;
		 }
	 }
 }

function callfn(ul){
	if(!ul.obj){return}
	var menu_ul_div = ul.obj.children;
	var divnone = ul.obj.getElementsByTagName('div');
	//alert(menu_ul_li.length)
	for(var i=0;i<menu_ul_div.length;i++){
		 click_menu(menu_ul_div[i],i);
	}

function click_menu(index,a){
	var oMdiv = index.children[1];
	var oMdiv1 = index.children[1].children[0].children;
	
	index.onclick =function(){
		for(var i=0;i<divnone.length;i++){
		   divnone[i].style.display = 'none';
		}
		for(var i=0;i<menu_ul_div.length;i++){
		  menu_ul_div[i].style.background = '#fff'	
	    }
        oMdiv.style.display = 'block';
		this.style.background = '#d7ecab';
		$('.lm_search span:eq(0)').html(this.children[0].innerHTML)
     }
	 
	// alert(oMdiv1.length)
	 for(var j=0;j<oMdiv1.length;j++){
		 click_m2(oMdiv1[j],j);
     }
    function click_m2(index1,a){
		var oMdiv2 = index1.children[1];
		var oMdiv3 = index1.children[1].children[0].children;
		index1.onclick =function(ev){
			var e = ev || event;
		    e.cancelBubble = true;
			for(var j=0;j<oMdiv1.length;j++){
				oMdiv1[j].children[1].style.display ='none';
				oMdiv1[j].style.background='#fff';
			 }
			oMdiv2.style.display = 'block'; 
			this.style.background = '#d7ecab';
			$('.lm_search span:eq(1)').html(this.children[0].innerHTML)
		 }
		 for(var j=0;j<oMdiv3.length;j++){
		 	oMdiv3[j].index = j;
			oMdiv3[j].onclick =function(){
				for(var j=0;j<oMdiv3.length;j++){
				   oMdiv3[j].style.background = '#fff';
				}
				this.style.background = '#d7ecab';
				$('.lm_search span:eq(2)').html(this.innerHTML)
			}
         }
		 
	}
}
}
//选择类目 end
function slideImg(json){
	if(!json){json={}}
	var o = {
		     liBox:$("#"+json.jQuery+" ."+json.liBox),  //图片盒子
			 allBtn:$("#"+json.jQuery+" ."+json.allBtn),//切换按钮
			 imgWidth:json.imgWidth||$("#"+json.jQuery+" .liBox img").css("width"),//滑动一次图片的滑动宽度，不设置默认为图片宽度
			 prev:$("#"+json.jQuery+" ."+(json.prev || "btn_prev")),//上一张按钮 (不设置按钮class默认是id下的.btn_prev)
			 next:$("#"+json.jQuery+" ."+(json.next || "btn_next")),//下一张按钮 (不设置按钮class默认是id下的.btn_next)
			 settime:json.settime||3000,//切换一次停留的时间（默认3秒）
			 speed:json.speed||200,//图片切换一次的时间（默认0.5秒）
			 ClickBackSpeed:json.ClickBackSpeed||2000,//点击图片切换后停留时间再次执行自动切换
			 movement:json.movement||'slide',//默认为slide(滑动)  fadeinout(淡入淡出)
		     btnPos:json.btnPos||{paddingLeft:"400px",bottom:"20px"},//控制切换按钮的css位置样式 （全屏显示幻灯片时常用）
			 fullScreen:json.fullScreen||false ,//是否全屏（默认为false）
			 autoPlay:json.autoPlay||true,
			 objImg:null,
			 _objImg:null,
			 onOff: true,
			 num:0
		};
    //计算全屏显示时的高度
    if(o.fullScreen){
		var h =parseInt($(window).width()/($("#"+json.jQuery+" img").width()/$("#"+json.jQuery+" img").height()))
		$("#"+json.jQuery).css('height',h+"px");
		$("#"+json.jQuery+" ."+json.allBtn).parent().css(o.btnPos)
	 	$("#"+json.jQuery+" img").css({"height":h+"px","width":$(window).width()})
	}
	//自动播放
	if(o.autoPlay){
	  autoPlay()
	}
	//划过显示第几张
	imgBtn()
	function autoPlay(){
		o.objImg = setInterval(function(){
		 		o.num++;
				if(o.num>=o.liBox.children().length){
					o.num=0
				}
				play(o.liBox,o.num,o.allBtn)
		},o.settime)
	}
	
	function imgBtn(){
       o.allBtn.each(function(index, element) {
			$(this).click(function(){
				 clearInterval(o.objImg);
				 o.num = index;
				 play(o.liBox,index,o.allBtn,function(){
				   	o._objImg = setTimeout(autoPlay,o.ClickBackSpeed)
				});
			})
       });
	}
	
	//判断是否存在上下按钮
	if(o.prev.length>0&&o.next.length>0){
		prevNext(o.prev,-1)
		prevNext(o.next,1)
	}
	//点击按钮切换幻灯片
	function prevNext(btn,num){
		btn.click(function(){
			clearInterval(o.objImg);
			if(o.onOff){
			  num<0?o.num--:o.num++;
				if(o.num<0){
				   o.num=o.liBox.children().length-1
				}
				if(o.num>o.liBox.children().length-1){
			       o.num=0
				}
				play(o.liBox,o.num,o.allBtn,function(){ 
				   	o._objImg = setTimeout(autoPlay,o.ClickBackSpeed)//切换图片后设置时间再次自动切换
				});
			} 
		})
	}
    function play(liBox,num,allBtn,CallBack){
		if(o.onOff){
		    o.onOff = false;
			//判断动画效果
			switch(o.movement){
			   case "slide":
			        liBox.animate({left:-parseInt(o.imgWidth)*num+"px"},o.speed,"linear",function(){sports()})
					break;
			   case "fadeinout":
			        liBox.animate({opacity: '0'},o.speed,function(){
					   $(this).css({left:-parseInt(o.imgWidth)*num+"px"})
					   $(this).animate({opacity: '1'},o.speed,"linear",function(){sports()})
					})
					break;
			}
			function sports(){
			   clearInterval(o._objImg)
			   o.onOff = true
			   if(o.autoPlay){
				  CallBack&&CallBack()
			   }	
			}
            allBtn.removeClass("on")
		    allBtn.eq(num).addClass("on")			
		}
    }
}
//幻灯片结束

 //左侧menu展开收缩
oMenu({slidedClass:"colis_0",oLi:$('.oPro_menu ul li'),oOlli:$('.oPro_menu ol li')})
oMenu({slidedClass:"colis",oLi:$('.oBrand_menu ul li'),oOlli:$('.oBrand_menu ol li')})
function oMenu(json){
	$("."+json.slidedClass+"").click(function(){
		if($(this).next().is(":hidden")){
			$(this).next().slideDown();
			 $(this).children().last().removeClass('i1');
			 $(this).children().last().removeClass('bg1').addClass('bg2');
		}else{
		    $(this).next().slideUp();
			$(this).children().last().addClass('i1');
			$(this).children().last().removeClass('bg2').addClass('bg1');
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

