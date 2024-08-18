package Baekjoon.소마코테준비;

import java.io.IOException;
// util = Scanner, StringTokenizer
import java.util.*;
// io = BufferedReader, InputStreamReader
import java.io.*;

public class Number11053 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int arrLength = scanner.nextInt();
        int[] arr = new int[arrLength + 1];
        arr[0] = 0;
        for(int i = 1; i <= arrLength; i++){
           arr[i] = scanner.nextInt();
        }

        int[] dp = new int[arrLength + 1];
        dp[0] = 0;
        for(int i = 1; i <= arrLength; i++){
            for(int j = i -1; j >= 0; j--){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int answer = 0;
        for(int i : dp){
            if(i > answer) {
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
