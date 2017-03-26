package com.toStriiing.cotrollers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.toStriiing.data.CustomerDAO;
import com.toStriiing.data.Game;
import com.toStriiing.data.GameDAO;
import com.toStriiing.data.GameDAOImpl;
import com.toStriiing.data.Inventory;
import com.toStriiing.data.InventoryDAO;
import com.toStriiing.data.InventoryDaoImpl;

@Controller
@SessionAttributes("currentGame")
public class GameController {
	private GameDAO gdao = new GameDAOImpl();
	private CustomerDAO cdao = new InventoryDaoImpl();
	private InventoryDAO idao = new InventoryDaoImpl();
	
	
	@RequestMapping(path="GetGameList.do", 
			method=RequestMethod.GET)
	public ModelAndView getGameList() {
		System.out.println("in getgamelist.do");
		ModelAndView mv = new ModelAndView();
		mv.addObject("gamelist", idao.listOfGames());
		mv.setViewName("developerdashboard");
		return mv;
	}
	
	@RequestMapping(value="GetGameByKeyword.do")
	public ModelAndView getGameInfoByKeyword(Game game) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerdashboard");
		List<Game> gamesdata = cdao.getGameByKeyWord(game);
		mv.addObject("game", gamesdata);
		return mv;
	}
	
	@RequestMapping(value="AddGame.do",
			method = RequestMethod.POST)
	public ModelAndView addNewGame(Game game) {
		ModelAndView mv = new ModelAndView();
		List<Game> games = gdao.listOfGames();
		mv.setViewName("developerdashboard");
		//having problems here to view the list! 
		gdao.addNewGameToDataBase(game);
		mv.addObject("gamelist", games);
		return mv;
	}
	
	// NEED TO PASS OBJECT
	@RequestMapping(value="EditGame.do",
			method = RequestMethod.POST)
	public ModelAndView editGame(Game game) {
//		System.out.println(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("developerdashboard");
		gdao.editExistingGame(game);
		mv.addObject("gamelist", gdao.listOfGames());
		return mv;
	}
	
	@RequestMapping(value="BuyGame.do",
			method = RequestMethod.POST)
	public ModelAndView removeOneGameFromDatabase(@RequestParam("id") Inventory inventory) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerdashboard");
		idao.markGameAsSold(inventory);
//		mv.addObject("response", response); // need function in method
		return mv;
	}
	
	@RequestMapping(value="DeleteGame.do",
			method = RequestMethod.POST)
	public ModelAndView removeGameFromDatabase(@RequestParam("id") int id) {
		gdao.deleteGame(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("developerdashboard");
		mv.addObject("gamelist", idao.listOfGames());
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
