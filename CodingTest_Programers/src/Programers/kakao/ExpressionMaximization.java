package Programers.kakao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpressionMaximization {
    public static void main(String[] args) throws IOException {
        String expression = "100-200*300-500+20";
//        String expression = "50*6-3*2";

        long result = solution(expression);
        System.out.println(result);
    }

    public static long solution(String expression) {
        char[] temp = expression.toCharArray();

        List<String> operator = new ArrayList<>();
        List<Integer> number = new ArrayList<>();

        StringBuilder integer = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != '-' && temp[i] != '*' && temp[i] != '+') {
                integer.append(temp[i]);
            } else {
                operator.add(String.valueOf(temp[i]));
                number.add(Integer.parseInt(integer.toString()));
                integer = new StringBuilder();
            }
        }
        number.add(Integer.parseInt(integer.toString()));



        long answer = 0;
        return answer;
    }
}
