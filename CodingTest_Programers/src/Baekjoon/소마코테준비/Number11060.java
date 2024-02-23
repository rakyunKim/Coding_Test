package Baekjoon.소마코테준비;

import java.util.*;
import java.io.*;
public class Number11060 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] arr = new int[length+1];
        long[] dp = new long[1101];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }

        dp[1] = 0;
        for (int i = 1; i <= length; i++) {
            if (dp[i] >= Integer.MAX_VALUE) continue;
            for (int j = 1; j <= arr[i]; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if (dp[length] >= Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(dp[length]);
        }
    }
}