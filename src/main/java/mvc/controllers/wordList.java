package mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;

import mvc.models.WordDTO;

import mvc.service.WordService;
import mvc.service.WordServiceImpl;

// to-do
// 틀린문제 확인 ( 퀴즈에서 틀린 단어를 확인할 수 있도록)

public class wordList extends AbstractController {
	private WordService wordService = WordServiceImpl.getInstance();
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
	
		
		ModelAndView mav = new ModelAndView();
		
		
		try {
			List<WordDTO> list = wordService.getWordList();
			
			mav.setViewName("/WEB-INF/views/exam.jsp");
			mav.addObject("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
		
}
