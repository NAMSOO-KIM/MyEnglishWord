package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;

public class Mywordlogin extends AbstractController{

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return new ModelAndView("/WEB-INF/views/login.jsp");
		
	}
	
	
}
