package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int LENGTH = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int CORRECT = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int[] items = new int[LENGTH];
		for (int i = 0; i < LENGTH; i++){
			items[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		Arrays.sort(items);
		int start = 0;
		int end = LENGTH - 1;
		int count = 0;

		while (start < end){
			if (items[start] + items[end] < CORRECT){
				start++;
			} else if (items[start] + items[end] > CORRECT){
				end--;
			} else {
				count++;
				start++;
				end--;
			}
		}
		System.out.println(count);
	}
}
