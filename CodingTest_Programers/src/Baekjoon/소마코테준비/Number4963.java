package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number4963 {
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static int width;
    static int height;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(bf.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            map = new int[height][width];
            visited = new boolean[height][width];
            count = 0;
            if(width == 0 && height == 0) {
                break;
            } else{
                for(int i = 0; i < height; i++){
                    st = new StringTokenizer(bf.readLine());
                    for(int j = 0; j < width; j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                for(int i = 0; i < height; i++){
                    for(int j = 0; j < width; j++){
                        if(!visited[i][j]){
                            if(map[i][j] == 1){
                                count ++;
                                dfs(i, j);
                            }
                            if(map[i][j] == 0){
                                visited[i][j] = true;
                            }
                        }
                    }
                }

                System.out.println(count);
            }
        }
    }

    private static void dfs(int y, int x) {
        if(!visited[y][x]){
            visited[y][x] = true;
            if(y > 0){
                if(x > 0 && !visited[y - 1][x - 1] && map[y - 1][x - 1] == 1){
                    dfs(y - 1, x - 1);
                }
                if(!visited[y - 1][x] && map[y - 1][x] == 1){
                    dfs(y - 1, x);
                }
                if(x < width - 1 && !visited[y - 1][x + 1] && map[y - 1][x + 1] == 1){
                    dfs(y - 1, x + 1);
                }
            }
            if(y < height - 1){
                if(x > 0 && !visited[y + 1][x - 1] && map[y + 1][x - 1] == 1){
                    dfs(y + 1, x - 1);
                }
                if(!visited[y + 1][x] && map[y + 1][x] == 1){
                    dfs(y + 1, x);
                }
                if(x < width - 1 && !visited[y + 1][x + 1] && map[y + 1][x + 1] == 1){
                    dfs(y + 1, x + 1);
                }
            }
            if(x > 0 && !visited[y][x - 1] && map[y][x - 1] == 1){
                dfs(y, x - 1);
            }
            if(x < width - 1 && !visited[y][x + 1] && map[y][x + 1] == 1){
                dfs(y, x + 1);
            }
        }
    }
}
