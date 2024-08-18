package Baekjoon.소마코테준비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Number2667 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static int[][] visited;
    static int mapSize;
    static List<Integer> houseCount;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(bufferedReader.readLine());
        houseCount = new ArrayList<>();
        map = new int[mapSize][mapSize];
        visited = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String temp = stringTokenizer.nextToken();
            char[] tempArr = temp.toCharArray();
            for (int j = 0; j < mapSize; j++){
                map[i][j] = Integer.parseInt(String.valueOf(tempArr[j]));
            }
        }

        for (int i = 0; i < mapSize; i++){
            for (int j = 0; j < mapSize; j++){
                if (map[i][j] == 1){
                    BFS(i, j);
                }
            }
        }
        System.out.println(houseCount.size());
        houseCount.forEach(System.out::println);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i,j});
        int count = 0;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++){
                int y = now[0] + dy[k];
                int x = now[1] + dx[k];
                if (y >= 0 && x >= 0 && y < mapSize && x < mapSize){ // 배열의 값을 넘어가면 안 되고
                    if (map[y][x] == 1 && visited[y][x] == 0){ // 값이 0이어서 못가는 배열이거나 이미 방문한 배열일 경우
                        visited[y][x] = 1;
                        queue.add(new int[] {y,x});
                        count++;
                    }
                }
            }
        }
        if (count != 0){
            houseCount.add(count);
        }
    }
}
