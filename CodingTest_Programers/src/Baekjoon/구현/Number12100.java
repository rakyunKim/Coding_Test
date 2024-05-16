package Baekjoon.구현;

import java.util.Scanner;

public class Number12100 {
    static int mapSize;
    static int MAX = 0;
    public static void main(String[] args) throws Exception {
        /*
            한 번 움직일 때마다 4번의 경우의 수가 생김
            한 번 움직일 때마다 맵 안에서 가장 큰 수를 찾고 그 수로 Max의 값을 갱신함
            움직인 횟수가 5번이 되면 함수를 중단함
         */

        Scanner scanner = new Scanner(System.in);
        mapSize = scanner.nextInt();
        int[][] map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        start(map, 0);



//        for (int i = 0; i < mapSize; i++) {
//            for (int j = 0; j < mapSize; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static void start(int[][] map, int count) {
        if (count < 5) {
            for (int i = 0; i < 4; i++) {
                int[][] copy = map;
                move(copy, i);
                start(copy, count + 1);
            }
        }
    }

    private static void move(int[][] map, int way) {
        /* 0 == 위 || 1 == 아래 || 2 == 왼쪽 || 3 == 오른쪽 */
        if (way == 0) {
            for (int x = 0; x < mapSize; x++) {
                int targetPtr = 0;
                for (int y = 0; y < mapSize; y++) {
                    int value = map[y][x];
                    if (y + 1 < mapSize && map[y][x] == map[y + 1][x]) {
                        map[y][x] = 0;
                        map[targetPtr++][x] = value * 2;
                        map[y + 1][x] = 0;
                        y ++;
                    }
                    else if (y + 1 < mapSize && map[y + 1][x] == 0) {
                        int nextPtr = y + 1;
                        while(nextPtr < mapSize) {
                            if (map[nextPtr + 1][x] == 0) nextPtr++;
                            else {
                                if (map[y][x] == map[nextPtr + 1][x]) {
                                    map[y][x] = 0;
                                    map[targetPtr++][x] = value * 2;
                                    map[nextPtr + 1][x] = 0;
                                    y = nextPtr + 1;
                                }
                                else {

                                }
                            }
                        }
                    }
                    else{
                        int prevPtr = y;
                        while(prevPtr > 0 && map[prevPtr - 1][x] == 0) {
                            map[prevPtr][x] = 0;
                            prevPtr -= 1;
                            map[prevPtr][x] = value;
                        }
                        targetPtr++;
                    }
                }
            }

            MAX = Math.max(MAX, getMaxValue(map));
        }


    }

    private static int getMaxValue(int[][] map) {
        int max = 0;
        for (int i = 0 ; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] > max) max = map[i][j];
            }
        }

        return max;
    }
}


//        4
//        2 4 8 2
//        2 4 0 0
//        2 0 0 0
//        2 0 2 0