package Baekjoon;

import java.util.Scanner;

public class Number2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long question = sc.nextLong();
		int count = 1;
		int sum = 1;
		int start = 1;
		int end = 1;
		while (end != question){
			if (sum == question) {
				count++;
				start++;
				end = start;
				sum = start;
			}
			if (sum < question){
				end = end + 1;
				sum = sum + end;
			}
			if (sum > question){
				start++;
				end = start;
				sum = start;
			}
		}
		System.out.println(count);
	}
}
