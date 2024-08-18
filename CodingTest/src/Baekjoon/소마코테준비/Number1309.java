package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number1309 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[n][3];

        for(int i = 0; i < 3; i++){
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }
        int answer = 0;
        for (int i = 0; i < 3; i++){
            answer += (int) dp[n - 1][i];
        }
        System.out.println(answer % 9901);
    }
}
