package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number1904 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        long[] dp = new long[target + 1];
        if (target > 2){
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= target; i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
            System.out.println(dp[target]);
        } else if (target == 1) {
            System.out.println(1);
        } else if (target == 2) {
            System.out.println(2);
        }

    }
}
