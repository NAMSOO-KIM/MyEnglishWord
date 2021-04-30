package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.MemberDTO;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;
import javax.servlet.http.HttpSession;




public class MemberloginAction extends AbstractController {
	
	
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUser_id(user_id);
		memberDTO.setPassword(password);
		
		
		ModelAndView mav = new ModelAndView();
		try {
			int result =memberService.loginMember(memberDTO);
			
			if (result == 1) {

				
				session.setAttribute("user_id",user_id);
				
				mav.setViewName("redirect:home");
				mav.addObject("msg", "success");
			}
			else if(result == 0) {
				
				mav.setViewName("redirect:login");
				mav.addObject("msg", "failure");
			}
			else if(result == -1) {
				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();

			mav.addObject("msg", "글 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}