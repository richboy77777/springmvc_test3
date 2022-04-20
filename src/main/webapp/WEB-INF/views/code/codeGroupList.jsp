<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<form id="formList" name="formList" method="post" action="/infra/code/codeGroupList">
	<input type="hidden" id="thisPage" name="thisPage" value="<c:out value="${vo.thisPage}" default="1"/>">
	<input type="hidden" id="ifcgSeq" name="ifcgSeq" value="<c:out value="${vo.ifcgSeq}"/>">
<%-- 	<input type="hidden" id="shIfcgDelNy" name="shIfcgDelNy" value="<c:out value="${vo.shIfcgDelNy}"/>">
 --%>	<%-- <input type="hidden" id="shOption" name="shOption" value="<c:out value="${vo.shOption}"/>"> --%>
	<%-- <input type="hidden" id="shValue" name="shValue" value="<c:out value="${vo.shValue}"/>"> --%>
	
	<select name="shIfcgDelNy" id="shIfcgDelNy">
		<option value="">::삭제여부::
		<option value="1" <c:if test="${vo.shIfcgDelNy eq 1}">selected</c:if>>Y
		<option value="0" <c:if test="${vo.shIfcgDelNy eq 0}">selected</c:if>>N
	</select> || 코드그룹이름 : <input type="text" name="shIfcgName" id="shIfcgName" value="<c:out value="${vo.shIfcgName}"/>"> 
	<select name="shOption" id="shOption">
		<option value="">::검색구분::
		<option value="1" <c:if test="${vo.shOption eq 1}">selected</c:if>>한글
		<option value="2" <c:if test="${vo.shOption eq 2}">selected</c:if>>영문
	</select> 
	<input type="text" name="shValue" id="shValue" value="<c:out value="${vo.shValue}"/>">
	 <input type="submit" id="btnSubmit" name="search"> 
	 <input type="submit" id="btnSubmit2" name="search"> 
	 <br>

	<c:choose>
		<c:when test="${fn:length(list) eq 0}">
			<tr>
				<td class="text-center" colspan="9">There is no data!</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="item" varStatus="status">

				<%-- <c:out value="${item.ifcgSeq}" /> | <a href="/infra/code/codeGroupView?ifcgSeq=<c:out value="${item.ifcgSeq}"/>&thisPage=<c:out value="${vo.thisPage}"/>&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>"><c:out value="${item.ifcgName}" /></a> | <c:out value="${item.ifcgNameEng}" /> | <c:out value="${item.ifcgDelNy}" /> --%>
				<c:out value="${item.ifcgSeq}" /> | <a href="javascript:goView(<c:out value="${item.ifcgSeq}"/>)"><c:out value="${item.ifcgName}"/></a> | <c:out value="${item.ifcgNameEng}" /> | <c:out value="${item.ifcgDelNy}" />
				<br>
	
			</c:forEach>
		</c:otherwise>
	</c:choose>

</form>

<c:out value="${vo.startPage}"/>

<%-- <nav aria-label="...">
  <ul class="pagination">
  
    <c:if test="${vo.startPage gt vo.pageNumToShow}">
                <li class="page-item"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${vo.startPage - 1}&shIfcgDelNy=<c:out value="${vo.shIfcgDelNy }"/>&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">Previous</a></li>
</c:if>
<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
	<c:choose>
		<c:when test="${i.index eq vo.thisPage}">
                <li class="page-item active"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${i.index}&shIfcgDelNy=<c:out value="${vo.shIfcgDelNy }"/>&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">${i.index}</a></li>
		</c:when>
		<c:otherwise>             
                <li class="page-item"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${i.index}&shIfcgDelNy=<c:out value="${vo.shIfcgDelNy }"/>&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">${i.index}</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>     
<c:if test="${vo.endPage ne vo.totalPages}">                
                <li class="page-item"><a class="page-link" href="/infra/code/codeGroupList?thisPage=${vo.endPage + 1}&shIfcgDelNy=<c:out value="${vo.shIfcgDelNy }"/>&shOption=<c:out value="${vo.shOption }"/>&shValue=<c:out value="${vo.shValue }"/>">Next</a></li>
</c:if> 

  </ul>
</nav> --%>

<nav aria-label="...">
  <ul class="pagination">
  
    <c:if test="${vo.startPage gt vo.pageNumToShow}">
                <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value='${vo.startPage - 1}'/>);">Previous</a></li>
</c:if>
<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
	<c:choose>
		<c:when test="${i.index eq vo.thisPage}">
                <li class="page-item active"><a class="page-link" href="javascript:goList(<c:out value='${i.index}'/>);">${i.index}</a></li>
		</c:when>
		<c:otherwise>             
                <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value='${i.index}'/>);">${i.index}</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>     
<c:if test="${vo.endPage ne vo.totalPages}">                
                <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value='${vo.endPage + 1}'/>);">Next</a></li>
</c:if> 

  </ul>
</nav>

<%-- <a href="http://localhost:8080/infra/code/codeGroupForm?thisPage=<c:out value="${vo.
}"/>&shIfcgDelNy=<c:out value="${vo.shIfcgDelNy }"/>&shOption=<c:out value="${vo.shOption}"/>&shValue=<c:out value="${vo.shValue}"/>">등록</a> --%>
<a href="javascript:goForm()">등록</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/infra/resources/js/validation.js"></script>
<script type = "text/javascript">

	$("#btnSubmit").on("click", function() {

		/* if(!checkNull($("#shIfcgName"), $("#shIfcgName").val(), "코드그룹이름을 입력해 주세요!")) return false; */ 
		if(!checkNull($("#shValue"), $("#shValue").val(), "검색어를 입력해 주세요!")) return false;
		
	});	
		
	$("#btnSubmit2").on("click", function() {
		
		alert("2번째 버튼 입니다.!")
		
	});
	
	goForm = function(){
		$("#formList").attr("action", "/infra/code/codeGroupForm");
		$("#formList").submit();
	};
	
	
	goList = function(Seq) {
		alert(Seq);
		//form 객체를 가져 온다.
		$("#thisPage").val(Seq);
		$("#formList").submit();
	}
	
	goView = function(seq) {
		alert(seq);
		$("#ifcgSeq").val(seq);
		$("#formList").attr("action", "/infra/code/codeGroupView");
		$("#formList").submit();
	}
	
	
	
		/* 		
		if($("#shIfcgName").val() == "" || $("#shIfcgName").val() == null) {
		alert("null 이다.");
		$("#shIfcgName").focus();
	}
		 */
	/* checkNull($("#shIfcgName"), $("#shIfcgName").val(), "null 이다."); */	
		
		/* alert($("#shOption").val()); */
		
		/* alert("hello javascript!!!!!");
		confirm("진짜 삭제하시겠습니까? 삭제 하시면 이후 복원이 되지 않습니다."); */
/* 		
		alert("jquery: " + $("#shIfcgName").val() );		//jquery 방식
		alert("javascript: " + document.getElementById("shIfcgName").value);		//javascript 방식
		 */

/* 		 
		/// alert($("#shIfcgDelNy").val());
		 alert($("#shIfcgName").val());
		 $("#shIfcgName").val(2);
		 alert($("#shIfcgName").val());
		 $("#shIfcgName").val("Tony");
		 alert($("#shIfcgName").val());
		// alert($("#shOption").val());
		// alert($("#shValue").val());
		 */
		
//	});
	
</script>	
