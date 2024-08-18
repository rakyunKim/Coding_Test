package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number14502 {
    static int maxX;
    static int maxY;
    static int[][] map;
    static int[][] visited;
    static int maxSafeZone;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);

        maxY = scanner.nextInt();
        maxX = scanner.nextInt();

        map = new int[maxY][maxX];
        visited = new int[maxY][maxY];

        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        maxSafeZone = 0;

        
        for(int i = 0; i < (maxY * maxX) - 2; i++){
            int[] first = findMap(i);
            if(map[first[0]][first[1]] == 0){

                for(int j = i + 1; j < (maxX * maxY) - 1; j++){
                    int[] second = findMap(j);
                    if(map[second[0]][second[1]] == 0){

                        for(int k = j + 1; k < maxX * maxY; k++){
                            int[] third = findMap(k);
                            if(map[third[0]][third[1]] == 0){

                                spreadVirus(first, second, third);
                            }
                        }
                    }

                }
            }

        }

        System.out.println(maxSafeZone);
    }

    private static void spreadVirus(int[] first, int[] second, int[] third) {
        map[first[0]][first[1]] = 1;
        map[second[0]][second[1]] = 1;
        map[third[0]][third[1]] = 1;
        visited = new int[maxY][maxX];

        int[][] copy = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            copy[i] = map[i].clone();
        }

        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                if(copy[i][j] == 2 && visited[i][j] == 0){
                    bfs(copy, i, j);
                }
            }
        }

        countSafeZone(copy);


        map[first[0]][first[1]] = 0;
        map[second[0]][second[1]] = 0;
        map[third[0]][third[1]] = 0;
    }

    private static void bfs(int[][] copyMap, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        while (!queue.isEmpty()){
            int[] point = queue.poll();
            int currentY = point[0];
            int currentX = point[1];
            visited[y][x] = 1;

            if(currentY + 1 < maxY && copyMap[currentY + 1][currentX] == 0 && visited[currentY + 1][currentX] == 0){
                copyMap[currentY + 1][currentX] = 2;
                queue.add(new int[]{currentY + 1, currentX});
            }
            if(currentY - 1 >= 0 && copyMap[currentY - 1][currentX] == 0 && visited[currentY - 1][currentX] == 0){
                copyMap[currentY - 1][currentX] = 2;
                queue.add(new int[]{currentY - 1, currentX});
            }
            if(currentX + 1 < maxX && copyMap[currentY][currentX + 1] == 0 && visited[currentY][currentX + 1] == 0){
                copyMap[currentY][currentX + 1] = 2;
                queue.add(new int[]{currentY, currentX + 1});
            }
            if(currentX - 1 >= 0 && copyMap[currentY][currentX - 1] == 0 && visited[currentY][currentX - 1] == 0){
                copyMap[currentY][currentX - 1] = 2;
                queue.add(new int[]{currentY, currentX - 1});
            }
        }


    }

    private static void countSafeZone(int[][] copyMap) {
        int count = 0;
        for(int i = 0; i < maxY; i++){
            for(int j = 0; j < maxX; j++){
                if(copyMap[i][j] == 0){
                    count++;
                }
            }
        }
        if(count > maxSafeZone){
            maxSafeZone = count;
        }
    }

    private static int[] findMap(int i) {
        if(i == 0) return new int[]{0,0};
        else{
            if(i < maxX) return new int[]{0, i};
            else return new int[]{i / maxX, i % maxX};
        }
    }
}
