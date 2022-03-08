package com.junefw.infra.modules.code;

import java.util.List;

import com.junefw.infra.modules.member.Member;

public interface CodeService {
	
//	infrCodeGroup
	public List<Code> selectList() throws Exception; 
	public int insert(Code dto) throws Exception;
	public Code selectOne(CodeVo vo) throws Exception;
	public int update(Code dto) throws Exception;
	
//	infrCode
	public List<Code> selectListCode() throws Exception; 
	public int insertCode(Code dto) throws Exception;
	public Code selectOneCode(CodeVo vo) throws Exception;
	public int updateCode(Code dto) throws Exception;
}