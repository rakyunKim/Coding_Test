package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number9095ReRetry {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i < 12; i++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for(int i = 0; i < testCase; i++){
            int target = scanner.nextInt();
            System.out.println(dp[target]);
        }
    }
}
