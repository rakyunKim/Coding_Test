package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Number13023 {
	static ArrayList<Integer>[] closeList;
	static boolean[] checkNodeVisit;
	static boolean arrive;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int nodeCount = Integer.parseInt(stringTokenizer.nextToken());
		int edgeCount = Integer.parseInt(stringTokenizer.nextToken());
		checkNodeVisit = new boolean[nodeCount];
		arrive = false;
		closeList = new ArrayList[nodeCount];

		for (int i = 0; i < nodeCount; i++){
			closeList[i] = new ArrayList<>();
		}
		for (int i = 0; i < edgeCount; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int first = Integer.parseInt(stringTokenizer.nextToken());
			int second = Integer.parseInt(stringTokenizer.nextToken());
			closeList[first].add(second);
			closeList[second].add(first);
		}

		for (int i = 0; i < nodeCount; i++){
			DFS(i, 1);
			if (arrive) break;
		}
		if (arrive) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	private static void DFS(int now, int depth){
		if (depth == 5 || arrive){
			arrive = true;
			return;
		}
		checkNodeVisit[now] = true;
		for (int i : closeList[now]){
			if (!checkNodeVisit[i]){
				DFS(i, depth + 1);
			}
		}
		checkNodeVisit[now] = false;
	}
}
