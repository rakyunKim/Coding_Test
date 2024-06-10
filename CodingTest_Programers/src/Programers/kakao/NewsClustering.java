package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class NewsClustering {

    public static void main(String[] args) throws IOException {
//        String str1 = "FRANCE";
//        String str2 = "french";

//        String str1 = "handshake";
//        String str2 = "shake hands";

//        String str1 = "aa1+aa2";
//        String str2 = "AAAA12";

        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";


        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        Queue<String> str1WithOnlyLetter = new LinkedList<>();
        Queue<String> str2WithOnlyLetter = new LinkedList<>();

        filterAlphabets(str1, str1WithOnlyLetter);
        filterAlphabets(str2, str2WithOnlyLetter);

        int intersectionCount = getIntersectionCount(str1WithOnlyLetter, str2WithOnlyLetter);
        int unionCount = getUnionCount(str1WithOnlyLetter, str2WithOnlyLetter);


        return getJaccardSimilarity(intersectionCount, unionCount);
    }

    public static void filterAlphabets(String str,  Queue<String> strWithOnlyLetter) {
        char prevChar = '.';

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                if (prevChar != '.') {
                   strWithOnlyLetter.add(new String(new char[] { prevChar, str.charAt(i) }));
                }
                prevChar = str.charAt(i);
            } else {
                prevChar = '.';
            }
        }
    }

    private static int getIntersectionCount(Queue<String> subset1, Queue<String> subset2) {
        int result = 0;
        int subset1Size = subset1.size();
        Queue<String> subset2Copy = new LinkedList<>(subset2);

        for (int i = 0; i < subset1Size; i++) {
            int subset2Size = subset2Copy.size();
            String str1 = subset1.poll();

            while (subset2Size > 0) {
                String str2 = subset2Copy.poll();
                if (str1.equalsIgnoreCase(str2)) {
                    result++;
                    break;
                }

                subset2Copy.add(str2);
                subset2Size--;
            }
            subset1.add(str1);
        }

        return result;
    }

    private static int getUnionCount(Queue<String> subset1, Queue<String> subset2) {
        List<String> union = new LinkedList<>();
        int subset1Size = subset1.size();

        for (int i = 0; i < subset1Size; i++) {
            int subset2Size = subset2.size();
            String str1 = subset1.poll();
            boolean isAlreadyAdd = false;

            while (subset2Size > 0) {
                String str2 = subset2.poll();
                if (str1.equalsIgnoreCase(str2)) {
                    union.add(str1);
                    isAlreadyAdd = true;
                    break;
                }

                subset2.add(str2);
                subset2Size--;
            }

            if (!isAlreadyAdd) union.add(str1);
        }

        union.addAll(subset2);

        return union.size();
    }

    private static int getJaccardSimilarity(int intersectionCount, int unionCount) {
        if (intersectionCount == 0 && unionCount == 0) return 65536;

        return (int) Math.floor(((double) intersectionCount / unionCount) * 65536);
    }
}
