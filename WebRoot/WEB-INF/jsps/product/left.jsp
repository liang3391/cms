<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<!-- 裸价体验 -->
<div id="oPro_menu" class="oPro_menu">
       <ul>
          <li class="on"><a href="#">新产品发布管理</a></li>
          <li><a href="<%=basePath%>/prd/selectForSalePrd.htm?type=${param.type}">待售产品管理</a></li>
          <li class="colis_0" ><a href="javascript:;">在售产品管理</a><i class="bg2"></i></li>
          <ol style="display:block">
               <li><em>-</em><a href="<%=basePath%>/prd/getOnSaleProductList.htm?type=${param.type}">${param.type==0?'体验':'试用'}中活动产品管理</a></li>
               <li><em>-</em><a href="<%=basePath%>/prd/getEndSaleProductList.htm?type=${param.type}">${param.type==0?'体验':'试用'}结束活动产品管理</a></li>
               <li><em>-</em><a href="<%=basePath%>/prd/getEditingProductList.htm?type=${param.type}">编辑中产品管理</a></li>
          </ol>
          <li><a href="<%=basePath%>/prd/getRecycleBinList.htm?type=${param.type}">产品回收站</a></li>
          <li class="colis_0 ping"><a href="javascript:;">活动申报管理</a><i class="bg2"></i></li>
          <ol style="display:block">
               <li><em>-</em><a href="<%=basePath%>/act/getActCheckList.htm?type=${param.type}&prdStatus=1">复核活动管理</a></li>
               <li><em>-</em><a href="<%=basePath%>/act/getActReportList.htm?type=${param.type}&prdStatus=1">重新申报管理</a></li>
               <li><em>-</em><a href="<%=basePath%>/act/getActCheckRecord.htm?type=${param.type}">复核记录查询</a></li>
          </ol>
       </ul>
</div>