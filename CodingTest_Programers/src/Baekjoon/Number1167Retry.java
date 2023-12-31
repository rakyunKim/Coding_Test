package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Number1167Retry {
	static ArrayList<Edge>[] adjacencyList;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		adjacencyList = new ArrayList[nodeCount + 1];
		visited = new boolean[nodeCount + 1];
		for (int i = 1; i <= nodeCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}
		for (int i = 0; i < nodeCount; i++){
			int startNode = scanner.nextInt();
			while (true){
				int node = scanner.nextInt();
				if (node == -1) break;
				int distance = scanner.nextInt();
				adjacencyList[startNode].add(new Edge(node, distance));
			}
		}

	}
}
class Edge {
	int node;
	int distance;
	public Edge(int node, int distance){
		this.node = node;
		this.distance = distance;
	}

}
