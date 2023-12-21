package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Number11047 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int coinCount = scanner.nextInt();
		int targetPrice = scanner.nextInt();
		int[] coin = new int[coinCount];
		for (int i  = 0; i < coinCount; i++){
			coin[i] = scanner.nextInt();
		}

		int answer = 0;
		int remainingAmount = targetPrice;
		int currentCoin = coinCount - 1;
		while (remainingAmount > 0){
			if (coin[currentCoin] <= remainingAmount){
				answer += remainingAmount / coin[currentCoin];
				remainingAmount = remainingAmount % coin[currentCoin];
			}else currentCoin--;
		}
		System.out.println(answer);
	}
}
