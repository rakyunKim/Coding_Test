package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Number1920Retry {
	static int[] data;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int dataCount = Integer.parseInt(bufferedReader.readLine());
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		data = new int[dataCount];
		for (int i = 0; i < dataCount; i++){
			data[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		Arrays.sort(data);

		int targetNumberCount = Integer.parseInt(bufferedReader.readLine());
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());


		for (int i = 0; i < targetNumberCount; i++){
			int targetNumber = Integer.parseInt(stringTokenizer.nextToken());
			if (binarySearch(targetNumber)) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}

		}


	}

	private static boolean binarySearch(int targetNumber) {
		int startIndex = 0;
		int endIndex = data.length - 1;
		int midIndex = (startIndex + endIndex) / 2;
		while (0 < endIndex && data.length > startIndex){
			if (targetNumber == data[midIndex]) return true;
			else if (data[midIndex] > targetNumber){
				endIndex = midIndex - 1;
				midIndex = (startIndex + endIndex) / 2;
			} else if (data[midIndex] < targetNumber){
				startIndex = midIndex + 1;
				midIndex = (startIndex + endIndex) / 2;
			}
		}
		return false;
	}
}
