package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;


public class Number1913 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        int[][] map = new int[mapSize][mapSize];

        int target = scanner.nextInt();

        int startY = mapSize / 2;
        int startX = mapSize / 2;

        map[startY][startX] = 1;

//        System.out.println("시작 점 :: " + startY + ", " + startX + " : " + map[startY][startX]);

        int right = 1;
        int underLeftOver = 2;
        int value = map[startY][startX] + 1;

        while(map[0][0] == 0){
            // 위로 한 칸
            startY -= 1;
            map[startY][startX] = value;
            value++;

//            System.out.println("다음 점 :: " + startY + ", " + startX + " : " + map[startY][startX]);

            // 오른쪽으로 right 칸 이동
            for(int i = 0; i < right; i++){
                startX += 1;
                map[startY][startX] = value++;;
            }


//            System.out.println("다음 점 :: " + startY + ", " + startX + " : " + map[startY][startX]);


            // 아래로 underLeftOver 칸 이동
            for(int i = 0; i < underLeftOver; i++){
                startY += 1;
                map[startY][startX] = value++;;
            }

//            System.out.println("다음 점 :: " + startY + ", " + startX + " : " + map[startY][startX]);


            // 왼쪽으로 underLeftOver 칸 이동
            for(int i = 0; i < underLeftOver; i++){
                startX -= 1;
                map[startY][startX] = value++;;
            }

//            System.out.println("다음 점 :: " + startY + ", " + startX + " : " + map[startY][startX]);


            // 위쪽으로 underLeftOver 칸 이동
            for(int i = 0; i < underLeftOver; i++){
                startY -= 1;
                map[startY][startX] = value++;;
            }

//            System.out.println("다음 점 :: " + startY + ", " + startX + " : " + map[startY][startX]);


            right += 2;
            underLeftOver += 2;

//            System.out.println("---------------------------------------");
        }

        int[] targetPoint = new int[2];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                sb.append(map[i][j] + " ");
                if(map[i][j] == target) {
                    targetPoint[0] = i + 1;
                    targetPoint[1] = j + 1;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.println(targetPoint[0] + " " + targetPoint[1]);
    }
}
