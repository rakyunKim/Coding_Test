package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Number17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int ARR_LENGTH = Integer.parseInt(bufferedReader.readLine());

		String[] space = bufferedReader.readLine().split(" ");

		int[] ARR = new int[ARR_LENGTH];
		for (int i = 0; i < ARR_LENGTH; i++){
			ARR[i] = Integer.parseInt(space[i]);
		}

		int[] answer = new int[ARR_LENGTH];

		Stack<Integer> stack = new Stack<>();
		// 처음에 스택에 아무것도 없으니 0번째 인덱스를 넣어줌
		stack.push(0);
		for (int i = 0; i < ARR_LENGTH; i++){
			while (!stack.isEmpty() && ARR[stack.peek()] < ARR[i]){
				answer[stack.pop()] = ARR[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()){
			answer[stack.pop()] = -1;
		}

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int a : answer){
			bufferedWriter.write(a + " ");
		}
		bufferedWriter.write("\n");
		bufferedWriter.flush();
	}
}
