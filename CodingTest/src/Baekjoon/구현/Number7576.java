package Baekjoon.구현;

import java.util.*;

public class Number7576 {
    static int[][] map;
    static int totalElements;
    static int time;
    static int[] dy = new int[] {0, 0, 1, -1};
    static int[] dx = new int[] {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        Queue<int[]> goodTomato = new LinkedList<>();

        x = scanner.nextInt();
        y = scanner.nextInt();
        totalElements = x * y;
        time = 0;
        map = new int[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == 1){
                    goodTomato.add(new int[]{i, j});
                   totalElements--;
                }
                else if (map[i][j] == -1)
                    totalElements--;
            }
        }

        letsStart(goodTomato, map);
        if (totalElements == 0)
            System.out.println(time);
        else
            System.out.println(-1);
    }

    private static void letsStart(Queue<int[]> goodTomato, int[][] map) {
        //printMap(map);

        if (totalElements == 0) return;

        time++;
        Queue<int[]> nextGoodTomato = new LinkedList<>();
        while (!goodTomato.isEmpty()){
            int[] current = goodTomato.poll();
            for (int i = 0; i < 4; i++){
                int y = current[0] + dy[i];
                int x = current[1] + dx[i];
                if (y < map.length
                        && y >= 0
                        && x < map[0].length
                        && x >= 0
                        && map[y][x] == 0){
                    nextGoodTomato.add(new int[]{y, x});
                    map[y][x] = 1;

                    totalElements--;
                }
            }
        }

        if (nextGoodTomato.isEmpty()) return;
        letsStart(nextGoodTomato, map);
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++){
            for (int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("======================");
    }

}