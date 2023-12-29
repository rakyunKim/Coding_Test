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

		for (int i = 1; i <= nodeCount; i++){
			Collections.sort(adjacencyList[i]);
		}
		visited = new boolean[nodeCount + 1];
		DFS(startNode);
		System.out.println();
		visited = new boolean[nodeCount + 1];
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
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	private static void DFS(int startNode) {
		System.out.print(startNode + " ");
		if (!visited[startNode]){
			visited[startNode] = true;
			for (int currentNode : adjacencyList[startNode]){
				if (!visited[currentNode]){
					DFS(currentNode);
				}
			}
		}
	}
}
