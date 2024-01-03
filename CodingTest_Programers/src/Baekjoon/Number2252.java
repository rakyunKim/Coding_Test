package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number2252 {
	static ArrayList<Integer>[] adjacencyList;
	static int[] inDegreeArray;
	static int studentCount;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		studentCount = scanner.nextInt();
		int heightComparisonCount = scanner.nextInt();

		adjacencyList = new ArrayList[studentCount + 1];
		for (int i = 1; i <= studentCount; i++){
			adjacencyList[i] = new ArrayList<>();
		}

		inDegreeArray = new int[studentCount + 1];
		for (int i = 0; i < heightComparisonCount; i++){
			int entering = scanner.nextInt();
			int receiving = scanner.nextInt();
			inDegreeArray[receiving]++;
			adjacencyList[entering].add(receiving);
		}

		topologicalSort();
	}

	private static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= studentCount; i++){
			if (inDegreeArray[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()){
			int student = queue.poll();
			System.out.println(student);
			if (adjacencyList[student] != null){
				for (int receiving : adjacencyList[student]){
					inDegreeArray[receiving]--;
					if (inDegreeArray[receiving] == 0) {
						queue.add(receiving);
					}
				}
			}
		}
	}
}
