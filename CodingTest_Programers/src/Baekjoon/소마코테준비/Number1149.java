package Baekjoon.소마코테준비;

import java.util.Scanner;

public class Number1149 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[][] dp = new int[target][3];

        dp[0][0] = scanner.nextInt();
        dp[0][1] = scanner.nextInt();
        dp[0][2] = scanner.nextInt();
        for (int i = 1; i < target; i++){
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + scanner.nextInt();
            dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + scanner.nextInt();
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + scanner.nextInt();
        }

        System.out.println(Math.min(Math.min(dp[target - 1][0], dp[target - 1][1]), dp[target - 1][2]));
    }
}
