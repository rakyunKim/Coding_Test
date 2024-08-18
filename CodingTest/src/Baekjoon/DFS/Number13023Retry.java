package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Number13023Retry {
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	static boolean answer;
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
		adjacencyList = new ArrayList[nodeCount];

		for (int i = 0; i < nodeCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i= 0; i < edgeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int first = Integer.parseInt(stringTokenizer.nextToken());
			int second = Integer.parseInt(stringTokenizer.nextToken());
			adjacencyList[first].add(second);
			adjacencyList[second].add(first);
		}
		visited = new boolean[nodeCount];
		answer = false;
		for (int i = 0; i < nodeCount; i++){
			DFS(i, 1);
		}

		if (answer){
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static void DFS(int startNode, int depth) {
		if (depth == 5 || answer) {
			answer = true;
			return;
		}
		visited[startNode] = true;
		for (int currentNode : adjacencyList[startNode]){
			if (!visited[currentNode]){
				DFS(currentNode, depth + 1);
			}
		}
		visited[startNode] = false;
	}
}
