package Baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number2164 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int question = scanner.nextInt();
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= question; i++){
			queue.add(i);
		}

		while (queue.size() > 1){
			queue.poll();
			Integer num = queue.poll();
			queue.add(num);
		}

		Integer answer = queue.poll();
		System.out.println(answer);
	}
}
