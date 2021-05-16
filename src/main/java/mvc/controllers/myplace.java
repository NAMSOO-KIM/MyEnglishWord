package mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.MyWordDTO;
import mvc.service.WordService;
import mvc.service.WordServiceImpl;

public class myplace extends AbstractController {
	private WordService wordService = WordServiceImpl.getInstance();
	
	// to-do
	// 내 단어 확인(미완성)
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {

		// 세션 객체 받아서 처리
		HttpSession session = request.getSession(true);
		
		
		String user_id = (String)session.getAttribute("user_id");
		ModelAndView mav = new ModelAndView();
		
		try {

			//List<WordDTO> list = wordService.getWordList();
			
			//List<WordDTO> list = wordService.getWordList(user_id);
			List<MyWordDTO> list = wordService.getWordList(user_id);
			System.out.println("myplace 오냐");
			mav.setViewName("/WEB-INF/views/mywordpage.jsp");
			mav.addObject("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
		
}
