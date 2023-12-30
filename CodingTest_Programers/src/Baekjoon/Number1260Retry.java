package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number1260Retry {
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
		int startNode = Integer.parseInt(stringTokenizer.nextToken());

		adjacencyList = new ArrayList[nodeCount + 1];
		visited = new boolean[nodeCount + 1];

		for (int i = 1; i <= nodeCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			adjacencyList[start].add(end);
			adjacencyList[end].add(start);
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
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		visited[startNode] = true;
		while (!queue.isEmpty()){
			int currentNode = queue.poll();
			System.out.print(currentNode + " ");
			for (int i : adjacencyList[currentNode]){
				if (!visited[i]){
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void DFS(int startNode) {
		visited[startNode] = true;
		System.out.print(startNode + " ");
		for (int currentNode : adjacencyList[startNode]){
			if (!visited[currentNode]){
				DFS(currentNode);
			}
		}
	}
}
