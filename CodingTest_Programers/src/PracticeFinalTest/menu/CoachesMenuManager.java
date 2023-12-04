package PracticeFinalTest.menu;

import java.util.ArrayList;
import java.util.List;

public class CoachesMenuManager {
	Input input;
	Output output;
	MakeCategory makeCategory;
	static List<String> coaches;
	static List<String> inedibleFood;
	List<CoachMenus> menus;
	public CoachesMenuManager(){
		input = new Input();
		output = new Output();
		makeCategory = new MakeCategory();
		menus = new ArrayList<>();
	}
	public void startRecommendMenu(){
		while (true){
			try {
				output.start();
				coaches = input.getCoachesName();
				break;
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
	public void getCoachesInedibleFood(){
		inedibleFood = new ArrayList<>();
		while (true){
			try{
				coaches.forEach(i -> {
					output.getInedibleFood(i);
					inedibleFood.add(input.getInedibleMenu());
				});
				break;
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
	public void setRecommendMenu(){
		for (int i = 0; i < coaches.size(); i++){
			menus.add(new CoachMenus(coaches.get(i), inedibleFood.get(i), makeCategory));
		}
	}

	public void printResult(){
		output.recommendResult(menus);
	}

}
