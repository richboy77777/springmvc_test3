package com.junefw.infra.modules.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.junefw.infra.modules.code.Code;
import com.junefw.infra.modules.code.CodeVo;

@Controller
public class MemberController {

	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping(value = "/member/memberList")
//	public String memberList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
	public String memberList(MemberVo vo, Model model) throws Exception {

		List<Member> list = service.selectList(vo);
		model.addAttribute("list", list);

		return "member/memberList";
	}
	
	@RequestMapping(value = "/member/memberForm")
	public String memberForm(MemberVo vo, Model model) throws Exception {
		
		List<Member> list = service.selectList(vo);
		model.addAttribute("list", list);
		
		
		return "member/memberForm";
	}
	
	@RequestMapping(value = "/member/memberInst")
	public String memberInst(Model model, Member dto) throws Exception {
		
		System.out.println("dto.getIfmmId(): " + dto.getIfmmId());
		System.out.println("dto.getIfmmName(): " + dto.getIfmmName());

		// 입력을 작동시킨다.
		int result = service.insert(dto);
		
		System.out.println("result: " + result);

		return "redirect:/member/memberList";
	}
	
	@RequestMapping(value = "/member/memberView")
	public String memberView(MemberVo vo, Model model) throws Exception {

		//디비까지 가서 한 건의 데이터 값을 가지고 온다, VO
		Member rt = service.selectOne(vo);
		
		//가지고 온값을 jsp로 넘겨준다
		model.addAttribute("item", rt);
		
		return "member/memberView";
	}
	
	@RequestMapping(value = "/member/memberForm2")
	public String memberForm2(MemberVo vo, Model model) throws Exception {
	
		// 한건의 데이터 가져오기
		Member rt = service.selectOne(vo);
		
		model.addAttribute("item", rt);
		
		return "/member/memberForm2";
	}
	
	@RequestMapping(value = "/member/memberUpdt")
	public String memberUpdt(Member dto) throws Exception {
	
		// 수정 프로세스 실행 
		service.update(dto);
		
		return "redirect:/member/memberView?ifmmSeq=" + dto.getIfmmSeq();
	}
	
	
	
}