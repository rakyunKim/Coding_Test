package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Number1260 {
	static ArrayList<Integer>[] adjacentArray;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int start = scanner.nextInt();
		visited = new boolean[N + 1];
		adjacentArray = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++){
			adjacentArray[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++){
			int s = scanner.nextInt();
			int e = scanner.nextInt();
			adjacentArray[s].add(e);
			adjacentArray[e].add(s);
		}
		for (int i = 1; i <=N; i++){
			Collections.sort(adjacentArray[i]);
		}
		DFS(start);
		System.out.println();
		visited = new boolean[N+1];
		BFS(start);
		System.out.println();
	}

	private static void BFS(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;

		while (!queue.isEmpty()){
			int nowNode = queue.poll();
			System.out.print(nowNode + " ");
			for (int i : adjacentArray[nowNode]){
				if (!visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

	private static void DFS(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		for (int i : adjacentArray[node]){
			if(!visited[i]){
				DFS(i);
			}
		}
	}
}
