package com.toStriiing.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class GameDAOImpl implements GameDAO {
	private static final String DATA_FILE = "/WEB-INF/game.csv";
	private List<Game> games = new ArrayList<>();
	private ServletContext context;

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		try (InputStream is = wac.getServletContext().getResourceAsStream(DATA_FILE);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line =buf.readLine();
			
			while((line=buf.readLine()) != null) {
				String[] input = line.split(", ");
				int id =Integer.parseInt(input[0]);
				String name = input[1];
				String description = input[2];
				String genre = input[3];
				double msrp = Double.parseDouble(input[4]);
				String rating = input[5];
				int vendorId = Integer.parseInt(input[6]);
				
				
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public void addNewGameToDataBase(Game game) {

	}

	@Override
	public Game editExistingGame(Game name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeGameFromDataBase(Game name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Game getGameByKeyWord(Game name) {
		// TODO Auto-generated method stub
		return null;
	}

}
