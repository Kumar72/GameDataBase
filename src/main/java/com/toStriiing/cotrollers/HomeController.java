package com.toStriiing.cotrollers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		List<Game> games = gamedao.listOfGames();
		System.out.println(games);
		mv.addObject("gamelist", games);
		mv.setViewName("customerdashboard");
		return mv;
	}
	
	@RequestMapping(value="vendor.do", method=RequestMethod.GET)
	public ModelAndView vendorPage() {
		System.out.println("***************************************************************");
		List<Game> games = gamedao.listOfGames();
		System.out.println(games);
		ModelAndView mv = new ModelAndView();
		mv.addObject("gamelist", games);
		mv.setViewName("vendordashboard");
		return mv;
	}
	
	@RequestMapping(value="developer.do", method=RequestMethod.GET)
	public ModelAndView developerPage() {
		System.out.println("***************************************************************");
		ModelAndView mv = new ModelAndView();
		List<Game> games = gamedao.listOfGames();
		System.out.println(games);
		mv.addObject("gamelist", games);
		mv.setViewName("developerdashboard");
		return mv;
	}
	
	@RequestMapping(value="addform.do", method=RequestMethod.POST)
	public ModelAndView addForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addgame");
		return mv;
	}
	
	@RequestMapping(value="editform.do", method=RequestMethod.POST)
	public ModelAndView editForm(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Game g = gamedao.getGameById(id);
		mv.setViewName("editgame");
		mv.addObject("game", g);
		return mv;
	}
	
}
