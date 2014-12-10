<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="currentPage" value="${po.currentPage}" />
<c:set var="pagesize" value="${po.pageSize}" />
<c:set var="count" value="${po.totalCount}" />
<c:set var="formName" value="${param.formName}" />
<c:set var="allpage" value="${po.totalPage}" />
<input type="hidden" id="pagenum" name="pagenum" value="${currentPage}" />
<div class="yahoo">
	<c:choose>
		<c:when test="${currentPage==1}">
			<span class="disabled"> < </span>
		</c:when>
		<c:otherwise>
			<a href="javascript:goTo_${formName}(${currentPage-1})"> < </a>
		</c:otherwise>
	</c:choose>
	<c:set var="begin" value="1" />
	<c:if test="${allpage <= 10}">
		<c:forEach begin="${begin}" end="${allpage}" var="i">
			<c:choose>
				<c:when test="${currentPage==i}">
					<span class="current">${i}</span>
				</c:when>
				<c:otherwise>
					<a href="javascript:goTo_${formName}(${i})">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:if>
	<c:if test="${allpage > 10}">
		<c:if test="${currentPage > 4}">
			<c:set var="begin" value="${currentPage-4}" />
		</c:if>
		<c:choose>
			<c:when test="${currentPage+5 < allpage}">
				<c:forEach begin="${begin}" end="${currentPage+5}" var="i">
					<c:choose>
						<c:when test="${currentPage==i}">
							<span class="current">${i}</span>
						</c:when>
						<c:otherwise>
							<a href="javascript:goTo_${formName}(${i})">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<span>...</span>
			</c:when>
			<c:otherwise>
				<c:forEach begin="${begin}" end="${allpage}" var="i">
					<c:choose>
						<c:when test="${currentPage==i}">
							<span class="current">${i}</span>
						</c:when>
						<c:otherwise>
							<a href="javascript:goTo_${formName}(${i})">${i}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:choose>
		<c:when test="${currentPage>=allpage}">
			<span class="disabled"> > </span>
		</c:when>
		<c:otherwise>
			<a href="javascript:goTo_${formName}(${currentPage+1})"> > </a>
		</c:otherwise>
	</c:choose>

	<span>共${allpage}页 ,去第</span>
	<input value="${currentPage}" id="_enterNum" type="text" />
	<a href="javascript:jumpTo_${formName}();" class="go">GO</a>
</div>
<script language="javascript">
	function jumpTo_${formName}(){
		$("#pagenum").val($("#_enterNum").val());
		document.${formName}.submit();
	}
	function goTo_${formName}(num){
		$("#pagenum").val(num);
		document.${formName}.submit();
	}
	$("#_enterNum").bind('keydown', function(event) {
		if (event.keyCode == 13) {
			jumpTo_${formName}();
			event.preventDefault();
		}
	});
</script>