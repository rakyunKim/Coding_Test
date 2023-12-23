package Baekjoon;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Number1747 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int min = scanner.nextInt();
		int[] arr = new int[10000001];
		for (int i = 2; i < arr.length; i++){
			arr[i] = i;
		}

		for (int i = 2; i < Math.sqrt(arr.length); i++){
			if (arr[i] == 0) continue;
			for (int j = i + i; j < arr.length; j = j + i){
				arr[j] = 0;
			}
		}

		for (int i = min; i < arr.length; i++){
			if (arr[i] != 0){
				if (checkPalindrome(arr[i])) {
				System.out.println(arr[i]);
				break;
				}
			}
		}
	}

	private static boolean checkPalindrome(int number) {
		char[] charNumber = String.valueOf(number).toCharArray();
		int startPoint = 0;
		int endPoint = charNumber.length - 1;
		while (startPoint <= endPoint){
			if (!Objects.equals(charNumber[startPoint], charNumber[endPoint])){
				return false;
			}
			startPoint++;
			endPoint--;
		}
		return true;
	}
}
