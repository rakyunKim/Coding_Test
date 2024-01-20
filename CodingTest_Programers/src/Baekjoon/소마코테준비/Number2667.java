package Baekjoon.소마코테준비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number2667 {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] map;
    static boolean[][] visited;
    static int mapSize;
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(bufferedReader.readLine());

        map = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < mapSize; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }

    private static void BFS(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startY,startX});
        visited[startY][startX] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int k = 0; k < 4; k++){
                int y = now[0] + dy[k];
                int x = now[1] + dx[k];
                if (y >= 0 && x >= 0 && y < mapSize && x < mapSize){ // 배열의 값을 넘어가면 안 되고
                    if (map[y][x] != 0 && !visited[y][x]){ // 값이 0이어서 못가는 배열이거나 이미 방문한 배열일 경우
                        visited[y][x] = true;
                        map[y][x] = map[now[0]][now[1]] + 1; // 핵심
                        queue.add(new int[] {y,x});
                    }
                }
            }
        }
    }
}
