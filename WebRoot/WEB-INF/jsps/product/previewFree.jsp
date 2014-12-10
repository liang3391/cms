<%@ include file="../../jsps/common/import.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品详情</title>
<link href="<%=basePath%>/css/preview.css" rel="stylesheet" type="text/css">
<link href="<%=basePath%>/css/baby_details.css" rel="stylesheet" type="text/css">
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
</div>

<div class="preview_table main">
    <h3><span class="nake"></span>裸价体验活动详情</h3>
    <div  class="preview_table_content">
<!--状态一：等待编辑活动-->
          <div class="salimg bggray">
               <p>等待</p>
               <p>编辑活动</p>
          </div>
          <div class="rightnews top35">
               <ul>
                  <li>产品编码：${prd.productCode}</li>
                  <li class="wid">活动编码：</li>
                  <li>活动时间：</li>
                  <li class="wid">活动天数：</li>
               </ul>
          </div>

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
	                       <td></td>
	                       <td id=""></td>
	                    </tr>
                    </c:forEach>
                    <tr>
                       <td bgcolor="#f7fceb" colspan="3">合计</td>
                       <td id=""></td>
                    </tr>
                </tbody>
              </table>
	         <script>
                $("#_oTable").rowspan(0)
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
         <span class="w131">体验价：</span> 
         <span class="w131">规格：${prd.standard}</span>
         <span class="w131">累计试用人数：<em class="green" id="total_exp"></em></span>
        
         <div class="w323 left"> 
            <span id="Lh">颜色和尺码：</span>
            <div class="example" id="emample1"> 
                <em class="img_sure"></em>
                <div class="tigger but_xuanze" id="ele1">请选择</div>
            </div>
          </div>
          <span class="w160 top5">试用数量：<em class="text_green"></em></span> 
          <span class="top5">已申请人数：<em class="text_green"></em></span>
          <div class="line mt10 mb10"></div>
          <!--免费试用次数-->
          <div class="mfs">
            <h3><strong>FREE</strong>免费试用<span>[每人仅限试用1次]</span></h3>
          </div>
          <!--保证金/立即申请/倒计时 情况1-->
          <div class="lj_sq">
                <h2>保证金：<em></em><label></label></h2>
                <span class="lv"><input type="button" value=""></span>
          </div>
          <div class="line mt10 mb10"></div>
          <div class="djs_begin">
            <h3 class="begin">距离申请开始</h3>
          </div>
          <div class="line mt10 mb10"></div>
        </div>
        <div class="lj_qq fixed">
            <a href="javascript:;" class="fr th_qq">联系客服<em></em></a>
        </div>
        <!--djs_begin end-->
    </div>
    <!--shangpin_text_wrap-->
    <div class="mude_wrap mf_bg">
        <h3></h3>
        <p style="height:42px;" class="mt10"></p>
        <h4></h4>
        <p class="mt10"> 
	           性别要求：<br>
	           年龄要求：<br>
	           会员类别：<br>
	           体验等级：<br>
	           本品牌勋章： </p>
        <p style="height:42px;" class="mt20">地区要求：大陆地区<br>
		全部参加：<span></span><span></span><span></span>
        </p>
        <h5></h5>
        <p class="mt10">请确认收货后0天内提交报告</p>
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
            <p class="time2 fr">累计试用：<span class="green" id="cp_rs">0人</span></p>
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
		   <c:choose>
           	<c:when test="${!empty prd.shopUrl}">
           		<a href="${prd.shopUrl}" target="_blank">
           	</c:when>
           	<c:otherwise>
           		<a href="javascript:;">
           	</c:otherwise>
           </c:choose>
           <img src="<%=imagePath%>/${prd.picture.shopPic}" width="718" height="80"></a>
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
<script type="text/javascript" src="<%=basePath%>/js/product/preview.js"></script>
</body>
</html>