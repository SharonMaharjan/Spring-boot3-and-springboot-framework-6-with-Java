package com.in28minutes.learnspringframework.gale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;

@Configuration 
public class GamingConfiguration {
	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
		
	}
	
	@Bean
	public GamingConsole game() {
		var game = new GameRunner();
		return game;
		
	}
	//var game = new PacmanGame();
	//var gameRunner = new GameRunner(game);
	//gameRunner.run();

}
