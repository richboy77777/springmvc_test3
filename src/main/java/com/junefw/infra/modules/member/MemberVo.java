package com.junefw.infra.modules.member;

public class MemberVo {
	
//	infrmember
	private String ifmmSeq;

//	infrmember Search
	private String shIfmmName;
	private Integer shIfmmDelNy;
	
	
	//---------------------
	
	public String getIfmmSeq() {
		return ifmmSeq;
	}

	public void setIfmmSeq(String ifmmSeq) {
		this.ifmmSeq = ifmmSeq;
	}

	public String getShIfmmName() {
		return shIfmmName;
	}

	public void setShIfmmName(String shIfmmName) {
		this.shIfmmName = shIfmmName;
	}

	public Integer getShIfmmDelNy() {
		return shIfmmDelNy;
	}

	public void setShIfmmDelNy(Integer shIfmmDelNy) {
		this.shIfmmDelNy = shIfmmDelNy;
	}


	
}
