package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number2667Retry {
    static boolean[][] visited;
    static int[][] map;
    static int mapSize;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        mapSize = Integer.parseInt(bf.readLine());

        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];

        for(int i = 0; i < mapSize; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String temp = st.nextToken();
            char[] charArr = temp.toCharArray();
            for(int j = 0; j < mapSize; j++){
                map[i][j] = Integer.parseInt(String.valueOf(charArr[j]));
            }
        }
//        for(int i = 0; i < mapSize; i++){
//            for(int j = 0; j < mapSize; j++){
//                System.out.print(visited[i][j]);
//            }
//            System.out.println();
//        }

        List<Integer> answer = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    count ++;
                    answer.add(dfs(i,j,1));
                }
            }
        }

        Collections.sort(answer);

        System.out.println(count);
        for(int i : answer){
            System.out.println(i);
        }

    }
    private static int dfs(int y, int x, int count){
        visited[y][x] = true;
        if(x > 0){
            if(map[y][x - 1] == 1 && !visited[y][x- 1]){
                count = dfs(y, x - 1, count + 1);
            }
        }
        if(x < mapSize - 1){
            if(map[y][x + 1] == 1 && !visited[y][x + 1]){
                count = dfs(y, x + 1, count + 1);
            }
        }
        if(y > 0){
            if(map[y - 1][x] == 1 && !visited[y - 1][x]){
                count = dfs(y -1, x, count + 1);
            }
        }
        if(y < mapSize - 1){
            if(map[y + 1][x] == 1 && !visited[y + 1][x]){
                count = dfs(y + 1, x, count + 1);
            }
        }
        return count;
    }
}
