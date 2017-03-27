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
	
	/*############## DEVELOPER CONTROLLERS BELOW ##############*/
	
	//DEV -Create
	@RequestMapping(value="AddGame.do",
			method = RequestMethod.POST)
	public ModelAndView addNewGame(Game game) {
		ModelAndView mv = new ModelAndView();
//		List<Game> games = gdao.listOfGames();
		//having problems here to view the list! 
		gdao.addNewGameToDataBase(game);
		mv.addObject("gamelist", gdao.listOfGames());
		mv.setViewName("developerdashboard");
		return mv;
	}
	
	//DEV -Read
	@RequestMapping(path="GetGameList.do", 
			method=RequestMethod.GET)
	public ModelAndView getGameList() {
//		System.out.println("in getgamelist.do");  //DEBUG
		ModelAndView mv = new ModelAndView();
		mv.addObject("gamelist", gdao.listOfGames());
		mv.setViewName("developerdashboard");
		return mv;
	}
	
	//DEV -Update
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
	
	//DEV -Delete
	@RequestMapping(value="DeleteGame.do",
			method = RequestMethod.POST)
	public ModelAndView removeGameFromDatabase(@RequestParam("id") int id) {
		gdao.deleteGame(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("developerdashboard");
		mv.addObject("gamelist", gdao.listOfGames());
		return mv;
	}	
	
	
	/*############## VENDOR CONTROLLERS BELOW ##############*/
	
	
	//VENDOR - InventoryList 
	@RequestMapping(path="GetInventoryList.do", 
			method=RequestMethod.GET)
	public ModelAndView getInventoryList() {
//		System.out.println("in getgamelist.do");	//DEBUG
		ModelAndView mv = new ModelAndView();
		System.out.println("###############"+idao.listOfGames());
		mv.addObject("invlist", idao.listOfGames());
		mv.setViewName("vendordashboard");
		return mv;
	}
	
	//VENDOR -Update
		@RequestMapping(value="ChangePrice.do",
				method = RequestMethod.POST)
		public ModelAndView changePrice(Inventory inventory) {
//			System.out.println(id);
			ModelAndView mv = new ModelAndView();
			idao.changePrice(inventory);
			mv.addObject("invlist", idao.listOfGames());
			mv.setViewName("vendordashboard");
			return mv;
		}

	//VENDOR - Buy Game From Developer
	@RequestMapping(path="GetNewGame.do",
			method=RequestMethod.GET)
	public ModelAndView getGameFromDev() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
	
	
	
	/*############## CUSTOMER CONTROLLERS BELOW ##############*/
	
	//CUSTOMER
		@RequestMapping(value="GetGameByKeyword.do")
		public ModelAndView getGameInfoByKeyword(Game game) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("customerdashboard");
			List<Game> gamesdata = cdao.getGameByKeyWord(game);
			mv.addObject("game", gamesdata);
			return mv;
		}

	
	@RequestMapping(value="BuyGame.do",
			method = RequestMethod.POST)
	public ModelAndView removeOneGameFromDatabase(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		idao.buyOneGame(id);
		mv.setViewName("customerdashboard");
//		idao.markGameAsSold(inventory);
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
