package Baekjoon.조합;

import java.io.IOException;
import java.util.Scanner;

public class Number1010 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int[][] D = new int[31][31];
		for (int i = 0; i <= 30; i++) {
			D[i][1] = i;
			D[i][0] = 1;
			D[i][i] = 1;
		}
		for (int i = 2; i <= 30; i++) {
			for (int j = 1; j < i; j++) {
				D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
			}
		}
		int testcase = scanner.nextInt();
		for (int i = 0; i < testcase; i++){
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			System.out.println(D[M][N]);
		}
	}
}
