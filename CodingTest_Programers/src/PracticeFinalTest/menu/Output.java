package PracticeFinalTest.menu;

import java.util.List;

public class Output {
	public void start(){
		System.out.println("점심 메뉴 추천을 시작합니다.");
		System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
	}
	public void getInedibleFood(String coachName){
		System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
	}
	public void recommendResult(List<CoachMenus> menus){
		System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
		List<String> menuCategory = menus.get(0).menuCategory;
		menuCategory.forEach(i -> {
			System.out.print(i + " | ");
		});
		System.out.println(" ");
		for (CoachMenus m : menus) {
			System.out.print("[ " + m.getName() + " | ");
			for (String menu : m.getRecommendedMenu()) {
				System.out.print(menu + " | ");
			}
			System.out.println("]");
		}

	}

}
