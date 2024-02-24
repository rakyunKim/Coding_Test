package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number2267Retry {

    static int mapSize;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(bf.readLine());
        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];
        for(int i = 0; i < mapSize; i++){
            String y = bf.readLine();
            char[] temp = y.toCharArray();
            for(int j = 0; j < mapSize; j++){
                map[i][j] = Integer.parseInt(String.valueOf(temp[j]));
            }
        }

        int groupCount = 0;
        List<Integer> houseCount = new ArrayList<>();
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    groupCount++;
                    count = 1;
                    dfs(i, j);
                    houseCount.add(count);
                }
            }
        }

        Collections.sort(houseCount);

        System.out.println(groupCount);
        for(int i : houseCount){
            System.out.println(i);
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        // 위를 탐색
        if(y > 0 && map[y - 1][x] == 1 && !visited[y - 1][x]){
            count++;
            dfs(y - 1, x);
        }
        // 아래를 탐색
        if(y < mapSize - 1 && map[y + 1][x] == 1 && !visited[y + 1][x]){
            count++;
            dfs(y + 1, x);
        }

        if(x > 0 && map[y][x - 1] == 1 && !visited[y][x - 1]){
            count++;
            dfs(y, x - 1);
        }

        if(x < mapSize - 1 && map[y][x + 1] == 1 && !visited[y][x + 1]){
            count++;
            dfs(y, x + 1);
        }
    }
}
