package Baekjoon.소마코테준비;
import java.util.*;

public class Number2644 {
    static int answer;
    static boolean[] visited;
    static int end;
    static ArrayList<Integer>[] adjacency;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int personCount = scanner.nextInt();

        int start = scanner.nextInt();
        end = scanner.nextInt();

        adjacency = new ArrayList[personCount + 1];

        for(int i = 1; i <= personCount; i++){
            adjacency[i] = new ArrayList<>();
        }

        visited = new boolean[personCount + 1];

        int edgeCount = scanner.nextInt();

        for(int i = 0; i < edgeCount; i++){
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            adjacency[first].add(second);
            adjacency[second].add(first);
        }
        answer = -1;
        dfs(start, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int count){
        if(start == end){
            answer = count;
            return;
        }
        if(!visited[start]){
            visited[start] = true;
            for(int i : adjacency[start]){
                if(!visited[i]){
                    dfs(i, count +1);
                }
            }
        }
    }
}
