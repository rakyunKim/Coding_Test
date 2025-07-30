package Baekjoon.DFS;

import java.util.Scanner;

public class Number10026 {
    static int n;
    static char[][] map;
    static int[][] visitedRedGreen;
    static int[][] visitedNormal;
    static int redGreenCount = 0;
    static int normalCount = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new char[n][n];
        visitedNormal = new int[n][n];
        visitedRedGreen = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedNormal[i][j] == 0) {
                    normalCount++;
                    checkMap(i, j, map[i][j], 0);
                }
                if (visitedRedGreen[i][j] == 0) {
                    redGreenCount++;
                    checkMap(i, j, map[i][j], 1);
                }
            }
        }

        System.out.println(normalCount + " " + redGreenCount);
    }

    public static void checkMap(int y, int x, char boundaryValue, int flag) {
        // if (flag == 1) {
        //     System.out.println("\u001B[31m" + y + ", " + x + ", " + boundaryValue + "\u001B[0m");
        // }
        // // if (flag == 0) {
        // //     System.out.println("\u001B[31m" + y + ", " + x + ", " + boundaryValue + "\u001B[0m");
        // // }
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         // if (flag == 0) {
        //         //     System.out.print(visitedNormal[i][j]);
        //         // }
        //         if (flag == 1) {
        //             System.out.print(visitedRedGreen[i][j]);
        //         }
        //     }
        //     // if (flag == 1) {
        //     //     System.out.println();
        //     // }
        //     if (flag == 1) {
        //         System.out.println();
        //     }
        // }
        // System.out.println("==========================================");

        if (flag == 0) {
            if (visitedNormal[y][x] != 0) {
                return;
            }
        }
        else {
            if (visitedRedGreen[y][x] != 0) {
                return;
            }
        }

        if (flag == 0) {
            if (map[y][x] != boundaryValue) {
                return;
            }
        }
        else {
            if (boundaryValue == 'R' || boundaryValue == 'G') {
                if (map[y][x] != 'R' && map[y][x] != 'G') {
                    return;
                }
            }
            else {
                if (map[y][x] != boundaryValue) {
                    return;
                }
            }
        }

        if (flag == 0) {
            visitedNormal[y][x] = normalCount;
        }
        else {
            visitedRedGreen[y][x] = redGreenCount;
        }

        // 위
        if (y + 1 < n) {
            checkMap(y + 1, x, boundaryValue, flag);
        }
        // 아래
        if (y - 1 >= 0) {
            checkMap(y - 1, x, boundaryValue, flag);
        }
        // 오른쪽
        if (x + 1 < n) {
            checkMap(y, x + 1, boundaryValue, flag);
        }
        // 왼쪽
        if (x - 1 >= 0) {
            checkMap(y, x - 1, boundaryValue, flag);
        }
    }
}