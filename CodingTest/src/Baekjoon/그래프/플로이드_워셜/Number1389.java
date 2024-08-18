package Baekjoon.그래프.플로이드_워셜;

import java.io.IOException;
import java.util.Scanner;

public class Number1389 {
	static int[][] distance;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int friendCount = scanner.nextInt();
		int friendshipCount = scanner.nextInt();
		distance = new int[friendCount + 1][friendCount + 1];
		final int MAX_VALUE = 100000000;

		for (int i = 0; i < friendshipCount; i++){
			int first = scanner.nextInt();
			int second = scanner.nextInt();
			distance[first][second] = 1;
			distance[second][first] = 1;
		}

		for (int i = 1; i <= friendCount; i++){
			for (int j = 1; j <= friendCount; j++){
				if (i != j && distance[i][j] == 0){
					distance[i][j] = MAX_VALUE;
				}
			}
		}

		for (int k = 1; k <= friendCount; k++){
			for (int i = 1; i <= friendCount; i++){
				for (int j = 1; j <= friendCount; j++){
					if (distance[i][j] == MAX_VALUE){
						if (distance[k][j] != MAX_VALUE && distance[k][j] != 0 && distance[i][k] != MAX_VALUE && distance[i][k] != 0){
							distance[i][j] = distance[i][k] + distance[k][j];
						}
					}
					if (distance[i][j] > distance[k][j] + distance[i][k]){
						distance[i][j] = distance[k][j] + distance[i][k];
					}
				}
			}
		}

		int min = MAX_VALUE;
		int answerIndex = 0;
		for (int i = 1; i <= friendCount; i++){
			int baconCount = 0;
			for (int j = 1; j <= friendCount; j++){
				baconCount += distance[i][j];
			}
			if (baconCount < min){
				min = baconCount;
				answerIndex = i;
			} else if (baconCount == min){
				if (answerIndex > i){
					answerIndex = i;
				}
			}
		}

		System.out.println(answerIndex);
	}
}
