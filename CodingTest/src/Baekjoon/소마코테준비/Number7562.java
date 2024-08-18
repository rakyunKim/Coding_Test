package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;


public class Number7562 {
    static int[] endPoint;
    static int chessPlateSize;
    static int[] startPoint;
    static int[][] dp;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int t = 0; t < testCase; t++){
            chessPlateSize = sc.nextInt();
            startPoint = new int[2];
            endPoint = new int[2];
            startPoint[0] = sc.nextInt();
            startPoint[1] = sc.nextInt();
            endPoint[0] = sc.nextInt();
            endPoint[1] = sc.nextInt();

            dp = new int[chessPlateSize][chessPlateSize];
            for(int i = 0; i < chessPlateSize; i++){
                for(int j = 0; j < chessPlateSize; j++){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            dp[startPoint[0]][startPoint[1]] = 0;

            bfs();
            System.out.println(dp[endPoint[0]][endPoint[1]]);
        }
    }
    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startPoint);
        while(!queue.isEmpty()){
            int[] currentPoint = queue.poll();
            int y = currentPoint[0];
            int x = currentPoint[1];

            for(int i = 0; i < 8; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if(nextY >= 0 && nextX >= 0 && nextX < chessPlateSize && nextY < chessPlateSize && dp[nextY][nextX] == Integer.MAX_VALUE){
                    queue.add(new int[]{nextY, nextX});
                    dp[nextY][nextX] = dp[y][x] + 1;
                }
            }
        }

    }
}
