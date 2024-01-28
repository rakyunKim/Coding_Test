package Baekjoon.소마코테준비;

import java.util.ArrayList;
import java.util.Scanner;

public class Number15650 {
    static int numberCount;
    static ArrayList<Integer>[] adjacency;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberRange = scanner.nextInt();
        numberCount = scanner.nextInt();
        adjacency = new ArrayList[numberRange + 1];

        for (int i = 1; i <= numberRange; i++){
            adjacency[i] = new ArrayList<>();
            for (int j = i + 1; j <= numberRange; j++){
                adjacency[i].add(j);
            }
        }

        for (int i = 1; i <= numberRange; i++){
            dfs(i);
        }
    }

    private static void dfs(int i) {
        for (int j : adjacency[i]){
            System.out.print(i + " ");
            System.out.print(j + "");
        }
    }
}
