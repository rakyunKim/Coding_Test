package Baekjoon.그리디;

import java.util.Scanner;

public class Number1541 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String example = scanner.nextLine();
		String[] str = example.split("-");
		int answer = 0;
		for (int i = 0; i < str.length; i++){
			int temp = mySum(str[i]);
			if (i == 0) answer = answer + temp;
			else answer = answer - temp;
		}
		System.out.println(answer);
	}

	private static int mySum(String s) {
		int sum = 0;
		String[] temp = s.split("[+]");
		for (int i = 0; i < temp.length; i++){
			sum += Integer.parseInt(temp[i]);
		}
		return sum;
	}

}
