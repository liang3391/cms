
	function showConfirmDialog(id,but,prd,ver){
		var beforeOnTime = $("#"+id+"_bot").val();
		var onTime = $("#"+id+"_ot").val();

		var beforeDate = new Date(beforeOnTime);
		var onDate = new Date(onTime);
		var beforeDay = parseInt((onDate.getTime()-beforeDate.getTime()) / (1000 * 60 * 60 * 24));
		$("#beforeOnTime").html(beforeDay);

		countDown_colon("showCountDown",beforeOnTime,0);
		
		oPbox($('#tk2'), $('#abk'), $('.lt_re1'), $(but)[0]);
		commitConfirm(id,prd,ver,but);
	}
	
	function commitConfirm(id,prd,ver,but){
		$('.lt_re1').on('click' , function() {
			$('#abk').hide();
			$('#tk2').hide();
			
			$.ajax({
				url : "confirmShow.htm",
				type : "get", //请求类型
				async : false,//默认true异步请求 ，false同步请求 
				data :"prdCode="+prd+"&ver="+ver,
				success : function(data) {
					var ret = data.result;
					if(ret==1){
						$("#"+id+"_userid").html("ID:"+data.confirmUser);
						$("#"+id+"_userid").show();
					}
				}
			});
			
			$(but).parent().html('<span class="icon_fund online"></span>运营已确认');
		});
	}
	
	function clearSelectForm(){
		$(':input','#selectForm').not(':button,:submit,:reset,:hidden').val('').removeAttr('checked').removeAttr('selected');
	}