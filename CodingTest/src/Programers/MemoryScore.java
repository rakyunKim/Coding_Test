package Programers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryScore {

	public static void main(String[] args) {
//		String[] name = new String[]{"may", "kein", "kain", "radi"};
//		int[] yearning = new int[]{5,10,1,3};
//		String[][] photo = {
//			{"may", "kein", "kain", "radi"},
//			{"may", "kein", "brin", "deny"},
//			{"kon", "kain", "may", "coni"}
//		};
//		String[] name = new String[]{"kali", "mari", "don"};
//		int[] yearning = new int[]{11,1,55};
//		String[][] photo = {
//			{"kali", "mari", "don"},
//			{"pony", "tom", "teddy"},
//			{"con", "mona", "don"}
//		};
		String[] name = new String[]{"may", "kein", "kain", "radi"};
		int[] yearning = new int[]{5, 10, 1, 3};
		String[][] photo = {
			{"may"},
			{"kein", "deny", "may"},
			{"kon", "coni"}
		};
		List<Integer> answer = solution(name, yearning, photo);
		answer.forEach(System.out::println);
	}
	public static List<Integer> solution(String[] name, int[] yearning, String[][] photo) {
		List<String[]> names = twoDArrayToArrayList(photo);
		Map<String, Integer> nameAndValue = makeNameAndValue(name, yearning);
		List<Integer> answer = new ArrayList<>();
		for(String[] a : names){
			calculateFromValue(a, nameAndValue, answer);
		}
		return answer;
	}

	private static void calculateFromValue(String[] name, Map<String, Integer> nameAndValue, List<Integer> answer) {
		int total = 0;
		for (int i = 0; i < name.length; i++){
			if (nameAndValue.get(name[i]) != null){
				total += nameAndValue.get(name[i]);
			}
		}
		answer.add(total);
	}

	public static Map<String, Integer> makeNameAndValue(String[] name, int[] yearning) {
		Map<String, Integer> nameAndValue = new HashMap<>();
		for (int i = 0; i < yearning.length; i++){
			nameAndValue.put(name[i], yearning[i]);
		}
		return nameAndValue;
	}

	public static List<String[]> twoDArrayToArrayList(String[][] photo){
		List<String[]> splitName = new ArrayList<>();
		for (int i = 0; i < photo.length; i++){
			splitName.add(photo[i]);
		}
		return splitName;
	}
}
