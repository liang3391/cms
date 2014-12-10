<%@ include file="../../jsps/common/import.jsp" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>产品管理</title>
<link href="<%=basePath%>/css/produce_manage.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/js/common/formValidator/style/validator.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wapper">
  <div class="main fixed">
    <%@ include file="header.jsp" %>
    <div class="box">
      <h2 class="box_bottom"><a href="#">综合管理后台</a> > <a href="#">产品及活动管理</a> > 
      <c:choose>
      		<c:when test="${prdDto.prd.type==1}">
				<a href="#">免费试用</a> > 
      		</c:when>
      		<c:otherwise>
      			<a href="#">裸价体验</a> > 
      		</c:otherwise>
      </c:choose>
      <c:choose>
      		<c:when test="${from=='report'}">
      			<em class="green">重新申报管理-编辑产品</em></h2>
      		</c:when>
      		<c:when test="${from=='endSale'}">
      			<em class="green">${prdDto.prd.type==1?'试用':'体验'}结束活动产品管理-编辑产品</em></h2>
      		</c:when>
      		<c:when test="${from=='editing'}">
		      <em class="green">编辑中产品管理-编辑产品</em></h2>
      	</c:when>
      		<c:otherwise>
      			<em class="green">新产品发布</em></h2>
      		</c:otherwise>
      </c:choose>
      <div class="fl fixed">
        <%@ include file="left.jsp" %>
      </div>
<form action="<%=basePath%>/prd/addPrd.htm" method="post" name="prdform" id="prdform" autocomplete="off">
		<input type="hidden" name="type" value="${prdDto.prd.type}"/>
		<input type="hidden" name="from" id="fromPage" value="${from}"/>
      <div class="fr fixed">
      <c:if test="${from==null}">
        <h3 class="fleft w505">1.选择品牌 > 2.选择类目 > <em class="yellow">3.填写产品属性</em> > 4.放入待售产品</h3>
      </c:if>
        <h4 class="fixed"> <img src="<%=imagePath%>/${prdDto.pic.picture1}" width="90" height="90" /><em>当前品牌：${prdDto.prd.brandName}</em></h4>
        <div class="boreda fixed clear padtop10">
          <div class="biao postop75">填写产品属性（<em class="red">*</em>为必填项）</div>
          <div class="product fixed">
            <h3>产品属性</h3>
                <div class="product_cent fixed">
              <ul class="proda fixed">
                <li>
                	<%--
                	<input type="hidden" name="pic.picture1" value="${prdDto.pic.picture1}"/>
                	<input type="hidden" name="prd.categoryId1" value="${prdDto.prd.categoryId1}"/>
                	<input type="hidden" name="prd.categoryName1" value="${prdDto.prd.categoryName1}"/>
                	<input type="hidden" name="prd.categoryId2" value="${prdDto.prd.categoryId2}"/>
                	<input type="hidden" name="prd.categoryName2" value="${prdDto.prd.categoryName2}"/>
                	<input type="hidden" name="prd.categoryId" value="${prdDto.prd.categoryId}"/>
                	<input type="hidden" name="prd.categoryName" value="${prdDto.prd.categoryName}"/>
                	--%>
                	<input type="hidden" name="pic.picture1" value="images/bannk/img_04.jpg"/>
                	<input type="hidden" name="prd.categoryName1" value="保健品／膳食营养补充剂 "/>
                	<input type="hidden" name="prd.categoryName2" value="蛋白质／氨基酸"/>
                	<input type="hidden" name="prd.categoryName" value="胶原蛋白"/>
                		<span>类目：</span>
                		<c:if test="${!empty prdDto.prd.categoryName1}">${prdDto.prd.categoryName1} > </c:if>
                		<c:if test="${!empty prdDto.prd.categoryName2}">${prdDto.prd.categoryName2} > </c:if>${prdDto.prd.categoryName}
                </li>
                <li>
                	<%--<input type="hidden" name="prd.brandId" value="${prdDto.prd.brandId}"/>
                	<input type="hidden" name="prd.brandName" value="${prdDto.prd.brandName}"/>
                	--%>
                	<input type="hidden" name="prd.brandName" value="merryshine/美似"/>
                	<span>品牌：</span>${prdDto.prd.brandName}
                </li>
                <li><span><em class="red">＊</em>产品名称：</span>
                  <input type="text" id="productName" name="prd.productName"  value="${prdDto.prd.productName}" class="w290" />
                  <p id="char_i" class="yellow fl whd">还可输入<strong>32</strong>个字符或<strong>16</strong>个汉字</p>
                   <p id="productNameTip"></p>
                </li>
                <li><span><em class="red">＊</em>市场价：</span>
                  <input type="text" id="marketPrice" name="prd.marketPrice" value="${prdDto.prd.marketPrice}" onkeyup="ckPrice(this)"  onafterpaste="ckPrice(this)"    class="w190 lt_scj" />
                  <p class="one fl">体验类别：<em class="yellow">
                  	<input type="hidden" name="prd.type" value="${prdDto.prd.type}"/>
                  	<c:choose>
                  		<c:when test="${prdDto.prd.type==1}">免费试用</c:when>
                  		<c:otherwise>
                  			裸价体验
                  		</c:otherwise>
                  	</c:choose>
                  </em></p>
                 <p id="marketPriceTip"></p>
                </li>
                <li><span>产品编码：</span>
                  <input type="hidden" name="prd.version" id="ver" value="${prdDto.prd.version}"/>
                  <input type="text" name="prd.productCode" id="prdCode" value="${prdDto.prd.productCode}" readonly class="w190" />
                  <p class="yellow fl">发布完成后自动生成</p>
                </li>
                <li>
                    <span><em class="red">＊</em>规格：</span>
                    <input type="text" name="prd.standard" id='standard' <c:if test="${!empty prdDto.prd.productCode}">readonly="readonly"</c:if> value="${prdDto.prd.standard}"  class="w190" />
                    <p class="yellow fl">发布完成后将不能修改</p>
                    <p id="standardTip"></p>
                </li>
                <li>
                  <span>颜色和尺码：</span>
                  <label>颜色：</label>
                  <input type="checkbox" id="std_color" name="prd.standColor" value="1" <c:if test="${prdDto.prd.standColor==1}">checked="checked"</c:if> class="fx oColor_box" />
                  <label>尺码：</label>
                  <input type="checkbox" id="std_size" name="prd.standSize" value="1" <c:if test="${prdDto.prd.standSize==1}">checked="checked"</c:if> class="fx oSize_box" />
                  <p class="yellow fl">颜色及尺码名称可自定义编辑，长度不超过6个字符</p>
                </li>
                </li>
              </ul>
             <c:choose>
             	<c:when test="${!empty dictList}">
             		<ul class="prodb fixed" id="prodb">
		                <li class="co_show"><span>+颜色分类：</span></li>
		                <li class="co_show" id="co_show" style="margin-top:-6px; padding-left:8px;">
		                  <c:forEach items="${dictList}" var="stdDict" varStatus="status" begin="0" end="11">
		                  	<c:if test="${stdDict.type=='0'}">
			                  <p>
			                    <label class="yy">
			                    <input class="poinp"  type="text" value="${stdDict.standardName}"></label>
			                    <input type="checkbox" class="fx" />
			                    <img src="" id="colorUp${status.index}s" style="display: none;" width="35" height="35" />
			                    <input type="hidden" id="colorUp${status.index}Artwork"/>
			                    <input type="hidden" id="colorUp${status.index}Show"/>
			                  </p>
			                 </c:if>
		                  </c:forEach>
		                </li>
		                <li class="btn_none co_show"><span>已选颜色：</span>
		                  <div class="fra" id="oCimg">
		                  	<c:forEach items="${dictList}" var="stdDict" varStatus="status" begin="0" end="11">
		                  		<c:if test="${stdDict.type=='0'}">
		                        	<div class="cimg"><strong>${stdDict.standardName}</strong>
		                            <input class='upload' onclick="ck('color',this)" id="colorUp${status.index}" type="button" value="本地上传" />
		                            <input type="button"  value="图片空间" />
		                                                                         （颜色名称可编辑，图片为产品实物图，500px*500px，大小不超过500K）
		                        	</div>
		                        </c:if>
		                  	</c:forEach>
		                  </div>
		                </li>
		                <li class="si_show"> <span>+尺码选择：</span>
		                  <div class="frb" id="frb">
		                    <div class="xie_size">
		                        <input type="radio" checked="checked" name="stdDto.type"  value="1" class="y1" />
		                        <label for="radio" class="y2">鞋码：</label>
								<c:forEach items="${dictList}" var="stdDict" begin="12" end="23">
		                  			<c:if test="${stdDict.type==1}">
				                        <input type="text"  value="${stdDict.standardName}" class="f1" />
				                        <input type="checkbox"  class="fx" />
			                        </c:if>
			                  	</c:forEach>
		                    </div>
		                    <div class="fu_size" id="fu_size">
		                        <input type="radio" name="stdDto.type" value="2" class="y1" />
		                        <label for="radio" class="y2">服装码：</label>
		                        <c:forEach items="${dictList}" var="stdDict" begin="24" end="35">
		                  			<c:if test="${stdDict.type==2}">
		                        		<input type="text"  value="${stdDict.standardName}" class="f1" />
		                        		<input type="checkbox" disabled  class="fx" />
		                        	</c:if>
			                  	</c:forEach>
		                     </div>
		                  </div>
		                </li>
		             </ul>
             	</c:when>
             	<c:otherwise>
             		<c:set var="colorLen" value="${fn:length(dictDto.colorList)}"></c:set>
             		<c:set var="sizeLen" value="${fn:length(dictDto.sizeList)}"></c:set>
             		<ul class="prodb fixed" id="prodb">
		                <li class="co_show"><span>+颜色分类</span></li>
		                <li class="co_show" id="co_show" style="margin-top:-6px; padding-left:8px;">
		                  <c:forEach items="${dictDto.colorList}" var="std" varStatus="status">
			                 <p>
			                    <label class="yy">
			                    <input class="poinp" readonly  type="text" value="${std.colorName}"></label>
			                    <input type="checkbox" checked="checked" class="fx" />
			                    <img src="<%=imagePath%>/${std.colorShow}" id="colorUp${status.index}s" width="35" height="35" />
			                    <input type="hidden" id="colorUp${status.index}Artwork" value="${std.colorArtwork}"/>
			                    <input type="hidden" id="colorUp${status.index}Show" value="${std.colorShow}"/>
			                 </p>
		                  </c:forEach>
		                  <c:forEach begin="${colorLen}" end="11" step="1" varStatus="status">
		                  	 <p>
			                    <label class="yy">
			                    <input class="poinp"  type="text" value=""></label>
			                    <input type="checkbox" class="fx" />
			                    <img src="" id="colorUp${status.index}s" style="display: none;" width="35" height="35" />
			                    <input type="hidden" id="colorUp${status.index}Artwork"/>
			                    <input type="hidden" id="colorUp${status.index}Show"/>
			                  </p>
		                  </c:forEach>
		                </li>
		                <li class="btn_none co_show"><span>已选颜色：</span>
		                  <div class="fra" id="oCimg">
		                   		<c:forEach items="${dictDto.colorList}" var="std" varStatus="status">
		                        	<div class="cimg"><strong>${std.colorName}</strong>
		                            <input class='upload' onclick="ck('color',this)" id="colorUp${status.index}" type="button" value="本地上传" />
		                            <input type="button"  value="图片空间" />
		                                                                         （颜色名称可编辑，图片为产品实物图，500px*500px，大小不超过500K）
		                        	</div>
		                  		</c:forEach>
		                  		<c:forEach begin="${colorLen}" end="11" step="1" varStatus="status">
				                	<div class="cimg"><strong></strong>
		                            <input class='upload' onclick="ck('color',this)" id="colorUp${status.index}" type="button" value="本地上传" />
		                            <input type="button"  value="图片空间" />
		                                                                         （颜色名称可编辑，图片为产品实物图，500px*500px，大小不超过500K）
		                        	</div>
				                </c:forEach>
		                  </div>
		                </li>
		                <li class="si_show"> <span>+尺码选择：</span>
		                  <div class="frb" id="frb">
		                    <div class="xie_size">
		                        <input type="radio" checked="checked" name="radio"  value="radio" class="y1" />
		                        <label for="radio" class="y2">尺码：</label>
		                       <c:forEach items="${dictDto.sizeList}" var="std">
			                        <input type="text" readonly value="${std.sizeName}" class="f1" />
			                        <input type="checkbox"  checked="checked" class="fx" />
			                  	</c:forEach>
			                  	<c:forEach begin="${sizeLen}" end="11" step="1">
			                        <input type="text"  value="" class="f1" />
			                        <input type="checkbox"  class="fx" />
			                  	</c:forEach>
		                    </div><%--
		                    <div class="fu_size" id="fu_size">
		                        <input type="radio" name="radio" value="radio" class="y1" />
		                        <label for="radio" class="y2">服装码：</label>
		                        <c:forEach items="${dictList}" var="stdDict" begin="24" end="35">
		                  			<c:if test="${stdDict.type==2}">
		                        		<input type="text"  value="${stdDict.standardName}" class="f1" />
		                        		<input type="checkbox" disabled  class="fx" />
		                        	</c:if>
			                  	</c:forEach>
		                     </div>
		                  --%></div>
		                </li>
		             </ul>
             	</c:otherwise>
             </c:choose>
             <table id="_oTable" border="0" cellspacing="0" cellpadding="0" class="w735">
                <thead>
                  <tr>
                    <th class="th1" width="70" align="center" valign="middle">已选颜色</th>
                    <th class="th2" width="72" align="center" valign="middle">已选尺码</th>
                    <th class="th3" width="72" align="center" valign="middle">市场价</th>
                    <th class="th4" width="150" align="center" valign="middle">商品编码</th>
                    <th class="th5" width="190" align="center" valign="middle"><em class="red">＊</em>条形码</th>
                    <th class="th6" align="center" valign="middle">是否启用</th>
                  </tr>
                </thead>
              	<tbody>
              		<c:forEach items="${prdDto.stdList}" var="stdList">
              			<tr>
	                       <td><p><input type='text' class='yanse' name="stdDto.colorName" readonly='readonly' value="${stdList.colorName}"></p><p class='oI'></p></td>
	                       <td><input type='text' class='chima' name="stdDto.sizeName" readonly='readonly' value="${stdList.sizeName}"></td>
	                       <td><input type='text' readonly='readonly' value="${prdDto.prd.marketPrice}"></td>
	                       <td><input type='text' readonly='readonly' value="${stdList.id}"></td>
	                       <td><input type='text' name="stdDto.barCode" value="${stdList.barCode}"></td>
	                       <td><input type='checkbox' name="stdDto.id" value="1" checked='checked'></td>
                    	</tr>
              		</c:forEach>
                </tbody>
              </table>
              <%--<input type="hidden" name="stdDto.id" value="111"/>--%>
              <c:if test="${prdDto.prd.type==0}">
              	<div class="top20 m_rg">
              	  <em class="red">＊</em>无理由退货：
              	  <input type="radio" name="prd.returnGoods" ${prdDto.prd.returnGoods==30?'checked':'' } value="30"><span>30天</span>
                  <input type="radio" name="prd.returnGoods" ${prdDto.prd.returnGoods==7?'checked':'' } value="7"><span>7天</span>
                  <input type="radio" name="prd.returnGoods" ${prdDto.prd.returnGoods==0?'checked':'' } value="0"><span>不参加</span>
              	</div>
              </c:if>
            </div>
          </div>
          <div class="product top30 fixed">
            <h3>产品详情</h3>
            <div class="product_cent fixed">
            	<input type="hidden" name="prd.countryName" id="countryName" value="${prdDto.prd.countryName}"/>
            	<input type="hidden" name="prd.provinceName" id="provinceName" value="${prdDto.prd.provinceName}"/>
				<input type="hidden" name="prd.cityName" id="cityName" value="${prdDto.prd.cityName}"/>
				<input type="hidden" name="prd.countyName" id="countyName" value="${prdDto.prd.countyName}"/>
              <ul class="prodc fixed">
                <li> <span><em class="red">＊</em>产地：国家&nbsp;</span>
                  <select name="prd.countryId" id="s_country" class="xl01">
                    <option value="0">中国</option>
                  </select>
                  <span class="mr">省份</span>
                  <select name="prd.provinceId" id="s_province" class="xl01">
                  	<option value="0">
						请选择
					</option>
                  </select>
                  <span class="mr">城市</span>
                  <select name="prd.cityId" id="s_city" class="xl01">
                  	<option value="0">
						请选择
					</option>
                  </select>
                  <span class="mr">地区</span>
                  <select name="prd.countyId" id="s_county"  class="xl01">
                   	<option value="0">
						请选择
					</option>
                  </select>
                  <p id="s_countyTip"></p>
                </li>
                <li><span><em class="red">＊</em>联系电话：</span>
                  <input type="text" name="prd.tel" value="${prdDto.prd.tel}" id="tel" class="w190" /> 发票：<strong>不提供发票</strong>
                  <p id="telTip">联系电话不能为空</p>
                  </li>
                <li><span><em class="red">＊</em>生产厂家：</span>
                  <input type="text" name="prd.manufacturer" value="${prdDto.prd.manufacturer}" id="manufacturer" class="width100" />
                  <p id="manufacturerTip">生产厂家不能为空</p>
                </li>
                <li> <span>资质证书：</span>（填写如：生产许可证，化妆品特殊用途许可证等）
                  <p>
                    <input type="text" name="detail.license1" value="${prdDto.detail.license1}" id="license1" class="width446" />
                  </p>
                  <p>
                    <input type="text" name="detail.license2" value="${prdDto.detail.license2}" id="license2" class="width446" />
                  </p>
                  <p>
                    <input type="text" name="detail.license3" value="${prdDto.detail.license3}" id="license3" class="width446" />
                  </p>
                </li>
                <li class="pos"><span>特别声明：</span>
                  <textarea name="detail.specialVersion" id="specialVersion" cols="45" rows="5" class="w100">${prdDto.detail.specialVersion}</textarea>
                  <%--<div id="text_area"><strong id="tear_st">0</strong>/500</div>--%>
                </li>
                 </ul>
              <div class="area_c top20 fixed">
                <div class="zhis">美试体验指数示例：</div>
                <div class="tiyan fixed">
                  <div class="cpxhd">
                    <h6>产品喜好度</h6>
                    <div class="cpxhd_del"> <span class="left">好</span>
                      <div class="cpxhd_du color_1"></div>
                      <p>100%</p>
                    </div>
                    <div class="cpxhd_del"> <span class="left">一般</span>
                      <div class="cpxhd_du color_2"></div>
                      <p >0%</p>
                    </div>
                    <div class="cpxhd_del"> <span class="left">不好</span>
                      <div class="cpxhd_du color_3"></div>
                      <p>0%</p>
                    </div>
                    <p class="time">产品上线时间：2014/3/28</p>
                    <p class="time">累计裸价体验：<span class="text_green green">123456人</span></p>
                  </div>
                  <div class="ppphd">
                    <h6>产品喜好度</h6>
                    <div class="ppphd_del"> <span class="left">喜欢</span>
                      <div class="ppphd_du color_4"></div>
                      <p>100%</p>
                    </div>
                    <div class="ppphd_del"> <span class="left">没感觉</span>
                      <div class="ppphd_du color_5"></div>
                      <p>0%</p>
                    </div>
                    <div class="ppphd_del"> <span class="left">不喜欢</span>
                      <div class="ppphd_du color_6"></div>
                      <p>0%</p>
                    </div>
                    <p class="time">品牌入驻时间：2014/3/28</p>
                    <p class="time">累计体验：<span class="text_green green">123456人</span></p>
                  </div>
                </div>
              </div>
              <div class="area_c top20 fixed">
                <div class="area_ca"><em>品牌官方体验中心：</em>
                  <span class="img"><img src="<%=imagePath%>/${prdDto.pic.picture1}" width="150" height="150" />
                    <p>${prdDto.prd.brandName}</p>
                  </span>
                </div>
                <div class="area_cb"><span><em class="red">＊</em>产品经理：姓名</span>
                  <input type="hidden" name="prd.pmName" id="pmName" value=""/>
                  <input type="hidden" id="pmIdSel" value="${prdDto.prd.pmId}"/>
                  <select name="prd.pmId" id="pmId" class="xl01">
                    <option value="0" selected="selected">选择姓名</option>
                    <option value="123456789">张三</option>
                  </select>
                  <span class="mar10">ID：1234567890</span><span>昵称：我就是别跑我就是别跑</span>
                  <p id="pmIdTip"></p>
                  </div>
              </div>
            </div>
          </div>
          <div class="product top30 fixed">
            <h3>图片视频</h3>
            <div class="product_cent fixed">
              <div class="vido_top fixed mainPic"><span><em class="red">＊</em>产品图片：<a href="javascript:;"></a></span>
				<input type="hidden" id="artwork_m" name="pic.artwork" value="${prdDto.pic.artwork}"/>
				<input type="hidden" id="showPic_m" name="pic.showPic" value="${prdDto.pic.showPic}"/>
				<input type="hidden" id="thumbnail_m" name="pic.thumbnail" value="${prdDto.pic.thumbnail}"/>
				<input type="hidden" id="centerPic_m" name="pic.centerPic" value="${prdDto.pic.centerPic}"/>		
				<input type="hidden" id="goodsCollect_m" name="pic.goodsCollect" value="${prdDto.pic.goodsCollect}"/>
				<input type="hidden" id="artworkList_s" name="pic.artworkList" value="${prdDto.pic.artworkList}"/>
				<input type="hidden" id="showPicList_s" name="pic.showPicList" value="${prdDto.pic.showPicList}"/>
				<input type="hidden" id="thumbnailList_s" name="pic.thumbnailList" value="${prdDto.pic.thumbnailList}"/>
				<c:set value="${fn:split(prdDto.pic.showPicList,',')}" var="showPics"></c:set>
                <ul id="vido_img">
                  <c:choose>
                  	<c:when test="${!empty prdDto.pic.showPicList}">
                  		<li><span><img src="<%=imagePath%>/${prdDto.pic.showPic}" width="140" height="140" /></span><a href="javascript:void(0)" onclick="ck('master',this)">上传图片</a></li>
                  		<c:forEach items="${showPics}" var="showPic">
                  			<li><span><img src="<%=imagePath%>/${showPic}" width="140" height="140" /></span><a href="javascript:void(0)" onclick="ck('slave',this)">上传图片</a></li>
                  		</c:forEach>
                  	</c:when>
                  	<c:otherwise>
                  		<li><span><img src="<%=basePath%>/images/bannk/img_07.jpg" width="140" height="140" /></span><a href="javascript:void(0)" onclick="ck('master',this)">上传图片</a></li>
                  		<li><span><img src="<%=basePath%>/images/bannk/img_07.jpg" width="140" height="140" /></span><a href="javascript:void(0)" onclick="ck('slave',this)">上传图片</a></li>
                  		<li><span><img src="<%=basePath%>/images/bannk/img_07.jpg" width="140" height="140" /></span><a href="javascript:void(0)" onclick="ck('slave',this)">上传图片</a></li>
                  		<li><span><img src="<%=basePath%>/images/bannk/img_07.jpg" width="140" height="140" /></span><a href="javascript:void(0)" onclick="ck('slave',this)">上传图片</a></li>
                  		<li><span><img src="<%=basePath%>/images/bannk/img_07.jpg" width="140" height="140" /></span><a href="javascript:void(0)" onclick="ck('slave',this)">上传图片</a></li>
                  	</c:otherwise>
                  </c:choose>
                </ul>
              </div>
              <div class="boxb top25">
                <div id="Tab1">
                  <div class="Menubox">
                    <ul>
                      <li id="one1" onclick="setTab('one',1,2)"  class="hover">图片空间</li>
                      <li id="one2" onclick="setTab('one',2,2)" >本地上传</li>
                    </ul>
                  </div>
                  <div class="Contentbox fixed">
                  </div>
                </div>
              </div>
              <div class="vido_top top30 fixed"> <span><em class="red">＊</em>产品视频：</span>
                <dl class="top15">
                  <dt><img src="<%=basePath%>/images/bannk/img_08.jpg" width="720" height="250" /></dt>
                  <dd><a href="#">视频选择</a></dd>
                </dl>
              </div>
            </div>
          </div>
          <div class="product top30 fixed">
            <h3>产品描述</h3>
            <div class="product_cent fixed">
              <div class="vido_top fixed"> <span><em class="red">＊</em>产品描述：</span>
              <%@ include file="editor.jsp" %>
              <textarea name="detail.detail" class="textarea" style="width:730px;height:430px;visibility:hidden;"><%=htmlspecialchars(detail)%></textarea>
              </div>
            </div>
          </div>
          <div class="product top30 fixed">
            <h3>产品描述</h3>
            <div class="product_cent fixed">
              <ul class="proda fixed">
                <li><span>店铺链接：</span>
                  <input type="text" name="prd.shopUrl" id="shopUrl" value="${prdDto.prd.shopUrl}" class="width445" />
                  <p class="one">（哪里能买到）</p>
                  <p id="shopUrlTip"></p>
                </li>
                <li><span class="width100"><em class="red">＊</em>上传店铺图片：</span>
                	<input type="hidden" id="shopPic" name="pic.shopPic" value="${prdDto.pic.shopPic}"/>
                	<a href="javascript:void(0)" onclick="ck('shopPic')">本地上传</a><a href="javascript:void(0)">图片空间</a>
                	<font class="yellow">图片尺寸为720px*80px，大小不超过500K。</font>
                	<div id="shopPicTip"></div>
                </li>
              </ul>
            </div>
          </div>
          <input type="file" name="file" id="file" style="display:none;"/>
          <p class="top10">
          	<input type="button" class="yl" id="prevPrd" value="产品预览" />
          	<c:if test="${empty prdDto}">
          		<input type="button" id="subPrd" value="保存并放入待售产品" class="bc"/>
          		<input type="button" value="返回上一步" class="showbox bc"/>
          	</c:if>
          	<c:if test="${!empty prdDto}">
          		<input type="button"  id="subPrd" class="bc" value="保存产品">
          	</c:if>
          	
          </p>
        </div>
      </div>
</form>   
    </div>
  </div>
</div>

<!--产品放入回收站弹出框-->
<div id="mask"></div>
	<div id="_recycle" class="_recycle">
  <div class="lt_text">
    <p></p>
    <p>带<em class="red">*</em>内容为必填项，不能为空</p>
  </div>
  <div class="re_btn">
    <input id="abtn1" class="lt_re1" type="button" value="查看填写">
  </div>
</div>
<script type="text/javascript">
	$(function(){
		var std_color = "${prdDto.prd.standColor}";
		var std_size = "${prdDto.prd.standSize}";
		if(std_color=="1"){
			$(".co_show").show();
		}
		if(std_size=="1"){
			$(".si_show").show();
		}
		_init_area('${prdDto.prd.provinceId}','${prdDto.prd.cityId}','${prdDto.prd.countyId}');	//省市区
	})
</script>
<script type="text/javascript" src="<%=basePath%>/js/common/area.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/ajaxfileupload.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/tableJs.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/common/formValidator/formValidator.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/common/formValidator/formValidatorRegex.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/merge_table.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/product.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
</body>
</html>
