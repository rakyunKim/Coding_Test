package Baekjoon.소마코테준비;

import java.util.Scanner;

public class Number15990 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        long[][] dp = new long[100_001][4];
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2+1
        dp[3][2] = 1; // 1+2
        dp[3][3] = 1; // 3
        for(int i = 4; i <= 100_000; i++) {
            // 숫자가 1로 끝나는 곳에는 dp에서 -1이 한 값에다가 1을 더해주면 되기에 1을 더해주기 위해서는 앞의 숫자가 1이면 안 되고 2와 3이어야 해서 아래와 같은 식이 나옴
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_009;
            // 숫자가 2로 끝나는 곳에서는 2로 끝나기에 -2를 해준다음 2가 아닌 1과 3의 값을 더함
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_009;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_009;
        }

        for(int i = 0; i < testCase; i++) {
            int t = scanner.nextInt();
            System.out.println((dp[t][1] + dp[t][2] + dp[t][3]) % 1_000_000_009);
        }
    }
}
