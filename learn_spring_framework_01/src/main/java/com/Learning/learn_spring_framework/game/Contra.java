package com.Learning.learn_spring_framework.game;

public class Contra implements GamingConsole {
	
	public String top() {
		return "jump";
	}

	public String left() {
		return "fire";
	}

	public String right() {
		return "stop";
	}

	public String bottom() {
		return "prone";
	}
}
