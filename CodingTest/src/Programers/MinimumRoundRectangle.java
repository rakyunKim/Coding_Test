package Programers;

import java.io.IOException;

public class MinimumRoundRectangle {
    public static void main(String[] args) throws IOException {
//        int[][] sizes = new int[][]{
//                {60, 50},
//                {30, 70},
//                {60, 30},
//                {80, 40}
//        };
//        int[][] sizes = new int[][]{
//                {10, 7},
//                {12, 3},
//                {8, 15},
//                {14, 7},
//                {5, 15}
//        };
        int[][] sizes = new int[][]{
                {14, 4},
                {19, 6},
                {6, 16},
                {18, 7},
                {7, 11}
        };

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int minHorizontal = Math.max(sizes[0][0], sizes[0][1]);
        int minVertical = Math.min(sizes[0][0], sizes[0][1]);

        for (int i = 1; i < sizes.length; i++) {
            int currentHorizontal = Math.max(sizes[i][0], sizes[i][1]);
            int currentVertical = Math.min(sizes[i][0], sizes[i][1]);

            if (minHorizontal < currentHorizontal) {
                minHorizontal = currentHorizontal;
            }
            if (minVertical < currentVertical) {
                minVertical = currentVertical;
            }
        }

        return minHorizontal * minVertical;
    }
}
