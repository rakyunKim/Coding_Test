package Baekjoon;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Number1715 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드 묶음의 수 저장
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int data = sc.nextInt();
			pq.add(data);
		}
		int data1 = 0;
		int data2 = 0;
		int sum = 0;
		while (pq.size() != 1) { // 큐에 사이즈가 1이면 1개의 덱만 남아 모든 덱이 합쳐졌으므로 중단
			data1 = pq.remove();
			data2 = pq.remove();
			sum += data1 + data2; // 덱을 합칠 때 걸리는 회수
			pq.add(data1 + data2); // 합쳐진 덱을 다시 덱 뭉치인 큐에 넣음
		}
		System.out.println(sum);
	}
}
