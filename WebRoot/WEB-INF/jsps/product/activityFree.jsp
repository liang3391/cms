<%@ include file="../common/import.jsp" %>
<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>活动管理</title>
<link href="<%=basePath%>/css/produce_manage.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/js/My97DatePicker/skin/WdatePicker.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/js/common/formValidator/style/validator.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="wapper">
  <div class="main fixed">
    <%@ include file="header.jsp" %>
    <div class="box">
      <h2><a href="#">综合管理后台</a> > <a href="#">产品及活动管理</a> > <a href="#">免费试用</a> > 
      <c:choose>
      	<c:when test="${from=='report'}">
		      <em class="green">重新申报管理-编辑活动</em></h2>
      	</c:when>
      	<c:when test="${from=='editing'}">
		      <em class="green">编辑中产品管理-编辑活动</em></h2>
      	</c:when>
      	<c:otherwise>
		      <em class="green">待售产品管理-编辑活动</em></h2>
      	</c:otherwise>
      </c:choose>
      <div class="fl fixed">
            <%@ include file="left.jsp" %>
      </div>
<form action="<%=basePath%>/prd/addPrdAct.htm" method="post" name="actfrom" id="actfrom" autocomplete="off">
      <div class="fr">
        <div class="edit_right"> 
          <!--显示预览内容-->
          <div class="mude_wrap mf_bg">
            <h4></h4>
            <p id="oE_p1" class="top15"></p>
            <h3></h3>
            <p class="top15"> 性别要求：<span id="oEs_xb"></span></br>
					                           年龄要求：<span id="oEs_age"></span></br>
					                           会员类别：<span id="oEs_vip"></span></br>
					                           体验等级：<span id="oEs_lv"></span></br>
					                           本品牌勋章：<span id="oEs_xz"></span> </p>
             <p class="top15">地区要求：大陆地区</br>
             <span id="oEs_cj">全部参加</span>：<span id="oEs_cj1"></span> </p>
             <h5></h5>
            <p class="mt10">请确认收货后<span id="oEs_day">0</span>天内提交报告</p>
          </div>
          <div  class="yl_btn">
            <input id="yl_btn" onclick="showPreview()" type="button" value="显示预览">
          </div>
          <!--显示预览内容end-->
          
          <div class="edit_explain">
            <h3>编辑活动：</h3>
          </div>
          <div class="edit_s1">
            <h3>参与标准</h3>
            <div id="edit_form" class="edit_form">
              <ul id="oEul">
                <li>
                  <label><span><em>*</em>保证金：</span></label>
                  <input type="hidden" name="prdAct.version" value="${ver}"/>
                  <input type="hidden" name="from" value="${from}"/>
                  <input type="hidden" name="prdAct.productCode" value="${prdCode}"/>
                  <input type="hidden" name="type" value="${param.type}"/>
                  <input type="hidden" name="prdAct.id" value="${actDto.prdAct.id}"/>
                  <input id="price" name="prdAct.price" value="${actDto.prdAct.price}" onkeyup="ckPrice(this)"  onafterpaste="ckPrice(this)"  type="text">
                   <span class="dao"></span>
                  <div id="priceTip"></div>
                </li>
                <li><label><span>体验价：</span></label>￥0.00</li>
                <li>
                  <label><span><em>*</em>体验目的：</span></label>
                  <input id="purpose" name="prdAct.purpose" value="${actDto.prdAct.purpose}" type="text">
                  <span id="tymd_n">0</span>/<strong>30</strong>
                  <div id="purposeTip"></div>
                 </li>
                <li>
                  <label><span><em>*</em>性别要求：</span></label>
                  <c:set var="gender" value="${actDto.prdAct.gender}"></c:set>
                  <select id="xb_tj" name="prdAct.gender">
                  	<c:choose>
                  		<c:when test="${!empty gender}">
                  			<option <c:if test="${gender==2}">selected="selected"</c:if> value="2">不限</option>
                    		<option <c:if test="${gender==1}">selected="selected"</c:if> value="1">男</option>
                    		<option <c:if test="${gender==0}">selected="selected"</c:if> value="0">女</option>
                  		</c:when>
                  		<c:otherwise>
                  			<option selected="selected"  value="2">不限</option>
                    		<option value="1">男</option>
                    		<option value="0">女</option>
                  		</c:otherwise>
                  	</c:choose>
                  </select>
                  <span class="dao"></span>
                </li>
                <li>
                  <label><span><em>*</em>年龄要求：</span></label>
                  <input id="ageMin"  name="prdAct.ageMin" value="${actDto.prdAct.ageMin}" onkeyup="ckAge(this)"  onafterpaste="ckAge(this)"  class="ageWi mr_10" type="text">
                  <span class="dao">到</span>
                  <input id="ageMax"  name="prdAct.ageMax" value="${actDto.prdAct.ageMax}" onkeyup="ckAge(this)"  onafterpaste="ckAge(this)"  class="ageWi" type="text">
                 <div id="ageTip"></div>
                </li>
				<li>
                  <label><span><em>*</em>会员类别：</span></label>
                  <select id="classHY" name="prdAct.userType">
                    <option selected="selected" value="0">普通会员</option>
                    <option value="1">VIP会员</option>
                    <option value="2">体验师</option>
                    <option value="3">产品经理</option>
                  </select>
                   <span class="dao"></span>
                </li>
                <li>
                  <label><span><em>*</em>体验等级：</span></label>
                  <input type="hidden" id="gradeLow" value="${actDto.prdAct.gradeLow}"/>
                  <input type="hidden" id="gradeHigh" value="${actDto.prdAct.gradeHigh}"/>
                  <input type="hidden" id="userType" value="${actDto.prdAct.userType}"/>
                  <input type="hidden" id="reportDay" value="${actDto.prdAct.reportDay}"/>
                  <input type="hidden" id="brandNum" value="${actDto.prdAct.brandNum}"/>
                  <input type="hidden" id="areaType" value="${actDto.prdAct.areaType}"/>
                  <input type="hidden" name="prdAct.area" id="area" value="${actDto.prdAct.area}"/>
                  <input type="hidden" name="prdAct.areaId" id="areaId" value="${actDto.prdAct.areaId}"/>
                  <select id='lv_tj' name="prdAct.gradeLow">
                    <!--1-->
                    <option selected="selected" value="-1">不限</option>
                    <option value="1">LV1</option>
                    <option value="2">LV2</option>
                    <option value="3">LV3</option>
                    <option value="4">LV4</option>
                    <option value="5">LV5</option>
                    <option value="6">LV6</option>
                    <option value="7">LV7</option>
                    <option value="8">LV8</option>
                    <option value="9">LV9</option>
                  </select>
                  <span class="dao">到</span>
                  <select id='lv_tj1' name="prdAct.gradeHigh">
                   	<option selected="selected" value="-1">不限</option>
                    <option value="1">LV1</option>
                    <option value="2">LV2</option>
                    <option value="3">LV3</option>
                    <option value="4">LV4</option>
                    <option value="5">LV5</option>
                    <option value="6">LV6</option>
                    <option value="7">LV7</option>
                    <option value="8">LV8</option>
                    <option value="9">LV9</option>
                  </select>
                </li>
                <li>
                  <label><span><em>*</em>本品牌勋章：</span></label>
                  <select id="brand" name="prdAct.brandNum">
                    <option selected="selected" value="-1">不限</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                  </select>个以上
                </li>
                <li>
                  <label><span><em>*</em>地区要求：</span></label>
                  	大陆地区
                </li>
                <li>
                  <label><span><em>*</em>省份选择方式：</span></label>
                  <select id="city_sec" name="prdAct.areaType">
                    <option selected="selected"  value="0">参与省份</option>
                    <option value="1">不参与省份</option>
                    <option value="2">全部参加</option>
                  </select>
                  <font>最多只能选择3个</font> 
                  </li>
              </ul>
              <ol id="oE_ol">
               	
              </ol>
              
              <p class="last"><em class="red">*</em>试用报告需在确认收货后
              	<select id="reportDaySec" name ="prdAct.reportDay">
              		<option value="0">请选择</option>
              		<option value="15">15</option>
              		<option value="30">30</option>
              		<option value="45">45</option>
              		<option value="60">60</option>
              	</select>
              	提交
              	&nbsp;<span id="reportDaySecTip"></span>
              </p>
            </div>
          </div>
          <!--活动时间-->
          <div class="edit_s1 top15">
            <h3>活动时间</h3>
            <div class="time_show freeu">
            <h5>特别说明：免费试用活动时间为19天，分为申请期，审核期，及订单提交期三个时间段。</h5>
              <p><em class="red">*</em>活动开始时间：
                <input class="Wdate" type="text" id="onTime" name="onTime" value="<fmt:formatDate value="${actDto.prdAct.onTime}" pattern="yyyy-MM-dd hh:mm"/>" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',readOnly:true})">
                <strong class="green">输入活动起始时间，下列自动计算显示。</strong>
              </p>
              <ul>
                  <li><label><a>申请期（7天）：</a></label><input id="report_1" disabled="disabled" type="text" >至<input id="report_2" disabled="disabled" type="text"></li>
                  <li><label><a>审核期（5天）：</a></label><input id="report_3" disabled="disabled" type="text" >至<input id="report_4" disabled="disabled" type="text"></li>
                  <li><label><a>订单提交期（7天）：</a></label><input id="report_5" disabled="disabled" type="text" >至<input id="report_6" disabled="disabled" type="text"></li>
              </ul>
              <div class="upleft"><em class="up1"></em>免费试用活动周期<em class="btm1"></em></div>
            </div>
          </div>
          
          <!--活动时间-->
          <div class="edit_s1 top15">
            <h3>参与人数</h3>
            <div class="table_show">
              <table border="0" cellspacing="0" id="stdTable" cellpadding="0" class="w735">
                <thead>
                  <tr>
                    <th width="70" align="center" valign="middle">已选颜色</th>
                    <th width="72" align="center" valign="middle">已选尺码</th>
                    <th width="72" align="center" valign="middle">体验价</th>
                    <th width="106" align="center" valign="middle"><em class="red">＊</em>本次开放体验人数</th>
                    <th width="150" align="center" valign="middle">商品编码</th>
                    <th width="190" align="center" valign="middle">条形码</th>
                  </tr>
                </thead>
                <c:forEach var="std" items="${actDto.stdList}" varStatus="status">
                  <tr>
                    <td width="70"  align="center" valign="middle">
                      <p>${std.colorName}</p>
                      <c:if test="${!empty std.colorShow}">
                      	<p><img src="<%=imagePath%>/${std.colorShow}" width="35" height="35" /></p>
                      </c:if>
                    </td>
                    <td width="72" height="35" align="center" valign="middle">${std.sizeName}</td>
                    <td width="72" height="35" align="center" id="price_${status.index}" valign="middle"></td>
                    <td width="106" height="35" align="center" bgcolor="#ffffff" valign="middle"><input type="text" name="stdDto.store" id="store_${status.index}"  onchange="getStore()" value="${std.store}"></td>
                    <td width="150" height="35" align="center" valign="middle">
                    	<input type="hidden" name="stdDto.id" value="${std.id}"/>
                    	${std.id}
                    </td>
                    <td width="190" height="35" align="center" valign="middle">${std.barCode}</td>
                  </tr>
                 </c:forEach>
              </table>
              <h4>
              	<input type="hidden" name="totalStore" id="totalStore" value="${actDto.totalStore}"/>
              	<span class="red">*</span>开放体验人数：<span id="store">${actDto.totalStore}</span>
              </h4>
            </div>
          </div>
          <div class="th_btn">
            <p>
              <a href="javascript:;" class="abutton gotoHuo" id="prevAct">活动页面预览</a>
              <a class="abutton bggreen" id="subAct" href="javascript:;">提交商家复核</a>
              <a href="javascript:;" id="addAct" class="abutton bggreen">保存活动</a>
            </p>
          </div>
        </div>
      </div>
</form>
    </div>
  </div>
</div>

<!--弹出框-->
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
<script type="text/javascript" src="<%=basePath%>/js/common/area.js"></script>
<script language="javascript" src="<%=basePath%>/js/common/formValidator/formValidator.min.js"></script>
<script language="javascript" src="<%=basePath%>/js/common/formValidator/formValidatorRegex.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/merge_table.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/product/activityFree.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/common.js"></script>
</body>
</html>
