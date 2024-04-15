package Programers.kakao;

import java.io.IOException;

public class CaveExploration {
    public static void main(String[] args) throws IOException {
        int n = 9; // 방 개수

        int[][] path = new int[][]{
                {0,1},
                {0,3},
                {0,7},
                {8,1},
                {3,6},
                {1,2},
                {4,7},
                {7,5}
        }; // 통로
//        int[][] path = new int[][]{
//                {8,1},
//                {0,1},
//                {1,2},
//                {0,7},
//                {4,7},
//                {0,3},
//                {7,5},
//                {3,6}
//        };

        int[][] order = new int[][]{
                {8,5},
                {6,7},
                {4,1}
        }; // 방문 순서
//        int[][] order = new int[][]{
//                {4,1},
//                {5,2}
//        };
//        int[][] order = new int[][]{
//                {4,1},
//                {8,7},
//                {6,5}
//        };

        System.out.println(solution(n, path, order));
    }
    public static boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        return answer;
    }
}
