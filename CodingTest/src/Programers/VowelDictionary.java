package Programers;
import java.util.*;

public class VowelDictionary {
    static String[] vowels;
    static List<String> created = new ArrayList<>();
    static int answer = 0;
    public static void main(String[] args) {
//        String word = "AAAAE";
//        String word = "AAAE";
//        String word = "I";
        String word = "EIO";

        System.out.println(solution(word));
    }

    public static int solution(String word) {
        vowels = new String[]{"A", "E", "I", "O", "U"};

        makeWord(vowels, new StringBuilder(), word);
        return answer;
    }

    private static void makeWord(String[] vowels, StringBuilder current, String word) {
        if (current.toString().equals(word)){
            answer = created.size();
            return;
        }
        if (current.toString().length() < 5) {
            for (int i = 0; i < vowels.length; i++) {
                current.append(vowels[i]);
                created.add(current.toString());
                makeWord(vowels, current, word);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
