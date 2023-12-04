package PracticeFinalTest.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoachMenus {
	Random random;
	String[] inedibleMenus;
	Menu menu;
	String name;
	List<String> recommendedMenu;
	List<String> menuCategory;
	public CoachMenus(String name, String inedibleMenu, MakeCategory category){
		menu = new Menu();
		random = new Random();
		this.name = name;
		this.inedibleMenus = makeInedibleMenuToArray(inedibleMenu);
		this.recommendedMenu = new ArrayList<>();
		menuCategory = category.getMenuCategory();
		List<List<String>> menus = checkCategory(menuCategory, menu);
		for (List<String> m : menus){
			makeMenu(m);
		}
	}

	private List<List<String>> checkCategory(List<String> menuCategory, Menu menu) {
		List<List<String>> menus = new ArrayList<>();
		menuCategory.forEach(i -> {
			if (i.equals("일식")) menus.add(menu.japan);
			if (i.equals("한식")) menus.add(menu.korea);
			if (i.equals("중식")) menus.add(menu.china);
			if (i.equals("아시안")) menus.add(menu.asia);
			if (i.equals("양식")) menus.add(menu.western);
		});
		return menus;
	}

	private String[] makeInedibleMenuToArray(String inedibleMenu) {
		return inedibleMenu.split(",");
	}

	private void makeMenu(List<String> menus) {
		boolean passValidate = true;
		while (passValidate){
			int randomNumber = makeRandomNumberForMenu();
			String menu = menus.get(randomNumber);
			if (checkMenu(menu)){
				recommendedMenu.add(menu);
				passValidate = false;
			}
		}

	}

	private boolean checkMenu(String menu) {
		for (String a : inedibleMenus){
			if (a.equals(menu)) return false;
		}
		if (!recommendedMenu.isEmpty()){
			return checkDuplicateMenu(menu);
		}
		return true;
	}

	private boolean checkDuplicateMenu(String menu){
		for (String a : recommendedMenu){
			if (menu.equals(a)) return false;
		}
		return true;
	}

	public int makeRandomNumberForMenu(){
		return random.nextInt(9);
	}

	public String getName(){
		return this.name;
	}
	public List<String> getRecommendedMenu(){
		return this.recommendedMenu;
	}

}
