package Baekjoon;

import java.util.Scanner;

public class Number11657 {
	static BusStop[] edgeList;
	static int[] distanceArray;
	static final int MAX_VALUE = 100000000;
	static final int START_CITY = 1;
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		int edgeCount = scanner.nextInt();
		edgeList = new BusStop[edgeCount];
		distanceArray = new int[nodeCount + 1];

		for (int i = 1; i <= nodeCount; i++){
			if (i != 1){
				distanceArray[i] = MAX_VALUE;
			} else {
				distanceArray[START_CITY] = 0;
			}
		}

		for (int i = 0; i < edgeCount; i++){
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int time = scanner.nextInt();
			edgeList[i] = new BusStop(start, end, time);
		}

		int repeat = nodeCount - 1;
		while (repeat > 0){
			for (BusStop nextBus : edgeList){
				int startCity = nextBus.startCity;
				int endCity = nextBus.endCity;
				int time = nextBus.time;
				if (distanceArray[startCity] != MAX_VALUE){
					if (distanceArray[endCity] > distanceArray[startCity] + time){
						distanceArray[endCity] = distanceArray[startCity] + time;
					}
				}
			}
			repeat--;
		}

		boolean isMinusCycle = false;
		for (BusStop nextBus : edgeList){
			int startCity = nextBus.startCity;
			int endCity = nextBus.endCity;
			int time = nextBus.time;
			if (distanceArray[startCity] != MAX_VALUE){
				if (distanceArray[endCity] > distanceArray[startCity] + time){
					isMinusCycle = true;
				}
			}
		}

		if (isMinusCycle) {
			System.out.println("-1");
		} else {
			for (int i = 2; i <= nodeCount; i++){
				if (distanceArray[i] == MAX_VALUE){
					System.out.println("-1");
				} else {
					System.out.println(distanceArray[i]);
				}
			}
		}
	}
}
class BusStop {
	int startCity;
	int endCity;
	int time;

	public BusStop(int startCity, int endCity, int time) {
		this.startCity = startCity;
		this.endCity = endCity;
		this.time = time;
	}
}
