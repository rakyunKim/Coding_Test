package Baekjoon.소마코테준비;

import java.io.*;
import java.util.*;

public class Number1753 {
    static ArrayList<Edge>[] adjacency;
    static int[] dp;
    static PriorityQueue<Edge> queue = new PriorityQueue<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(bf.readLine());

        adjacency = new ArrayList[nodeCount + 1];
        for(int i = 1; i <= nodeCount; i++){
            adjacency[i] = new ArrayList<>();
        }

        dp = new int[nodeCount + 1];
        for(int i = 0; i < nodeCount; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < edgeCount; i++){
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            adjacency[start].add(new Edge(end,size));
        }

        queue.add(new Edge(startNode, 0));
        dp[startNode] = 0;

        visited = new boolean[nodeCount + 1];

        while(!queue.isEmpty()){
            Edge current = queue.poll();
            int currentNode = current.endNode;
            if(!visited[currentNode]){
                visited[currentNode] = true;
                for(Edge nextNode : adjacency[currentNode]){
                    int nodeIndex = nextNode.endNode;
                    int newDistance = dp[currentNode] + nextNode.length;
                    int currentDistance = dp[nodeIndex];
                    if(newDistance < currentDistance){
                        dp[nodeIndex] = newDistance;
                        queue.add(new Edge(nodeIndex, dp[nodeIndex]));
                    }
                }
            }
        }
        for(int i = 1; i <= nodeCount; i++){
            if(visited[i]) System.out.println(dp[i]);
            else System.out.println("INF");
        }

    }
}

class Edge implements Comparable<Edge>{
    int endNode;
    int length;
    public Edge(int endNode, int length) {
        this.endNode = endNode;
        this.length = length;
    }

    public int compareTo(Edge e){
        if(this.length > e.length) return 1;
        else return -1;
    }
}
