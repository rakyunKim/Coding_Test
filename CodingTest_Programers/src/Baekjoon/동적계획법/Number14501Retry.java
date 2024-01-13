package Baekjoon.동적계획법;

import java.io.IOException;
import java.util.Scanner;

public class Number14501Retry {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int dayCount = scanner.nextInt();
		int[] D = new int[dayCount + 2];
		int[] time = new int[dayCount + 1];
		int[] pay = new int[dayCount + 1];
		for (int i = 0; i < dayCount; i++){
			time[i] = scanner.nextInt();
			pay[i] = scanner.nextInt();
		}

		for (int i = dayCount; i > 0; i--){
			if (i + time[i] > dayCount + 1) D[i] = D[i + 1];
			else {
				D[i] = Math.max(D[i + 1], pay[i] + D[i + time[i]]);
			}
		}

		System.out.println(D[1]);
	}
}
