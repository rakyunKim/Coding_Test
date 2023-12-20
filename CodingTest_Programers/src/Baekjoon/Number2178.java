package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number2178 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static boolean[][] visited;
	static int[][] A;
	static int Y,X;
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		Y = Integer.parseInt(stringTokenizer.nextToken());
		X = Integer.parseInt(stringTokenizer.nextToken());
		A = new int[Y][X];
		visited = new boolean[Y][X];
		for (int i = 0; i < Y; i++){
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			String line = stringTokenizer.nextToken();
			for (int j = 0; j < X; j++){
				A[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		int startY= 0;
		int startX = 0;
		BFS(startY,startX);
		System.out.println(A[Y-1][X-1]);
	}

	private static void BFS(int startY, int startX) {
		Queue<int[]>queue = new LinkedList<>();
		queue.offer(new int[] {startY,startX});
		visited[startY][startX] = true;
		while (!queue.isEmpty()){
			int[] now = queue.poll();
			for (int k = 0; k < 4; k++){
				int y = now[0] + dy[k];
				int x = now[1] + dx[k];
				if (y >= 0 && x >= 0 && y < Y && x < X){ // 배열의 값을 넘어가면 안 되고
					if (A[y][x] != 0 && !visited[y][x]){ // 값이 0이어서 못가는 배열이거나 이미 방문한 배열일 경우
						visited[y][x] = true;
						A[y][x] = A[now[0]][now[1]] + 1; // 핵심
						queue.add(new int[] {y,x});
					}
				}
			}
		}
	}
}
