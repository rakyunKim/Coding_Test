package Baekjoon.정렬모음.삽입정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number11399 {
	static int personCount;
	static int[] personNumber;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		personCount = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		personNumber = new int[personCount];
		for (int i = 0; i < personCount; i++){
			personNumber[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		int[] total = new int[personCount];
		ascendingOrder();
		makeSumArr(total);
		printAnswer(total);
	}

	private static void ascendingOrder() {
		for (int i = 0; i < personCount; i++){
			int insertPoint = i;
			int insertValue = personNumber[i];
			for (int j = i - 1; j >= 0; j--){
				if (personNumber[j] < personNumber[i]){
					insertPoint = j+1;
					break;
				}
				if (j == 0){
					insertPoint = 0;
				}
			}
			for (int j = i; j > insertPoint; j--){
				personNumber[j] = personNumber[j-1];
			}
			personNumber[insertPoint] = insertValue;
		}
	}
	private static void makeSumArr(int[] total) {
		total[0] = personNumber[0];
		for (int i = 1; i < personCount; i++){
			total[i] = total[i-1] + personNumber[i];
		}
	}
	private static void printAnswer(int[] total) {
		int sum = 0;
		for (int i = 0; i < personCount; i++){
			sum = sum + total[i];
		}
		System.out.println(sum);
	}
}
