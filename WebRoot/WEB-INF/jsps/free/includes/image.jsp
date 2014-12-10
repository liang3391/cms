<%@ page language="java"   pageEncoding="UTF-8" import="java.util.*,com.framelib.common.CommonConstants"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<script type="text/javascript">
function searchImageList(){
	var url="${pageContext.request.contextPath}/image/getAllByName.htm";
	$.ajax({
	      url : url,
	      type : "post", //请求类型
	      async : false,//默认true异步请求 ，false同步请求 
	      data : $("#searchImageName").serialize(),//待发送 Key/value 参数。如 { name: "John", time: "2pm" } 没有参数可以为空
	      success : function(data) { 
	           if (500 == data) {
	              //系统内部异常
	              alert('系统内部异常');
	           } else if (501 == data) {
	              //用户未登录，请求被拦截
	              alert('未登录');
	           } else {
	              //正确返回结果
	              $("#imageList").html(data);
	          }
	     }
	});
}

function toThisPage(all) {
	var target = $('#currentPage').val();
	$("#hidden_currentPage").val(target);
	if(0 < target && target <= all){
		searchImageList();
	}else{
		alert('无效字符');
	}		
}
function toShowPage(page){
	$("#hidden_currentPage").val(page);
	var all = $("#hidden_allPage").val();
	if(0 < page && page <= all){
		searchImageList();
	}else{
		alert('无效字符');
	}		
}

</script>
<div class="box boxb" style="display: none">
			<div id="Tab1">
				<div class="Menubox">
					<ul>
						<li id="one1" onclick="setTab('one',1,2)" class="hover">图片空间</li>
						<li id="one2" onclick="setTab('one',2,2)">本地上传</li>
					</ul>
				</div>
				<div class="Contentbox fixed" style="width:710px;">
					<div style="overflow-y:auto;overflow-x:hidden;width:710px" id="con_one_1" class="hover">
					<form id="searchImageName">
						<p class="seek top20 fixed">
						
						<input name="page" type="hidden" id="hidden_currentPage">
							<input name="imageName" type="text" class="seek01" placeholder="请输入图片名称"  /><input
								type="button" name="button2" id="button2" value="" onclick="searchImageList()"
								class="seek02" />
							
						</p>
						</form>	
						<span id="imageList">
							<jsp:include page="imageDiv.jsp"></jsp:include>
						</span>
							
						
					</div>
					<div id="con_one_2" style="display: none">
						<form id="form3" name="form3" method="post" action=""
							class="border_bottom">
							<input type="hidden" id="img_hidden" />
							<input type="hidden" id="locationId_hidden" />
							<input type="hidden" id="locationNote_hidden" />
							<input type="hidden" id="locationSize_hidden" />
							<input type="button" name="button" id="button" onclick="doUpload()" value="选择上传"
								class="xzsc" /> 
							
								 <input type="button"
								name="button" id="button" value="确定" class="sc close" onclick="onEnterImg()" /> <input
								type="button" name="button" id="button" value="取消" onclick="closeDialog()" class="qx close" />
						</form>
						
							<div id="imgspan" align="center"></div>
					</div>
				</div>
			</div>

		</div>