package Baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int NUMBER_COUNT = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int[] arr = new int[NUMBER_COUNT];
		for (int i = 0; i < NUMBER_COUNT; i++){
			arr[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		Arrays.sort(arr);

		int count = 0;
		// 주어진 배열을 모두 돌면서 주어진 배열 마다 두 개의 포인터로 합한 값인지 확인
		for (int k = 0; k < NUMBER_COUNT; k++){
			long find = arr[k];
			int start = 0;
			int end = NUMBER_COUNT - 1;
			while (start < end){
				if (arr[start] + arr[end] == find){
					if (start != k && end != k){
						count++;
						break;
					} else if (start == k){
						start++;
					} else {
						end--;
					}
				} else if (arr[start] + arr[end] < find) {
					start++;
				} else {
					end--;
				}
			}
		}
		System.out.println(count);
	}
}
