package Baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Number1753 {
	static boolean[] visited;
	static ArrayList<Edge>[] adjacencyList;
	static int[] distanceArray;
	static int nodeCount;
	static int edgeCount;
	static int startNode;
	static int MAX_VALUE;
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		nodeCount = scanner.nextInt();
		edgeCount = scanner.nextInt();
		adjacencyList = new ArrayList[nodeCount + 1];
		visited = new boolean[nodeCount + 1];
		distanceArray = new int[nodeCount + 1];
		startNode = scanner.nextInt();
		MAX_VALUE = 1000000000;

		for (int i = 1; i <= nodeCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}

		for (int i = 0; i < edgeCount; i++){
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int distance = scanner.nextInt();
			adjacencyList[start].add(new Edge(end, distance));
		}

		for (int i = 1; i <= nodeCount; i++){
			if (i == startNode){
				distanceArray[i] = 0;
			} else {
				distanceArray[i] = MAX_VALUE;
			}
		}
		dijkstra();

		for (int i = 1; i <= nodeCount; i++){
			if (distanceArray[i] == MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distanceArray[i]);
			}
		}
	}

	private static void dijkstra() {
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		queue.add(new Edge(startNode, 0));

		while (!queue.isEmpty()){
			Edge node = queue.poll();
			int currentNodeIndex = node.node;
			if (!visited[currentNodeIndex]){
				visited[currentNodeIndex] = true;
				for (Edge nextNode : adjacencyList[currentNodeIndex]){
					int nodeIndex = nextNode.node;
					int newDistance = distanceArray[currentNodeIndex] + nextNode.distance;
					int currentDistance = distanceArray[nodeIndex];
					if (newDistance < currentDistance){
						distanceArray[nodeIndex] = newDistance;
						queue.add(new Edge(nodeIndex, distanceArray[nodeIndex]));
					}
				}
			}
		}
	}
}

class Edge implements Comparable<Edge>{
	int node;
	int distance;
	public Edge(int node, int distance){
		this.node = node;
		this.distance = distance;
	}
	public int compareTo(Edge e){
		if (this.distance > e.distance) return 1;
		else return -1;
	}
}
