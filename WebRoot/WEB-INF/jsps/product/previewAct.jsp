<%@ include file="../../jsps/common/import.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品详情</title>
<link href="<%=basePath%>/css/preview.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/css/header_footer.css" rel="stylesheet" type="text/css">
</head>
<body class=" background_gray">
<!--head-->
<%@ include file="prev_left.jsp"%>
<!--head end-->
<!--当前位置-->
<div class="main">
    <h2 class="current_location"><a  class="plc">首页</a>&gt;
    <c:choose>
    	<c:when test="${prd.type==0}">
    		<a>裸价体验</a>
    	</c:when>
    	<c:otherwise>
    		<a>免费试用</a>
    	</c:otherwise>
    </c:choose>
    -<a>${prd.categoryName1}</a>
    -<c:if test="${!empty prd.categoryName2}"><a>${prd.categoryName2}</a></c:if>
    -<c:if test="${!empty prd.categoryName}"><a>${prd.categoryName}</a></c:if>
    -<a>${prd.brandName}</a>-<em class="green">${prd.brandName}${prd.productName}</em></h2>
    <input type="hidden" id="onTime" value="<fmt:formatDate value="${prd.activity.onTime}" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
    <input type="hidden" id="onTime1" value="${prd.activity.onTime}"/>
    <input type="hidden" id="offTime" value="<fmt:formatDate value="${prd.activity.offTime}" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
    <input type="hidden" id="beforeOnTime" value="<fmt:formatDate value="${prd.activity.beforeOnTime}" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
    <input type="hidden" id="checkStatus" value="${prd.activity.checkStatus}"/>
</div>

<div class="preview_table main">
    <h3><span class="nake"></span>裸价体验活动详情</h3>
    <div  class="preview_table_content">
            <c:choose>
            	<c:when test="${prd.activity.checkStatus==1}">
            	    <div class="salimg bggray">
            		 <p>等待</p>
              		 <p>品牌复核</p>
              	    </div>
              	    <div class="rightnews top35">
		               <ul>
		                  <li>产品编码：${prd.productCode}</li>
		                  <li class="wid">活动编码：${prd.activity.id}</li>
		                  <li>活动时间：<fmt:formatDate value="${prd.activity.onTime}" pattern="yyyy-MM-dd hh:mm:ss"/> — <fmt:formatDate value="${prd.activity.offTime}" pattern="yyyy-MM-dd hh:mm:ss"/></li>
		                  <li class="wid" id="day">活动天数：</li>
		               </ul>
		            </div>
            	</c:when>
            	<c:when test="${prd.activity.checkStatus==2}">
            		 <div class="salimg bggreen">
		               <p>品牌</p>
		               <p>复核通过</p>
			         </div>
			         <div class="rightnews top20">
		               <ul>
		                  <li>产品编码：${prd.productCode}</li>
		                  <li class="wid">活动编码：${prd.activity.id}</li>
		                  <li>活动时间：<fmt:formatDate value="${prd.activity.onTime}" pattern="yyyy-MM-dd hh:mm:ss"/> — <fmt:formatDate value="${prd.activity.offTime}" pattern="yyyy-MM-dd hh:mm:ss"/></li>
		                  <li class="wid" id="day">活动天数：</li>
		                  <c:choose>
		                  	<c:when test="${!empty prd.activity.beforeOnTime}">
		                  		<li>展示时间：<fmt:formatDate value="${prd.activity.beforeOnTime}" pattern="yyyy-MM-dd hh:mm:ss"/> — <fmt:formatDate value="${prd.activity.onTime}" pattern="yyyy-MM-dd hh:mm:ss"/></li>
		                  		<li class="wid" id="beforDay">活动展示天数：</li>
		                  	</c:when>
		                  	<c:otherwise>
		                  		<li>展示时间：</li>
		                 		<li class="wid">活动展示天数：</li>
		                  	</c:otherwise>
		                  </c:choose>
		               </ul>
			         </div>
            	</c:when>
            	<c:when test="${prd.activity.checkStatus==3}">
            		  <div class="salimg bgorange">
			               <p>品牌</p>
			               <p>复核未通过</p>
			          </div>
			          <div class="rightnews">
			          	 <ul>
			              <li>产品编码：${prd.productCode}</li>
		                  <li class="wid">活动编码：${prd.activity.id}</li>
		                  <li>活动时间：<fmt:formatDate value="${prd.activity.onTime}" pattern="yyyy-MM-dd hh:mm:ss"/> — <fmt:formatDate value="${prd.activity.offTime}" pattern="yyyy-MM-dd hh:mm:ss"/></li>
		                  <li class="wid" id="day">活动天数：</li>
		                 </ul>
			              <div class="account">
			                 <span>未通过理由：</span><p>${prd.activity.checkReason}</p>
			              </div>
			          </div>
            	</c:when>
            	<c:otherwise>
            	   <div class="salimg bggray">
           		 	<p>等待</p>
              		<p>提交活动</p>
              	   </div>
              	   <div class="rightnews top35">
		               <ul>
		                  <li>产品编码：${prd.productCode}</li>
		                  <li class="wid">活动编码：${prd.activity.id}</li>
		                  <li>活动时间：<fmt:formatDate value="${prd.activity.onTime}" pattern="yyyy-MM-dd hh:mm:ss"/> — <fmt:formatDate value="${prd.activity.offTime}" pattern="yyyy-MM-dd hh:mm:ss"/></li>
		                  <li class="wid" id="day">活动天数：</li>
		               </ul>
		           </div>
            	</c:otherwise>
            </c:choose>
    </div>
</div>
<div class="preview_colorsize main">
    <h3>颜色尺码列表</h3>
    <div  class="preview_colorsize_content">
         	<table id="_oTable" border="0" cellspacing="0" cellpadding="0" >
                <thead>
                  <tr>
                    <th class="th1" width="240" align="center" valign="middle">商品颜色</th>
                    <th class="th2" width="155" align="center" valign="middle">商品尺码</th>
                    <th class="th3" width="155" align="center" valign="middle">体验价</th>
                    <th class="th4" width="440" align="center" valign="middle">开放体验人数</th>
                  </tr>
                </thead>
                 <tbody>
                	<c:forEach items="${prd.goodList}" var="goods" varStatus="i">
	                    <tr>
	                       <td>
	                          <div class="com1">
	                              	${goods.colorName}<span><img src="<%=imagePath%>/${goods.colorShow}" width="35" height="35"></span>
	                          </div>
	                       </td>
	                       <td>${goods.sizeName}</td>
	                       <td>${prd.activity.price}</td>
	                       <td id="openNum_${i.index}">${goods.store}</td>
	                    </tr>
                    </c:forEach>
                    <tr>
                       <td bgcolor="#f7fceb" colspan="3">合计</td>
                       <td id="totalNum"></td>
                    </tr>
                </tbody>
              </table>
	         <script type="text/javascript">
                $("#_oTable").rowspan(0);
              </script>
    </div>
</div>
<!--预览产品页内容-->
<div class="preview_produce">
	<div class="area_a">
    <div class="itemPic tabs">
      <div class="selImg"></div>
      <div class="itemPicM">
      	<div class="tabcon" style="display:block;"><a class="MagicZoom"><img src="<%=imagePath%>/${prd.picture.artwork}" width="300" height="300"></a></div>
      </div>
      <div class="itemPicSBox">
        <ul class="itemPicS fix tabnav">
          <li class="un"><img src="<%=imagePath%>/${prd.picture.thumbnail}" width="50" height="50"></li>
          <c:forEach items="${fn:split(prd.picture.thumbnailList,',')}" var="pic">
			<li><img src="<%=imagePath%>/${pic}" width="50" height="50"></li>
		  </c:forEach>
        </ul>
      </div>
    </div>
    <div class="shangpin_text_wrap">
         <h3>
             <span class="lt_sqsr"></span>
             <span class="lt_sqs"><img style="display:none" src="<%=basePath%>/images/bannk/book.jpg" width="260" height="360"></span>
             ${prd.brandName}
         </h3>
         <h4>${prd.productName}</h4>
         <div class="line mb5"></div>
         <div class="left w340 "> 
         
         <span class="w131">市场价：￥${prd.marketPrice}</span> 
         <span class="w131">折扣：${prd.discount}折</span> 
         <span class="w131">规格：${prd.standard}</span>
        
         <div class="w323 left"> 
            <span id="Lh">颜色和尺码：</span>
            <div class="example" id="emample1"> 
                <em class="img_sure"></em>
                <div class="tigger but_xuanze" id="ele1">请选择</div>
            </div>
          </div>
          <span class="w160 top5">剩余体验：<em class="text_green"></em></span> 
          <span class="top5">开放体验：<em class="text_green">${prd.openExperience}</em></span>
          <span class="w160">累计体验：<em class="text_green" id="total_exp"></em></span> 
          <div class="line mt10 mb10"></div>
          <!--免费试用次数-->
          <div class="mfs">
            <h3><strong></strong>裸价体验<span>[每人仅限体验1次]</span></h3>
          </div>
          <!--保证金/立即申请/倒计时 情况1-->
          <div class="lj_sq">
                <h2>体验价：<label>￥${prd.activity.price}</label></h2>
                <span class="mf"><input type="button" value=""></span>
          </div>
          <div class="line mt10 mb10"></div>
          <div class="djs_begin">
            <h3 class="begin">距离体验开始</h3><strong id="countDown"></strong>
          </div>
          <div class="line mt10 mb10"></div>
        </div>
        <div class="lj_qq fixed">
            <c:choose>
	        	<c:when test="${prd.returnGoods==7}">
	            	<span class="fl th7"><em></em>参加7天无理由退货</span>
	            </c:when>
	            <c:when test="${prd.returnGoods==30}">
	            	<span class="fl th30"><em></em>参加30天无理由退货</span>
	            </c:when>
	            <c:otherwise>
	            	<span class="fl thwu"><em></em>特殊商品，不参加无理由退货</span>
	            </c:otherwise>
	        </c:choose>
            <a href="javascript:;" class="fr th_qq">联系客服<em></em></a>
        </div>
        <!--djs_begin end-->
    </div>
    <!--shangpin_text_wrap-->
    <div class="mude_wrap">
      <h3></h3>
      <p class="mt15" style="height:45px;">${prd.activity.purpose}</p>
      <h4></h4>
      <p class="mt15"> 性别要求：
      	<c:choose>
			<c:when test="${prd.activity.gender==2}">
				不限
			</c:when>
			<c:when test="${prd.activity.gender==0}">
				女
			</c:when>
			<c:otherwise>
				男
			</c:otherwise>
		</c:choose>
      </br>
        年龄要求：
        <c:choose>
			<c:when test="${prd.activity.ageMin==1&&prd.activity.ageMax==100}">
				不限
			</c:when>
			<c:otherwise>
				${prd.activity.ageMin}-${prd.activity.ageMax}岁
			</c:otherwise>
		</c:choose>
	  </br>
        体验等级：
        <c:choose>
			<c:when test="${prd.activity.gradeLow==-1||prd.activity.gradeHigh==-1}">
				不限
			</c:when>
			<c:otherwise>
				LV${prd.activity.gradeLow}-LV${prd.activity.gradeHigh}
			</c:otherwise>
		</c:choose>
      </br>
        会员类别：
      	<c:choose>
			<c:when test="${prd.activity.userType==1}">
				VIP会员
			</c:when>
			<c:when test="${prd.activity.userType==2}">
				体验师
			</c:when>
			<c:when test="${prd.activity.userType==3}">
				产品经理
			</c:when>
			<c:otherwise>
				普通会员
			</c:otherwise>
		</c:choose>  
      </br>
        本品牌勋章： 
      	<c:choose>
			<c:when test="${prd.activity.brandNum==-1}">
				不限
			</c:when>
			<c:otherwise>
				${prd.activity.brandNum}个以上
			</c:otherwise>
		</c:choose>
      </p>
      <p class="top30">地区要求： 大陆地区</p>
      <p class="top">
      	<c:choose>
			<c:when test="${prd.activity.areaType==0}">
				参与省份：${prd.activity.area}
			</c:when>
			<c:when test="${prd.activity.areaType==1}">
				不参与省份：${prd.activity.area}
			</c:when>
			<c:otherwise>
				全部参与
			</c:otherwise>
		</c:choose>
      </p>
    </div>
    <!--mude_wrap end-->
    <div class="share_wrap"> 
		<a href="javascript:;" class="fenx"><span></span>分享</a> 
		<a href="javascript:;" class="but_soucang"><span></span>收藏</a>
		<a href="javascript:;">品牌订阅</a> 
		<a href="javascript:;">举报</a>
    </div>
     <!--share_wrap-->  
 </div>
 <!--area_a-->   
    <div class="area_b">
    <div class="area_c">
      <div class="video"><img src="<%=basePath%>/images/bannk/video_bg.jpg"></div>
      <div class="liucheng_lj"></div>
      <div class="tiyan_wrap">
        <h3 class="tiyan_title">美试体验指数</h3>
        <div class="tiyan">
          <div class="cpxhd">
            <h3>产品喜好度</h3>
            <div class="cpxhd_del"> <span class="left">好</span>
              <div class="cpxhd_du"><span class="color_1" id="cp_pj_1" style="width:100%"></span></div>
              <p>100%</p>
            </div>
            <div class="cpxhd_del"> <span class="left">一般</span>
              <div class="cpxhd_du"><span class="color_2" id="cp_pj_2" style="width:0%"></span></div>
              <p>0</p>
            </div>
            <div class="cpxhd_del"> <span class="left">不好</span>
              <div class="cpxhd_du"><span class="color_3" id="cp_pj_3" style="width:0%"></span></div>
              <p>0</p>
            </div>
            <p class="time1 fl">上线时间：<fmt:formatDate value="${prd.releaseTime}" pattern="yyyy/MM/dd"/></p>
            <p class="time2 fr">累计体验：<span class="green" id="cp_rs">0人</span></p>
          </div>
          <div class="ppphd">
            <h3>品牌偏好度</h3>
            <div class="ppphd_del"> <span class="left">喜欢</span>
              <div class="ppphd_du"><span class="color_4" id="pp_pj_1" style="width:100%"></span></div>
              <p>100%</p>
            </div>
            <div class="ppphd_del"> <span class="left">没感觉</span>
              <div class="ppphd_du"><span class="color_5" id="pp_pj_2" style="width:0%"></span></div>
              <p>0</p>
            </div>
            <div class="ppphd_del"> <span class="left">不喜欢</span>
              <div class="ppphd_du"><span class="color_6" id="pp_pj_3" style="width:0%"></span></div>
              <p>0</p>
            </div>
            <p class="time1 fl">入驻时间：2014/03/28</p>
            <p class="time2 fr">累计体验：<span class="green" id="pp_rs">0人</span></p>
          </div>
        </div>
      </div>
      <div class="baby_cs_wrap">
          <h3 class="baby_cs_title">宝贝参数</h3>
          <div class="baby_cs">
             <p> 
          		<span class="w220">品牌名称：${prd.brandName}</span> 
                <span class="w350">产品名称：${prd.productName}</span> 
                <span class="w120">规格：${prd.standard}</span> 
                <span class="w120">产地：
                  	${prd.countryName} ${prd.provinceName}
                  	<c:if test="${prd.provinceName!=prd.cityName}">
                  		${prd.cityName}
                  	</c:if>
                </span> 
                <span>商家联系电话：${prd.tel}</span> 
                <span class="w350">生产厂址：${prd.manufacturer}</span> 
                <span></span> 
                <span></span> 
             </p>
            <div class="line left mb15"></div>
            <p>特别说明：</br>
            	${prd.detail.specialVersion}
            </p>
         </div>
         <!--baby_cs end-->
      </div>

      <div class="baby_tab_wrap">
        <div id="Tab1">
          <div class="Menubox baby_tab_wrap">
            <ul class="baby_tab">
              <li id="one1"  class="hover">宝贝详情</li>
            </ul>
          </div>
          <div class="Contentbox baby_tab_cont">
            <div id="con_one_1" class="hover">
              <div class="bb_xiangqing">
              	${prd.detail.detail}
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="baby_cs_wrap fixed">
        <h2>哪里能买到</h2>
        <div class="babycs_xia">
		   <a href="${prd.shopUrl}" target="_blank"><img src="<%=imagePath%>/${prd.picture.shopPic}" width="718" height="80"></a>
        </div>
        <input type="hidden" id="prdCode" value="${prd.productCode}"/>
      </div>
    </div>
    <div class="area_d">
      <div class="white_box">
        <h3 class="title_1">品牌<span class="text_green">官方体验中心</span></h3>
        <img src="<%=basePath%>/images/bannk/linshi_3.jpg" width="230" height="230" class="tyzx_img">
        <p>${prd.brandName}</p>
      </div>
      <div class="white_box top15">
        <h3 class="title_2">产品<span class="text_green">经理</span></h3>
        <img src="<%=basePath%>/images/bannk/classify07.png" width="135" height="135">
        <p class="jinli">张欣 <span>女 射手座</span><br>
          <span>粉丝数：</span><em class="yellow">123456</em></p>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="<%=basePath%>/js/product/previewAct.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/countDown.js"></script>
</body>
</html>