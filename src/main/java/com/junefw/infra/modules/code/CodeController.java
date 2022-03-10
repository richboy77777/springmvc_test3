package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service;
	
	
//	infrCodeGroup
	@RequestMapping(value = "/code/codeGroupList")

	public String codeGroupList(Model model) throws Exception {

		List<Code> list = service.selectList();
		model.addAttribute("list", list);

		return "code/codeGroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupForm")

	public String codeGroupForm() throws Exception {

		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")

	public String codeGroupInst(Code dto) throws Exception {

		System.out.println();
		
//		입력 실행
		service.insert(dto);
		
		return "redirect:/code/codeFroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupView")

	public String codeGroupView(CodeVo vo, Model model) throws Exception {

		System.out.println("vo.getIfcgSeq(): " + vo.getIfcgSeq());
		
		//디비까지 가서 한 건의 데이터 값을 가지고 온다, VO
		Code rt = service.selectOne(vo);
		
		//가지고 온값을 jsp로 넘겨준다
		model.addAttribute("item", rt);
		
		return "code/codeGroupView";
	}
	
	// 수정폼이 보여지는 주소
	
	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(CodeVo vo, Model model) throws Exception {
	
		// 한건의 데이터 가져오기
		Code rt = service.selectOne(vo);
		
		model.addAttribute("rt", rt);
		
		return "/code/codeGroupForm2";
	}
	
	// 실제 수정을 하는 주소
	
	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto) throws Exception {
	
		// 수정 프로세스 실행 
		service.update(dto);
		
		return "redirect:/code/codeFroupView?ifcgSeq=" + dto.getIfcgSeq();
	}
	
//	infrCode
	
	@RequestMapping(value = "/code/codeList")

	public String codeList(Model model) throws Exception {

		List<Code> list = service.selectListCode();
		model.addAttribute("list", list);

		return "code/codeList";
	}
	
	@RequestMapping(value = "/code/codeForm")

	public String codeForm(Model model) throws Exception {
		
		List<Code> list = service.selectList();
		
		model.addAttribute("list", list);

		return "code/codeForm";
	}
	
	@RequestMapping(value = "/code/codeInst")

	public String codeInst(Code dto) throws Exception {

	
		service.insertCode(dto);
		
		return "";
	}
	
	@RequestMapping(value = "/code/codeView")

	public String codeView(CodeVo vo, Model model) throws Exception {

		
		//디비까지 가서 한 건의 데이터 값을 가지고 온다, VO
		Code rt = service.selectOneCode(vo);
		
		//가지고 온값을 jsp로 넘겨준다
		model.addAttribute("item", rt);
		
		return "code/codeView";
	}
	
	// 수정폼이 보여지는 주소
	
	@RequestMapping(value = "/code/codeForm2")
	public String codeForm2(CodeVo vo, Model model) throws Exception {
	
		// 한건의 데이터 가져오기
		Code rt = service.selectOneCode(vo);
		
		model.addAttribute("item", rt);
		
		return "/code/codeForm2";
	}
	
	// 실제 수정을 하는 주소
	
	@RequestMapping(value = "/code/codeUpdt")
	public String codeUpdt(Code dto) throws Exception {
	
		// 수정 프로세스 실행 
		service.updateCode(dto);
		
		return "";
	}
		
}