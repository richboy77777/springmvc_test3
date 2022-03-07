package com.junefw.infra.modules.code;

import java.util.List;

import com.junefw.infra.modules.member.Member;

public interface CodeService {
	
	public List<Code> selectList() throws Exception; 
	
	public int insert(Code dto) throws Exception;
	
	public Code selectOne(CodeVo vo) throws Exception;
	
	public int update(Code dto) throws Exception;
}