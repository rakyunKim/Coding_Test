package Baekjoon.DFS;

import java.io.IOException;
import java.util.Scanner;

public class Number2023 {
	static int LENGTH;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		LENGTH = scanner.nextInt();

		DFS(2, 1);
		DFS(3, 1);
		DFS(5, 1);
		DFS(7, 1);
	}

	private static void DFS(int number, int digitPlace) {
		if (digitPlace == LENGTH){
			if (isPrime(number)) {
				System.out.println(number);
			}
			return;
		}
		for (int i = 1; i < 10; i++){
			if (i % 2 == 0){
				continue;
			}
			int nextDigitNumber = number * 10 + i;
			if (isPrime(nextDigitNumber)){
				DFS(nextDigitNumber, digitPlace + 1);
			}
		}
	}

	private static boolean isPrime(int checkNumber) {
		for (int i = 2; i <= checkNumber / 2; i++){
			if (checkNumber % i == 0){
				return false;
			}
		}
		return true;
	}
}
