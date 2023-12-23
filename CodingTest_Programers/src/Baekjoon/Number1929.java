package Baekjoon;

import java.util.Scanner;

public class Number1929 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int start = scanner.nextInt();
		int end = scanner.nextInt();
		int[] arr = new int[end + 1];

		for (int i = 2; i <= end; i++){
			arr[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(end); i++){
			if (arr[i] == 0) continue;
			for (int j = i + i; j <= end; j = j+ i){
				arr[j] = 0;
			}
		}

		for (int i = start; i <= end; i++){
			if (arr[i] != 0){
				System.out.println(arr[i]);
			}
		}
	}
}
