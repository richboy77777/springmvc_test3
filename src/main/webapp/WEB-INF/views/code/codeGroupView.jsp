<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>


<form id="formView" name="formView" method="post" action="/infra/code/codeGroupView">
	<input type="hidden" id="thisPage" name="thisPage" value="<c:out value="${vo.thisPage}"/>">
	<input type="hidden" id="ifcgSeq" name="ifcgSeq" value="<c:out value="${vo.ifcgSeq}"/>">
	<input type="hidden" id="shIfcgDelNy" name="shIfcgDelNy" value="<c:out value="${vo.shIfcgDelNy}"/>">
	<input type="hidden" id="shIfcgName" name="shIfcgName" value="<c:out value="${vo.shIfcgName}"/>">
	<input type="hidden" id="shOption" name="shOption" value="<c:out value="${vo.shOption}"/>">
	<input type="hidden" id="shValue" name="shValue" value="<c:out value="${vo.shValue}"/>">

<c:out value="${item.ifcgSeq}"/> | <c:out value="${item.ifcgName}"/> | <c:out value="${item.ifcgDelNy}"/> <br>

<%-- <a href="/infra/code/codeGroupList?thisPage=<c:out value="${vo.thisPage}"/>&shOption=<c:out value="${vo.shOption}"/>&shValue=<c:out value="${vo.shValue}"/>">목록</a> --%>
<a href="javascript:goList()">목록</a>
<%-- <a href="/infra/code/codeGroupForm2?ifcgSeq=<c:out value="${item.ifcgSeq}"/>&thisPage=<c:out value="${vo.thisPage}"/>&shOption=<c:out value="${vo.shOption}"/>&shValue=<c:out value="${vo.shValue}"/>">수정</a> --%>
<a href="javascript:goEdit()">수정</a>
<a href="/infra/code/codeGroupDele?ifcgSeq=<c:out value="${item.ifcgSeq}"/>" id="btnDelete">삭제(진짜)</a>
<a href="/infra/code/codeGroupNele?ifcgSeq=<c:out value="${item.ifcgSeq}"/>" id="btnupdateDelete">삭제(가짜)</a>

</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script type="text/javascript">
$("#btnDelete").on("click", function() {
	var answer = confirm ('삭제 하시겠습니까?');
	
	if(answer) {
		// /infra/code/codeGroupDele 이동
	} else {
		return false;
	}
});	

$("#btnupdateDelete").on("click", function() {
	var answer = confirm ('삭제 하시겠습니까?');
	
	if(answer) {
		
	} else {
		return false;
	}
});	


</script>