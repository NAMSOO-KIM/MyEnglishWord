package mvc.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.WordDTO;
import mvc.service.WordService;
import mvc.service.WordServiceImpl;

public class wordInsertAction extends AbstractController {
	
	WordService wordService = WordServiceImpl.getInstance();
	
	
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		String english = request.getParameter("english");
		String answer = request.getParameter("answer");

		WordDTO wordDTO = new WordDTO();
		
		wordDTO.setQuestion(english);
		wordDTO.setAnswer(answer);
		
		
		
		ModelAndView mav = new ModelAndView();
		try {
			wordService.insertWord(wordDTO);
			mav.setViewName("redirect:list");
			

		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "글 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}