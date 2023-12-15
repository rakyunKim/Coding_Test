package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Number17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int ARR_LENGTH = Integer.parseInt(stringTokenizer.nextToken());
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int[] ARR = new int[ARR_LENGTH];
		int[] answer = new int[ARR_LENGTH];
		for (int i = 0; i < ARR_LENGTH; i++){
			ARR[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		// 여기서 스택은 인덱스를 저장하기 위한 용도로 활용
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 0; i < ARR_LENGTH; i++){
			while (!stack.isEmpty() && ARR[stack.peek()] < ARR[i]){
				answer[stack.pop()] = ARR[i];
			}
			stack.push(i);
		}
		while (!stack.empty()){
			answer[stack.pop()] = -1;
		}
		for (int i : answer){
			System.out.println(i);
		}
	}
}
