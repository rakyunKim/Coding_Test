package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Number12891 {
	static int[] checkArr;
	static int[] myArr;
	static int checkSecret;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int DNA_LENGTH = Integer.parseInt(stringTokenizer.nextToken());
		int PART_ARR_LENGTH = Integer.parseInt(stringTokenizer.nextToken());
		int answer = 0;
		char[] DNA = new char[DNA_LENGTH];
		checkArr = new int[4];
		myArr = new int[4];
		checkSecret = 0;

		DNA = bufferedReader.readLine().toCharArray();
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < 4; i++){
			checkArr[i] = Integer.parseInt(stringTokenizer.nextToken());
			if (checkArr[i] == 0) checkSecret++;
		}

		for (int i = 0; i < PART_ARR_LENGTH; i++){
			add(DNA[i]);
		}
		if (checkSecret == 4) answer++;

		// 슬라이딩 윈도우 알고리즘 적용 부분
		for (int end = PART_ARR_LENGTH; end < DNA_LENGTH; end++){
			int start = end - PART_ARR_LENGTH;
			add(DNA[end]);
			remove(DNA[start]);
			if (checkSecret == 4) answer++;
		}
		System.out.println(answer);
		bufferedReader.close();
	}

	private static void remove(char c) {
		if (c == 'A'){
			if (myArr[0] == checkArr[0]){
				checkSecret--;
			}
			myArr[0]--;
			return;
		}

		if (c == 'C'){
			if (myArr[1] == checkArr[1]){
				checkSecret--;
			}
			myArr[1]--;
			return;
		}

		if (c == 'G'){
			if (myArr[2] == checkArr[2]){
				checkSecret--;
			}
			myArr[2]--;
			return;
		}

		if (c == 'T'){
			if (myArr[3] == checkArr[3]){
				checkSecret--;
			}
			myArr[3]--;
		}
	}

	private static void add(char c) {
		if (c == 'A'){
			myArr[0]++;
			if (myArr[0] == checkArr[0]){
				checkSecret++;
				return;
			}
		}

		if (c == 'C'){
			myArr[1]++;
			if (myArr[1] == checkArr[1]){
				checkSecret++;
				return;
			}
		}

		if (c == 'G'){
			myArr[2]++;
			if (myArr[2] == checkArr[2]){
				checkSecret++;
				return;
			}
		}

		if (c == 'T'){
			myArr[3]++;
			if (myArr[3] == checkArr[3]){
				checkSecret++;
			}
		}
	}


}
