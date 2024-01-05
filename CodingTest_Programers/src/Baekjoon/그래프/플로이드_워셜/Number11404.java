package Baekjoon.그래프.플로이드_워셜;

import java.io.IOException;
import java.util.Scanner;

public class Number11404 {
	static int[][] distance;
	static final int MAX_VALUE = 100000000;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int cityCount = scanner.nextInt();
		int busCount = scanner.nextInt();
		distance = new int[cityCount + 1][cityCount + 1];

		for (int i = 1; i <= cityCount; i++){
			for (int j = 1; j <= cityCount; j++){
				if (i == j){
					distance[i][j] = 0;
 				} else {
					distance[i][j] = MAX_VALUE;
				}
			}
		}

		for (int i = 0; i < busCount; i++){
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int charge = scanner.nextInt();
			int existing = distance[start][end];
			if (existing > charge){
				distance[start][end] = charge;
			}
		}

		for (int stopover = 1; stopover <= cityCount; stopover++){
			for (int start = 1; start <= cityCount; start++){
				for (int end = 1; end <= cityCount; end++){
					if (distance[start][end] > distance[stopover][end] + distance[start][stopover]){
						distance[start][end] = distance[stopover][end] + distance[start][stopover];
					}
				}
			}
		}

		for (int i = 1; i <= cityCount; i++){
			for (int j = 1; j <= cityCount; j++){
				if (distance[i][j] == MAX_VALUE){
					System.out.print(0);
				} else {
					System.out.print(distance[i][j]);
				}
				System.out.print(" ");
			}

			System.out.println();
		}
	}
}
