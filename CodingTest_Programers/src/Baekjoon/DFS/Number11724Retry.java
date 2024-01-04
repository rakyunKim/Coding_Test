package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Number11724Retry {
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
		adjacencyList = new ArrayList[nodeCount + 1];
		visited = new boolean[nodeCount + 1];

		for (int i = 1; i <= nodeCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int first = Integer.parseInt(stringTokenizer.nextToken());
			int second = Integer.parseInt(stringTokenizer.nextToken());
			adjacencyList[first].add(second);
			adjacencyList[second].add(first);
		}

		int count = 0;
		for (int i = 1; i <= nodeCount; i++){
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}

	private static void DFS(int start) {
		if (visited[start]){
			return;
		} else {
			visited[start] = true;
			for (int current : adjacencyList[start]){
				if (!visited[current]){
					DFS(current);
				}
			}
		}
	}
}
