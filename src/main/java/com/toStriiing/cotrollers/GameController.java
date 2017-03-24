package com.toStriiing.cotrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.toStriiing.data.Game;
import com.toStriiing.data.GameDAO;
import com.toStriiing.data.GameDAOImpl;

public class GameController {
	private GameDAO dao = new GameDAOImpl();
	
	@RequestMapping(value="home.do")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value="getGame.do")
	public ModelAndView getGameInfoByKeyword(Game game) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		dao.getGameByKeyWord(game);
		mv.addObject("game", game);
		return mv;
	}
	
	@RequestMapping(value="addGame.do",
			method = RequestMethod.POST)
	public ModelAndView addNewGame(Game game) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		dao.addNewGameToDataBase(game);
		return mv;
	}

}
