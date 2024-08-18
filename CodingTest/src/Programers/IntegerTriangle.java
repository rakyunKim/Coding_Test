package Programers;

import java.io.IOException;

public class IntegerTriangle {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] triangle = new int[5][5];

        int answer = solution(triangle);

        System.out.println(answer);
    }

    static public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle[triangle.length - 1].length];
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                int current = triangle[i][j] + dp[i - 1][j];
                if(j - 1 >= 0){
                    current = Math.max(current, triangle[i][j] + dp[i - 1][j - 1]);
                }
                dp[i][j] = current;
            }
        }

        int answer = 0;
        for(int i = 0; i < triangle.length; i++){
            if(answer < dp[triangle.length - 1][i]){
                answer = dp[triangle.length - 1][i];
            }
        }

        return answer;
    }
}
