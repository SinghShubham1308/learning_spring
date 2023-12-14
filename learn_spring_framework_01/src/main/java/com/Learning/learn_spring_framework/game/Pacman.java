package com.Learning.learn_spring_framework.game;

public class Pacman implements GamingConsole {
	
	public String top() {
		return "move up";
	}

	public String left() {
		return "move left";
	}

	public String right() {
		return "move right";
	}

	public String bottom() {
		return "move down";
	}
}
