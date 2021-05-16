package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.service.WordService;
import mvc.service.WordServiceImpl;

public class myplaceDeleteAction extends AbstractController{
	
	private WordService wordService = WordServiceImpl.getInstance();
	
	
	//Delete
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		//HttpSession session = request.getSession(true);

		//String user_id= (String)session.getAttribute("user_id");
		String word_id =request.getParameter("id");
		
		ModelAndView mav = new ModelAndView();
		
		try {
			
			wordService.deleteMyWord(Long.parseLong(word_id));
			mav.setViewName("redirect:myplace");
			System.out.println("성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
		//return null;
	}
	
}
