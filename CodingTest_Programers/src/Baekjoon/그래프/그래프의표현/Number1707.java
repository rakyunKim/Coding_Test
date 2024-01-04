package Baekjoon.그래프.그래프의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Number1707 {
	static ArrayList<Integer>[] A;
	static int[] check;
	static boolean[] visited;
	static boolean IsEven;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++){ // 테스트 케이스의 개수만큼 실행
			String[] s = br.readLine().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			A = new ArrayList[V + 1];
			visited = new boolean[V + 1];
			check = new int[V + 1];
			IsEven = true;
			for (int i = 1; i <= V; i++){
				A[i] = new ArrayList<>();
			}
			// 에지 데이터 저장하기
			for (int i = 0; i < E; i++){
				s = br.readLine().split(" ");
				int start = Integer.parseInt(s[0]);
				int end = Integer.parseInt(s[1]);
				A[start].add(end);
				A[end].add(start);
			}
			// 모든 노드에서 DFS 실행 해야함
			for (int i = 1; i <= V; i++){
				if (IsEven){
					DFS(i);
				} else {
					break;
				}
			}
			if (IsEven) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static void DFS(int start) {
		visited[start] = true;
		for (int currentNode : A[start]){
			if (!visited[currentNode]){
				// 바로 직전에 있는 노드와 다른 집합으로 분류
				check[currentNode] = (check[start] + 1) % 2;
				DFS(currentNode);
			} else if (check[start] == check[currentNode]){
				IsEven = false;
			}
		}
	}
}
