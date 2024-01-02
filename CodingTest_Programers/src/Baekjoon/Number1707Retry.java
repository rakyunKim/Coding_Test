package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Number1707Retry {
	static ArrayList<Integer>[]  adjacencyList;
	static boolean[] visited;
	static boolean isEven;
	static int[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bufferedReader.readLine());
		for (int test = 0; test < testcase; test++){
			String[] s = bufferedReader.readLine().split(" ");
			int nodeCount = Integer.parseInt(s[0]);
			int edgeCount = Integer.parseInt(s[1]);
			adjacencyList = new ArrayList[nodeCount + 1];
			visited = new boolean[nodeCount + 1];
			isEven = true;
			check = new int[nodeCount + 1];
			for (int node = 1; node <= nodeCount; node++){
				adjacencyList[node] = new ArrayList<>();
			}
			for (int edge = 0; edge < edgeCount; edge++){
				s = bufferedReader.readLine().split(" ");
				int first = Integer.parseInt(s[0]);
				int second = Integer.parseInt(s[1]);
				adjacencyList[first].add(second);
				adjacencyList[second].add(first);
			}
			for (int node = 1; node <= nodeCount; node++){
				if (isEven){
					DFS(node);
				} else {
					break;
				}
			}
			if (isEven) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		bufferedReader.close();
	}

	private static void DFS(int pastNode) {
		visited[pastNode] = true;
		for (int currentNode : adjacencyList[pastNode]){
			if (!visited[currentNode]){
				check[currentNode] = (check[pastNode] + 1) % 2;
				DFS(currentNode);
			} else if (check[currentNode] == check[pastNode]){
				isEven = false;
			}
		}
	}
}
