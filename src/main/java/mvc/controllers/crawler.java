package mvc.controllers;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import mvc.fx.AbstractController;
import mvc.fx.ModelAndView;
import mvc.models.WordDTO;
import mvc.service.CrawlerService;
import mvc.service.CrawlerServiceImpl;
import mvc.service.WordService;
import mvc.service.WordServiceImpl;


//@WebServlet("/crawling")
public class crawler extends AbstractController {
	
	

	CrawlerService crawlerservice = CrawlerServiceImpl.getInstance();
	
	
	
	
	@Override
	public ModelAndView handleRquestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		String user_id = (String)session.getAttribute("user_id");
		ModelAndView mav = new ModelAndView();	
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
			
			Calendar cal = Calendar.getInstance();
			for(int i=1; i<=300; i++) {
				
				cal.add(Calendar.DATE, -1);

				String timedate= format.format(cal.getTime());
			
				crawlerservice.insert("https://learn.dict.naver.com/endic/today/words.nhn?targetDate="+timedate,user_id);
				
			}

			
			mav.setViewName("redirect:home");
			
		} catch (Exception e) {
			e.printStackTrace();

			mav.addObject("msg", "왜 안되지?");
			mav.addObject("url", "javascript:history.back();");
		}
		
		mav.setViewName("redirect:home");
			
		return mav;
	}

}
