package PracticeFinalTest.menu;

public class Output {
	public void start(){
		System.out.println("점심 메뉴 추천을 시작합니다.");
		System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
	}
	public void getInedibleFood(String coachName){
		System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
	}
//	public void recommendResult(List<String> coachesName){
//		System.out.println
//			("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]"
//			+ "\n"
//			+ "[ 카테고리 | 한식 | 한식 | 일식 | 중식 | 아시안 ]");
//		for (int i = 0; i < coachesName.size(); i++){
//			System.out.println
//				("[ " + coachesName.get(i) + " | 쌈밥 | 김치찌개 | 미소시루 | 짜장면 | 팟타이 ]"
//				+ "\n");
//		}
//
//	}

}
