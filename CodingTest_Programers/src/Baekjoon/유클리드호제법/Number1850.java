package Baekjoon.유클리드호제법;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Number1850 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		long firstNum = scanner.nextLong();
		long secondNum = scanner.nextLong();

		long result = 0;
		if (firstNum > secondNum){
			result = gcd(firstNum, secondNum);
		}else {
			result = gcd(secondNum, firstNum);
		}

		while (result > 0){
			bufferedWriter.write("1");
			result--;
		}

		bufferedWriter.flush();
		bufferedWriter.close();
	}
	private static long gcd(long large, long small){
		if (small == 0){
			return large;
		} else {
			return gcd(small, large % small);
		}
	}
}
