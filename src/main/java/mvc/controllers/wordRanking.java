package mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;

// to-do
// 현재 내 순위 조회(전체 회원 중 맞은 개수가 몇개인지), 구현x
public class wordRanking extends AbstractController{

	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return new ModelAndView("/WEB-INF/views/ranking.jsp");
		
	}
	
	
}
