package Baekjoon.소마코테준비;
import java.util.*;

public class Number11055 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberLength = scanner.nextInt();

        int[] number = new int[numberLength + 1];
        for(int i = 1; i <= numberLength; i++){
            number[i] = scanner.nextInt();
        }

        int[] dp = new int[numberLength + 1];
        dp[1] = number[1];
        for(int i = 2; i <= numberLength; i++){
            dp[i] = number[i];
            for(int j = i - 1; j > 0; j--){
                if(number[i] > number[j]){
                    dp[i] = Math.max(dp[j] + number[i], dp[i]);
                }
            }
        }

//        for(int i = 1; i <= numberLength; i++){
//            System.out.println(dp[i]);
//        }

        int answer = 0;
        for(int i = 1; i <= numberLength; i++){
            if(answer < dp[i]){
                answer = dp[i];
            }
        }

        System.out.println(answer);
    }
}
