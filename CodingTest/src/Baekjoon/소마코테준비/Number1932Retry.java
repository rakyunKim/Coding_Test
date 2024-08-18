package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number1932Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int triangleSize = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        int[][] triangle = new int[triangleSize][triangleSize];
        for(int i = 0; i < triangleSize; i++){
            for(int j = 0; j < triangleSize; j++){
                triangle[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < triangleSize; i++){
            st = new StringTokenizer(bf.readLine());
            int xSize = 0;
            while(st.hasMoreTokens()){
                triangle[i][xSize] = Integer.parseInt(st.nextToken());
                xSize ++;
            }
        }

//        for(int i = 0; i < triangleSize; i++){
//            for(int j = 0;j < triangleSize; j++){
//                System.out.print(triangle[i][j] + " ");
//            }
//            System.out.println();
//        }

        int[][] dp = new int[triangleSize][triangleSize];
        dp[0][0] = triangle[0][0];


        for(int i = 1; i < triangleSize; i++){
            for(int j = 0; j <= i; j++){
                if(j > 0){
                    int over = 0;
                    int overLeft = dp[i - 1][j - 1] + triangle[i][j];
                    if(triangle[i - 1][j] != Integer.MAX_VALUE){
                        over = dp[i - 1][j] + triangle[i][j];
                    }
                    dp[i][j] = Math.max(overLeft, over);
                } else {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
            }
        }


        int value = 0;
        for(int i = 0; i < triangleSize; i++){
            if(dp[triangleSize - 1][i] > value){
                value = dp[triangleSize - 1][i];
            }
        }

        System.out.println(value);
    }
}
