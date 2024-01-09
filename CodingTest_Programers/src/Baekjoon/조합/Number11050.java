package Baekjoon.조합;

import java.io.IOException;
import java.util.Scanner;

public class Number11050 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int totalElementCount = scanner.nextInt();
		int selectElementCount = scanner.nextInt();
		// 5 2
		// 1*2*3*4*5 / 1*2*3*1*2
		// 5! / (5-2)!*2!
		int totalElementFactorialValue = getFactorialValue(totalElementCount);
		int selectElementFactorialValue = getFactorialValue(selectElementCount);
		int totalElementMinusSelectElementFactorialValue = getFactorialValue(totalElementCount - selectElementCount);
		int answer = totalElementFactorialValue / (selectElementFactorialValue * totalElementMinusSelectElementFactorialValue);
		System.out.println(answer);
	}
	private static int getFactorialValue(int input){
		int output = 1;
		for (int i = 2; i <= input; i++){
			output *= i;
		}
		return output;
	}
}
