package Baekjoon.그래프.최소신장트리;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Number1414 {
	static List<LanCable> edgeList;
	static int[] parent;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		edgeList = new ArrayList<>();
		parent = new int[nodeCount];
		int totalLength = 0;

		for (int first = 0; first < nodeCount; first++){
			char[] charArray = scanner.next().toCharArray();
			for (int second = 0; second < nodeCount; second++){
				int length = alphabetToNumber(charArray[second]);
				totalLength += length;
				if (first != second && length != 0){
					edgeList.add(new LanCable(first, second, length));
				}
			}
		}

		for (int i = 0; i < nodeCount; i++){
			parent[i] = i;
		}

		Collections.sort(edgeList);

//		edgeList.forEach(i -> {
//			System.out.print("first : " + i.firstComputer);
//			System.out.print(" second : " + i.secondComputer);
//			System.out.print(" length : " + i.lanCableLength);
//			System.out.println();
//		});

		int answer = 0;
		int edgeCount = 0;
		for (LanCable edge : edgeList){
			if (find(edge.firstComputer) != find(edge.secondComputer)){
				union(edge.firstComputer, edge.secondComputer);
				answer += edge.lanCableLength;
				edgeCount++;
			}
			if (edgeCount == nodeCount - 1){
				break;
			}
		}

		if (edgeCount != nodeCount - 1){
			System.out.println("-1");
		} else {
			System.out.println(totalLength - answer);
		}
	}

	private static void union(int first, int second) {
		int firstParent = find(first);
		int secondParent = find(second);

		if (firstParent != secondParent){
			parent[secondParent] = firstParent;
		}
	}

	private static int find(int currentNode) {
		if (parent[currentNode] == currentNode) return currentNode;
		else return parent[currentNode] = find(parent[currentNode]);
	}

	private static int alphabetToNumber(char ch) {
		if ('a' <= ch && ch <= 'z') {
			// 소문자 알파벳인 경우
			return ch - 'a' + 1;
		} else if ('A' <= ch && ch <= 'Z') {
			// 대문자 알파벳인 경우
			return ch - 'A' + 27;
		} else {
			// 알파벳이 아닌 경우
			return 0; // 혹은 다른 처리를 원하는 대로 추가할 수 있습니다.
		}
	}
}
class LanCable implements Comparable<LanCable>{
	int firstComputer;
	int secondComputer;
	int lanCableLength;

	public LanCable(int firstComputer, int secondComputer, int lanCableLength) {
		this.firstComputer = firstComputer;
		this.secondComputer = secondComputer;
		this.lanCableLength = lanCableLength;
	}

	@Override
	public int compareTo(LanCable o) {
		return this.lanCableLength - o.lanCableLength;
	}
}