package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number11722 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int arrLength = scanner.nextInt();
        int[] arr = new int[arrLength];
        int[] dp = new int[arrLength];

        for(int i = 0; i < arrLength; i++){
            arr[i] = scanner.nextInt();
        }


        dp[0] = 1;
        for(int i=1; i<arrLength; i++){
            int max = 0;
            for(int j=0; j<i; j++){
                if(arr[i] < arr[j])
                    max = Math.max(dp[j], max);
            }
            dp[i] = max + 1;
        }

        int answer = 0;
        for(int i = 0; i < arrLength; i++){
            if(dp[i] > answer) answer = dp[i];
        }
        System.out.println(answer);
    }
}
