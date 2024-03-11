package Baekjoon.구현;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number3190 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        int[][] map = new int[mapSize + 1][mapSize + 1];

        for(int i = 1; i < mapSize + 1; i++){
            for(int j = 1; j < mapSize + 1; j++){
                map[i][j] = 1;
            }
        }
        map[1][1] = 3;

        int appleCount = scanner.nextInt();
        for(int i = 0; i < appleCount; i++){
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            map[y][x] = 2;
        }

        int moveCount = scanner.nextInt();

        int time = 0;
        int[] currentPoint = new int[]{1,1};
        int[] currentWay = new int[]{0, 1};
        boolean isEnd = false;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});

        for(int i = 0; i <= moveCount; i++){
            int moveTime = Integer.MAX_VALUE;
            String nextWay = "NOWAY";
            if(i < moveCount){
                moveTime = scanner.nextInt();
                nextWay = scanner.next();
            }

            while(time != moveTime){
                currentPoint[0] += currentWay[0];
                currentPoint[1] += currentWay[1];

                if(currentPoint[0] == mapSize + 1 || currentPoint[1] == mapSize + 1 ||
                        map[currentPoint[0]][currentPoint[1]] == 0 ||
                        map[currentPoint[0]][currentPoint[1]] == 3){
                    time++;
                    isEnd = true;
                    break;
                }

                else if(map[currentPoint[0]][currentPoint[1]] == 2){
                    map[currentPoint[0]][currentPoint[1]] = 3;
                    queue.add(new int[]{currentPoint[0], currentPoint[1]});
                }

                else {
                    queue.add(new int[]{currentPoint[0], currentPoint[1]});
                    map[currentPoint[0]][currentPoint[1]] = 3;
                    int[] tail = queue.poll();
                    map[tail[0]][tail[1]] = 1;
                }

                time++;
            }


            if(nextWay.equals("D")){
                if(currentWay[0] < 0){
                    currentWay[0] = 0;
                    currentWay[1] = 1;
                } else if(currentWay[1] < 0){
                    currentWay[0] = -1;
                    currentWay[1] = 0;
                } else if(currentWay[0] == 1){
                    currentWay[0] = 0;
                    currentWay[1] = -1;
                } else {
                    currentWay[0] = 1;
                    currentWay[1] = 0;
                }
            }

            else if(nextWay.equals("L")){
                if(currentWay[0] < 0){
                    currentWay[0] = 0;
                    currentWay[1] = -1;
                } else if(currentWay[1] < 0){
                    currentWay[0] = 1;
                    currentWay[1] = 0;
                } else if(currentWay[0] == 1){
                    currentWay[0] = 0;
                    currentWay[1] = 1;
                } else {
                    currentWay[0] = -1;
                    currentWay[1] = 0;
                }
            }

            if(isEnd){
                break;
            }
        }
        System.out.println(time);
    }
}
