package Baekjoon.동적계획법;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Number13398 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bufferedReader.readLine());
		int[] A = new int[N];
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++){
			A[i] = Integer.parseInt(stringTokenizer.nextToken());
		}

		int[] L = new int[N];
		int[] R = new int[N];
		L[0] = A[0];
		R[N - 1] = A[N - 1];
		int result = L[0];
		for (int i = 1; i < N; i++){
			L[i] = Math.max(A[i], L[i - 1] + A[i]);
			result = Math.max(result, L[i]); // 연속된 수를 뽑는데 중간에 삭제를 안 하는 경우
		}
		for (int i = N - 2; i >= 0; i--){
			R[i] = Math.max(A[i], R[i + 1] + A[i]);
		}

		// 하나를 빼는 로직 구현
		for (int i = 1; i < N - 1; i++){
			int temp = L[i - 1] + R[i + 1]; // 수열에서 i번째 수를 하나 빼고 만들 수 있는 MAX
			result = Math.max(result, temp);
		}
		bufferedWriter.write(result + "\n");
		bufferedWriter.flush();
		bufferedWriter.close();
	}
}
