package Baekjoon.구현;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Number14889 {
    static int personCount;
    static List<Integer> rink;
    static List<Integer> start;
    static int[][] ability;
    static int min;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        personCount = scanner.nextInt();
        ability = new int[personCount + 1][personCount + 1];

        rink = new ArrayList<>();
        start = new ArrayList<>();
        min = Integer.MAX_VALUE;

        for(int i = 1; i <= personCount; i++){
            for (int j = 1; j <= personCount; j++) {
                ability[i][j] = scanner.nextInt();
            }
        }

        backTracking(1, 1);


        System.out.println(min);

//
//        for(int i = 0; i < personCount; i++){
//            for (int j = 0; j < personCount; j++) {
//                System.out.print(ability[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static void backTracking(int current, int depth) {
        rink.add(current);
        if (depth == personCount / 2){
            for (int i = 1; i <= personCount; i++) {
                if (!rink.contains(i)){
                    start.add(i);
                }
            }
            setTeamScore();
            rink.remove(depth - 1);
            start.clear();
        } else {
            for (int i = current; i < personCount; i++){
                backTracking(i + 1, depth + 1);
            }
            rink.remove(depth - 1);
        }

    }

    private static void setTeamScore() {
        int rinkTotal = 0;
        for(int i = 0; i < rink.size(); i++){
            int current = rink.get(i);
            for(int j = 1; j <= personCount; j++){
                if (rink.contains(j)){
                    rinkTotal += ability[current][j];
                }
            }
        }

        int startTotal = 0;
        for(int i = 0; i < start.size(); i++){
            int current = start.get(i);
            for(int j = 1; j <= personCount; j++){
                if (start.contains(j)){
                    startTotal += ability[current][j];
                }
            }
        }

        min = Math.min(min, Math.abs(rinkTotal - startTotal));
    }
}
