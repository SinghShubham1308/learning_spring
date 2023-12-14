package com.Learning.learn_spring_framework.game;

public class Gamerunner {
	GamingConsole gameConsole;

	public Gamerunner(GamingConsole game) {

		this.gameConsole = game;
	}

	public void run() {
		System.out.println("running game " + gameConsole);
		System.out.println(gameConsole.bottom());
		System.out.println(gameConsole.left());
		System.out.println(gameConsole.right());
		System.out.println(gameConsole.top());
	}
}
