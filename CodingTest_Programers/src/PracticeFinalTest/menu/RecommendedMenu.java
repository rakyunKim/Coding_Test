package PracticeFinalTest.menu;

import java.util.List;

public class RecommendedMenu {
	String name;
	List<String> orderedMenu;
	List<String> orderedMenuCategory;
	public void RecommendMenu(String name, String orderedMenu, int index){
		this.name = name;
		this.orderedMenu.add(orderedMenu);
		if (index == 1) orderedMenuCategory.add("일식");
		if (index == 2) orderedMenuCategory.add("한식");
		if (index == 3) orderedMenuCategory.add("중식");
		if (index == 4) orderedMenuCategory.add("아시아");
		if (index == 5) orderedMenuCategory.add("양식");
 	}
}
