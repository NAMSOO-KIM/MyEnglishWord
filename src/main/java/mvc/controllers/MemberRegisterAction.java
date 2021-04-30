package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.MemberDTO;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;

//회원 등록
public class MemberRegisterAction extends AbstractController {
	
	
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id(user_id);
		memberDTO.setPassword(password);
		memberDTO.setName(name);
		
		
		ModelAndView mav = new ModelAndView();
		try {
			memberService.insertMember(memberDTO);
			mav.setViewName("redirect:login");
			mav.addObject("msg", "success");

		} catch (Exception e) {
			e.printStackTrace();

			mav.addObject("msg", "글 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}