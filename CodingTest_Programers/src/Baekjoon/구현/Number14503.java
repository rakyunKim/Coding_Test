package Baekjoon.구현;

import java.io.IOException;
import java.util.Scanner;

public class Number14503 {
    // 0 : 북 , 1 : 동, 2 : 남, 3 : 서
    static int maxY;
    static int maxX;
    static int[][] map;
    static int vacuumY;
    static int vacuumX;
    static int vacuumWay;
    static int[][] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);

        maxY = scanner.nextInt();
        maxX = scanner.nextInt();

        map = new int[maxY][maxX];
        visited = new int[maxY][maxX];

        vacuumY = scanner.nextInt();
        vacuumX = scanner.nextInt();
        vacuumWay = scanner.nextInt();


        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        // 지금은 맵에 있는 모든 곳을 뒤지게 됨, 그러나 내가 갈 수 있는 방향에서
        // 청소할 곳을 찾아야 함
        dfs(vacuumY, vacuumX, vacuumWay);

        System.out.println(countVisited());
    }

    private static int countVisited() {
        int count = 0;
        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                if(visited[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int y, int x, int way) {
        visited[y][x] = 1;

        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");

        int count = 0;
        while(count <= 3){
            if(way == 0){
                if(y - 1 >= 0 && map[y - 1][x] == 0 && visited[y - 1][x] == 0){
                    dfs(y - 1, x, way);
                } else {
                    way = 1;
                    count++;
                }
            }

            if(way == 1){
                if(x + 1 < maxX && map[y][x + 1] == 0 && visited[y][x + 1] == 0){
                    dfs(y, x + 1, way);
                } else {
                    way = 2;
                    count++;
                }
            }

            if(way == 2){
                if(y + 1 < maxY && map[y + 1][x] == 0 && visited[y + 1][x] == 0){
                    dfs(y + 1, x, way);
                } else {
                    way = 3;
                    count++;
                }

            }

            if(way == 3) {
                if (x - 1 >= 0 && map[y][x - 1] == 0 && visited[y][x - 1] == 0) {
                    dfs(y, x - 1, way);
                } else {
                    way = 0;
                    count++;
                }
            }
        }

//        if (way == 0 && y + 1 < maxY && map[y + 1][x] == 0) {
//            dfs(y + 1, x, way);
//        } else if (way == 1 && x - 1 >= 0 && map[y][x - 1] == 0) {
//            dfs(y, x - 1, way);
//        } else if (way == 2 && y - 1 >= 0 && map[y - 1][x] == 0) {
//            dfs(y - 1, x, way);
//        } else if (way == 3 && x + 1 < maxX && map[y][x + 1] == 0) {
//            dfs(y, x + 1, way);
//        } else {
//            return;
//        }
    }


}
