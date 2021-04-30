package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.MemberDTO;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;
import mvc.service.WordService;
import mvc.service.WordServiceImpl;

public class home  extends AbstractController{

	
	MemberService memberService = MemberServiceImpl.getInstance();
	WordService wordService = WordServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		// 세션 객체 받아서 처리
		HttpSession session = request.getSession(true);
		
		MemberDTO memberDTO = new MemberDTO();
		String user_id = (String)session.getAttribute("user_id");
		
		memberDTO.setUser_id(user_id);
		
	
		
		try {
			
			String result = wordService.getWordCount();
			session.setAttribute("word_result", result);
			

		} catch (Exception e) {
			e.printStackTrace();

			
		}
		
		
		return new ModelAndView("/WEB-INF/views/home.jsp");
		
	}
	
}
