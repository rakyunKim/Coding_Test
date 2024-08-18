package Baekjoon.정렬모음.기수정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Number10989 {
	static int[] arrBeforeSort;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int numberCount = Integer.parseInt(bufferedReader.readLine());
		arrBeforeSort = new int[numberCount];
		for (int i = 0; i < numberCount; i++){
			arrBeforeSort[i] = Integer.parseInt(bufferedReader.readLine());
		}
		radixSort(5);
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < numberCount; i++){
			bufferedWriter.write(arrBeforeSort[i] + "\n");
		}
	}

	private static void radixSort(int maxNumberSize) {
		int[] output = new int[arrBeforeSort.length];
		int numberPosition = 1;
		int count = 0;
		while (count != maxNumberSize){
			int[] temp = new int[10];
			for (int i = 0; i < arrBeforeSort.length; i++){
				temp[(arrBeforeSort[i] / numberPosition) % 10] ++;
			}
			for (int i = 1; i < 10; i++){
				temp[i] += temp[i -1];
			}
			for (int i = arrBeforeSort.length - 1; i >= 0; i--){
				output[temp[(arrBeforeSort[i] / numberPosition % 10)]] = arrBeforeSort[i];
				temp[(arrBeforeSort[i] / numberPosition) % 10]--;
			}
			for (int i = 0; i < arrBeforeSort.length; i++){
				arrBeforeSort[i] = output[i];
			}
			numberPosition = numberPosition * 10;
			count++;
		}
	}
}
