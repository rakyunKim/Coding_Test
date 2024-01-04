package Baekjoon.정렬모음.퀵정렬.선택정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String stringARR = bufferedReader.readLine();

		int[] arr = new int[stringARR.length()];
		for (int i = 0; i < stringARR.length(); i++){
			arr[i] = Integer.parseInt(stringARR.substring(i,i+1));
		}

		for (int i = 0; i < arr.length; i++){
			for (int j = 0; j < arr.length; j++){
				if (arr[j] < arr[i]){
					int a = arr[i];
					arr[i] = arr[j];
					arr[j] = a;
				}
			}
		}
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]);
		}
	}
}
