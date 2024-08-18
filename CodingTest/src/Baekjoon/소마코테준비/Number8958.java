package Baekjoon.소마코테준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < caseCount; i++){
            String question = bufferedReader.readLine();
            char[] chars = new char[question.length()];
            for (int j = 0; j < question.length(); j++){
                chars[j] = question.charAt(j);
            }
            int[] answer = new int[chars.length];
            if (chars[0] == 'O') answer[0] = 1;
            for (int j = 1; j < question.length(); j++){
                if (chars[j] == 'O') {
                    answer[j] += answer[j - 1] + 1;
                }
            }
            int answerPrint = 0;
            for (int j : answer){
                answerPrint += j;
            }
            System.out.println(answerPrint);
        }
    }
}
