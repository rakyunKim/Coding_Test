package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static Baekjoon.그래프.유니온파인드.Number1717.union;

public class Number1005 {
    static List<Integer>[] needBuilding;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase-- > 0) {
            int buildingCount = scanner.nextInt();  // max : 1000
            int buildingSeqTotalCount = scanner.nextInt();  // max : 100000
            int[] buildingTime = new int[buildingCount];  // max : 100000
            needBuilding = new ArrayList[buildingCount];
            int targetBuilding;

            for (int i = 0; i < buildingCount; i++) {
                buildingTime[i] = scanner.nextInt();
                needBuilding[i] = new ArrayList<>();
            }

            while (buildingSeqTotalCount-- > 0) {
                union(scanner.nextInt(), scanner.nextInt());
            }
            targetBuilding = scanner.nextInt();

            // union find를 써서 해결하자
        }
    }
}
