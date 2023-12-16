package Baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class Number2750 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		int[] sortArr = new int[count];

		for (int i = 0; i < count; i++){
			sortArr[i] = scanner.nextInt();
		}

		for (int i = 0; i < count - 1; i++){
			for (int j = 0; j < count - 1 - i; j++){
				if (sortArr[j] > sortArr[j+1]){
					int space = sortArr[j];
					sortArr[j] = sortArr[j+1];
					sortArr[j+1] = space;
				}
			}
		}

		for (int i = 0; i < count; i++){
			System.out.println(sortArr[i]);
		}
	}
}
