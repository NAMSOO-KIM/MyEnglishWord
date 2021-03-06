package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.WordDTO;
import mvc.service.WordService;
import mvc.service.WordServiceImpl;

public class myplaceInsertAction extends AbstractController{
	
	private WordService wordService = WordServiceImpl.getInstance();
	
	
	//학습하기에서 myword로 insert 넣기
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);

		String user_id= (String)session.getAttribute("user_id");
		String word_id =request.getParameter("id");
		
		try {
			
			//List<WordDTO> list = wordService.getWordList(user_id);
			
			WordDTO wordDTO = wordService.getWord(Integer.parseInt(word_id));
			
			wordService.insertMyWord(user_id, wordDTO);
			System.out.println("성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
