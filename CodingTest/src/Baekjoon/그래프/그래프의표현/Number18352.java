package Baekjoon.그래프.그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number18352 {
	static ArrayList<Integer>[] adjacencyList;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int nodeCount =	Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
		int goalDistance = Integer.parseInt(stringTokenizer.nextToken());
		int startCity = Integer.parseInt(stringTokenizer.nextToken());
		visited = new int[nodeCount + 1];
		adjacencyList = new ArrayList[nodeCount + 1];
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= nodeCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			adjacencyList[start].add(end);
		}

		for (int i = 0; i <= nodeCount; i++){
			visited[i] = -1;
		}
		
		BFS(startCity);

		for (int i = 0; i <= nodeCount; i++){
			if (visited[i] == goalDistance){
				answer.add(i);
			}
		}
		if (answer.isEmpty()){
			System.out.println("-1");
		}else {
			Collections.sort(answer);
			for (int i : answer){
				System.out.println(i);
			}
		}
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node]++;
		while (!queue.isEmpty()){
			int currentNode = queue.poll();
			for (int adjacencyNode : adjacencyList[currentNode]){
				if (visited[adjacencyNode] == -1){
					visited[adjacencyNode] = visited[currentNode] + 1;
					queue.add(adjacencyNode);
				}
			}
		}
	}
}
