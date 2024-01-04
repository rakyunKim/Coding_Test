package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Number1854 {
	static final int INF = 100000000;
	public static void main(String[] args) throws Exception {
		int node, edge, k;
		int[][] adjacencyMatrix = new int[1001][1001];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		node = Integer.parseInt(stringTokenizer.nextToken());
		edge = Integer.parseInt(stringTokenizer.nextToken());
		k = Integer.parseInt(stringTokenizer.nextToken());

		PriorityQueue<Integer>[] distanceQueue = new PriorityQueue[node + 1];

		for (int i = 1; i <= node; i++) {
			distanceQueue[i] = new PriorityQueue<>(k, (o1, o2) -> o1 < o2 ? 1 : -1);
		}

		for (int i = 0; i < edge; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			int time = Integer.parseInt(stringTokenizer.nextToken());

			adjacencyMatrix[start][end] = time;
		}

		PriorityQueue<Road> priorityQ = new PriorityQueue<Road>();
		priorityQ.add(new Road(1, 0));
		distanceQueue[1].add(0);
		while (!priorityQ.isEmpty()){
			Road currentRoad = priorityQ.poll();
			for (int adjacencyNode = 1; adjacencyNode <= node; adjacencyNode++){
				if (adjacencyMatrix[currentRoad.node][adjacencyNode] != 0){
					if (distanceQueue[adjacencyNode].size() < k){
						distanceQueue[adjacencyNode].add(currentRoad.cost + adjacencyMatrix[currentRoad.node][adjacencyNode]);
						priorityQ.add(new Road(adjacencyNode, currentRoad.cost + adjacencyMatrix[currentRoad.node][adjacencyNode]));
					} else if (distanceQueue[adjacencyNode].peek() > currentRoad.cost + adjacencyMatrix[currentRoad.node][adjacencyNode]) {
						distanceQueue[adjacencyNode].poll();
						distanceQueue[adjacencyNode].add(currentRoad.cost + adjacencyMatrix[currentRoad.node][adjacencyNode]);
						priorityQ.add(new Road(adjacencyNode, currentRoad.cost + adjacencyMatrix[currentRoad.node][adjacencyNode]));
					}
				}
			}
		}
		for (int i = 1; i <= node; i++){
			if (distanceQueue[i].size() == k) {
				bufferedWriter.write(distanceQueue[i].peek() + "\n");
			} else {
				bufferedWriter.write(-1 + "\n");
			}
		}
		bufferedWriter.flush();
		bufferedWriter.close();
		bufferedReader.close();
	}
}

class Road implements Comparable<Road> {
	int node;
	int cost;
	Road(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Road o) {
		return this.cost < o.cost ? -1 : 1;
	}
}
