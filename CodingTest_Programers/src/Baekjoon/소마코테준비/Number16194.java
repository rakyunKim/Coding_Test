package Baekjoon.소마코테준비;
import java.util.*;
public class Number16194 {
    static int[][] price;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cardCount = scanner.nextInt();

        price = new int[cardCount + 1][cardCount + 1];
        for(int i = 1; i <= cardCount; i++){
            price[i][i] = scanner.nextInt();
        }
        for(int i = 1; i <= cardCount; i++){
            price[i][1] = price[1][1] * i;
        }

        int[] dp = new int[cardCount + 1];
        for(int i = 1; i <= cardCount; i++){
            dp[i] = 10000000;
        }
        dp[1] = price[1][1];
        dp[2] = Math.min(price[2][1],price[2][2]);

        for(int i = 3; i <= cardCount; i++){
            for(int j = 2; j < i; j++){
                price[i][j] = dp[j] + dp[i - j];
            }
            dp[i] = getSmallest(i);
        }

        System.out.println(dp[cardCount]);
    }
    private static int getSmallest(int y){
        int answer = 10000001;
        for(int i = 1; i <= y; i++){
            if(answer > price[y][i]){
                answer = price[y][i];
            }
        }
        return answer;
    }
}
