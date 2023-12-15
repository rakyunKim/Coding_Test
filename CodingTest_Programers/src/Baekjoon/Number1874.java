package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Number1874 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		final int ARR_LENGTH = scanner.nextInt();
		final int[] ARR = new int[ARR_LENGTH];
		boolean result = true;
		for (int i = 0; i < ARR_LENGTH; i++){
			ARR[i] = scanner.nextInt();
		}
		Stack<Integer> stack = new Stack<>();
		List<String> resultList = new ArrayList<>();
		int number = 1;
		for (int i = 0; i < ARR_LENGTH; i++){
			int currentNumber = ARR[i];
			if (currentNumber >= number){
				while (currentNumber >= number){
					stack.push(number++);
					resultList.add("+");
				}
				stack.pop();
				resultList.add("-");
			}else {
				int current = stack.pop();
				if (current > currentNumber){
					System.out.println("NO");
					result = false;
					break;
				}else {
					resultList.add("-");
				}
			}
		}
		if (result){
			resultList.forEach(System.out::println);
		}
	}
}
