package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	CodeDao dao;

	//	insert, update, delete 는 컨트롤러가 아니라 서비스 임플에 작성함!!! 이유는 다음주월요일(3월 21일)에 공개함
	
	// infrCodeGroup

	@Override
	public int selectOneCount(CodeVo vo) throws Exception {
		return dao.selectOneCount(vo);
	}

	@Override
	public List<Code> selectList(CodeVo vo) throws Exception {

		return dao.selectList(vo);
	}

	@Override
	public int insert(Code dto) throws Exception {
		dao.insert(dto);	// ifcgName, ifcdName
		dao.insertCode(dto);	//ifcgName, ifcdName, ifcgSeq
		return 1;
	}

	@Override
	public Code selectOne(CodeVo vo) throws Exception {

		return dao.selectOne(vo);
	}

	@Override
	public int update(Code dto) throws Exception {

		return dao.update(dto);
	}

//	infrCode
	
	@Override
	public int selectOneCodeCount(CodeVo vo) throws Exception {
		return dao.selectOneCodeCount(vo);
	}
	
	@Override
	public List<Code> selectListCode(CodeVo vo) throws Exception {
		return dao.selectListCode(vo);
	}

	@Override
	public int insertCode(Code dto) throws Exception {
		return dao.insertCode(dto);
	}

	@Override
	public Code selectOneCode(CodeVo vo) throws Exception {
		return dao.selectOneCode(vo);
	}

	@Override
	public int updateCode(Code dto) throws Exception {
		return dao.updateCode(dto);
	}



}