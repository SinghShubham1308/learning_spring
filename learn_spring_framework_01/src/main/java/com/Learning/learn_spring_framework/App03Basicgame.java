package com.Learning.learn_spring_framework;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Learning.learn_spring_framework.game.Contra;
import com.Learning.learn_spring_framework.game.Gamerunner;
import com.Learning.learn_spring_framework.game.GamingConsole;
import com.Learning.learn_spring_framework.game.Pacman;
import com.Learning.learn_spring_framework.game.Supermario;

public class App03Basicgame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
			System.out.println(context.getBean(GamingConsole.class));

			context.getBean(Gamerunner.class).run();

		}

	}

}
