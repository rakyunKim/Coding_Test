package Baekjoon.동적계획법;

import java.util.*;

public class Number2294 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coinCount = scanner.nextInt();
        int goal = scanner.nextInt();

        int[] coins = new int[coinCount];
        for (int i = 0; i < coinCount; i++) {
            coins[i] = scanner.nextInt();
        }

        int[] dp = new int[goal + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i <= goal; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < coinCount; j++) {
                int count = 0;
                int currentValue = coins[j];
                if (i / currentValue != 0) {
                    count += i / currentValue;
                    if (dp[i % currentValue] != -1) {
                        count += dp[i % currentValue];
                        minValue = Math.min(minValue, count);
                    }
                }
            }
            if (minValue == Integer.MAX_VALUE)
                dp[i] = -1;
            else
                dp[i] = minValue;
        }

        for (int coin : coins) {
            for (int amount = coin; amount <= goal; amount++) {
                dp[amount] = Math.min(dp[amount], dp[amount - coin] + 1);
            }
        }
//        System.out.println("==========================");
//        for(int x : dp) {
//            System.out.print(x + " ");
//        }
//        System.out.println("\n==========================");
        System.out.println(dp[goal] > goal ? -1 : dp[goal]);
    }
}
