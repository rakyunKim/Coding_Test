package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.*;


public class Number10164 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int x = scanner.nextInt();
        int wayPoint = scanner.nextInt();

        int[][] map = new int[y][x];

        map[0][0] = 1;
        for(int i = 0; i < x; i++){
            map[0][i] = 1;
        }

        for(int i = 0; i < y; i++){
            map[i][0] = 1;
        }

        for(int i = 1; i < y; i++){
            for(int j = 1; j < x; j++){
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        }

//        System.out.println("맵 초기화 전");
//        for(int i = 0; i < y; i++){
//            for(int j = 0; j < x; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        if(wayPoint == 0){
            System.out.println(map[y - 1][x - 1]);
        }
        else {
            int wayY = 0;
            int wayX = 0;
            if(wayPoint < x){
                wayX = wayPoint - 1;
            } else {
                while(wayPoint > x){
                    wayPoint -= x;
                    wayY++;
                }
                wayX = wayPoint - 1;
            }

            int wayPointValue = map[wayY][wayX];
            for(int i = wayY; i < y; i++){
                map[i][wayX] = 1;
            }
            for(int i = wayX; i < x; i++){
                map[wayY][i] = 1;
            }



            for(int i = wayY + 1; i < y; i++){
                for(int j = wayX + 1; j < x; j++){
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                }
            }

//            System.out.println("맵 초기화 후");
//            for(int i = 0; i < y; i++){
//                for(int j = 0; j < x; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            System.out.println(wayPointValue * map[y - 1][x - 1]);
//            System.out.println("경유지 y좌표 :: " + wayY);
//            System.out.println("경유지 x좌표 :: " + wayX);
        }
    }
}
