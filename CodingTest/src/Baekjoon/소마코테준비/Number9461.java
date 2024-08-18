package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number9461 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        dp[6] = 3;
        dp[7] = 4;
        dp[8] = 5;
        dp[9] = 7;
        dp[10] = 9;
        for (int i = 0; i < testCase; i++){
            int question = scanner.nextInt();
            if (question > 10){
                for (int j = 11; j <= question; j++){
                    dp[j] = dp[j - 1] + dp[j -5];
                }
                System.out.println(dp[question]);
            } else {
                System.out.println(dp[question]);
            }
        }
    }
}
