package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;

public class wordExam extends AbstractController{

	// to-do
	// 단어 퀴즈(미완성)
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return new ModelAndView("/WEB-INF/views/exam.jsp");
		
	}
	
	
}
