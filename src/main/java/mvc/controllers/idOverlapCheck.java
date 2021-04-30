package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.MemberDTO;
import mvc.service.MemberService;
import mvc.service.MemberServiceImpl;

public class idOverlapCheck extends AbstractController {
	
	
	MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		
		String user_id = request.getParameter("user_id");
		
		return new ModelAndView("/WEB-INF/views/home.jsp");
	}

}