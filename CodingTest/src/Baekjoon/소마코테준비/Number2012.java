package Baekjoon.소마코테준비;

import java.util.*;

public class Number2012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = scanner.nextInt();

        int[] studentRank = new int[studentCount];

        for(int i = 0; i < studentCount; i++){
            studentRank[i] = scanner.nextInt();
        }

        Arrays.sort(studentRank);

        long result = 0;
        for(int i = 0; i < studentCount; i++){
            result += Math.abs(i + 1 - studentRank[i]);
        }

        System.out.println(result);
    }
}
