package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;

public class Number1463Retry {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] dp = new int[10000002];

        int targetNumber = scanner.nextInt();

        if(targetNumber == 1) {
            System.out.println(0);
        }

        else if(targetNumber == 2) {
            System.out.println(1);
        }

        else{
            dp[1] = 0;
            dp[2] = 1;
            for(int i = 3; i <= targetNumber; i++){
                if(i % 3 == 0){
                    if(i % 2 == 0){
                        int two = dp[i / 2] + 1;
                        int three = dp[i / 3] + 1;
                        int minusOne = dp[i - 1] + 1;
                        dp[i] = Math.min(Math.min(three, minusOne), two);
                    } else{
                        int three = dp[i / 3] + 1;
                        int minusOne = dp[i - 1] + 1;
                        dp[i] = Math.min(three, minusOne);
                    }
                } else if(i % 2 == 0){
                    int two = dp[i / 2] + 1;
                    int minusOne = dp[i - 1] + 1;
                    dp[i] = Math.min(minusOne, two);
                } else{
                    dp[i] = dp[i - 1] + 1;
                }
            }
            System.out.println(dp[targetNumber]);
        }

    }
}
