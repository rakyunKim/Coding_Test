package Baekjoon.동적계획법;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Number2193 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		long[][] D = new long[length + 1][length + 1];
		D[0][0] = 1;
		D[0][1] = 0;
		D[1][0] = 0;
		D[1][1] = 1;
		for (int i = 2; i <= length; i++){
			D[i][0] = D[i - 1][0] + D[i - 1][1];
			D[i][1] = D[i - 1][0];
		}

		System.out.println(D[length][0] + D[length][1]);
	}
}
