package com.hand.Main;

import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.hand.film.FilmJDBCTemplate;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context =  new FileSystemXmlApplicationContext("ApplicationContext.xml");
		((AbstractApplicationContext) context).start();
		String film_title=null;
		String film_description = null;
		Long film_language_id = null;
		System.out.println("请输入电影名称（title）：");
		Scanner sc1 = new Scanner(System.in);
		film_title = sc1.nextLine();
		System.out.println("请输入电影描述（description）：");
		Scanner sc2 = new Scanner(System.in);
		film_description = sc2.nextLine();
		System.out.println("请输入语言ID（language_id）：");
		Scanner sc3 = new Scanner(System.in);
		film_language_id = sc3.nextLong();
		FilmJDBCTemplate filmJDBCTemplate =(FilmJDBCTemplate) context.getBean("filmJDBCTemplate");
		filmJDBCTemplate.create(film_title, film_description, film_language_id);

		
		((AbstractApplicationContext) context).stop();
		
	}
}
