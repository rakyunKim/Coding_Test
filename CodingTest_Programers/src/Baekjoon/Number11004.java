package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number11004 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int ARR_LENGTH = Integer.parseInt(stringTokenizer.nextToken());
		int position = Integer.parseInt(stringTokenizer.nextToken()) - 1;

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int[] ARR = new int[ARR_LENGTH];
		for (int i = 0; i < ARR_LENGTH; i++){
			ARR[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		Arrays.sort(ARR);
		System.out.println(ARR[position]);
	}
}
