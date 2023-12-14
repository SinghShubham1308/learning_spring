package com.Learning.learn_spring_framework.game;

public class Supermario implements GamingConsole {
	
	public String top() {
		return "jump";
	}

	public String left() {
		return "run forward";
	}

	public String right() {
		return "run backward";
	}

	public String bottom() {
		return "crouch";
	}
}
