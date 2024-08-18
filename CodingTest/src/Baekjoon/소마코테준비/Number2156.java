package Baekjoon.소마코테준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Number2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];
        for(int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = wine[1];
        if(n > 1) {
            dp[2] = wine[1] + wine[2];
        }
        for(int i = 3; i <= n; i++) {
            // dp[i - 3] + wine[i - 1] + wine[i] = 현재 포도주를 마시기 위해 전의 포도주와 전전전의 최대 포도주를 마신 개수를 합침
            // dp[i -2] + wine[i] = 현재 포도주를 마시기 위해 전전의 최대 포도주의 개수와 합침
            dp[i] = Math.max(dp[i-3] + wine[i-1] + wine[i], dp[i-2] + wine[i]);
            // 현재 포도주를 마셨을 때 최대 개수와 현재 포도주를 마시지 않았을 때의 최대 개수 중 큰 값을 dp[i]에 넣음
            dp[i] = Math.max(dp[i], dp[i-1]);
        }
        System.out.println(dp[n]);
    }
}
