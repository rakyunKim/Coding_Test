package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number1912 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberCount = scanner.nextInt();

        int[] dp = new int[numberCount];
        dp[0] = scanner.nextInt();
        for(int i = 1; i < numberCount; i++){
            int currentNumber = scanner.nextInt();
            dp[i] = Math.max(dp[i - 1] + currentNumber, currentNumber);
        }

        int answer = -10001;
        for(int i : dp){
            if(i > answer) answer = i;
        }
        System.out.println(answer);
    }
}
