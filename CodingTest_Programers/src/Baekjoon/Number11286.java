package Baekjoon;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Number11286 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int operationNumber = scanner.nextInt();
		int count = 0;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
			Comparator.comparingInt((Integer i) -> Math.abs(i)).thenComparingInt(i -> i)
		);

		List<Integer> listForPrint = new ArrayList<>();

		while (operationNumber > count){
			int input = scanner.nextInt();
			if (input != 0){
				priorityQueue.add(input);
			} else {
				if (priorityQueue.isEmpty()) {
					listForPrint.add(0);
				}else {
					listForPrint.add(priorityQueue.poll());
				}
			}
			count++;
		}
		listForPrint.forEach(System.out::println);
	}
}
