package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Number2343 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++){
			A[i] = scanner.nextInt();
			if (start < A[i]) start =  A[i]; // 레슨 최댓값을 시작 인덱스로 설정
			end = end  + A[i]; // 모든 레슨의 총합을 종료 인덱스로 설정
		}
		while (start <= end){
			int mid = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++){
				if (sum + A[i] > mid){
					count++;
					sum = 0;
				}
				sum = sum + A[i];
			}
			if (sum != 0) count++;
			if (count > M) start = mid + 1;
			else end = mid - 1;
		}
		System.out.println(start);
	}
}
