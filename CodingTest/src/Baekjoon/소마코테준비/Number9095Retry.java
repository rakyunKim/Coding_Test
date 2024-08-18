package Baekjoon.소마코테준비;
import java.util.*;
public class Number9095Retry {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 11; i++){
            dp[i] = dp[i - 2] + dp[i - 1] + dp[i - 3];
        }
        for(int i = 0; i < testCase; i++){
            int target = scanner.nextInt();
            System.out.println(dp[target]);
        }
    }
}
