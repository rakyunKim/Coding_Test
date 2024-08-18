package Baekjoon.소마코테준비;

import java.util.Scanner;

public class Number1932 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int depth = scanner.nextInt();
        int[][] triangle = new int[depth][depth];
        int[][] dp = new int[depth][depth];

        for (int i = 0; i < depth; i++){
            for (int j = 0; j < depth; j++){
                triangle[i][j] = -1;
            }
        }

        triangle[0][0] = scanner.nextInt();
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < depth; i++){
            for (int j = 0; j <= i; j++){
                triangle[i][j] = scanner.nextInt();
            }
        }

        for (int i = 1; i < depth; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if (j == i) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }

        int max = dp[depth - 1][0];
        for (int i = 1; i < depth; i++){
            if (max < dp[depth - 1][i]){
                max = dp[depth - 1][i];
            }
        }
        System.out.println(max);
    }
}
