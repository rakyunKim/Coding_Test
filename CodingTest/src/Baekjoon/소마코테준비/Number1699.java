package Baekjoon.소마코테준비;
import java.util.*;
public class Number1699 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        long[] dp = new long[target + 1];

        for (int i = 1; i <= target; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if(dp[i] > dp[i - j * j] + 1){
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.println(dp[target]);

    }
}
