package Baekjoon.그래프.유니온파인드;

import java.io.IOException;
import java.util.Scanner;

public class Number1717Retry {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int elementCount = scanner.nextInt();
		int operationCount = scanner.nextInt();
		parent = new int[elementCount + 1];

		for (int i = 0; i <= elementCount; i++){
			parent[i] = i;
		}

		for (int i = 0; i < operationCount; i++){
			int operationKind = scanner.nextInt();
			int firstElement = scanner.nextInt();
			int secondElement = scanner.nextInt();
			if (operationKind == 0){
				union(firstElement, secondElement);
			} else {
				if (find(firstElement) == find(secondElement)){
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static int find(int element) {
		if (parent[element] == element) return  element;
		else {
			return parent[element] = find(parent[element]);
		}
	}

	private static void union(int firstElement, int secondElement) {
		int firstElementParent = find(firstElement);
		int secondElementParent = find(secondElement);

		if (firstElementParent != secondElementParent) {
			parent[secondElement] = firstElementParent;
		}

		// 아래 코드는 문제 제출에서 성공하지 못하고 위의 코드는 성공하는 이유가 궁금함
		// 아래 코드는 내가 부모 배열에 더 작은 값으로 업데이트 해주기 위해서 if문을 조금 더 추가함
//		if (firstElementParent < secondElementParent){
//			parent[secondElement] = firstElementParent;
//		} else if(firstElementParent > secondElementParent){
//			parent[firstElement] = secondElementParent;
//		} else {
//			return;
//		}
	}
}
