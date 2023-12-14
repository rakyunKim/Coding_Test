package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Number11659 {
	public static void main(String[] args) throws IOException {
		// 위 문제는 질의의 개수가 10만개로 굉장히 많음으로 Scanner보다는 BufferedReader가 더 빠르다
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		// 위 문제는 10만개의 데이터가 입력이 가능한데, 그럼 10만개의 데이터를 int로 받기는 어렵다. 그런 경우 일반적으로
		// StringTokenizer를 사용하여 값을 분리하여 사용한다.
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int suNo = Integer.parseInt(stringTokenizer.nextToken());
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());

		long[] S = new long[suNo + 1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 1; i <= suNo; i++){
			S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}

		for (int q = 0; q < quizNo; q++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(S[j] - S[i-1]);
		}
	}
}
