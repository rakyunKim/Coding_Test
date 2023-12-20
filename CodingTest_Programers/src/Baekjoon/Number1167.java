package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Number1167 {
	static boolean[] visited;
	static int[] distance;
	static ArrayList<Node>[] adjacencyList;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int nodeCount = sc.nextInt();
		adjacencyList = new ArrayList[nodeCount + 1];
		for (int i = 1; i <= nodeCount; i++){
			adjacencyList[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < nodeCount; i++){
			int S = sc.nextInt();
			while (true){
				int E = sc.nextInt();
				if (E == -1){
					break;
				}
				int V = sc.nextInt();
				adjacencyList[S].add(new Node(E,V));
			}
		}
		distance = new int[nodeCount + 1];
		visited = new boolean[nodeCount + 1];
		BFS(1);
		int max = 1;
		for (int i = 2; i <= nodeCount; i++){
			if (distance[max] < distance[i]){
				max = i;
			}
		}
		distance = new int[nodeCount + 1];
		visited = new boolean[nodeCount + 1];
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[nodeCount]);
	}

	private static void BFS(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);
		visited[index] = true;
		while (!queue.isEmpty()){
			int nowNode = queue.poll();
			for (Node node : adjacencyList[nowNode]){
				int e = node.node;
				int v = node.length;
				if (!visited[e]){
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[nowNode] + v;
				}
			}
		}
	}
}

class Node {
	int node;
	int length;

	public Node(int node, int length) {
		this.node = node;
		this.length = length;
	}
}

