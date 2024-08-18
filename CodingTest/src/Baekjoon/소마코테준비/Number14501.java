package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;
public class Number14501 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberRange = scanner.nextInt();
        int[] day = new int[numberRange + 1];
        int[] pay = new int[numberRange + 1];
        int[] dp = new int[numberRange + 2];

        for(int i = 1; i <= numberRange; i++){
            day[i] = scanner.nextInt();
            pay[i] = scanner.nextInt();
        }

        // dp[i] = i번째 날부터 마지막 날까지 일 했을 때의 최대값
        for(int i = numberRange; i > 0; i--){
            if(day[i] + i > numberRange + 1){
                dp[i] = dp[i + 1];
            } else{
                // 그날에 일을 안 하거나, 아니면 일을 하고 일한 후에 시간이 지난 만큼의 값과 더하거나
                dp[i] = Math.max(dp[i + 1], pay[i] + dp[i + day[i]]);
            }
        }

        System.out.println(dp[1]);
    }
}
