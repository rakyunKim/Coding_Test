package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number2225 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= n; i++){
            dp[1][i] = 1;
        }
        for (int i = 0; i <= k; i++){
            dp[i][0] = 1;
        }

        for (int i = 1; i <= k; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }

        System.out.println(dp[k][n]);
    }
}
