package Baekjoon.소마코테준비;
import java.util.*;
public class Number1463ReRetry {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int[] dp = new int[target + 1];

        for(int i = 2; i <= target; i++){
           int minusOne = dp[i - 1] + 1;
           int divisionTwo = 1000000;
           int divisionThree = 1000000;
           if(i % 2 == 0){
               divisionTwo = dp[i / 2] + 1;
           }
           if(i % 3 == 0){
               divisionThree = dp[i / 3] + 1;
           }
           dp[i] = Math.min(Math.min(minusOne,divisionTwo),divisionThree);
        }
        System.out.println(dp[target]);
    }
}
