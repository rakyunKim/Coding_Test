package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Number2178Retry {
	static boolean[][] visited;
	static int[][] twoDimensionalArray;
	static final int[] xCoordinates = new int[]{0, 1, 0, -1};
	static final int[] yCoordinates = new int[]{1, 0, -1, 0};
	static int maxX;
	static int maxY;
	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		maxY = Integer.parseInt(stringTokenizer.nextToken());
		maxX = Integer.parseInt(stringTokenizer.nextToken());
		visited = new boolean[maxY][maxX];
		twoDimensionalArray = new int[maxY][maxX];

		for (int y = 0; y < maxY; y++){
			String temporary = bufferedReader.readLine();
			for (int x = 0; x < maxX; x++){
				twoDimensionalArray[y][x] = Integer.parseInt(temporary.substring(x, x + 1));
			}
		}

		BFS();
		System.out.println(twoDimensionalArray[maxY - 1][maxX - 1]);
	}

	private static void BFS() {
		Queue<int[]> coordinatesQueue = new LinkedList<>();
		coordinatesQueue.add(new int[]{0,0});
		visited[0][0] = true;
		while (!coordinatesQueue.isEmpty()){
			int[] currentCoordinates = coordinatesQueue.poll();
			for (int i = 0; i < 4; i++){
				int y = currentCoordinates[0] + yCoordinates[i];
				int x = currentCoordinates[1] + xCoordinates[i];
				if (y >= 0 && x >= 0 && y < maxY && x < maxX){
					if (!visited[y][x] && twoDimensionalArray[y][x] != 0){
						coordinatesQueue.add(new int[]{y, x});
						visited[y][x] = true;
						twoDimensionalArray[y][x] = twoDimensionalArray[currentCoordinates[0]][currentCoordinates[1]] + 1;
					}
				}
			}
		}
	}
}
