package Baekjoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Number1043Retry {
	static int[] parent;
	static ArrayList<Integer>[] party;
	static int[] knowTruth;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int peopleCount = scanner.nextInt();
		parent = new int[peopleCount + 1];
		for (int i = 1; i <= peopleCount; i++){
			parent[i] = i;
		}

		int partyCount = scanner.nextInt();

		int knowTruthCount = scanner.nextInt();
		knowTruth = new int[knowTruthCount];
		for (int i = 0; i < knowTruthCount; i++){
			knowTruth[i] = scanner.nextInt();
		}

		party = new ArrayList[partyCount];
		for (int i = 0; i < partyCount; i++){
			party[i] = new ArrayList<>();
			int peopleCountInParty = scanner.nextInt();
			for (int j = 0; j < peopleCountInParty; j++){
				party[i].add(scanner.nextInt());
			}
		}

		for (int i = 0; i < partyCount; i++){
			int firstPeople = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++){
				union(firstPeople, party[i].get(j));
			}
		}

		int answer = 0;
		for (int i = 0; i < partyCount; i++){
			boolean isPossible = true;
			int firstPeople = party[i].get(0);
			for (int j = 0; j < knowTruthCount; j++){
				if (find(firstPeople) == find(knowTruth[j])){
					isPossible = false;
					break;
				}
			}
			if (isPossible) answer++;
		}
		System.out.println(answer);
	}

	private static void union(int firstPeople, int nextPeople) {
		firstPeople = find(firstPeople);
		nextPeople = find(nextPeople);
		if (firstPeople != nextPeople){
			parent[nextPeople] = firstPeople;
		}
	}

	private static int find(int person) {
		if (parent[person] == person) return person;
		else {
			return parent[person] = find(parent[person]);
		}
	}
}
