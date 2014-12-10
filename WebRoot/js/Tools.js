// JavaScript Document
//单选全选
//产品及活动管理 选择品牌
    //点击图片将图片放在最上面
$('#oBrand img').each(function(index, element) {
   $(this).click(function(){
		$('#searchResult a').html('<img src="'+this.src+'" height="'+this.height+'">')
		$('#searchResult p').html($(this).parent().next().html())
   }) 
}); 

//左侧收缩菜单
xlk({
  nav:$('#produce .vtitle'),
  className:'vcon',
  classtwo:$('#produce .vcon'),
  icon:$('#produce .vtitle em'),
  json1:{background:'url(./images/icon/vicon.png) no-repeat 0 -16px'},
  json2:{background:'url(./images/icon/vicon.png) no-repeat'}
})
//裸价体验划过授权显示授权书
Clickshow({ obj:$('.lt_sqs'), box:$('.lt_sqs img'),onOF:"authoriz"})

//焦点图幻灯片效果
slideImg({
	 jQuery:"ad_visual",//幻灯片id
	 liBox:"ad_image ul.liBox",  //幻灯片图片Box
	 allBtn:"flicking_inner a",//切换按钮
	 imgWidth:$(window).width(),//幻灯片滚动的宽度（$(window).width()为屏幕显示的最大宽度）
	 fullScreen:true,
	 movement:"fadeinout"
})
//选择类目
callfn({obj:id('menu_ul')})
//选择产品尺寸和颜色
$(function(){
	    $('#emample1 .size_sure').hide();
	    $('#ele1').on('click',function(){
			
		   $('#blk1').css({left:getPos($('#Lh')[0]).left+"px",top:getPos(this).top+30+'px'})
		   $('#blk1').show() ;
		})  
		$('#close1').on('click',function(){
			$('#blk1').hide() ;
			
		})
		$('#lt_sure').on('click',function(){
			this.n = 0;
			this.m = 0;
		    $('#blk1').hide() ;
			$('.selImg').show();
			for(var i=0;i<$('#lt_color a').length;i++){
				if($('#lt_color a')[i].className != ''&& $('#lt_color a')[i].className !="wu"){
					$('#emample1 .img_sure')[0].innerHTML = $('#lt_color a')[i].innerHTML;
					$('.selImg').html("<img src='"+$('#lt_color a')[i].children[0].src+"'>")
					$('#emample1 .img_sure').show();
				}
				else{
				  	this.n++;
					if(this.n==$('#lt_color a').length){
						$('#blk1').show();
						alert('请选择颜色');
						return
					}
				}
			}
			for(var i=0;i<$('#lt_size a').length;i++){
			   if($('#lt_size a')[i].className != ''&& $('#lt_size a')[i].className !="wu"){
			      $('#emample1 .size_sure')[0].innerHTML= $('#lt_size a')[i].innerHTML;
				  $('#emample1 .size_sure').show();
				  $('#Lh').css({height:'34px',lineHeight:"34px"})
				  $('#ele1').css({marginTop:"5px"})
			   }
			   else{
				  	this.m++
					if(this.m==$('#lt_size a').length){
						$('#blk1').show();
						alert('请选择尺码');
						return
					}
				}

		    }
			$('#ele1')[0].innerHTML = '重新选择';
			
			
		})
		$('.itemPicS').click(function(){
		   	$('.selImg').hide();
		})
		 $('.lt_sqs').on('mouseover',function(){
			$('#sqs').show() 
			this.style.position ='relative'
			$('#sqs').css({position:'absolute',left:'35px',zIndex:'77'})
			$('.lt_sqs').css({zIndex:'77'})
		}) 
		$('.lt_sqs').on('mouseout',function(){
			$('#sqs').hide()
		}) 
		//控制商品资讯是否显示
		$('.baby_tab').each(function(index, element) {
            $(this).click(function(){
			    if($('#con_one_1')[0].style.display =='block'){
		     	   $("#spzx").show()	
				}else{
				   	 $("#spzx").hide()
				}
		    })
	    
        });
		
})