package PracticeFinalTest.menu;

import java.util.List;
import java.util.Scanner;

public class Input {
	Scanner scanner;
	InputValidate validate = new InputValidate();

	public Input() {
		scanner = new Scanner(System.in);
	}

	public List<String> getCoachesName() throws IllegalArgumentException{
		String coachesName = scanner.next();
		return validate.validateCoachesName(coachesName);
	}

	public String getInedibleMenu() throws IllegalArgumentException{
		String inedibleFood = scanner.next();
		validate.validateInedibleFood(inedibleFood);
		return inedibleFood;
	}

}
