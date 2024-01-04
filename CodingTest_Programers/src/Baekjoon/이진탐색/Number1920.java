package Baekjoon.이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number1920 {
	static int[] arr;
	static int arrLength;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		arrLength = Integer.parseInt(bufferedReader.readLine());
		arr = new int[arrLength ];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < arrLength; i++){
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		Arrays.sort(arr);

		int searchNumberCount = Integer.parseInt(bufferedReader.readLine());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < searchNumberCount; i++){
			int target = Integer.parseInt(stringTokenizer.nextToken());
			binarySearch(target);
		}
	}

	private static void binarySearch(int number) {
		int start = 0;
		int end = arrLength - 1;
		while (start <= end){
			int midIndex = start + end / 2;
			int midValue = arr[midIndex];
			if (midValue == number){
				System.out.println(1);
				break;
			} else if (midValue < number) {
				start = midIndex + 1;
			} else {
				end = midIndex - 1;
			}
		}
	}
}
