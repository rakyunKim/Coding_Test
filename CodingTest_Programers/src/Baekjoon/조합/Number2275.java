package Baekjoon.조합;

import java.io.IOException;
import java.util.Scanner;

public class Number2275 {
	static int[][] DP;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int testCase = scanner.nextInt();
		DP = new int[15][15];
		for (int i = 1; i < 15; i++){
			DP[0][i] = i;
		}
		for (int i = 1; i < 15; i++){
			for (int j = 1; j < 15; j++){
				DP[i][j] = DP[i - 1][j] + DP[i][j - 1];
			}
		}
		for (int i = 0; i < testCase; i++){
			int floor = scanner.nextInt();
			int room = scanner.nextInt();
			System.out.println(DP[floor][room]);
		}
	}
}
