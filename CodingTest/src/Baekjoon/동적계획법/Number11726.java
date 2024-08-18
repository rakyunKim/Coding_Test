package Baekjoon.동적계획법;

import java.io.IOException;
import java.util.Scanner;

public class Number11726 {
	public static void main(String[] args) throws IOException {
		int[] DP = new int[1001];
		DP[1] = 1;
		DP[2] = 2;
		DP[3] = 3;
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 4; i <= n; i++){
			DP[i] = (DP[i - 1] + DP[i - 2]) % 10007;
		}
		System.out.println(DP[n]);
	}
}
