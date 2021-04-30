package mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.WordDTO;
import mvc.service.WordService;
import mvc.service.WordServiceImpl;

public class wordPractice extends AbstractController{
	
	private WordService wordService = WordServiceImpl.getInstance();
	
	
	//학습하기
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);

		ModelAndView mav = new ModelAndView();
		//String user_id= (String)session.getAttribute("user_id");
		
		
		try {
			List<WordDTO> list = wordService.getWordList();
			
			
			mav.setViewName("/WEB-INF/views/practice.jsp");

			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	
}
