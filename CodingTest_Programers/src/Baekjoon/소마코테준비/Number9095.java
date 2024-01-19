package Baekjoon.소마코테준비;

import java.util.Locale;
import java.util.Scanner;

public class Number9095 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int questionCount = scanner.nextInt();

        for (int i = 0; i < questionCount; i++){
            int question = scanner.nextInt();
            int[] dp = new int[question + 1];
            if (question > 3){
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                for (int j = 4; j <= question; j++){
                    dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
                }
                System.out.println(dp[question]);
            } else if (question == 1) {
                System.out.println(1);
            } else if (question == 2) {
                System.out.println(2);
            } else if (question == 3) {
                System.out.println(4);
            }
        }
    }
}
