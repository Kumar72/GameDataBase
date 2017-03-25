package com.toStriiing.cotrollers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.toStriiing.data.Game;
import com.toStriiing.data.GameDAO;
import com.toStriiing.data.GameDAOImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private GameDAO gamedao = new GameDAOImpl();
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="customer.do", method=RequestMethod.GET)
	public ModelAndView customerPage() {
		System.out.println("***************************************************************");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerdashboard");
		List<Game> games = gamedao.listOfGames();
		System.out.println(games);
		mv.addObject("gamelist", games);
		return mv;
	}
	
	@RequestMapping(value="vendor.do", method=RequestMethod.GET)
	public ModelAndView vendorPage() {
		System.out.println("***************************************************************");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("vendordashboard");
		
		return mv;
	}
	
	@RequestMapping(value="developer.do", method=RequestMethod.GET)
	public ModelAndView developerPage() {
		System.out.println("***************************************************************");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("developerdashboard");
		
		return mv;
	}
	
	
	
}
