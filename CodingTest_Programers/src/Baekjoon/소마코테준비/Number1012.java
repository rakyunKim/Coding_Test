package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
public class Number1012 {
    static int[][] farm;
    static int[][] visited;
    static int answer;
    static int xSize;
    static int ySize;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        for(int i = 0; i < testCase; i++){
            xSize = scanner.nextInt();
            ySize = scanner.nextInt();

            farm = new int[ySize][xSize];
            visited = new int[ySize][xSize];
            answer = 0;

            for(int j = 0; j < ySize; j++){
                for(int k = 0; k < xSize; k++){
                    farm[j][k] = 0;
                }
            }

            int cabbageCount = scanner.nextInt();
            for(int j = 0; j < cabbageCount; j++){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                farm[y][x] = 1;
            }

            int answer = 0;

            for(int j = 0; j < ySize; j++){
                for(int k = 0; k < xSize; k++){
                    if(farm[j][k] == 1){
                        if(bfs(j,k)){
                            answer += 1;
                        }
                    }
                }
            }

            System.out.println(answer);
        }

    }

    private static boolean bfs(int yPoint, int xPoint) {
        Queue<int[]> queue = new LinkedList<>();
        if(visited[yPoint][xPoint] == 0){
            queue.add(new int[]{yPoint, xPoint});
            while(!queue.isEmpty()){
                int[] yx = queue.poll();
                int currentY = yx[0];
                int currentX = yx[1];
                visited[currentY][currentX] = 1;
                if(currentY + 1 < ySize && farm[currentY + 1][currentX] == 1 && visited[currentY + 1][currentX] == 0){
                    queue.add(new int[]{currentY + 1, currentX});
                    visited[currentY + 1][currentX] = 1;
                }
                if(currentY - 1 >= 0 && farm[currentY - 1][currentX] == 1 && visited[currentY - 1][currentX] == 0){
                    queue.add(new int[]{currentY - 1, currentX});
                    visited[currentY - 1][currentX] = 1;
                }
                if(currentX + 1 < xSize && farm[currentY][currentX + 1] == 1 && visited[currentY][currentX + 1] == 0){
                    queue.add(new int[]{currentY, currentX + 1});
                    visited[currentY][currentX + 1] = 1;
                }
                if(currentX - 1 >= 0 && farm[currentY][currentX - 1] == 1 && visited[currentY][currentX - 1] == 0){
                    queue.add(new int[]{currentY, currentX - 1});
                    visited[currentY][currentX - 1] = 1;
                }
            }
            return true;
        } else{
            return false;
        }
    }
}