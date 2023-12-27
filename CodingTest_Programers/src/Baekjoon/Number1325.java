package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number1325 {
	static ArrayList<Integer>[] adjacencyList;
	static boolean[] visited;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
		adjacencyList = new ArrayList[nodeCount + 1];
		answer = new int[nodeCount + 1];

		for (int i = 1; i <= nodeCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			adjacencyList[start].add(end);
		}

		for (int i = 1; i <= nodeCount; i++){
			visited = new boolean[nodeCount + 1];
			BFS(i);
		}
		int max = 0;
		for (int i = 1; i <= nodeCount; i++){
			max = Math.max(max, answer[i]);
		}
		for (int i = 1; i <= nodeCount; i++){
			if (answer[i] == max){
				System.out.print(i + " ");
			}
		}
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		while (!queue.isEmpty()){
			int currentNode = queue.poll();
			for (int i : adjacencyList[currentNode]){
				if (!visited[i]){
					visited[i] = true;
					answer[i]++;
					queue.add(i);
				}
			}
		}
	}
}
