package Baekjoon.구간합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int LENGTH = Integer.parseInt(stringTokenizer.nextToken());
		int SUM_COUNT = Integer.parseInt(stringTokenizer.nextToken());

		long[] sum = new long[LENGTH + 1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		for (int i = 1; i <= LENGTH; i++){
			sum[i] = sum[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
		}

		for (int q = 0; q < SUM_COUNT; q++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int START = Integer.parseInt(stringTokenizer.nextToken());
			int END = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(sum[END] - sum[START - 1]);
		}
	}
}
