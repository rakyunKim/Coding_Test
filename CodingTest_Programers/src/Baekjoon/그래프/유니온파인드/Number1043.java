package Baekjoon.그래프.유니온파인드;


 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Scanner;

public class Number1043 {
	static int[] parent;
	static int[] trueP;
	static ArrayList<Integer>[] party;
	static int result;
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int personCount = scanner.nextInt();
		int partyCount = scanner.nextInt();
		int knowTruthCount = scanner.nextInt();
		result = 0;
		trueP = new int[knowTruthCount];
		for (int i = 0; i < knowTruthCount; i++){
			trueP[i] = scanner.nextInt();
		}
		party = new ArrayList[partyCount];
		for (int i = 0; i < partyCount; i++){
			party[i] = new ArrayList<>();
			int partySize = scanner.nextInt();
			for (int j = 0; j < partySize; j++){
				party[i].add(scanner.nextInt());
			}
		}
		parent = new int[personCount + 1];
		for (int i = 1; i <= personCount; i++){
			parent[i] = i;
		}
		for (int i = 0; i < partyCount; i++){
			int firstPeople = party[i].get(0);
			for (int j = 1; j < party[i].size(); j++){
				union(firstPeople, party[i].get(j));
			}
		}
		for (int i = 0; i < partyCount; i++){
			boolean isPossible = true;
			int cur = party[i].get(0);
			for (int j = 0; j < trueP.length; j++){
				if (find(cur) == find(trueP[j])){
					isPossible = false;
					break;
				}
			}
			if (isPossible) result++;
		}
		System.out.println(result);
	}

	private static int find(int a) {
		if (a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b){
			parent[b] = a;
		}
	}
}
