package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;
public class Number11048 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int ySize = scanner.nextInt();
        int xSize = scanner.nextInt();

        int[][] map = new int[ySize][xSize];
        int[][] dp = new int[ySize][xSize];

        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        dp[0][0] = map[0][0];

        for(int x = 1; x < xSize; x++){
            dp[0][x] = dp[0][x - 1] + map[0][x];
        }

        for(int y = 1; y < ySize; y++){
            dp[y][0] = dp[y - 1][0] + map[y][0];
        }

        for(int i = 1; i < ySize; i++){
            for(int j = 1; j < xSize; j++){
                dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1], dp[i - 1][j]),dp[i][j - 1]) + map[i][j];
            }
        }

        System.out.print(dp[ySize - 1][xSize - 1]);

    }
}
