package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Number11724 {
	static boolean[] visited;
	static ArrayList<Integer>[] A;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());

		visited = new boolean[nodeCount + 1]; // 0번 인덱스를 사용하지 않기 위함

		A = new ArrayList[nodeCount + 1];
		for (int i  = 1; i < nodeCount + 1; i++){
			A[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < edgeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int startPoint = Integer.parseInt(stringTokenizer.nextToken());
			int endPoint = Integer.parseInt(stringTokenizer.nextToken());
			A[startPoint].add(endPoint);
			A[endPoint].add(startPoint);
		}
		int answer = 0;

		for (int i = 1; i < nodeCount + 1; i++){
			if (!visited[i]){
				answer++;
				dfs(i);
			}
		}
		System.out.println(answer);
	}

	private static void dfs(int currentNode) {
		if (visited[currentNode]){
			return;
		}
		visited[currentNode] = true;
		for (int i  : A[currentNode]){
			if (!visited[i]){
				dfs(i);
			}
		}
	}
}
