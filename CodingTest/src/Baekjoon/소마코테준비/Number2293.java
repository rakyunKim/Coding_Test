package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number2293 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int coinCount = scanner.nextInt();
        int targetValue = scanner.nextInt();
        int[] arr = new int[coinCount + 1];
        int[] dp = new int[targetValue + 1];
        dp[0] = 1;

        for (int i = 1; i <= coinCount; i++){
            arr[i] = scanner.nextInt();
            for (int j = arr[i]; j <= targetValue; j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        System.out.println(dp[targetValue]);
    }
}
