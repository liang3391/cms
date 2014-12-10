<%@ page language="java"   pageEncoding="UTF-8" import="java.util.*,com.framelib.common.CommonConstants"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	/*********PATH***********/

	String imagePath = CommonConstants.IMAGE_PATH;
%>

<ul class="fixed" >
					
							<c:forEach items="${images }" var="p">
							
								<li><a href="javascript:void(0);" onclick="selectImage('${p.imageUrl}');"><img
										src="<%=imagePath %>/${p.imageUrl}"
										width="120" height="120" /></a>
									<p>
										${p.imageSize}<br />${p.imageName}
									</p>
								</li>
							</c:forEach>
					
						</ul>
						<div class="margin12 fixed">
							
								<!-- 分页组件 -->
								<%@include file="/WEB-INF/jsps/common/paging.jsp"%>
								
								
							



						</div>