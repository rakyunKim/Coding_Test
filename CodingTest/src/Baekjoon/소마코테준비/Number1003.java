package Baekjoon.소마코테준비;

import java.util.*;

public class Number1003 {
    static int[][] dp = new int[2][41];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[0][1] = 0;
        dp[1][1] = 1;
        for(int i = 2; i < 41; i++){
            for(int j = 0; j < 2; j++){
                dp[j][i] = dp[j][i - 1] + dp[j][i - 2];
            }
        }
        int testCase = scanner.nextInt();
        for(int i = 0; i < testCase; i++){

            int target = scanner.nextInt();
            System.out.print(dp[0][target] + " ");
            System.out.println(dp[1][target] + " ");
        }
    }
}
