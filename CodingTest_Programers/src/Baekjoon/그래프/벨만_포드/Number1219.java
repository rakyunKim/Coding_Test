package Baekjoon.그래프.벨만_포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Number1219 {
	static Move[] edgeList;
	static long[] maxCost;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int cityCount = Integer.parseInt(stringTokenizer.nextToken());
		int startCity = Integer.parseInt(stringTokenizer.nextToken());
		int endCity = Integer.parseInt(stringTokenizer.nextToken());
		int transportationCount = Integer.parseInt(stringTokenizer.nextToken());
		edgeList = new Move[transportationCount];
		maxCost = new long[cityCount];

		for (int i = 0; i < transportationCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int start = Integer.parseInt(stringTokenizer.nextToken());
			int end = Integer.parseInt(stringTokenizer.nextToken());
			int charge = -(Integer.parseInt(stringTokenizer.nextToken()));
			edgeList[i] = new Move(start, end, charge);
		}

		long[] income = new long[cityCount];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < cityCount; i++){
			income[i] = Integer.parseInt(stringTokenizer.nextToken());
			if (i != startCity) maxCost[i] = Long.MIN_VALUE;
			else maxCost[startCity] = 0;
		}
		maxCost[startCity] = income[startCity];

		for (int i = 0; i <= cityCount + 100; i++){
			for (Move cityInformation : edgeList){
				int start = cityInformation.startCity;
				int end = cityInformation.endCity;
				int charge = cityInformation.charge;
				// 만약 노드가 최대 값이라면 양수 사이클에 들어가 있다는 뜻이므로 출발 노드와 연결 되어 있는 도착 노드 또한 최대 값을 넣어줌
				if (maxCost[start] == Long.MAX_VALUE) maxCost[end] = Long.MAX_VALUE;
				if (maxCost[start] != Long.MIN_VALUE && maxCost[end] < maxCost[start] + charge + income[end]){
					maxCost[end] = maxCost[start] + charge + income[end];
					// 중요한 부분, 원래 벨만-포드는 노드의 -1 만큼만 가면 에지의 개수가 최대이기에 최단 거리를 알 수 있지만,
					// 최단 거리를 구하는 문제가 아닌, 최대로 벌 수 있는 돈을 구하는 문제이기에 for루프를 문제에서 주어진 최대 값으로 돌면서
					// 노드의 -1이 지나고도 값이 변경 되는 노드들은 양수 사이클이 있는 것이므로 최대 값을 넣어줌
					// 원래는 노드 -1 만큼만 루프를 돌면 최대 값이 나와야 함. 단, 양수 사이클이 있다면 계속해서 값이 증가하기에 노드 -1이 지나고도 값이 증가함
					if (i >= cityCount - 1) maxCost[end] = Long.MAX_VALUE;
				}
			}
		}

		if (maxCost[endCity] == Long.MIN_VALUE) {
			System.out.println("gg");
		} else if (maxCost[endCity] == Long.MAX_VALUE) {
			// 만약 도착 도시의 값이 최대 값이라면 양수 사이클에 연결 되어 있는 값이므로 Gee 출력
			System.out.println("Gee");
		} else {
			System.out.println(maxCost[endCity]);
		}
	}
}
class Move {
	int startCity;
	int endCity;
	int charge;
	public Move(int startCity, int endCity, int charge) {
		this.startCity = startCity;
		this.endCity = endCity;
		this.charge = charge;
	}
}