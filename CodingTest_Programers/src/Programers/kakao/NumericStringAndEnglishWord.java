package Programers.kakao;

import java.io.IOException;
import java.util.*;

public class NumericStringAndEnglishWord {
    static String[] english = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static void main(String[] args) throws IOException {
//        String s = "one4seveneight";
        String s = "123";
//        String s = "2three45sixseven";
//        String s = "23four5six7";
        int result = solution(s);
        System.out.println(result);
    }

    private static int solution(String s) {
        char[] arr = s.toCharArray();
        List<Integer> intArr = new ArrayList<>();
        String temp = "";
        for (int i = 0; i < arr.length; i++) {
            try {
                int a = Integer.parseInt(String.valueOf(arr[i]));
                intArr.add(a);
            } catch (Exception e) {
                temp += String.valueOf(arr[i]);
                int result = find(temp);

                if (result != -1) {
                    intArr.add(result);
                    temp = "";
                }
            }
        }

        return concatenateNumbers(intArr);
    }

    private static int concatenateNumbers(List<Integer> intArr) {
        StringBuilder sb = new StringBuilder();
        for (int num : intArr) {
            sb.append(num);
        }
        return Integer.parseInt(sb.toString());
    }

    private static int find(String s) {
        int result = -1;
        for (int i = 0; i < english.length; i++) {
            if (english[i].equals(s)) {
                result = i;
            }
        }
        return result;
    }
}
