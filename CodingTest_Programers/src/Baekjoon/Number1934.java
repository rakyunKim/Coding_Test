package Baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class Number1934 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++){
			int small = scanner.nextInt();
			int large = scanner.nextInt();
			int result = small * large / MOD(small, large);
			System.out.println(result);
		}
	}

	private static int MOD(int small, int large) {
		if (large == 0){
			return small;
		}else {
			return MOD(large, small % large);
		}
	}


}
