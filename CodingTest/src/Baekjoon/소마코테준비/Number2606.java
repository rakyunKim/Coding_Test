package Baekjoon.소마코테준비;

import java.util.*;

public class Number2606 {
    static ArrayList<Integer>[] adjacency;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int computerCount = scanner.nextInt();
        adjacency = new ArrayList[computerCount + 1];

        visited = new boolean[computerCount + 1];
        int edgeCount = scanner.nextInt();

        for(int i = 1; i <= computerCount; i++){
            adjacency[i] = new ArrayList<>();
        }

        for(int i = 0; i < edgeCount; i++){
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            adjacency[first].add(second);
            adjacency[second].add(first);
        }

        dfs(1);
        int count = 0;
        for(boolean b : visited){
            if(b) count ++;
        }

        System.out.println(count - 1);
    }

    private static void dfs(int bug){
        visited[bug] = true;
        for(int i : adjacency[bug]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }
}
