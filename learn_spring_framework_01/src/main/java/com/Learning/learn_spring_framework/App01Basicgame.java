package com.Learning.learn_spring_framework;

import com.Learning.learn_spring_framework.game.Contra;
import com.Learning.learn_spring_framework.game.Gamerunner;
import com.Learning.learn_spring_framework.game.Pacman;
import com.Learning.learn_spring_framework.game.Supermario;

public class App01Basicgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supermario game = new Supermario();
		// Contra game = new Contra();
		// Pacman game = new Pacman();
		Gamerunner runner = new Gamerunner(game);
		runner.run();
	}

}
