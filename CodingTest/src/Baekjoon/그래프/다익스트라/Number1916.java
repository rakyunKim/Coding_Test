package Baekjoon.그래프.다익스트라;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Number1916 {
	static int[] minCostArray;
	static boolean[] visited;
	static ArrayList<Bus>[] adjacency;
	static PriorityQueue<Bus> queue;
	static int MAX_VALUE;
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int cityCount = scanner.nextInt();
		int busCount = scanner.nextInt();
		minCostArray = new int[cityCount + 1];
		visited = new boolean[cityCount + 1];
		adjacency = new ArrayList[cityCount + 1];
		queue = new PriorityQueue<>();
		MAX_VALUE = 1000000000;

		for (int i = 1; i <= cityCount; i++){
			adjacency[i] = new ArrayList<>();
		}

		for (int i = 0; i < busCount; i++){
			int start = scanner.nextInt();
			int arrive = scanner.nextInt();
			int cost = scanner.nextInt();
			adjacency[start].add(new Bus(arrive, cost));
		}

		int startCity = scanner.nextInt();
		int finalArriveCity = scanner.nextInt();

		for (int i = 1; i <= cityCount; i++){
			if (i != startCity){
				minCostArray[i] = MAX_VALUE;
			} else {
				minCostArray[i] = 0;
			}
		}

		queue.add(new Bus(startCity, 0));
		while (!queue.isEmpty()){
			Bus currentBus = queue.poll();
			int currentCity = currentBus.arriveCity;
			if (!visited[currentCity]){
				visited[currentCity] = true;
				for (Bus nextBus : adjacency[currentCity]){
					int nextCity = nextBus.arriveCity;
					int nextCityCost = nextBus.cost;
					int newCost = minCostArray[currentCity] + nextCityCost;
					int currentCost = minCostArray[nextCity];
					if (newCost < currentCost){
						minCostArray[nextCity] = newCost;
						queue.add(new Bus(nextCity, newCost));
					}
				}
			}
		}

		System.out.println(minCostArray[finalArriveCity]);
	}
}
class Bus implements Comparable<Bus>{
	int arriveCity;
	int cost;
	public Bus(int arriveCity, int cost) {
		this.arriveCity = arriveCity;
		this.cost = cost;
	}

	@Override
	public int compareTo(Bus o) {
		return this.cost - o.cost;
	}
}
