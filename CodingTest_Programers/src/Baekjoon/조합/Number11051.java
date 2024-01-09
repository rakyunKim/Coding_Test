package Baekjoon.조합;

import java.io.IOException;
import java.util.Scanner;

public class Number11051 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int totalElementCount = scanner.nextInt();
		int selectElementCount = scanner.nextInt();
		int[][] D = new int[totalElementCount + 1][totalElementCount + 1];

		for (int total = 0; total <= totalElementCount; total++){
			for (int select = 0; select <= totalElementCount; select++){
				if (select == 0 || total == select){
					D[total][select] = 1;
				} else if (select == 1){
					D[total][select] = total;
				} else if (total < select){
					D[total][select] = 0;
				} else {
					D[total][select] = (D[total - 1][select] + D[total - 1][select - 1]);
					D[total][select] = D[total][select] % 10007;
				}
			}
		}


		System.out.println(D[totalElementCount][selectElementCount]);
	}
}
