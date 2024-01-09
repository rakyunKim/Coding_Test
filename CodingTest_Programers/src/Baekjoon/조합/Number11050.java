package Baekjoon.조합;

import java.io.IOException;
import java.util.Scanner;

public class Number11050 {
	static int[][] DP;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int totalElementCount = scanner.nextInt();
		int selectElementCount = scanner.nextInt();
		DP = new int[totalElementCount + 1][totalElementCount + 1];

		for (int total = 0; total <= totalElementCount; total++){
			for (int select = 0; select <= totalElementCount; select++){
				if (select == 0 || total == select){
					DP[total][select] = 1;
				} else if (total < select){
					DP[total][select] = 0;
				} else if (select == 1) {
					DP[total][select] = total;
				} else {
					DP[total][select] = DP[total - 1][select] + DP[total - 1][select - 1];
				}
			}
		}

		System.out.println(DP[totalElementCount][selectElementCount]);

//		// 5 2
//		// 1*2*3*4*5 / 1*2*3*1*2
//		// 5! / (5-2)!*2!
//		int totalElementFactorialValue = getFactorialValue(totalElementCount);
//		int selectElementFactorialValue = getFactorialValue(selectElementCount);
//		int totalElementMinusSelectElementFactorialValue = getFactorialValue(totalElementCount - selectElementCount);
//		int answer = totalElementFactorialValue / (selectElementFactorialValue * totalElementMinusSelectElementFactorialValue);
//		System.out.println(answer);
	}
//	private static int getFactorialValue(int input){
//		int output = 1;
//		for (int i = 2; i <= input; i++){
//			output *= i;
//		}
//		return output;
//	}
}
