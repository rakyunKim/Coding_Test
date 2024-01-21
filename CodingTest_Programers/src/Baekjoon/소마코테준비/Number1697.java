package Baekjoon.소마코테준비;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number1697 {
    static int N;
    static int K;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int input2 = scanner.nextInt();

        N = input;
        K = input2;

        int result = bfs(N);
        System.out.println(result);
    }

    private static int  bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int n;
        visited[node] = 1;
        while (!queue.isEmpty()) {
            n = queue.poll();
            if (n == K) return visited[n]-1;
            if (n-1>=0 && visited[n-1] == 0) {
                visited[n-1] = visited[n]+1;
                queue.add(n-1);
            }
            if (n+1 <= 100000 && visited[n+1] == 0) {
                visited[n+1] = visited[n]+1;
                queue.add(n+1);
            }
            if (2*n <= 100000 && visited[2*n] == 0) {
                visited[2*n] = visited[n] + 1;
                queue.add(2*n);
            }
        }
        return -1;
    }
}