package com.Learning.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Learning.learn_spring_framework.game.Contra;
import com.Learning.learn_spring_framework.game.Gamerunner;
import com.Learning.learn_spring_framework.game.GamingConsole;
import com.Learning.learn_spring_framework.game.Pacman;
import com.Learning.learn_spring_framework.game.Supermario;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
//			Pacman game = new Pacman();
//			Supermario game =  new Supermario();
		Contra game = new Contra();
		;
		return game;
	}

	@Bean
	public Gamerunner gamerunner(GamingConsole game) {
		Gamerunner gamerunner = new Gamerunner(game);
		return gamerunner;
	}

}
