package Baekjoon.동적계획법;

import java.io.IOException;
import java.util.Scanner;

public class Number10844 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		long[][] DP = new long[n + 1][11];

		for (int i = 1; i <= 9; i++){
			DP[1][i] = 1;
		}
		for (int i = 2; i <= n; i++){
			DP[i][0] = DP[i - 1][1];
			DP[i][9] = DP[i - 1][8];
			for (int j = 1; j <= 8; j++){
				DP[i][j] = (DP[i - 1][j - 1] + DP[i - 1][j + 1]) % 1000000000;
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++){
			sum = (sum + DP[n][i]) % 1000000000;
		}
		System.out.println(sum);
	}
}
