package Baekjoon.그래프.최소신장트리;

import java.io.IOException;
import java.util.Scanner;

public class Number1197 {
	static Edge[] edgeList;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		int edgeCount  = scanner.nextInt();
		edgeList = new Edge[edgeCount];
		parent = new int[nodeCount + 1];

		for (int i = 1; i <= nodeCount; i++){
			parent[i] = i;
		}

		for (int i = 0; i < edgeCount; i++){
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int distance = scanner.nextInt();
			edgeList[i] = new Edge(start, end, distance);
		}

		int maximumEdgeCount = nodeCount - 1;
		int answer = 0;
		for (int i = 0; i < edgeCount; i++){
			Edge temporary = edgeList[i];
			int start = temporary.start;
			int end = temporary.end;
			int distance = temporary.distance;
			if(find(start) != find(end)) {
				union(start, end);
				answer += distance;
				maximumEdgeCount++;
				if (maximumEdgeCount == nodeCount - 1) break;
			}
		}
		System.out.println(answer);

	}
	private static void union(int start, int end){
		int startParent = find(start);
		int endParent = find(end);
		if (startParent != endParent){
			parent[end] = startParent;
		}
	}
	private static int find(int node) {
		if (node == parent[node]) return node;
		else {
			return parent[node] = find(parent[node]);
		}
	}
}
class Edge implements Comparable<Edge>{
	int start, end, distance;

	public Edge(int start, int end, int distance){
		this.start = start;
		this.end = end;
		this.distance = distance;
	}

	@Override
	public int compareTo(Edge o) {
		return this.distance - o.distance;
	}
}