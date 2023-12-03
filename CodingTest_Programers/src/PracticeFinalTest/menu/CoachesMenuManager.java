package PracticeFinalTest.menu;

import java.util.ArrayList;
import java.util.List;

public class CoachesMenuManager {
	Input input;
	Output output;
	static List<String> coaches;
	static List<String> inedibleFood;
	RecommendMenu recommendMenu;
	public CoachesMenuManager(){
		input = new Input();
		output = new Output();
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

	}

}
