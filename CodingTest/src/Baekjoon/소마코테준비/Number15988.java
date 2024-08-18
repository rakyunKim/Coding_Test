package Baekjoon.소마코테준비;
import java.util.*;
public class Number15988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int j = 4; j <= 1000000; j++){
            dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
        }
        int testCase = scanner.nextInt();
        for(int i = 0; i < testCase; i++){
            int element = scanner.nextInt();
            System.out.println(dp[element]);
        }
    }
}
