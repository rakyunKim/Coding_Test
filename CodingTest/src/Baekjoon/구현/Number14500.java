package Baekjoon.구현;

import java.util.*;

public class Number14500 {
    static int[][] map;
    static int max = 0;
    static int ySize;
    static int xSize;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ySize = scanner.nextInt();
        xSize = scanner.nextInt();

        map = new int[ySize][xSize];

        for(int i = 0; i < ySize; i++) {
            for(int j = 0; j < xSize; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        checkTetromino();

        System.out.println(max);

//        for(int i = 0; i < ySize; i++) {
//            for(int j = 0; j < xSize; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static void checkTetromino() {
        int sum;
        for(int i = 0; i < ySize; i++) {
            for(int j = 0; j < xSize; j++) {
                if(i + 2 < ySize && j + 1 < xSize) {
                    // 1번
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
                    max = Math.max(max, sum);

                    // 3번
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
                    max = Math.max(max, sum);

                    // 2번의 1번
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
                    max = Math.max(max, sum);

                    // 3번의 2번
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j];
                    max = Math.max(max, sum);
                }

                if(i - 1 >= 0 && j + 2 < xSize) {
                    // 2번
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i - 1][j + 2];
                    max = Math.max(max, sum);

                    // 4번
                    sum = 0;
                    sum += map[i][j] + map[i - 1][j] + map[i - 1][j + 1] + map[i - 1][j + 2];
                    max = Math.max(max, sum);

                    // 2번의 2번
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i - 1][j + 2];
                    max = Math.max(max, sum);

                    // 3번의 3번
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i - 1][j + 1] + map[i][j + 2];
                    max = Math.max(max, sum);
                }

                if(i + 2 < ySize && j - 1 >= 0) {
                    // 5번
                    sum = 0;
                    sum += map[i][j] + map[i][j - 1] + map[i + 1][j - 1] + map[i + 2][j - 1];
                    max = Math.max(max, sum);

                    // 7번
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j - 1];
                    max = Math.max(max, sum);

                    // 2번의 3번
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 2][j - 1];
                    max = Math.max(max, sum);

                    // 3번의 4번
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 1][j - 1] + map[i + 2][j];
                    max = Math.max(max, sum);
                }

                if(i + 1 < ySize && j + 2 < xSize) {
                    // 6번
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
                    max = Math.max(max, sum);

                    // 8번
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
                    max = Math.max(max, sum);

                    // 2번의 4번
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
                    max = Math.max(max, sum);

                    // 3번의 1번
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i][j + 2];
                    max = Math.max(max, sum);

                    // 네모
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
                    max = Math.max(max, sum);
                }

                // 막대기
                if(j + 3 < xSize) {
                    sum = 0;
                    sum += map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i][j + 3];
                    max = Math.max(max, sum);
                }

                if(i + 3 < ySize) {
                    sum = 0;
                    sum += map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 3][j];
                    max = Math.max(max, sum);
                }

            }
        }
    }
}