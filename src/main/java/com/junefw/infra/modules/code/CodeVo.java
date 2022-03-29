package com.junefw.infra.modules.code;

public class CodeVo {

	// VO
//	infrCodeGroup
	private String ifcgSeq;

//	infrCodeGroup Search
	private String shIfcgName;
	private Integer shIfcgDelNy;

//	infrCode
	private String ifcdSeq;

//	infrCode Search
	private String shIfcgSeq;

//	common
	private String shOption;
	private String shValue;

//	paging
	private Integer thisPage = 1; // 현재 페이지
	private Integer rowNumToShow = 10; // 화면에 보여줄 데이터 줄 갯수
	private Integer pageNumToShow = 5; // 화면에 보여줄 페이징 번호 갯수

	private Integer totalRows; // 전체 데이터 갯수
	private Integer totalPages; // 전체 페이지 번호
	private Integer startPage; // 시작 페이지 번호
	private Integer endPage; // 마지막 페이지 번호

	private Integer startRnumForOracle = 1; // 쿼리 시작 row
	private Integer endRnumForOracle; // 쿼리 끝 row
	private Integer RNUM;

	private Integer startRnumForMysql = 0; // 쿼리 시작 row

	// ----------------

	public void setParamsPaging(Integer totalRowsParam) {

		totalRows = totalRowsParam;

		totalPages = totalRows / rowNumToShow;

		if (totalRows % rowNumToShow > 0) {
			totalPages = totalPages + 1;
		}

		if (totalPages < thisPage) {
			thisPage = totalPages;
		}

		startPage = (((thisPage - 1) / pageNumToShow) * pageNumToShow + 1);

		endPage = (startPage + pageNumToShow - 1);

		if (endPage > totalPages) {
			endPage = (totalPages);
		}

		endRnumForOracle = ((rowNumToShow * thisPage));
		startRnumForOracle = ((endRnumForOracle - rowNumToShow) + 1);
		if (startRnumForOracle < 1)
			startRnumForOracle = 1;

		if (thisPage == 1) {
			startRnumForMysql = 0;
		} else {
			startRnumForMysql = ((rowNumToShow * (thisPage - 1)));
		}

		System.out.println("getThisPage():" + thisPage);
		System.out.println("getTotalRows():" + totalRows);
		System.out.println("getRowNumToShow():" + rowNumToShow);
		System.out.println("getTotalPages():" + totalPages);
		System.out.println("getStartPage():" + startPage);
		System.out.println("getEndPage():" + endPage);
		System.out.println("getStartRnumForOracle():" + startRnumForOracle);
		System.out.println("getEndRnumForOracle():" + endRnumForOracle);
		System.out.println("getStartRnumForMysql(): " + startRnumForMysql);

	}

	public String getIfcgSeq() {
		return ifcgSeq;
	}

	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}

	public String getShIfcgName() {
		return shIfcgName;
	}

	public void setShIfcgName(String shIfcgName) {
		this.shIfcgName = shIfcgName;
	}

	public Integer getShIfcgDelNy() {
		return shIfcgDelNy;
	}

	public void setShIfcgDelNy(Integer shIfcgDelNy) {
		this.shIfcgDelNy = shIfcgDelNy;
	}

	public String getIfcdSeq() {
		return ifcdSeq;
	}

	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}

	public String getShIfcgSeq() {
		return shIfcgSeq;
	}

	public void setShIfcgSeq(String shIfcgSeq) {
		this.shIfcgSeq = shIfcgSeq;
	}

	public String getShOption() {
		return shOption;
	}

	public void setShOption(String shOption) {
		this.shOption = shOption;
	}

	public String getShValue() {
		return shValue;
	}

	public void setShValue(String shValue) {
		this.shValue = shValue;
	}

	public Integer getThisPage() {
		return thisPage;
	}

	public void setThisPage(Integer thisPage) {
		this.thisPage = thisPage;
	}

	public Integer getRowNumToShow() {
		return rowNumToShow;
	}

	public void setRowNumToShow(Integer rowNumToShow) {
		this.rowNumToShow = rowNumToShow;
	}

	public Integer getPageNumToShow() {
		return pageNumToShow;
	}

	public void setPageNumToShow(Integer pageNumToShow) {
		this.pageNumToShow = pageNumToShow;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getStartRnumForOracle() {
		return startRnumForOracle;
	}

	public void setStartRnumForOracle(Integer startRnumForOracle) {
		this.startRnumForOracle = startRnumForOracle;
	}

	public Integer getEndRnumForOracle() {
		return endRnumForOracle;
	}

	public void setEndRnumForOracle(Integer endRnumForOracle) {
		this.endRnumForOracle = endRnumForOracle;
	}

	public Integer getRNUM() {
		return RNUM;
	}

	public void setRNUM(Integer rNUM) {
		RNUM = rNUM;
	}

	public Integer getStartRnumForMysql() {
		return startRnumForMysql;
	}

	public void setStartRnumForMysql(Integer startRnumForMysql) {
		this.startRnumForMysql = startRnumForMysql;
	}

}