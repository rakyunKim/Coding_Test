package Baekjoon.소마코테준비;
import java.util.*;

public class Number2579Retry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stairsCount = sc.nextInt();
        int[] stairs = new int[301];

        for(int i = 1; i <= stairsCount; i++){
            stairs[i] = sc.nextInt();
        }
        int[] dp = new int[301];

        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];
        dp[3] = Math.max(stairs[1],stairs[2]) + stairs[3];

        for(int i = 4; i <= stairsCount; i++){
            dp[i] = Math.max(dp[i - 3] + stairs[i - 1], dp[i - 2]) + stairs[i];
        }

        System.out.println(dp[stairsCount]);

    }
}
