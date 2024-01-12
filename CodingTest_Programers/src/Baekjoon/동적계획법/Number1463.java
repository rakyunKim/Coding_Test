package Baekjoon.동적계획법;

import java.io.IOException;
import java.util.Scanner;

public class Number1463 {
	static int[] D;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		D = new int[1000001];
		int number = scanner.nextInt();
		D[1] = 0;
		D[2] = 1;
		D[3] = 1;

		for (int i = 4; i <= number; i++){
			int minimum = D[i - 1] + 1;
			if(i % 3 == 0 && D[i / 3] + 1 < minimum) minimum = D[i / 3] + 1;
			if(i % 2 == 0 && D[i / 2] + 1 < minimum) minimum = D[i / 2] + 1;
			D[i] = minimum;
		}

		System.out.println(D[number]);
	}
}
