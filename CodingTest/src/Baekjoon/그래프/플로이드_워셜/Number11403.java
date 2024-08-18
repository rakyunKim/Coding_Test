package Baekjoon.그래프.플로이드_워셜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number11403 {
	static int[][] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		distance = new int[nodeCount][nodeCount];

		for (int i = 0; i < nodeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for (int j = 0; j < nodeCount; j++){
				distance[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		for (int k = 0; k < nodeCount; k++){
			for (int i = 0; i <  nodeCount; i++){
				for (int j = 0; j < nodeCount; j++){
					if (distance[i][k] == 1 && distance[k][j] == 1) distance[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < nodeCount; i++){
			for (int j = 0; j < nodeCount; j++){
				System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}
}
