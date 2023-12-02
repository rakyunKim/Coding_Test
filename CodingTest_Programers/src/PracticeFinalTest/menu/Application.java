package PracticeFinalTest.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		List<String> menu = new ArrayList<>();
		menu.add("우동");
		menu.add("규동");
		menu.add("덮밥");
		menu.add("스시");
		menu.add("초밥");
		menu.add("계란");
		System.out.println(menu);
		Collections.shuffle(menu);
		System.out.println(menu);
	}
}
