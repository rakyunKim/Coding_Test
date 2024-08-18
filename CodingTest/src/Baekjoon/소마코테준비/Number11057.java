package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;

public class Number11057 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        if (target == 1) System.out.println(10);
        else {
            int[][] dp = new int[target+1][10];
            for (int i = 0; i < 10; i++){
                dp[1][i] = 1;
            }
            for (int i = 2; i <= target; i++){
                for (int k = 0; k < 10; k++){
                    for (int j = k; j < 10; j++){
                        dp[i][k] += (dp[i-1][j] % 10007);
                    }
                }
            }
            int answer = 0;
            for (int i = 0; i < 10; i++){
                answer += dp[target][i];
            }
            // 현재 배열에는 10007로 나누어진 값만 들어있고 그 배열을 0부터 9까지
            // 다시 더해서 출력해야 하니까 다시 10007로 나눠야함
            System.out.println(answer % 10007);
        }

    }
}
