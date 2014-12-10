<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${allCount>0}">
	<div class="yahoo">
		<c:if test="${currentPage > 1}">
			<a href="javascript:toShowPage(${currentPage-1});">&lt; </a>
		</c:if>
		<c:if test="${currentPage <= 1}">
			<span class="disabled"> &lt; </span>
		</c:if>
		<c:if test="${currentPage<=5}">
			<c:forEach var="i" begin="1" end="${10}" step="1">
				<c:if test="${i<=allPage}">
					<c:if test="${currentPage==i}">
						<span class="current">${currentPage}</span>
					</c:if>
					<c:if test="${currentPage!=i}">
						<a href="javascript:toShowPage(${i});">${i}</a>
					</c:if>
				</c:if>
			</c:forEach>
		</c:if>

		<c:if test="${currentPage>5}">
			<c:forEach var="i" begin="${currentPage-5}" end="${currentPage+5}"
				step="1">
				<c:if test="${i<=allPage}">
					<c:if test="${currentPage==i}">
						<span class="current">${currentPage}</span>
					</c:if>
					<c:if test="${currentPage!=i}">
						<a href="javascript:toShowPage(${i});">${i}</a>
					</c:if>
				</c:if>
			</c:forEach>
		</c:if>





		<c:if test="${currentPage < allPage}">
			<a href="javascript:toShowPage(${currentPage+1});">&gt; </a>
		</c:if>
		<c:if test="${currentPage >= allPage}">
			<span class="disabled"> &gt; </span>
		</c:if>
		<input type="hidden" id="hidden_allPage" value="${allPage}" />
		共${allPage}页,${allCount}张图片 ,去第 <input name="" type="text" style="color: #000000;font-size:10px" id="currentPage" /> 页
		<a href="javascript:toThisPage(${allPage});" class="go">GO</a>
	</div>
</c:if>
