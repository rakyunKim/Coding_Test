package PracticeFinalTest.menu;


import java.util.Arrays;
import java.util.List;

public class InputValidate {
	public static final String ERROR = "[ERROR]";
	Menu menu = new Menu();

	public List<String> validateCoachesName(String coachesName) throws IllegalArgumentException{
		List<String> coaches;
		try {
			coaches = Arrays.asList(coachesName.split(","));
		}catch (Exception e){
			throw new IllegalArgumentException();
		}
		validateCoachesSize(coaches);
		validateCoachesNameInRange(coaches);
		return coaches;
	}

	private void validateCoachesSize(List<String> coaches) {
		if (coaches.size() < 2 || coaches.size() > 5){
			throw new IllegalArgumentException(ERROR + " 코치는 최소 2명 최대 5명까지 입력 가능합니다.");
		}
	}

	private void validateCoachesNameInRange(List<String> coaches) {
		coaches.forEach(i -> {
			if (i.length() < 2 || i.length() > 4){
				throw new IllegalArgumentException(ERROR + "코치의 이름은 최소 2글자 최대 4글자입니다.");
			}
		});
	}

	public void validateInedibleFood(String inedibleFood) {
		if (!menu.japan.contains(inedibleFood) &&
			!menu.korea.contains(inedibleFood) &&
			!menu.china.contains(inedibleFood) &&
			!menu.asia.contains(inedibleFood) &&
			!menu.western.contains(inedibleFood)){
			throw new IllegalArgumentException(ERROR + "없은 메뉴입니다.");
		}
	}
}
