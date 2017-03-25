package com.toStriiing.cotrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.toStriiing.data.CustomerDAO;
import com.toStriiing.data.Game;
import com.toStriiing.data.GameDAO;
import com.toStriiing.data.GameDAOImpl;
import com.toStriiing.data.Inventory;
import com.toStriiing.data.InventoryDAO;
import com.toStriiing.data.InventoryDaoImpl;

public class GameController {
	private GameDAO gdao = new GameDAOImpl();
	private CustomerDAO cdao = new InventoryDaoImpl();
	private InventoryDAO idao = new InventoryDaoImpl();
	
	@RequestMapping(value="home.do")
	public String home() {
		return "home";
	}
	
	@RequestMapping(path="GetGameList.do", 
			method=RequestMethod.GET)
	public ModelAndView getGameList() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("gamelist", gdao.listOfGames());
		mv.setViewName("gamelist");
		return mv;
	}
	
	@RequestMapping(value="getGame.do")
	public ModelAndView getGameInfoByKeyword(Game game) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		cdao.getGameByKeyWord(game);
		mv.addObject("game", game);
		return mv;
	}
	
	@RequestMapping(value="AddGame.do",
			method = RequestMethod.POST)
	public ModelAndView addNewGame(Game game) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		gdao.addNewGameToDataBase(game);
		return mv;
	}
	
	// NEED TO PASS OBJECT
	@RequestMapping(value="EditGame.do",
			method = RequestMethod.POST)
	public ModelAndView editGame(@RequestParam("id")int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("developerdashboard");
		gdao.editExistingGame(id);
		return mv;
	}
	
	@RequestMapping(value="BuyGame.do",
			method = RequestMethod.POST)
	public ModelAndView removeOneGameFromDatabase(@RequestParam("id") Inventory inventory) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerdashboard");
		idao.updateByInventoryId(inventory);
//		mv.addObject("response", response); // need function in method
		return mv;
	}
	
	
//	// no method yet for removing entire game from DB - extended goal
//	@RequestMapping(value="removeGame.do",
//			method = RequestMethod.POST)
//	public ModelAndView removeGame(Game game) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("home");
//		gdao.removeGameFromDataBase(game);
//		return mv;
//	}
	

}
