package Baekjoon.소마코테준비;
import java.util.*;
public class Number1463ReReRetry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] divisionThree = new int[target + 1];
        int[] divisionTwo = new int[target + 1];
        int[] minusOne = new int[target + 1];
        int[] dp = new int[target + 1];
        for(int i = 0; i <= target; i++){
            divisionThree[i] = Integer.MAX_VALUE;
            divisionTwo[i] = Integer.MAX_VALUE;
            minusOne[i] = Integer.MAX_VALUE;
        }
        divisionThree[1] = 0;
        divisionTwo[1] = 0;
        minusOne[1] = 0;

        for(int i = 2;i <= target; i++){
            if(i % 3 == 0){
                divisionThree[i] = dp[i / 3] + 1;
            }
            if(i % 2 == 0){
                divisionTwo[i] = dp[i / 2] + 1;
            }
            minusOne[i] = dp[i - 1] + 1;
            dp[i] = Math.min(Math.min(divisionThree[i], divisionTwo[i]), minusOne[i]);
        }

        System.out.println(dp[target]);
    }
}
