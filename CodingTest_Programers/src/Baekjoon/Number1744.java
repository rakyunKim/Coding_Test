package Baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Number1744 {
	static int zeroCount;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberCount = scanner.nextInt();
		PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> minus = new PriorityQueue<>();
		zeroCount = 0;
		for (int i = 0; i < numberCount; i++){
			int number = scanner.nextInt();
			if (number > 0){
				plus.add(number);
			} else if (number < 0) {
				minus.add(number);
			} else {
				zeroCount++;
			}
		}

		int minusTotal = checkMinus(minus);
		int plusTotal = checkPlus(plus);
		System.out.println(minusTotal + plusTotal);
	}
	private static int checkMinus(PriorityQueue<Integer> minus) {
		int total = 0;

		while (!minus.isEmpty()){
			if (minus.size() == 1){
				if (zeroCount != 0){
					break;
				}
				total += minus.poll();
				break;
			}
			int first = minus.poll();
			int second = minus.poll();
			total += first * second;
		}

		return total;
	}
	private static int checkPlus(PriorityQueue<Integer> plus) {
		int total = 0;

		while (!plus.isEmpty()){
			if (plus.size() == 1){
				total += plus.poll();
				break;
			}
			if (plus.peek() == 1){
				total += plus.poll();
			} else {
				int first = plus.poll();
				if (plus.peek() == 1){
					total += first + plus.poll();
				}else {
					total += first * plus.poll();
				}
			}
		}

		return total;
	}

}
