package Baekjoon.소마코테준비;

import java.util.*;

public class Number1260 {
    static int nodeCount;
    static int edgeCount;
    static boolean[] visited;
    static ArrayList<Integer>[] adjacencyList;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        nodeCount = scanner.nextInt();
        edgeCount = scanner.nextInt();
        int startNode = scanner.nextInt();

        visited = new boolean[nodeCount + 1];
        adjacencyList = new ArrayList[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++){
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++){
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            adjacencyList[first].add(second);
            adjacencyList[second].add(first);
        }

        for (int i = 1; i <= nodeCount; i++){
            Collections.sort(adjacencyList[i]);
        }

        DFS(startNode);
        
        visited = new boolean[nodeCount + 1];
        System.out.println();
        BFS(startNode);
    }

    private static void BFS(int startNode) {
        visited[startNode] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        while (!queue.isEmpty()){
            startNode = queue.poll();
            System.out.print(startNode + " ");
            for (int node : adjacencyList[startNode]){
                if (!visited[node]){
                    queue.add(node);
                    visited[node] = true;
                }
            }
        }
    }

    private static void DFS(int startNode) {
        visited[startNode] = true;
        System.out.print(startNode + " ");
        for (int nextNode : adjacencyList[startNode]){
            if (!visited[nextNode]){
                DFS(nextNode);
            }
        }
    }
}
