package PracticeFinalTest.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MakeCategory {
	Random random;
	List<String> menuCategory;
	public MakeCategory(){
		random = new Random();
		menuCategory = new ArrayList<>();
		setMenuCategory(checkMenuCategory());
	}

	private List<Integer> checkMenuCategory(){
		List<Integer> menuCategorySpace = new ArrayList<>();
		boolean passValidate = true;
		while (passValidate){
			for (int i = 0; i < 5; i++){
				menuCategorySpace.add(random.nextInt(5)+1);
			}
			if (validateMenuCategory(menuCategorySpace)){
				passValidate = false;
			}
		}
		return menuCategorySpace;
	}

	private static boolean validateMenuCategory(List<Integer> menuCategorySpace) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int number : menuCategorySpace) {
			countMap.put(number, countMap.getOrDefault(number, 0) + 1);
			if (countMap.get(number) >= 3) {
				return false;
			}
		}
		return true;
	}

	private void setMenuCategory(List<Integer> menuCategorySpace) {
		for (Integer i : menuCategorySpace){
			if (i == 1) menuCategory.add("일식");
			if (i == 2) menuCategory.add("한식");
			if (i == 3) menuCategory.add("중식");
			if (i == 4) menuCategory.add("아시안");
			if (i == 5) menuCategory.add("양식");
		}
	}

	public List<String> getMenuCategory(){
		return menuCategory;
	}
}
