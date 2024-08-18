package Baekjoon.DFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Number24479 {
	static boolean[] visited;
	static ArrayList<Integer>[] adjacency;
	static List<Integer> answer;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		int edgeCount = scanner.nextInt();
		int startNode = scanner.nextInt();
		adjacency = new ArrayList[nodeCount + 1];
		visited = new boolean[nodeCount + 1];
		answer = new ArrayList<>();
		for (int i = 1; i <= nodeCount; i++){
			adjacency[i] = new ArrayList<>();
		}
		for (int i = 0; i < edgeCount; i++){
			int first = scanner.nextInt();
			int second = scanner.nextInt();
			adjacency[first].add(second);
			adjacency[second].add(first);
		}
		for (int i = 1; i < adjacency.length; i++){
			Collections.sort(adjacency[i]);
		}
		DFS(startNode);
		for (int i = 0; i < visited.length; i++){
			if (!visited[i] && i != 0){
				System.out.println("0");
			}
			if (i < answer.size()){
				System.out.println(answer.get(i));
			}
		}
	}

	private static void DFS(int node) {
		visited[node] = true;
		answer.add(node);
		for (int next : adjacency[node]){
			if (!visited[next]){
				DFS(next);
			}
		}
	}
}
