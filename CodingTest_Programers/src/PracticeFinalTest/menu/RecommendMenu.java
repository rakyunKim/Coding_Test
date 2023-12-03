package PracticeFinalTest.menu;


import java.util.Random;

public class RecommendMenu {
	Random random;
	public RecommendMenu(){
		random = new Random();
	}
	public String randomCategory(){
		int randomNumber = random.nextInt(5) + 1;
		if (randomNumber == 1) return "japan";
		if (randomNumber == 2) return "korea";
		if (randomNumber == 3) return "china";
		if (randomNumber == 4) return "asia";
		return "western";
	}
}
