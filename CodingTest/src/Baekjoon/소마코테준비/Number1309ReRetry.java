package Baekjoon.소마코테준비;

import java.util.*;

public class Number1309ReRetry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cageSize = scanner.nextInt();

        int[][] dp = new int[cageSize + 1][3];
        dp[0][0] = 1;
        for(int i = 1; i <= cageSize; i++){
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        int answer = 0;
        for(int i = 0; i < 3; i++){
            answer += dp[cageSize][i];
        }

        System.out.println(answer % 9901);
    }
}
