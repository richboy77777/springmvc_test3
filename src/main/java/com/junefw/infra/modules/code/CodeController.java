package com.junefw.infra.modules.code;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {


	@Autowired
	CodeServiceImpl service;

//	infrCodeGroup
	@RequestMapping(value = "/code/codeGroupList")	// codeGroupList에서 form 부분을 post로 바꾼뒤 GET은 화면자체는 출력됨 다만 제출하면 POST 방식이 아니라서 오류뜸
																				// POST로 할 경우 처음부터 codeGroupList url 안먹힘 홈페이지 통째로 post 처리되서 접속불가임
																				// method = RequestMethod.GET, method = RequestMethod.POST
	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
								//@ModelAttribute는 jsp로 보내는 vo 옆에 CodeVo오는 여기 코드그룹리스트에 사용하는 vo
		// count 가져올 것
		int count = service.selectOneCount(vo);
		
		vo.setParamsPaging(count);

		// count가 0이 아니면 list 가져오는 부분 수행후 model 개체에 담기
		if (count != 0) {
			List<Code> list = service.selectList(vo);

			model.addAttribute("list", list);
		} else {
			// by pass
		}

		//@ModelAttribute("vo", vo); 	위에 @ModelAttribute("vo") 안적고 밑에 빼서 적어도 결과값은 동일함 개발자성향차이임 
		
		return "code/codeGroupList";
	}

	@RequestMapping(value = "/code/codeGroupForm")

	public String codeGroupForm(@ModelAttribute("vo") CodeVo vo) throws Exception {

		return "code/codeGroupForm";
	}

	@RequestMapping(value = "/code/codeGroupInst")

	public String codeGroupInst(Code dto, CodeVo vo) throws Exception {

		
		  MultipartFile multipartFile = dto.getFile();
		  
		  String fileName = multipartFile.getOriginalFilename(); String ext =
		  fileName.substring(fileName.lastIndexOf(".") + 1); //입실1
		  String uuid = UUID.randomUUID().toString(); String uuidFileName = uuid + "." + ext;
		  
		  multipartFile.transferTo(new File(
		  "C:/factory/ws_sts_4130/springmvc_test3/src/main/webapp/resources/uploaded/"
		  + uuidFileName));
		 
		
		System.out.println("dto.getIfcgSeq(): " + dto.getIfcgSeq());  //null

//		입력 실행
		
		dto.setOriginalFileName(fileName);
		dto.setUuidFileName(uuidFileName);
		service.insert(dto);
	

		System.out.println("dto.getIfcgSeq(): " + dto.getIfcgSeq());  // 추가된 갯수나옴
		
//		return "redirect:/code/codeGroupList";
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq();
//		return "redirect:/code/codeGroupList?ifcgSeq=" + dto.getIfcgSeq() + "&thisPage=" + vo.getThisPage() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue();
		return "redirect:/code/codeGroupList?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
	}
	
	
	  public String makeQueryString(CodeVo vo) { 
	  String tmp = "&thisPage=" + vo.getThisPage() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue(); 
	  return tmp; 
	  }
	 

	@RequestMapping(value = "/code/codeGroupView")

	public String codeGroupView(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		System.out.println("#####################################");
		System.out.println("vo.getShOption(): " +vo.getShOption());
		System.out.println("vo.getShValue(): " + vo.getShValue());
		System.out.println("vo.getThisPage(): " + vo.getThisPage());
		System.out.println("vo.getIfcgSeq(): " + vo.getIfcgSeq());
		System.out.println("#####################################");

		// 디비까지 가서 한 건의 데이터 값을 가지고 온다, VO
		Code rt = service.selectOne(vo);

		// 가지고 온값을 jsp로 넘겨준다
		model.addAttribute("item", rt);

		return "code/codeGroupView";
	}

	// 수정폼이 보여지는 주소

	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {

		// 한건의 데이터 가져오기
		Code rt = service.selectOne(vo);

		model.addAttribute("rt", rt);

		return "/code/codeGroupForm2";
	}

	// 실제 수정을 하는 주소

	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto, CodeVo vo) throws Exception {

		// 수정 프로세스 실행
		service.update(dto);


//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + "&thisPage=" + vo.getThisPage() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue();
		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo);
	}
	
	@RequestMapping(value = "/code/codeGroupDele")
	public String codeGroupDele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {

		service.delete(vo);
		
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());
		redirectAttributes.addAttribute("shOption", vo.getShOption());
		redirectAttributes.addAttribute("shValue", vo.getShValue());

		return "redirect:/code/codeGroupList";
	}
	
	@RequestMapping(value = "/code/codeGroupNele")
	public String codeGroupNele(CodeVo vo, RedirectAttributes redirectAttributes) throws Exception {
		
		service.updateDelete(vo);
		
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());
		redirectAttributes.addAttribute("shOption", vo.getShOption());
		redirectAttributes.addAttribute("shValue", vo.getShValue());
		
		return "redirect:/code/codeGroupList";
	}
	
//	infrCode

	@RequestMapping(value = "/code/codeList")

	public String codeList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		List<Code> listCodeGroup = service.selectList(vo);
		model.addAttribute("listCodeGroup", listCodeGroup);
		
		int Codecount = service.selectOneCodeCount(vo);
		
		vo.setParamsPaging(Codecount);
		
		if(Codecount != 0) {
		List<Code> list = service.selectListCode(vo);
		model.addAttribute("list", list);
		
		} else {
			//by pass
		}
		
		return "code/codeList";
	}

	@RequestMapping(value = "/code/codeForm")

	public String codeForm(CodeVo vo, Model model) throws Exception {

		List<Code> listCodeGroup = service.selectList(vo);
		model.addAttribute("listCodeGroup", listCodeGroup);

		return "code/codeForm";
	}

	@RequestMapping(value = "/code/codeInst")

	public String codeInst(Code dto) throws Exception {

		service.insertCode(dto);

		return "redirect:/code/codeList";
	}

	@RequestMapping(value = "/code/codeView")

	public String codeView(CodeVo vo, Model model) throws Exception {

		// 디비까지 가서 한 건의 데이터 값을 가지고 온다, VO
		Code rt = service.selectOneCode(vo);

		// 가지고 온값을 jsp로 넘겨준다
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

		return "redirect:/code/codeView?ifcdSeq=" + dto.getIfcdSeq();
	}

}